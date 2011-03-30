package networkCore.client;

import networkCore.packageObj.*;
import networkCore.*;
import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.*;



public class threadClient extends Thread
{

    private recievingCallback callback;
    private Socket outSocket;
    private Socket inSocket;
    private InetAddress serverAddress;
    private int port;
    private ObjectInputStream recvStream;
    private ObjectOutputStream sendStream;

    private boolean isSetIP;
    private boolean isConnect;
    private boolean isSetCallback;

    public threadClient(){
        isSetIP = false;
        isConnect = false;
    }

    public void setIP(String IP,int newport){
       	try
	{
	    serverAddress = InetAddress.getByName(IP);
	    port = newport;
            isSetIP = true;
	}catch(UnknownHostException ecp){
            System.err.println("Error happened when seting server IP!");
            System.err.println(IP);
            isSetIP = false;
        }
    }

    public void setCallback(recievingCallback newCallback){
        callback = newCallback;
        isSetCallback = true;
    }


    public void send(packageObj packageobj){
        try{
            sendStream.reset();
            if(isConnect){
                sendStream.writeObject(packageobj);
            }else{
                throw(new IOException("Connection must be set before sending!"));
            }
        }catch(IOException e){
            System.err.println("Error happened when sending object!");
            System.err.println(e);
        }
    }

    public boolean connect(){
        try
        {
            if(!isSetIP){throw(new IOException("Server IP must be set before connetion!"));}
            ServerSocket income = new ServerSocket(10001,1);
	    outSocket = new Socket(serverAddress,10000);
	    inSocket = income.accept();
            recvStream = new ObjectInputStream(inSocket.getInputStream());
	    sendStream = new ObjectOutputStream(outSocket.getOutputStream());
            isConnect = true;
            return true;
        }catch(IOException e){
            System.err.println("Error happened when connect to server!");
            System.err.println(e);
            return false;
        }
    }

    public void run(){
	try
	{
            if(!isConnect||!isSetCallback)
            {throw(new IOException("Connection and Callback must be set before recieving data!"));}
	    while(true)
	    {
		packageObj recv = (packageObj)recvStream.readObject();
		callback.process(recv);
	    }

	
	}catch(Exception e){
            callback.process(new packageObj(packageType.CUT_OFF));
            System.err.println("Error happened when recieving!");
            System.err.println(e);
        }
    }
}
