/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import java.net.Socket;

/**
 *
 * @author Sheyla
 */
public class EchoClientController implements Controller{

    EchoClientMainView view;
    MessagingModel model;
    Socket s;// = new Socket();
    final int SERVERPORT = 7000;
    
    
    public void setView(EchoClientMainView view){ this.view = view; }
    public void setModel(MessagingModel model){ this.model = model; }

    public void handleUserMessage( String msg, String user ){}
    public void handleServerMessage(){}
    
    public void messageListener( String msg, String user )
    {
        model.logMessage( msg, "ERROR MESSAGE" );
        handleUserMessage( msg, user );
    }
    
    public void updateErrorText(String e){ view.setlblErrorText(e); }
    @Override
    public void update(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
