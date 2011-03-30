/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chatroom.classes;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author eeuser
 */
public class Room {
        public String name;
        public boolean type;
        public JSplitPane splitPane, smallerSplitPane;
        public JScrollPane scrollPaneTop, scrollPaneBot;
        public JTextPane textPaneTop, textPaneBot;
        public JButton enterButton;
        public ArrayList<User> roomUser;
        public MyUserToolBar roomUserListToolBar;
        static public ClosableTabbedPane closableTabbedPane;
        static public JPanel dialogPanel;
        static public JScrollPane roomListScrollPane;

        public Room(String name, boolean type){
            this.type = type;
            this.name = name;
            splitPane = new JSplitPane();
            smallerSplitPane = new JSplitPane();
            scrollPaneTop = new JScrollPane();
            scrollPaneBot = new JScrollPane();
            textPaneTop = new JTextPane();
            textPaneBot = new JTextPane();
            enterButton = new JButton();
            roomUser = new ArrayList<User>();
            roomUserListToolBar = new MyUserToolBar(this);
            
            splitPane.setTopComponent(scrollPaneTop);
            splitPane.setBottomComponent(smallerSplitPane);
            smallerSplitPane.setLeftComponent(scrollPaneBot);
            smallerSplitPane.setRightComponent(enterButton);
            scrollPaneTop.setViewportView(textPaneTop);
            scrollPaneBot.setViewportView(textPaneBot);
            splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
            smallerSplitPane.setOrientation(javax.swing.JSplitPane.HORIZONTAL_SPLIT);
            splitPane.setDividerLocation(dialogPanel.getHeight()-100);
            smallerSplitPane.setDividerLocation(dialogPanel.getWidth()-70);
            splitPane.setResizeWeight(1.0);
            smallerSplitPane.setResizeWeight(1.0);
        }
    }