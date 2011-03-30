package chatroom.classes;
import chatroom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MyRoomButtonPopup extends JPopupMenu{
    Room room;
    public static MainFrame mainFrame;
    class MyRoomButtonPopupItem extends JMenuItem{
        Room room;
        public MyRoomButtonPopupItem (Room room){
            super();
            this.room = room;
        }
    }
    public MyRoomButtonPopup (Room room) {
        super();
        this.room = room;
        MyRoomButtonPopupItem menuItem_leave = new MyRoomButtonPopupItem(room);
        menuItem_leave.setIcon(new ImageIcon("./src/chatroom/resources/icons/minus white.png"));
        //menuItem_leave.setText("離開");
        menuItem_leave.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                //System.out.printf("HERE1");
                //mainFrame.addNewRoomRequest("addad");
                mainFrame.leaveRoomRequest(((MyRoomButtonPopupItem)(e.getSource())).room.name);
            }
        });
        /*MyRoomButtonPopupItem menuItem_show = new MyRoomButtonPopupItem(room);
        menuItem_show.setIcon(new ImageIcon("./src/chatroom/resources/icons/cats_display.png"));
        //menuItem_show.setText("顯示");
        menuItem_show.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e){
                mainFrame.showRoom(((MyRoomButtonPopupItem)(e.getSource())).room.name);
            }
        });*/
        MyRoomButtonPopupItem menuItem_attend = new MyRoomButtonPopupItem(room);
        menuItem_attend.setIcon(new ImageIcon("./src/chatroom/resources/icons/plus white.png"));
        //menuItem_attend.setText("加入");
        menuItem_leave.addActionListener(new ActionListener(){
            @Override
            public void  actionPerformed(ActionEvent e){
                mainFrame.joinRoomRequest(((MyRoomButtonPopupItem)(e.getSource())).room.name);
            }

        });
        this.add(menuItem_attend);
        this.add(menuItem_leave);
        //this.add(menuItem_show);
        
    }
}
