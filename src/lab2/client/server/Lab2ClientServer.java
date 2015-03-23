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

Commits on Feb 27, 2015
    Save Messages
    Added a capability to save messages to a log. Essentially a
    'conversation history'.  Currently works directly from view to model.
    But in the future may change to only receiving server messages so that
    local messages that don't make it to the server aren't saved.

    Minor Controller Alterations

    MVC Setup 
    Set up connections between the model, view, and controller.

    Basic Client View Look
    Changed the look of the client view according to current requirements.

    Initialized repository 
    My first attempt to use GitHub.
 */
package lab2.client.server;

import java.io.IOException;
import java.net.InetAddress;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Sheyla
 */
public class Lab2ClientServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame clientView = new JFrame("First Java Messenger");
        clientView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        EchoClientMainView view = new EchoClientMainView() ; 
        EchoClientController controller = new EchoClientController();
        MessagingModel model = new MessagingModel();
        
        view.setController(controller);
        controller.setView(view);
        controller.setModel(model);
        clientView.add( view );
        
        try {
            controller.setClient( new Client( InetAddress.getLocalHost().getHostAddress(), 54321, controller) );
        } catch (IOException ex) {
            controller.updateErrorText(ex.getMessage());
        }
        
        model.addController(controller);
        
        clientView.pack();
        clientView.setVisible(true);
        
        controller.listenForServerMessages();
        
    }
    
}
