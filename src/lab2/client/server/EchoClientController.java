/*
 * Name: Sheyla Trudo
 * Course: CSCE 320
 * Semester: Spring 2015
 * Language: Java
 * IDE: Netbeans 8.0.2
 * Date: 3/2/2015
 * 
 * Sources Consulted:
 *      Dr. George Hauser
 *      Chris Boe
 */
package lab2.client.server;

/**
 *
 * @author Sheyla
 */
public class EchoClientController {

    EchoClientMainView view;
    MessagingModel model;
    Client client;
    
    /**
     * Sets the view for the program. Currently just a simple user interface.
     * Setter method.
     * @param view      The view the controller refers to
     */
    public void setView(EchoClientMainView view){ this.view = view; }

    /**
     * Sets the model for the program. This model is mostly in charge of 
     * logging incoming information and errors.
     * Setter method.
     * @param model     The model the controller refers to
     */
    public void setModel(MessagingModel model){ this.model = model; }

    /**
     * Sets the client model the controller refers to in order 
     * to handle messages to and from a server.
     * Setter method.
     * @param client    The client the controller refers to
     */
    public void setClient( Client client ){ this.client = client; }
    
    /**
     * Starts the listener thread of the program. Listens
     * for incoming server messages.
     */
    public void listenForServerMessages() {
        try {
            client.goSocket();
        } catch (Exception ex) {
            updateErrorText(ex.getMessage());
        }
    }
    
    /**
     * Called by the client when a message has been 
     * received from the server. Logs the message with the 
     * Messaging model and updates the view with the messages.
     * @param msg   The incoming message
     */
    public void handleServerMessages( String msg ) {
        model.logMessage(msg);
        view.postMessage(msg);
    }
    
    /**
     * Called when a user attempts to send a message. 
     * This method send the message to the global variable client. 
     * @param msg   The message to be sent to the server.
     * 
     * @see client
     */
    public void messageListener( String msg )
    {
        try {
            client.sendMessage(msg);
        } catch (Exception ex) {
            updateErrorText(ex.getMessage());
        }
    }
    
    /**
     * When an exception is thrown, the exception is 
     * intended to call this method by sending the exception message.
     * Makes a call to the view to update the messageLog text field to inform 
     * the user of the error. Also calls upon the model to record the error in a text file.
     * 
     * @param e    The error message
     */
    public void updateErrorText(String e)
    { 
        view.postMessage(e); 
        model.logMessage(e); 
    } 
    
}
