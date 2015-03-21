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
 *
 * Revision History:
Commits on Mar 3, 2015
    Missing Source Corrections 
    Corrected some missing sources.

    Minor Alterations

    View Javadoc 
    Updated the view javadocs.

    EchoClientController Javadoc 
    Created the javadocs for the EchoClientController.

    Client Javadoc 
    Created the client javadoc. Also updated error handling and removed the
    error label. Instead the messageLog text pane will also be used to
    report errors.

Commits on Mar 2, 2015
    Error Messages 
    Working on improving the error messages system.

    Documentation and Client 
    Used the controller to take care of the Client. Almost looks like a
    second model to me. Also added the documentation for information
    provided by the instructor for the lab.

    Client Thread 
    I tried using a Client class that extends Runnable. Yes the client side
    implementation has issues and I'm not sure where to go.

    More Threading Set up 
    Currently I do not believe these changes will persist as I do not
    believe they are correct. I am trying to implement the threads and the
    sockets.

Commits on Feb 27, 2015
    Save Messages 
    Added a capability to save messages to a log. Essentially a
    'conversation history'.  Currently works directly from view to model.
    But in the future may change to only receiving server messages so that
    local messages that don't make it to the server aren't saved.

    Message Log and Error Notify 
    Setting up a system that saves error messages and regular messages in
    the message log. Users are also known by their logged in user name (on
    local computer).

    View Changes
    Methods implemented to cause changes in the view's objects. Calls
    controller which calls the model (or not), then back.

    Minor Controller Alterations

    MVC Setup 
    Set up connections between the model, view, and controller.

    Initializing files 
    Added the files needed for the project.
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
