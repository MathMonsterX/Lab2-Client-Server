/*
 * Name: Sheyla Trudo
 * Course: CSCE 320
 * Semester: Spring 2015
 * Language: Java
 * IDE: Netbeans 8.0.2
 * Date: 3/2/2015
 * 
 */
package lab2.client.server;

import java.util.Date;

/**
 *
 * @author Sheyla
 */
public class EchoClientMainView extends javax.swing.JPanel {

    final String username = System.getProperty("user.name");
    EchoClientController controller;
    
    /**
     * Creates new form ClientMainView
     */
    public EchoClientMainView() {
        initComponents();
        
    }

    /**
     * Sets the controller of the view. 
     * Controls the updating of the view's components.
     * @param controller    The controller that is used to update the view
     */
    public void setController(EchoClientController controller){ this.controller = controller; }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageLog = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(102, 255, 102));
        setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        txtMessage.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMessage.setText("Place text here and press ENTER to send");
        txtMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMessageActionPerformed(evt);
            }
        });

        messageLog.setEditable(false);
        messageLog.setColumns(20);
        messageLog.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        messageLog.setRows(5);
        jScrollPane1.setViewportView(messageLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(txtMessage))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        controller.messageListener( new Date().toString() + ": " + username + ": " + txtMessage.getText().trim() );
        txtMessage.setText("");
    }//GEN-LAST:event_txtMessageActionPerformed

    /**
     * Sets the text of the text area messageLog. 
     * Each new message is entered on a new line.
     * @param msg     The message to add to the text area
     * 
     * @see messageLog
     */
    public void postMessage( String msg ){ messageLog.append( msg ); }//messageLog.setText( messageLog.getText() + "\n" + msg); }//
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageLog;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    
}
