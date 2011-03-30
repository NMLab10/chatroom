package chatroom.classes;

import java.util.ArrayList;
import javax.swing.*;

public class User {
    public String name;
    public ArrayList<Room> userRoom;
    public User(String name){
        this.name = name;
        userRoom = new ArrayList<Room>();
    }
}
