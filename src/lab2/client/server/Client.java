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
 *      http://www.javabeginner.com/learn-java/java-threads-tutorial
 *      http://www.oracle.com/technetwork/java/socket-140484.html#client
 */
package lab2.client.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

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
        is = CLIENT.getInputStream() ;
        os = CLIENT.getOutputStream() ;
    }

    /**
     * Creates a new thread and begins to run.
     * @throws Exception    Underlying methods may throw an exception.
     * @see Client.run()
     */
    public void goSocket() throws Exception {
        worker = new Thread( this ) ;
        worker.start() ;  // calls run() in the new Thread
    }

    // send messages to the server

    /**
     * A separate thread method prepares the message to be sent here 
     * and writes the byte stream to the server.
     * HANDLES SENDING MESSAGES.
     * @param msg   The message to be sent.
     * @throws Exception
     */
    public void sendMessage( String msg ) throws Exception {
        System.out.println(Thread.currentThread());
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
    /**
     * Gets messages from the server and sends them 
     * to the controller to be handled.
     * HANDLES RECEIVING MESSAGES.
     */
    public void run() {
        char[] buff = new char[500];
        while( true ) {
            System.out.println(Thread.currentThread());
            // receiving a message
            InputStreamReader r = new InputStreamReader(is);
            BufferedReader br = new BufferedReader( r ) ;
            String msg ;
            try {
                //read in message from server
                int len = br.read(buff);
                msg = new String(buff, 0, len);
                
                //display the message to the user
                ec.handleServerMessages( msg );
            } catch (IOException ex) {
                ec.updateErrorText(ex.getMessage());
            }
            
        }
    }
}
