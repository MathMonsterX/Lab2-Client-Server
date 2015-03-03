/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class EchoClientController implements Controller{

    EchoClientMainView view;
    MessagingModel model;
    Client client;
    
    public void setView(EchoClientMainView view){ this.view = view; }
    public void setModel(MessagingModel model){ this.model = model; }
    public void setClient( Client client ){ this.client = client; }
    
    void handleServerMessages( String msg ) {
        model.logMessage(msg);
        view.postMessage(msg);
    }
    
    public void messageListener( String msg, String user )
    {
        msg = (new Date().toString() + ": " + user + ": " + msg);
        model.logMessage( msg );
        try {
            client.sendMessage(msg);
        } catch (IOException ex) {
            model.logMessage(ex.getMessage());
            view.setlblErrorText(ex.getMessage());
        }
    }
    
    public void updateErrorText(String e){ view.setlblErrorText(e); }
    @Override
    public void update(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void listenForServerMessages() {
        try {
            client.goSocket();
        } catch (IOException ex) {
            model.logMessage(ex.getMessage());
            view.setlblErrorText(ex.getMessage());
        }
    }

    
    
}
