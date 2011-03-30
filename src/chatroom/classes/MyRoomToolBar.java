/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom.classes;

import com.sun.java.swing.plaf.windows.WindowsToolBarUI;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.plaf.SliderUI;

public class MyRoomToolBar extends JToolBar{
        public MyRoomToolBar(){
            super();
            this.setBackground(Color.WHITE); // NOI18N
            this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            this.setFloatable(false);
            this.setOrientation(1);
            this.setRollover(true);
            //this.setName("jToolBar4"); // NOI18N
        }
        public MyRoomButton AddRoomButton(Room room){
            MyRoomButton newRoomButton = new MyRoomButton(room);
            this.add(newRoomButton);
            newRoomButton.setSize(80,16);
            //System.out.printf("w=%f, l=%f",newRoomButton.getSize().getWidth(), newRoomButton.getSize().getHeight());
            this.updateUI();
            
            return newRoomButton;
        }
        public void RemoveRoomButton(Room room){
            for(int i=0;i<this.getComponentCount();i++){
               MyRoomButton roomButton = (MyRoomButton)this.getComponentAtIndex(i);
               if(roomButton.room == room){
                   this.remove(roomButton);
                   this.updateUI();
                }
            }
        }
        public void  JoinRoomChangeColor (Room room){
            for(int i=0;i<this.getComponentCount();i++){
               MyRoomButton roomButton = (MyRoomButton)this.getComponentAtIndex(i);
               if(roomButton.room == room){
                   roomButton.toGreen();
                }
            }
        }
        public void  LeaveRoomChangeColor (Room room){
            for(int i=0;i<this.getComponentCount();i++){
               MyRoomButton roomButton = (MyRoomButton)this.getComponentAtIndex(i);
               if(roomButton.room == room){
                   roomButton.toRed();
                }
            }
        }

}
