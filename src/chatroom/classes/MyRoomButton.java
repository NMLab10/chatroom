/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom.classes;

import javax.swing.JButton;
import chatroom.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

 public class MyRoomButton extends JButton{
     Room room;
     public void toGreen(){
         this.setIcon(new ImageIcon("./src/chatroom/resources/icons/Circle_Green.png"));
     }
     public void toRed(){}{
         this.setIcon(new ImageIcon("./src/chatroom/resources/icons/Circle_Red.png"));
     }
     public MyRoomButton(Room r){
        super();
        room = r;
        setBackground(Color.WHITE); // NOI18N
        this.setIcon(new ImageIcon("./src/chatroom/resources/icons/Circle_Red.png")); // NOI18N
        this.setText(room.name);
        this.setAlignmentX(0.5F);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.setFocusable(false);
        this.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        this.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        this.setMaximumSize(new Dimension(220,42));
        this.setMinimumSize(new Dimension(220,42));
        this.setIconTextGap(8);
        this.addMouseListener(new MouseAdapter(){
            @Override
             public void mouseClicked(MouseEvent e){
                 MyRoomButtonPopup popup = new MyRoomButtonPopup(room);
                 popup.show(e.getComponent(), e.getComponent().getX()+155, e.getY()-30);
             }
        });
        //jButton2.setName("jButton2"); // NOI18N

        /*
           File dir1 = new File (".");
           try {
              System.out.println ("Current dir : " + dir1.getCanonicalPath());
              System.out.println ("Parent  dir : " + dir2.getCanonicalPath());
            }
            catch(Exception e) {
               //e.printStackTrace();
            }
         */
     }

    
     
 }
