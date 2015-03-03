/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class Client implements Runnable {

    Thread worker;
    Socket CLIENT;
    InputStream is;
    OutputStream os ;
    EchoClientController ec;
    
    Client( String server, int port, EchoClientController controller ) throws IOException 
    {
        CLIENT = new Socket( server, port );
        ec = controller;
    }

    public void goSocket() throws IOException {
        worker = new Thread( this ) ;
        is = CLIENT.getInputStream() ;
        os = CLIENT.getOutputStream() ;
        worker.start() ;  // calls run() in the new Thread
    }

    // send messages to the server
    public void sendMessage( String msg ) throws IOException {
        
        DataOutputStream dos = new DataOutputStream( os ) ;
        
        // sending a message
            //get a message from the user
            //send the message to the Server
        byte [] buff ;
        buff = msg.getBytes() ;
        dos.write( buff, 0, msg.length() ) ;
        dos.flush();
    }
        
    @Override
    // get messages from the server
    public void run() {
        while( true ) {
            // receiving a message
            InputStreamReader r = new InputStreamReader(is);
            BufferedReader br = new BufferedReader( r ) ;
            String msg ;
            try {
                //read in message from server
                msg = br.readLine();
                
                //display the message to the user
                ec.handleServerMessages( msg );
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
