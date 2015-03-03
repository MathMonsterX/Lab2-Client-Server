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

import java.io.IOException;
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
            controller.setClient( new Client( "152.117.177.191", 54321, controller) );
        } catch (IOException ex) {
            controller.updateErrorText(ex.getMessage());
        }
        
        model.addController(controller);
        
        
        clientView.pack();
        clientView.setVisible(true);
        
        controller.listenForServerMessages();
        
    }
    
}
