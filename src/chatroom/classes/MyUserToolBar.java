package chatroom.classes;
import com.sun.java.swing.plaf.windows.WindowsToolBarUI;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.plaf.SliderUI;

public class MyUserToolBar extends JToolBar{
        Room room;
        
        public MyUserToolBar(Room r){
            super();
            this.setBackground(Color.WHITE); // NOI18N
            this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            this.setFloatable(false);
            this.setOrientation(1);
            this.setRollover(true);
           room = r;
        }
        public MyUserButton AddUserButton(User user){
            MyUserButton newUserButton = new MyUserButton(user);
            this.add(newUserButton);
            this.updateUI();
            return newUserButton;
        }
        public void RemoveUserButton(User user){
            for(int i=0;i<this.getComponentCount();i++){
               MyUserButton userButton = (MyUserButton)this.getComponentAtIndex(i);
               if(userButton.user == user){
                   this.remove(userButton);
                   this.updateUI();
                }
            }
        }
    }
