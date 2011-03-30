package chatroom;
import ChatMessage.ChatMessage;
import java.awt.image.BufferedImage;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import networkCore.client.*;
import networkCore.packageObj.*;
import userInfo.*;

public class ChatRoom extends SingleFrameApplication {
    enum FrameType{
       SIGNIN, LINKING, MAIN
    };    
    public static ChatRoom chatRoom;
    private SignInFrame signInFrame;
    private LinkingFrame linkingFrame;
    private MainFrame mainFrame;

    threadClient client;   // thread object for socket client

    public void startup() {

        chatRoom = new ChatRoom();
        chatRoom.myStart();

    }
    void myStart(){
        signInFrame = new SignInFrame(chatRoom);
        linkingFrame = new LinkingFrame(chatRoom);
        mainFrame = new MainFrame(chatRoom);
        //mainFrame.setVisible(true);

        client = new threadClient();
        client.setCallback(new callback());  // setup the client object

        goToFrame(FrameType.SIGNIN);
        //goToFrame(FrameType.MAIN);
    }
    void goToFrame(FrameType a){
        switch(a){
            case SIGNIN: signInFrame.myRun(); break;
            case LINKING:linkingFrame.myRun(); break;
            case MAIN:  mainFrame.myRun(); break;
            default: break;
        }
    }
    void leaveFromFrame(FrameType a) {
        switch(a){
            case SIGNIN:signInFrame.myEnd(); break;
            case LINKING:linkingFrame.myEnd(); break;
            case MAIN:mainFrame.myEnd(); break;
            default: break;
        }
    }

    private class callback implements recievingCallback
    {
        public void process(packageObj obj){            // this function will be call after receiving datas
             switch(obj.getType()){
                 case LOGIN_SUCC:
                     linkingFrame.loginSuccess();
                     break;
                 case ERR_SAME_NAME:
                     linkingFrame.errSameName();
                     break;
                 case USER_INFO:
                     mainFrame.newUserInfo((userInfo)(obj.getObj()));
                     break;
                 case USER_LOGOUT:
                     mainFrame.userLogoutInfo((String) (obj.getObj()));
                     break;
                 case ROOM_INFO:
                     mainFrame.newRoomInfo((String)(obj.getObj()));
                     break;
                 case USER_JOIN_ROOM:
                     String username1 = ((String[])obj.getObj())[0];
                     String roomname1 = ((String[])obj.getObj())[1];
                     mainFrame.userJoinRoomInfo(username1, roomname1);
                     break;
                 case USER_LEAVE_ROOM:
                     String username2 = ((String[])obj.getObj())[0];
                     String roomname2 = ((String[])obj.getObj())[1];
                     mainFrame.userLeaveRoomInfo(username2, roomname2);
                     break;
                 case ASK_SECRET_ROOM:
                     mainFrame.secretInvitationInfo((String)(obj.getObj()));
                     break;
                 case ROOM_CLOSED:
                     mainFrame.roomClosedInfo((String)(obj.getObj()));
                     break;
                 case MESSAGE:
                     mainFrame.addMessage((ChatMessage)obj.getObj());
                     break;
                 case CUT_OFF:
                     //mainFrame.cutOffInfo();
                     break;
             }
        }
    }
/*
    LOGIN_SUCC,
    ERR_SAME_NAME,
    USER_INFO,   // userInfo
    USER_LOGOUT,    // String
    ROOM_INFO,   // String
    USER_JOIN_ROOM, // String username, roomname
    USER_LEAVE_ROOM, // String username, roomname
    ASK_SECRET_ROOM, // String roomname
    ROOM_CLOSED, // String roomname
    MESSAGE,    // message
    CUT_OFF
 */
    String userName;
    BufferedImage head;
    int[] serverAdd = new int[4];
    public static void main(String[] args)  {
        Application.launch(ChatRoom.class,args);
    }



}
