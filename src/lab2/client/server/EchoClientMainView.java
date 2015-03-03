/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import java.awt.Color;

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

    public void setMessagesPane( String m ){ txtMessage.setText( txtMessage.getText() + "/n" + m );}
    public void setlblErrorText( String e ){ lblError.setText(e); }
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
        lblError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));
        setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        txtMessage.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMessage.setText("Place text here and press ENTER to send");
        txtMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMessageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMessageFocusLost(evt);
            }
        });
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

        lblError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMessage)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMessageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusLost
        txtMessage.setBackground(new Color(txtMessage.getBackground().getRed(),txtMessage.getBackground().getGreen(),txtMessage.getBackground().getBlue(),255));
    }//GEN-LAST:event_txtMessageFocusLost

    private void txtMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMessageFocusGained
        txtMessage.setBackground( new Color(txtMessage.getBackground().getRed(),txtMessage.getBackground().getGreen(),txtMessage.getBackground().getBlue(),127));
    }//GEN-LAST:event_txtMessageFocusGained

    private void txtMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMessageActionPerformed
        controller.messageListener(txtMessage.getText().trim(), username);
        txtMessage.setText("");
    }//GEN-LAST:event_txtMessageActionPerformed

    public void postMessage( String msg ){ messageLog.append( msg ); }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextArea messageLog;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables

    
}
