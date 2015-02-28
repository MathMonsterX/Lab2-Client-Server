/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import javax.swing.JFrame;

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
        
        EchoClientMainView view = new EchoClientMainView() ; 
        EchoClientController controller = new EchoClientController();
        MessagingModel model = new MessagingModel();
        
        view.setController(controller);
        controller.setView(view);
        controller.setModel(model);
        model.addController(controller);
        
        clientView.add( view );
        clientView.pack();
        clientView.setVisible(true);
        
        
    }
    
}
