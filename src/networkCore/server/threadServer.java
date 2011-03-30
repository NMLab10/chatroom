package networkCore.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import networkCore.*;
import networkCore.packageObj.*;
import userInfo.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;
import ChatMessage.*;

public class threadServer extends Thread
{
    
    final private HashMap userList ;
    final private HashMap chatroomList ;
    final private HashMap secretRoomList;
    private int port;


    

    public  threadServer(int newport){
        userList = new HashMap();
        port = newport;
        chatroomList = new HashMap();
        secretRoomList = new HashMap();
    }

    public void run()
    {
	try
	{
	    ServerSocket serversocket = new ServerSocket(port);
            while(true){
                Socket connSocket = serversocket.accept();
                Thread_recv recv = new Thread_recv(connSocket);
                recv.start();
                System.out.println("A connection from "+connSocket.getInetAddress());
            }
	}
	catch(IOException ecp){
            System.err.println("Error happened when accept()!");
            System.err.println(ecp);
        }
    }
    
    private class Thread_recv extends Thread
    {
	private Socket recvSocket;
	private Socket sendSocket;
	private secretUserInfo user;
        ObjectOutputStream sendStream;
	ObjectInputStream recvStream;


	private Thread_recv(){}
	public Thread_recv(Socket newSocket)
	{	    
            recvSocket = newSocket;
	}

	@Override public void run()
	{

	    try
	    {
		sendSocket = new Socket(recvSocket.getInetAddress(),10001);
		sendStream = new ObjectOutputStream(sendSocket.getOutputStream());
		recvStream = new ObjectInputStream(recvSocket.getInputStream());
	

		while(recieve((packageObj)recvStream.readObject())){}

	    }
	    catch(IOException e){
                logout();
                System.out.println("Connection closed by client : "+recvSocket.getInetAddress().getHostAddress());
                System.err.println(e);
                
            }
            catch(ClassNotFoundException e){
                System.err.println(e);
            }


	}

	//implement recieving condition
	private boolean recieve(packageObj obj){
	    switch(obj.getType()){
		case LOGIN:
                    System.out.println("LG");
                    login(obj);
		break;

                case CREAT_ROOM:
                    System.out.println("CR");
                    creatRoom(obj);
                break;

                case JOIN_ROOM:
                    joinRoom(obj);
                break;

                case MESSAGE:
                    getMessage(obj);
                break;

		case LEAVE_ROOM:
                    leaveRoom(obj);
		break;

                case CREAT_SECRET_ROOM:
                    creatSecretRoom(obj);
                break;


		case JOIN_SECRET_ROOM:
		break;
	

		default:
                    return true;
		
	    }
            return true;
	}

        private boolean login(packageObj obj){
            try{
            //Set up all connection information in userinfo
            user = new secretUserInfo();
            user.setUserInfo((userInfo)obj.getObj());
            user.setInSocket(recvSocket);
            user.setOutSocket(sendSocket);
            user.setInStream(recvStream);
            user.setOutStream(sendStream);
            //Find weather name conflicts, if it happens than close connection.
            if(userList.containsKey(user.getID())){
                user.send(new packageObj(packageType.ERR_SAME_NAME));
                recvStream.close();
                sendStream.close();
                recvSocket.close();
                sendSocket.close();
                return false;
            }else{
                //save new file to list
                synchronized(userList){
                    userList.put(user.getID(), user);
                }
                //Login success
                user.send(new packageObj(packageType.LOGIN_SUCC));
                System.out.println(user.getID() + " logins from "+user.getInSocket().getInetAddress().getHostAddress());

                //send the login information to all users
                packageObj myInfo = new packageObj(packageType.USER_INFO);
                myInfo.setObj(user.getUserInfo());
                broadcast(myInfo);

                //send the current information to client
                getAllUserInfo();
                getAllChatroom();

                return true;
            }
            }catch(IOException e){
                System.out.println("login err");
                System.out.println(e);
                return true;
            }

        }//End of login function

        private void sendToOthers(packageObj obj){
            synchronized(userList){
                Iterator it = userList.entrySet().iterator();
                while(it.hasNext()){
                    try{
                        secretUserInfo tmp = (secretUserInfo)((Map.Entry)it.next()).getValue();
                        if(tmp.getID().equals(user.getID()))continue;
                        tmp.send(obj);

                    }catch(IOException e){
                        System.err.println("Error happened when sendToOthers!");
                        System.err.println(e);
                    }
                }
            }
        }

        // get all users' infomation to new user
        private void getAllUserInfo(){
            synchronized(userList){
                Iterator it = userList.entrySet().iterator(); // This may cause some problem!
                while(it.hasNext()){
                    try{
                        secretUserInfo tmp = (secretUserInfo)((Map.Entry)it.next()).getValue();
                        if(tmp.getID().equals(user.getID()))continue;
                        packageObj packUserInfo = new packageObj(packageType.USER_INFO);
                        packUserInfo.setObj(tmp.getUserInfo());
                        user.send(packUserInfo);
                    }catch(IOException e){
                        System.err.println("Error happened when sending all UserInfo!");
                        System.err.println(e);
                    }
                }
            }
        }//end of getAllUserInfo()

        //get all room infomation to new user
        private void getAllChatroom(){
            synchronized(chatroomList){
                Iterator it = chatroomList.entrySet().iterator();
                while(it.hasNext()){
                    try{
                        packageObj packRoomName = new packageObj(packageType.ROOM_INFO);
                        packRoomName.setObj((String)((Map.Entry)it.next()).getKey());
                        user.send(packRoomName);
                    }catch(IOException e){
                        System.err.println("Error happened when sending all room info");
                        System.err.println(e);
                    }
                }
            }

        }//end of getAllChatRoom

        //call when recieve room info
        //bug ! when room name used before
        private void creatRoom(packageObj obj){
            ArrayDeque<secretUserInfo> tmp = new ArrayDeque<secretUserInfo>();
            tmp.add(user);
            user.getRoomList().add((String)obj.getObj());
            chatroomList.put((String)obj.getObj(), tmp);
            obj.setType(packageType.ROOM_INFO);
            packageObj userjoin = new packageObj(packageType.USER_JOIN_ROOM);
            String[] info = new String[2];
            info[0] = user.getID();
            info[1] = (String)obj.getObj();
            userjoin.setObj(info);
            try {
                
                broadcast(obj);
                user.send(userjoin);
            } catch (IOException ex) {
                System.err.println("ERROR creatRoom()");
                System.err.println(ex);
            }

        }

        //call when the user what to join a room
        private void joinRoom(packageObj obj){
            ArrayDeque<secretUserInfo> tmp = (ArrayDeque<secretUserInfo>)chatroomList.get((String)obj.getObj());          
            try{
                broadcast(obj, tmp);
            }catch(IOException e){
               System.err.println("Error happernd when joinRoom");
               System.err.println(e);
            }
            tmp.add(user);
            user.getRoomList().add((String)obj.getObj());
        }

        //call when the user leave
        private void leaveRoom(packageObj obj){
            ArrayDeque<secretUserInfo> tmp = (ArrayDeque<secretUserInfo>)chatroomList.get((String)obj.getObj());
            user.getRoomList().remove((String)obj.getObj());
            try{

                packageObj tmpobj = new packageObj(packageType.USER_LEAVE_ROOM);
                String[] info = new String[2];
                info[0] = user.getID();
                info[1] = (String)obj.getObj();
                tmpobj.setObj(info);
                broadcast(tmpobj,tmp);
                tmp.remove(user);
                if(tmp.isEmpty()){
                    packageObj close = new packageObj(packageType.ROOM_CLOSED);
                    close.setObj(obj.getObj());
                    broadcast(close);
                    chatroomList.remove((String)obj.getObj());
                }
                
            }catch(IOException e){
                System.err.println("ERROR:leaveRoom");
                System.err.println(e);
            }
        }

        private void getMessage(packageObj obj){
            ChatMessage mes = (ChatMessage)obj.getObj();

            if(mes.getChatRoom() == null){
                synchronized(userList){
                    Iterator it  = userList.entrySet().iterator();
                    while(it.hasNext()){
                        try{
                            secretUserInfo tmp = (secretUserInfo)((Map.Entry)it.next()).getValue();
                            packageObj packmes = new packageObj(packageType.MESSAGE);
                            packmes.setObj(mes);
                            tmp.send(packmes);
                            
                        }catch(Exception e){
                            System.err.println("Error happened when sending message!");
                            System.err.println(e);
                        }
                    }
                }
            }else{
                
                
            }
        }

        //logout
        private void logout(){
            Iterator it  = user.getRoomList().iterator();
            while(it.hasNext()){
                String roomname = (String)it.next();
                ((ArrayDeque<secretUserInfo>)chatroomList.get(roomname)).remove(user);

            }
            userList.remove(user.getID());
            packageObj logout = new packageObj(packageType.USER_LOGOUT);
            logout.setObj(user.getID());
            try {
                broadcast(logout);
            } catch (IOException ex) {
                System.err.println("ERROR: logout");
                System.err.println(ex);
            }
        }

        //call when create secret room
        private void creatSecretRoom(packageObj obj){
            ArrayDeque<secretUserInfo> tmp = new ArrayDeque<secretUserInfo>();
            tmp.add(user);
            user.getRoomList().add((String)obj.getObj());
            secretRoomList.put((String)obj.getObj(), tmp);
            packageObj joinObj = new packageObj(packageType.USER_JOIN_SECRET_ROOM);
            joinObj.setObj(obj.getObj());
            try {
                user.send(joinObj);
            } catch (IOException ex) {
                System.err.println("ERROR: creatSecretRoom\n"+ex);
            }
        }

    }// End of private inner class Thread_recv

    private void broadcast(packageObj obj) throws IOException{
        Iterator it = userList.entrySet().iterator();
        System.out.println(obj.getType());
        while(it.hasNext()){
            
            ((secretUserInfo)((Map.Entry)it.next()).getValue()).send(obj);
        }
    }

    private void broadcast(packageObj obj, ArrayDeque<secretUserInfo> roomUser)throws  IOException{
        Iterator it = roomUser.iterator();
        System.out.println(obj.getType());
        while(it.hasNext()){
            ((secretUserInfo)it.next()).send(obj);
        }
                
    }














}

