/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

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
        controller.setClient( new Client( "152.117.177.191", 54321, controller) );
        
        model.addController(controller);
        
        clientView.add( view );
        clientView.pack();
        clientView.setVisible(true);
        
        controller.listenForServerMessages();
        
    }
    
}
