package chatroom.classes;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;

public class MyMap{
       public HashMap<String, Room> RoomName_Room;
       public HashMap<JTextPane, Room> TextPane_Room;
       public HashMap<JSplitPane, Room> SplitPane_Room;
       public HashMap<String, User> UserName_User;
       public MyMap(){
            RoomName_Room = new HashMap<String, Room> ();
            TextPane_Room = new HashMap<JTextPane, Room> ();
            SplitPane_Room = new HashMap<JSplitPane, Room> ();
            UserName_User = new HashMap<String, User> ();
       }
       public void AddRoom(Room room){
           RoomName_Room.put(room.name, room);
           TextPane_Room.put(room.textPaneBot, room);
           SplitPane_Room.put(room.splitPane, room);
       }
       public void RemoveRoom(Room room){
           RoomName_Room.remove(room.name);
           TextPane_Room.remove(room.textPaneBot);
           SplitPane_Room.remove(room.splitPane);
       }
       public void AddUser(User user){
           UserName_User.put(user.name, user);
       }
       public void RemoveUser(User user){
           UserName_User.remove(user.name);
       }
    }