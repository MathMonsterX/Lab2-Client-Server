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
    
    void listenForServerMessages() {
        try {
            client.goSocket();
        } catch (Exception ex) {
            updateErrorText(ex.getMessage());
        }
    }
    
    void handleServerMessages( String msg ) {
        model.logMessage(msg);
        view.postMessage(msg);
    }
    
    public void messageListener( String msg )
    {
        try {
            client.sendMessage(msg);
        } catch (Exception ex) {
            updateErrorText(ex.getMessage());
        }
    }
    
    public void updateErrorText(String e){ view.setMessagesPane(e); model.logMessage(e); }
    
    @Override
    public void update(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
