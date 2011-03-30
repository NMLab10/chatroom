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

public class MyUserButtonPopup extends JPopupMenu{
    User user;
    public static MainFrame mainFrame;
    class MyUserButtonPopupItem extends JMenuItem{
        User user;
        public MyUserButtonPopupItem (User user){
            super();
            this.user = user;
        }
    }
    public MyUserButtonPopup (User user) {
        super();
        this.user = user;
        MyUserButtonPopupItem menuItem_file = new MyUserButtonPopupItem(user);
        menuItem_file.setIcon(new ImageIcon("./src/chatroom/resources/icons/send.png"));
        //menuItem_file.setText("傳檔");
        menuItem_file.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e) {
                //System.out.printf("HERE1");
                //mainFrame.addNewRoomRequest("addad");
                //mainFrame.leaveRoomRequest(((MyRoomButtonPopupItem)(e.getSource())).room.name);
            }
        });

        this.add(menuItem_file);

    }
}
