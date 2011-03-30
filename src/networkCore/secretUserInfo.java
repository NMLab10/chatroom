package networkCore;

import userInfo.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class secretUserInfo extends userInfo
{
    private Socket inSocket;
    private Socket outSocket;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;


    public Socket getInSocket(){return inSocket;}
    public Socket getOutSocket(){return outSocket;}
    public ObjectOutputStream getOutStream(){return outStream;}
    public ObjectInputStream getInStream(){return inStream;}


    public void setUserInfo(userInfo user){
        ID = user.getID();
      //  name = user.getName();
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

