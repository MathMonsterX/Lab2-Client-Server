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

Revision History:
Commits on Mar 3, 2015
    Missing Source Corrections 
    Corrected some missing sources.

    MessagingModel Javadoc 
    Created the javadocs for the messaging model. The messaging model is
    mainly in charge of storing server messages and any program errors in a
    log.

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

    Thread Class Deletions 
    I decided to delete the separate implementation of the threads.  Instead
    I am going to put implement the threads and sockets in the echoclient
    controller.

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

    MVC Setup 
    Set up connections between the model, view, and controller.

    Message Model 
    Created a model to handle the saving of messages including the date and
    time a message is sent or recieved.
 */
package lab2.client.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sheyla
 */
public class MessagingModel {
    
    EchoClientController view;
    
    /**
     * Sets the controller of the messagingModel.
     * @param newController     The controller for the model
     */
    public void addController( EchoClientController newController ){ view = newController; }

    /**
     * Creates a log file where server messages are kept track of. 
     * If the file ("log.txt") does not exist, one is created.
     * Also informs the controller of errors in logging messages.
     * Errors are also saved within the log.
     * @param msg   The message to be logged
     */
    public void logMessage( String msg )
    {
        BufferedWriter bw = null;
        File f = null;
        
        try {
            f = new File("log.txt");
            if(!f.exists()) f.createNewFile();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            
            bw.append(msg + "\n");
        } catch (IOException ex) {
            // report
            view.updateErrorText(ex.getMessage());
            //Can I be sure that the file is always there?
            //Assuming I can...this should be ok...
            //Assuming I can't...that's a lot of memory...
            //logMessage(ex.getMessage());
        } finally {
            try {bw.close();} catch (Exception ex) { view.updateErrorText(ex.getMessage());}
        }
    }
    
    
}
