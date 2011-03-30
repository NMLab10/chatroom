package networkCore;

import userInfo.*;
import java.net.*;
import java.io.*;
import java.util.*;
import networkCore.*;
import networkCore.packageObj.packageObj;

public class secretUserInfo extends userInfo
{
    private Socket inSocket;
    private Socket outSocket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private ArrayDeque<String> roomlist;
    
    public void send(packageObj obj)throws  IOException{

            outStream.writeObject(obj);
            switch(obj.getType()){
                case LOGIN_SUCC:
                    System.out.println("LS");
                break;
                case ERR_SAME_NAME:
                    System.out.println("ERR SAME NAME");
                break;
                case USER_JOIN_ROOM:
                    System.out.println("ujr");
                break;
                case ROOM_CLOSED:
                    System.out.println("rc");
                break;
            }

    }
    public Socket getInSocket(){return inSocket;}
    public Socket getOutSocket(){return outSocket;}
    public ObjectOutputStream getOutStream(){return outStream;}
    public ObjectInputStream getInStream(){return inStream;}

    public secretUserInfo(){
        roomlist = new ArrayDeque<String>();
    }

    public void setUserInfo(userInfo user){
        ID = user.getID();
       // name = user.getName();
    }

    public ArrayDeque<String> getRoomList(){
        return roomlist;
    }
    
    public userInfo getUserInfo(){
        userInfo tmp = new userInfo();
        tmp.setID(ID);
        //tmp.setName(name);
        return tmp;
    }
    public void setInSocket(Socket newSocket){inSocket = newSocket;}
    public void setOutSocket(Socket newSocket){outSocket = newSocket;}
    public void setOutStream(ObjectOutputStream newStream){outStream = newStream;}
    public void setInStream(ObjectInputStream newStream){inStream = newStream;}

}

