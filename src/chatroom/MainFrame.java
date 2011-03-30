package chatroom;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.AbstractMap.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import userInfo.*;
import ChatMessage.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import networkCore.packageObj.packageObj;
import networkCore.packageObj.packageType;
import chatroom.classes.*;
import java.util.HashMap;
import networkCore.packageObj.*;
public class MainFrame extends JFrame {

    private ChatRoom app;
    private int YES_NO_OPTION;
    private class MyClosableTabbedPane extends ClosableTabbedPane {
        @Override
        protected void process(int x, int y) {
           requestFocus();
           int tab;
           if ((tab = getUI().tabForCoordinate(this, x, y)) >= 0) {
              if (((CloseTabIcon)getIconAt(tab)).getBounds().contains(x, y))
                  leaveRoomRequest();
           }
        }
    }
    private MyClosableTabbedPane mainClosableTabbedPane;
    MyMap myMap;
    MyRoomToolBar allRoomListToolBar;
    MyRoomToolBar myRoomListToolBar;
    boolean roomToolBarState;
    //org.jdesktop.application.ResourceMap myResourceMap;

    public MainFrame(ChatRoom a) {
        app = a;
        initComponents();
        //myResourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(MainFrame.class);
        MyInitComponent();/*
        jTextPane4.addKeyListener(new mySendListener());
        jTextPane2.addKeyListener(new mySendListener());*/
        //jTextPane4.setStyledDocument(realDoc);
        //bonoshi: need to be added more!!!!!
    }
    protected void myRun() {
        newRoomInfo("大廳");
        this.setVisible(true);
        jScrollPane1.setViewportView(allRoomListToolBar);
        roomToolBarState = false;
        jScrollPane2.setViewportView(myMap.RoomName_Room.get("大廳").roomUserListToolBar);
        /********debug*******/
        /*userInfo me = new userInfo();
        me.setName("occqoo");
        newUserInfo(me);*/
    }
    protected void myEnd() {
        this.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fontDialog = new javax.swing.JFrame();
        jPanelFont = new javax.swing.JPanel();
        jTextFieldFont = new javax.swing.JTextField();
        jPanelFont2 = new javax.swing.JPanel();
        fontCheckB = new javax.swing.JCheckBox();
        fontCheckI = new javax.swing.JCheckBox();
        fontCheckU = new javax.swing.JCheckBox();
        fontCheckD = new javax.swing.JCheckBox();
        fontCheckSuper = new javax.swing.JCheckBox();
        fontCheckSub = new javax.swing.JCheckBox();
        jPanelFont3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelFontColor = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelBackColor = new javax.swing.JPanel();
        buttonFontOK = new javax.swing.JButton();
        buttonFontCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonTextMode = new javax.swing.JButton();
        jButtonDrawMode = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jButtonEmotion = new javax.swing.JButton();
        jButtonBuzz = new javax.swing.JButton();
        jButtonFont = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jToolBar5 = new javax.swing.JToolBar();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jToolBar4 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(MainFrame.class);
        fontDialog.setTitle(resourceMap.getString("fontDialog.title")); // NOI18N
        fontDialog.setAlwaysOnTop(true);
        fontDialog.setMinimumSize(new java.awt.Dimension(260, 250));
        fontDialog.setName("fontDialog"); // NOI18N
        fontDialog.setResizable(false);

        jPanelFont.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelFont.border.title"))); // NOI18N
        jPanelFont.setName("jPanelFont"); // NOI18N

        jTextFieldFont.setText(resourceMap.getString("jTextFieldFont.text")); // NOI18N
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(MainFrame.class, this);
        jTextFieldFont.setAction(actionMap.get("fontClickOK")); // NOI18N
        jTextFieldFont.setName("jTextFieldFont"); // NOI18N

        javax.swing.GroupLayout jPanelFontLayout = new javax.swing.GroupLayout(jPanelFont);
        jPanelFont.setLayout(jPanelFontLayout);
        jPanelFontLayout.setHorizontalGroup(
            jPanelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFontLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldFont, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFontLayout.setVerticalGroup(
            jPanelFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelFont2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelFont2.border.title"))); // NOI18N
        jPanelFont2.setName("jPanelFont2"); // NOI18N

        fontCheckB.setText(resourceMap.getString("fontCheckB.text")); // NOI18N
        fontCheckB.setName("fontCheckB"); // NOI18N

        fontCheckI.setText(resourceMap.getString("fontCheckI.text")); // NOI18N
        fontCheckI.setName("fontCheckI"); // NOI18N

        fontCheckU.setText(resourceMap.getString("fontCheckU.text")); // NOI18N
        fontCheckU.setName("fontCheckU"); // NOI18N

        fontCheckD.setText(resourceMap.getString("fontCheckD.text")); // NOI18N
        fontCheckD.setName("fontCheckD"); // NOI18N

        fontCheckSuper.setText(resourceMap.getString("fontCheckSuper.text")); // NOI18N
        fontCheckSuper.setName("fontCheckSuper"); // NOI18N
        fontCheckSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontCheckSuperActionPerformed(evt);
            }
        });

        fontCheckSub.setText(resourceMap.getString("fontCheckSub.text")); // NOI18N
        fontCheckSub.setName("fontCheckSub"); // NOI18N
        fontCheckSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontCheckSubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFont2Layout = new javax.swing.GroupLayout(jPanelFont2);
        jPanelFont2.setLayout(jPanelFont2Layout);
        jPanelFont2Layout.setHorizontalGroup(
            jPanelFont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFont2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontCheckB)
                    .addComponent(fontCheckI)
                    .addComponent(fontCheckSuper)
                    .addComponent(fontCheckSub)
                    .addComponent(fontCheckU)
                    .addComponent(fontCheckD))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelFont2Layout.setVerticalGroup(
            jPanelFont2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFont2Layout.createSequentialGroup()
                .addComponent(fontCheckB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontCheckI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontCheckSuper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontCheckSub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontCheckU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fontCheckD)
                .addContainerGap())
        );

        jPanelFont3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanelFont3.border.title"))); // NOI18N
        jPanelFont3.setName("jPanelFont3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jPanelFontColor.setBackground(resourceMap.getColor("jPanelFontColor.background")); // NOI18N
        jPanelFontColor.setName("jPanelFontColor"); // NOI18N
        jPanelFontColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelFontColorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFontColorLayout = new javax.swing.GroupLayout(jPanelFontColor);
        jPanelFontColor.setLayout(jPanelFontColorLayout);
        jPanelFontColorLayout.setHorizontalGroup(
            jPanelFontColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanelFontColorLayout.setVerticalGroup(
            jPanelFontColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jPanelBackColor.setBackground(resourceMap.getColor("jPanelBackColor.background")); // NOI18N
        jPanelBackColor.setName("jPanelBackColor"); // NOI18N
        jPanelBackColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBackColorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBackColorLayout = new javax.swing.GroupLayout(jPanelBackColor);
        jPanelBackColor.setLayout(jPanelBackColorLayout);
        jPanelBackColorLayout.setHorizontalGroup(
            jPanelBackColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanelBackColorLayout.setVerticalGroup(
            jPanelBackColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelFont3Layout = new javax.swing.GroupLayout(jPanelFont3);
        jPanelFont3.setLayout(jPanelFont3Layout);
        jPanelFont3Layout.setHorizontalGroup(
            jPanelFont3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFont3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFont3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFont3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelFontColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFont3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanelFont3Layout.setVerticalGroup(
            jPanelFont3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFont3Layout.createSequentialGroup()
                .addGroup(jPanelFont3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFontColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(14, 14, 14)
                .addGroup(jPanelFont3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanelBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonFontOK.setText(resourceMap.getString("buttonFontOK.text")); // NOI18N
        buttonFontOK.setName("buttonFontOK"); // NOI18N
        buttonFontOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFontOKActionPerformed(evt);
            }
        });

        buttonFontCancel.setText(resourceMap.getString("buttonFontCancel.text")); // NOI18N
        buttonFontCancel.setName("buttonFontCancel"); // NOI18N
        buttonFontCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFontCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fontDialogLayout = new javax.swing.GroupLayout(fontDialog.getContentPane());
        fontDialog.getContentPane().setLayout(fontDialogLayout);
        fontDialogLayout.setHorizontalGroup(
            fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fontDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fontDialogLayout.createSequentialGroup()
                        .addGroup(fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelFont3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelFont2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fontDialogLayout.createSequentialGroup()
                        .addComponent(buttonFontOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFontCancel)))
                .addContainerGap())
        );
        fontDialogLayout.setVerticalGroup(
            fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fontDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fontDialogLayout.createSequentialGroup()
                        .addComponent(jPanelFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelFont3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelFont2, 0, 163, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fontDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFontOK)
                    .addComponent(buttonFontCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setAlwaysOnTop(true);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMinimumSize(new java.awt.Dimension(825, 757));
        setName("Form"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(732, 675));
        jPanel2.setName("jPanel2"); // NOI18N

        jPanel6.setBackground(resourceMap.getColor("jPanel6.background")); // NOI18N
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setName("jPanel6"); // NOI18N

        jToolBar1.setBackground(resourceMap.getColor("jToolBar1.background")); // NOI18N
        jToolBar1.setFloatable(false);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setName("jToolBar1"); // NOI18N

        jButtonTextMode.setBackground(resourceMap.getColor("jButtonEmotion.background")); // NOI18N
        jButtonTextMode.setIcon(resourceMap.getIcon("jButtonTextMode.icon")); // NOI18N
        jButtonTextMode.setText(resourceMap.getString("jButtonTextMode.text")); // NOI18N
        jButtonTextMode.setFocusable(false);
        jButtonTextMode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonTextMode.setName("jButtonTextMode"); // NOI18N
        jButtonTextMode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonTextMode);

        jButtonDrawMode.setBackground(resourceMap.getColor("jButtonEmotion.background")); // NOI18N
        jButtonDrawMode.setIcon(resourceMap.getIcon("jButtonDrawMode.icon")); // NOI18N
        jButtonDrawMode.setText(resourceMap.getString("jButtonDrawMode.text")); // NOI18N
        jButtonDrawMode.setFocusable(false);
        jButtonDrawMode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDrawMode.setName("jButtonDrawMode"); // NOI18N
        jButtonDrawMode.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButtonDrawMode);

        jToolBar3.setBackground(resourceMap.getColor("jToolBar3.background")); // NOI18N
        jToolBar3.setFloatable(false);
        jToolBar3.setBorderPainted(false);
        jToolBar3.setDoubleBuffered(true);
        jToolBar3.setName("jToolBar3"); // NOI18N

        jButtonEmotion.setBackground(resourceMap.getColor("jButtonEmotion.background")); // NOI18N
        jButtonEmotion.setIcon(resourceMap.getIcon("jButtonEmotion.icon")); // NOI18N
        jButtonEmotion.setFocusable(false);
        jButtonEmotion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEmotion.setName("jButtonEmotion"); // NOI18N
        jButtonEmotion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButtonEmotion);

        jButtonBuzz.setBackground(resourceMap.getColor("jButtonEmotion.background")); // NOI18N
        jButtonBuzz.setIcon(resourceMap.getIcon("jButtonBuzz.icon")); // NOI18N
        jButtonBuzz.setFocusable(false);
        jButtonBuzz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuzz.setName("jButtonBuzz"); // NOI18N
        jButtonBuzz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButtonBuzz);

        jButtonFont.setBackground(resourceMap.getColor("jButtonEmotion.background")); // NOI18N
        jButtonFont.setIcon(resourceMap.getIcon("jButtonFont.icon")); // NOI18N
        jButtonFont.setFocusable(false);
        jButtonFont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonFont.setName("jButtonFont"); // NOI18N
        jButtonFont.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonFont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonFontMousePressed(evt);
            }
        });
        jToolBar3.add(jButtonFont);

        jToolBar2.setBackground(resourceMap.getColor("jToolBar2.background")); // NOI18N
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setName("jToolBar2"); // NOI18N

        jButton.setBackground(resourceMap.getColor("jButton.background")); // NOI18N
        jButton.setIcon(resourceMap.getIcon("jButton.icon")); // NOI18N
        jButton.setText(resourceMap.getString("jButton.text")); // NOI18N
        jButton.setFocusable(false);
        jButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton.setName("jButton"); // NOI18N
        jButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserAddNewRoomButtonClicked(evt);
            }
        });
        jToolBar2.add(jButton);

        jButton3.setBackground(resourceMap.getColor("jButton3.background")); // NOI18N
        jButton3.setIcon(resourceMap.getIcon("jButton3.icon")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton3);

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setName("jPanel3"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        jPanel4.setBackground(resourceMap.getColor("jPanel4.background")); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jToolBar5.setBackground(resourceMap.getColor("jToolBar5.background")); // NOI18N
        jToolBar5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar5.setFloatable(false);
        jToolBar5.setOrientation(1);
        jToolBar5.setRollover(true);
        jToolBar5.setName("jToolBar5"); // NOI18N

        jButton9.setBackground(resourceMap.getColor("jButton9.background")); // NOI18N
        jButton9.setIcon(resourceMap.getIcon("jButton9.icon")); // NOI18N
        jButton9.setText(resourceMap.getString("jButton9.text")); // NOI18N
        jButton9.setAlignmentX(0.5F);
        jButton9.setFocusable(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton9.setName("jButton9"); // NOI18N
        jToolBar5.add(jButton9);

        jButton10.setBackground(resourceMap.getColor("jButton10.background")); // NOI18N
        jButton10.setIcon(resourceMap.getIcon("jButton10.icon")); // NOI18N
        jButton10.setText(resourceMap.getString("jButton10.text")); // NOI18N
        jButton10.setAlignmentX(0.5F);
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton10.setName("jButton10"); // NOI18N
        jToolBar5.add(jButton10);

        jScrollPane2.setViewportView(jToolBar5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)))
                .addContainerGap())
        );

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel2.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jPanel5.setBackground(resourceMap.getColor("jPanel5.background")); // NOI18N
        jPanel5.setName("jPanel5"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jToolBar4.setBackground(resourceMap.getColor("jToolBar4.background")); // NOI18N
        jToolBar4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar4.setFloatable(false);
        jToolBar4.setOrientation(1);
        jToolBar4.setRollover(true);
        jToolBar4.setName("jToolBar4"); // NOI18N

        jButton2.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setAlignmentX(0.5F);
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testFunc(evt);
            }
        });
        jToolBar4.add(jButton2);

        jButton1.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setAlignmentX(0.5F);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setName("jButton1"); // NOI18N
        jToolBar4.add(jButton1);

        jScrollPane1.setViewportView(jToolBar4);

        jButton8.setBackground(resourceMap.getColor("jButton8.background")); // NOI18N
        jButton8.setFont(resourceMap.getFont("jButton8.font")); // NOI18N
        jButton8.setActionCommand(resourceMap.getString("jButton8.actionCommand")); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.setContentAreaFilled(false);
        jButton8.setLabel(resourceMap.getString("jButton8.label")); // NOI18N
        jButton8.setName("jButton8"); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangeRoomToolBarState(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton8.getAccessibleContext().setAccessibleName(resourceMap.getString("jButton8.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void MyInitComponent(){  
        mainClosableTabbedPane = new MyClosableTabbedPane();
        Room.closableTabbedPane = mainClosableTabbedPane;
        Room.dialogPanel = jPanel3;
        myMap = new MyMap();
        allRoomListToolBar = new MyRoomToolBar();
        myRoomListToolBar = new MyRoomToolBar();
        MyRoomButtonPopup.mainFrame = this;

        
        
        //mainClosableTabbedPane.setBackground(jTabbedPane2.getBackground()); // NOI18N
        //mainClosableTabbedPane.setFont(jTabbedPane2.getFont()); // NOI18N
        mainClosableTabbedPane.setName("mainClosableTabbedPane"); // NOI18N
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(mainClosableTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainClosableTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
        );

        mainClosableTabbedPane.getAccessibleContext().setAccessibleName("mainClosableTabbedPane"); // NOI18N
        
    }
    
    private final int defaultFontSize = 15;
    private int currentFontSize = defaultFontSize;
    private Color currentFontColor = Color.BLACK;
    private Color currentBackColor = Color.WHITE;
    private final SimpleAttributeSet defaultSimpleAttributeSet;
    private boolean isFontB = false;
    private boolean isFontI = false;
    private boolean isFontU = false;
    private boolean isFontD = false;
    private boolean isFontSuper = false;
    private boolean isFontSub = false;
    {
        defaultSimpleAttributeSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(defaultSimpleAttributeSet, defaultFontSize);
        StyleConstants.setForeground(defaultSimpleAttributeSet, Color.BLACK);
        StyleConstants.setBackground(defaultSimpleAttributeSet, Color.WHITE);
        StyleConstants.setBold(defaultSimpleAttributeSet, false);
        StyleConstants.setItalic(defaultSimpleAttributeSet, false);
        StyleConstants.setUnderline(defaultSimpleAttributeSet, false);
        StyleConstants.setStrikeThrough(defaultSimpleAttributeSet, false);
        StyleConstants.setSuperscript(defaultSimpleAttributeSet, false);
        StyleConstants.setSubscript(defaultSimpleAttributeSet, false);
    }
    private void restoreFontDialog(){
        jTextFieldFont.setText(Integer.toString(currentFontSize));
        jPanelFontColor.setBackground(currentFontColor);
        jPanelBackColor.setBackground(currentBackColor);
        fontCheckB.setSelected(isFontB);
        fontCheckI.setSelected(isFontI);
        fontCheckU.setSelected(isFontU);
        fontCheckD.setSelected(isFontD);
        fontCheckSuper.setSelected(isFontSuper);
        fontCheckSub.setSelected(isFontSub);
    }
    
    private void setFont(){
        currentFontColor = jPanelFontColor.getBackground();
        currentBackColor = jPanelBackColor.getBackground();
        isFontB = fontCheckB.isSelected();
        isFontI = fontCheckI.isSelected();
        isFontU = fontCheckU.isSelected();
        isFontD = fontCheckD.isSelected();
        isFontSuper = fontCheckSuper.isSelected();
        isFontSub = fontCheckSub.isSelected();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setFontSize(sas, currentFontSize);
        StyleConstants.setForeground(sas, currentFontColor);
        StyleConstants.setBackground(sas, currentBackColor);
        StyleConstants.setBold(sas, isFontB);
        StyleConstants.setItalic(sas, isFontI);
        StyleConstants.setUnderline(sas, isFontU);
        StyleConstants.setStrikeThrough(sas, isFontD);
        StyleConstants.setSuperscript(sas, isFontSuper);
        StyleConstants.setSubscript(sas, isFontSub);
        //jTextPane4.setCharacterAttributes(sas, false);
    }

    private void buttonFontOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFontOKActionPerformed
        int newSize = defaultFontSize;
        try {
            newSize = Integer.parseInt(jTextFieldFont.getText());
            System.out.println(newSize);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fontDialog, "Illegal font size!", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextFieldFont.setText(Integer.toString(currentFontSize));
        }
        if(newSize > 72 || newSize <8){
            JOptionPane.showMessageDialog(fontDialog, "Font size must be an integer form 8 to 72!", "Warning", JOptionPane.WARNING_MESSAGE);
            jTextFieldFont.setText(Integer.toString(currentFontSize));
        }
        else{
            currentFontSize = newSize;
            setFont();
            fontDialog.setVisible(false);
        }
    }//GEN-LAST:event_buttonFontOKActionPerformed

    private void buttonFontCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFontCancelActionPerformed
         fontDialog.setVisible(false);
    }//GEN-LAST:event_buttonFontCancelActionPerformed

    private void jPanelFontColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFontColorMousePressed
        Color c = JColorChooser.showDialog(
                            fontDialog,
                            "選取顏色",
                            jPanelFontColor.getBackground());
        jPanelFontColor.setBackground(c);
    }//GEN-LAST:event_jPanelFontColorMousePressed

    private void jPanelBackColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBackColorMousePressed
        Color c = JColorChooser.showDialog(
                            fontDialog,
                            "選取顏色",
                            jPanelBackColor.getBackground());
        jPanelBackColor.setBackground(c);
    }//GEN-LAST:event_jPanelBackColorMousePressed

    private boolean ifSuperAndSubBothChecked(){
        return(fontCheckSuper.isSelected()&&fontCheckSub.isSelected());
    }

    private void fontCheckSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontCheckSubActionPerformed
        if(ifSuperAndSubBothChecked()){
            fontCheckSuper.setSelected(false);
        }
    }//GEN-LAST:event_fontCheckSubActionPerformed

    private void fontCheckSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontCheckSuperActionPerformed
        if(ifSuperAndSubBothChecked()){
            fontCheckSub.setSelected(false);
        }
    }//GEN-LAST:event_fontCheckSuperActionPerformed

    private void UserAddNewRoomButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserAddNewRoomButtonClicked
        String newRoomName = JOptionPane.showInputDialog(null, "請輸入新聊天室名稱：");
        if(!newRoomName.isEmpty())
            addNewRoomRequest(newRoomName);
}//GEN-LAST:event_UserAddNewRoomButtonClicked

    private void jButtonFontMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFontMousePressed
        fontDialog.setVisible(true);
        fontDialog.setLocationRelativeTo(this);
        fontDialog.setExtendedState(Frame.NORMAL);
        restoreFontDialog();
        //System.out.println(Frame.NORMAL);
}//GEN-LAST:event_jButtonFontMousePressed

    private void testFunc(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testFunc
        // TODO add your handling code here:
    }//GEN-LAST:event_testFunc

    private void ChangeRoomToolBarState(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangeRoomToolBarState
        if(!roomToolBarState){
            jScrollPane1.setViewportView(myRoomListToolBar);
            jButton8.setText("顯示所有聊天室");
            roomToolBarState = true;
        }
        else{
            jScrollPane1.setViewportView(allRoomListToolBar);
            jButton8.setText("顯示我的聊天室");
            roomToolBarState = false;
        }
    }//GEN-LAST:event_ChangeRoomToolBarState

    boolean ctrlKeyEntered = false;//bonoshi: need to be add if change to another taggedframe

    /**********************************************************************************
     *                                                                                *
     *                            Sending Messages                                    *
     *                                                                                *
     **********************************************************************************/
    class mySendListener extends KeyAdapter{
        //System.out.println("p" + evt.getComponent().getName()); //bonoshi: remember to make use of it!
        //System.out.println("p" + evt.getSource());
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt){
            //System.out.println("p" + evt.getComponent().getName());
            JTextPane currentJtp= ((JTextPane)evt.getSource());
            StyledDocument currentDoc = currentJtp.getStyledDocument();
            if(evt.isControlDown())
                ctrlKeyEntered = true;
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                if(ctrlKeyEntered){
                    //System.out.println("Enter!");
                    try {
                        currentDoc.insertString(currentJtp.getCaretPosition(), "\n", currentJtp.getInputAttributes());
                    } catch (BadLocationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    evt.consume();
			}
			else{
				System.out.println("Send!");
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.setDoc(currentDoc);
//                StyledDocument testDoc = chatMessage.getDoc();
//                            try {
//                System.out.println(testDoc.getText(0, testDoc.getLength()));
//            } catch (BadLocationException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
                //chatMessage.setSendID("b");
                chatMessage.setSendName("bonoshi@XDOrz");
                //bonoshi: need to have convert JTextPane "currentJtp" to chatroom name
                chatMessage.setChatRoom(null);
                packageObj messagePack = new packageObj(packageType.MESSAGE);
                messagePack.setObj(chatMessage);
                app.client.send(messagePack);
                try {
                    currentDoc.remove(0, currentDoc.getLength());
                } catch (BadLocationException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                evt.consume();
			}
		}
        }
        @Override
        public void keyReleased(java.awt.event.KeyEvent evt){
            if(evt.getKeyCode()==KeyEvent.VK_CONTROL){
                ctrlKeyEntered = false;
            }
        }
    }

    public void showRoom(String roomname){
        int index = -1;
        for(int i=0;i<mainClosableTabbedPane.getComponentCount();i++){
            if(mainClosableTabbedPane.getTitleAt(i).equals(roomname)){
                mainClosableTabbedPane.setSelectedIndex(i);
                index = i;
            }
        }
        if(index >= 0){
            jScrollPane2.setViewportView(myMap.RoomName_Room.get(roomname).roomUserListToolBar);
        }
    }
    
    public void addNewRoomRequest (String newRoomName) {
        //newRoomInfo("新聊天室");  //for debug
        packageObj creatroomObj = new packageObj(packageType.CREAT_ROOM);
        creatroomObj.setObj(newRoomName);
        app.client.send(creatroomObj);
    }
    protected void leaveRoomRequest() {
        if(mainClosableTabbedPane.getSelectedIndex() == 0) return; //大廳
        Room room = myMap.SplitPane_Room.get((JSplitPane)mainClosableTabbedPane.getSelectedComponent());
        String roomname = room.name;
        mainClosableTabbedPane.remove(mainClosableTabbedPane.getSelectedComponent());
        packageObj leaveroomObj = new packageObj(packageType.LEAVE_ROOM);
        leaveroomObj.setObj(roomname);
        app.client.send(leaveroomObj);
    }
    protected void newRoomInfo(String newRoomName){
        Room newRoom = new Room(newRoomName,true);
        allRoomListToolBar.AddRoomButton(newRoom);
        jScrollPane1.setViewportView(allRoomListToolBar);
        jScrollPane1.updateUI();
        myMap.AddRoom(newRoom);
    }
    protected void roomClosedInfo(String roomname){
        Room room = myMap.RoomName_Room.get(roomname);
        allRoomListToolBar.RemoveRoomButton(room);
        myMap.RemoveRoom(room);
    }
    protected void newUserInfo(userInfo user){
        User newUser = new User(user.getID());
        myMap.AddUser(newUser);
        userJoinRoomInfo(user.getID(), "大廳");
    }
    protected void userLogoutInfo(String username){
        User user = myMap.UserName_User.get(username);
        myMap.RemoveUser(user);
        for(int i=0;i<user.userRoom.size();i++){
            Room room = user.userRoom.get(i);
            userLeaveRoomInfo(user.name, room.name);
        }
    }
    protected void userJoinRoomInfo(String username, String roomname){
        Room room = myMap.RoomName_Room.get(roomname);
        User user = myMap.UserName_User.get(username);
        user.userRoom.add(room);
        room.roomUser.add(user);
        room.roomUserListToolBar.AddUserButton(user);

        if(username.equals(app.userName)){
           System.out.printf("%s, %s", username, app.userName);
           if(!roomname.equals("大廳")) mainClosableTabbedPane.addTab(roomname, room.splitPane, new ImageIcon());
           else mainClosableTabbedPane.addTab(roomname, room.splitPane, null);
           myRoomListToolBar.AddRoomButton(room);
           allRoomListToolBar.JoinRoomChangeColor(room);
           myRoomListToolBar.JoinRoomChangeColor(room);
        }
    }
    protected void userLeaveRoomInfo(String username, String roomname){
        Room room = myMap.RoomName_Room.get(roomname);
        User user = myMap.UserName_User.get(username);
        user.userRoom.remove(room);
        room.roomUser.remove(user);
        room.roomUserListToolBar.RemoveUserButton(user);
        if(username.equals(app.userName)){
            myRoomListToolBar.RemoveRoomButton(room);
            allRoomListToolBar.LeaveRoomChangeColor(room);
            myRoomListToolBar.LeaveRoomChangeColor(room);  
        }
}
    public void leaveRoomRequest(String roomname){
        packageObj leaveroomObj = new packageObj(packageType.LEAVE_ROOM);
        leaveroomObj.setObj(roomname);
        app.client.send(leaveroomObj);
    }
    public void joinRoomRequest(String roomname){
        packageObj joinroomObj = new packageObj(packageType.JOIN_ROOM);
        joinroomObj.setObj(roomname);
        app.client.send(joinroomObj);
    }

    public void secretInvitationInfo(String roomname){
        String message = new String();
        message.format("有人邀請您加入秘密聊天室 %s，請選擇是否加入：",roomname);
        int reply = JOptionPane.showConfirmDialog(this, message, "秘密邀請", YES_NO_OPTION);
        if(reply == 0)
    }
    /*
        *LOGIN,  // userInfo
    *CREAT_ROOM,    // String roomname
    *JOIN_ROOM,   // String roomname
    *LEAVE_ROOM, // String roomname
    CREAT_SECRET_ROOM,  // String roomname
    JOIN_SECRET_ROOM, // String username
    NOT_JOIN_SECRET_ROOM, // String roomname
    INVITE_SECRET_ROOM,  // String username, roomname
    FILE_SEND_REQUEST,
    VOICE_REQUEST,


     */
    protected void addMessage(ChatMessage cm){
        /*DefaultStyledDocument newDoc = (DefaultStyledDocument) cm.getDoc();
        String chatroom = cm.getChatRoom();
        //bonoshi: need to have convert chatroom to JTextPAne
        String sendName = cm.getSendName();
        JTextPane currentJtp = jTextPane3;
        Document currentDoc = currentJtp.getStyledDocument();

//        try {
//            //SimpleAttributeSet sas = new SimpleAttributeSet(defaultSimpleAttributeSet);
//
//            currentDoc.insertString(currentDoc.getLength(), "\n", currentJtp.getInputAttributes());
//        } catch (BadLocationException ex) {
//            //Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }

        try {
                SimpleAttributeSet sas = new SimpleAttributeSet(defaultSimpleAttributeSet);
                StyleConstants.setLeftIndent(sas, 0.0F);
                StyleConstants.setBold(sas, true);
                currentJtp.setParagraphAttributes(sas, false);
                currentJtp.setCaretPosition(currentJtp.getDocument().getLength());
                currentDoc.insertString(currentDoc.getLength(), sendName + " says:\n", currentJtp.getParagraphAttributes());
                //currentDoc.insertString(currentDoc.getLength(), "\n", currentJtp.getParagraphAttributes());
            } catch (BadLocationException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Element temp = newDoc.getDefaultRootElement();
        //System.out.println("Top has:" + temp.getElementCount());
        //System.out.println(temp.getElementCount());
        {
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setLeftIndent(sas, 10.0F);
            StyleConstants.setBold(sas, false);
            currentJtp.setCaretPosition(currentJtp.getDocument().getLength());
            currentJtp.setParagraphAttributes(sas, false);
        }
        for(int i =0; i<temp.getElementCount(); ++i)
        {
            Element tempE = temp.getElement(i);
            //System.out.println(i + " has " + tempE.getElementCount());
            for (int j = 0; j < tempE.getElementCount(); j++) {
                Element tempE2 = tempE.getElement(j);
                int start = tempE2.getStartOffset();
                int end = tempE2.getEndOffset();

                try {
                        //AttributeSet tempA =  tempE2.getAttributes();
                        //StyleConstants.setLeftIndent((MutableAttributeSet) tempA, 10.0F);
                        currentDoc.insertString(currentDoc.getLength(), newDoc.getText(start, end-start), tempE2.getAttributes());
                        currentJtp.setCaretPosition(currentJtp.getDocument().getLength());
                        //currentDoc.insertString(currentDoc.getLength(), newDoc.getText(start, end-start), tempA);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //try {
        //    currentDoc.remove(currentDoc.getLength() - 1, 1);
        //} catch (BadLocationException ex) {
        //    //Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
       // }
        currentJtp.setCaretPosition(currentDoc.getLength());*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFontCancel;
    private javax.swing.JButton buttonFontOK;
    private javax.swing.JCheckBox fontCheckB;
    private javax.swing.JCheckBox fontCheckD;
    private javax.swing.JCheckBox fontCheckI;
    private javax.swing.JCheckBox fontCheckSub;
    private javax.swing.JCheckBox fontCheckSuper;
    private javax.swing.JCheckBox fontCheckU;
    private javax.swing.JFrame fontDialog;
    private javax.swing.JButton jButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonBuzz;
    private javax.swing.JButton jButtonDrawMode;
    private javax.swing.JButton jButtonEmotion;
    private javax.swing.JButton jButtonFont;
    private javax.swing.JButton jButtonTextMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelBackColor;
    private javax.swing.JPanel jPanelFont;
    private javax.swing.JPanel jPanelFont2;
    private javax.swing.JPanel jPanelFont3;
    private javax.swing.JPanel jPanelFontColor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldFont;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    // End of variables declaration//GEN-END:variables

}
