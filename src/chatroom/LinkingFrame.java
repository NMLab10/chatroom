package chatroom;
import javax.swing.*;
import networkCore.packageObj.*;
import userInfo.*;
class LinkingFrame extends javax.swing.JFrame {

    private ChatRoom app;
    private boolean waiting; // this is a flag indicating "waiting for login success"

    protected LinkingFrame(ChatRoom a) {
        app = a;
        waiting = false;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("連線中...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    protected void myRun(){
        
        this.setVisible(true);

        //set server IP
        app.client.setIP(String.format("%d.%d.%d.%d",app.serverAdd[0],app.serverAdd[1],app.serverAdd[2],app.serverAdd[3]),10000);

        //establish connection to server
        boolean linkSuccess = app.client.connect();
        if(!linkSuccess) {
            JOptionPane.showConfirmDialog(null,"無法建立與伺服器端的連線");
            app.leaveFromFrame(ChatRoom.FrameType.LINKING);
            app.goToFrame(ChatRoom.FrameType.SIGNIN);
        }
        //set waiting flag up
        waiting = true;
        //start to recieve data
        app.client.start();
        //send a login request to server
        packageObj loginPack = new packageObj(packageType.LOGIN);
        userInfo user = new userInfo();
        //user.setName(app.userName);
        user.setID(app.userName);
        loginPack.setObj(user);
        app.client.send(loginPack);


    }

    //Called after recieving loginsuccess
    protected void loginSuccess(){
       if(waiting){
        app.leaveFromFrame(ChatRoom.FrameType.LINKING);
        app.goToFrame(ChatRoom.FrameType.MAIN);
        waiting = false;
       }
    }

    //Called when the ID has been used by others
    protected void errSameName(){

    }
    protected void myEnd(){
        this.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
