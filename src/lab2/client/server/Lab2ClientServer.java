/*
 * Name: Sheyla Trudo
 * Course: CSCE 320
 * Semester: Spring 2015
 * Date: 3/2/2015
 * 
 */
package lab2.client.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        JFrame clientView = new JFrame();
        clientView.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        EchoClientMainView view = new EchoClientMainView() ; 
        EchoClientController controller = new EchoClientController();
        MessagingModel model = new MessagingModel();
        Client client;
        
        view.setController(controller);
        controller.setView(view);
        controller.setModel(model);
        try {
            controller.setClient( new Client( "152.117.177.191", 54321, controller) );
        } catch (IOException ex) {
            Logger.getLogger(Lab2ClientServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.addController(controller);
        
        clientView.add( view );
        clientView.pack();
        clientView.setVisible(true);
        
        controller.listenForServerMessages();
        
    }
    
}
