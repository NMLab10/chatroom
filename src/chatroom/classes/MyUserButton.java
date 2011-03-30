/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyUserButton extends JButton{
    User user;
    public MyUserButton(User u){
        super();
        user =  u;
        setBackground(Color.WHITE); // NOI18N
        this.setIcon(new ImageIcon("./src/chatroom/resources/icons/male.png")); // NOI18N
        this.setText(user.name);
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
                 MyUserButtonPopup popup = new MyUserButtonPopup(user);
                 popup.show(e.getComponent(), e.getComponent().getX()+100, e.getY()-10);
             }
        });
        //jButton2.setName("jButton2"); // NOI18N
     }
    
}
