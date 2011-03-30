package ChatMessage;

import java.io.*;
import javax.swing.text.StyledDocument;
public class ChatMessage implements Serializable
{
   // private String sendID;
    private String sendName;//nickname
    private String chatRoom;//name for chatroom regardless of secret or public
    private StyledDocument doc;
    
    //public String getSendID(){return sendID;}
    //public void setSendID(String s){sendID = s;}
    public String getChatRoom(){return chatRoom;}
    public void setChatRoom(String s){chatRoom = s;}
    public String getSendName(){return sendName;}
    public void setSendName(String s){sendName = s;}
    public StyledDocument getDoc(){return doc;}
    public void setDoc(StyledDocument d){doc = d;}
}
