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
*       http://stackoverflow.com/questions/21067551/auto-reconnect-to-a-server-using-a-socket-in-java
 *
 * Revision History:

Commits on Mar 3, 2015
    Fixed Buffered Reader/Completed Lab 
    The buffered reader was trying to read until a readline. Which it did
    not find. So instead, used a character array to buffer the input.
    Project Complete!

    Missing Source Corrections 
    Corrected some missing sources.

    EchoClientController Javadoc 
    Created the javadocs for the EchoClientController.

    Client Javadoc
    Created the client javadoc. Also updated error handling and removed the
    error label. Instead the messageLog text pane will also be used to
    report errors.

Commits on Mar 2, 2015
    Input and Output Streams
    Moved intiliazation of input stream and output stream to the
    constructor.

    Documentation and Client

    Client Thread
    I tried using a Client class that extends Runnable. Yes the client side
    implementation has issues and I'm not sure where to go
 */
package lab2.client.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Sheyla
 */
public class Client implements Runnable {

    private Thread worker;
    private final String server;
    private final int port;
    private Socket CLIENT;
    private InputStream is;
    private OutputStream os ;
    private final EchoClientController ec;
    private boolean connected;
    
    private final int CONNECT_RETRY = 1000 * 5;
    private long RETRY_TIME = 1000 * 15;
    
    Client( String server, int port, EchoClientController controller )
    {
        this.server = server;
        this.port = port;
        ec = controller;
        connected = false;
    }

    /**
     * Creates a new thread and begins to run.
     * @see Client.run()
     */
    public void goSocket() {
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
        DataOutputStream dos = new DataOutputStream( CLIENT.getOutputStream() ) ;
        
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
        openSocket();
        serverMessageListener();
    }
    
    /**
     * Listens for messages from the server.
     */
    private void serverMessageListener()
    {
        char[] buff = new char[500];
        //boolean connected = true;
        while( true ){
        while( connected ) {
            ec.enableRetry( false );
            // receiving a message
            InputStreamReader r;
            BufferedReader br;
            String msg;
            try {
                r = new InputStreamReader( CLIENT.getInputStream() );
                br = new BufferedReader( r ) ;
            
                //read in message from server
                int len = br.read(buff);
                msg = new String(buff, 0, len);
                
                //display the message to the user
                ec.handleServerMessages( msg );
            } catch (SocketException se){
                ec.updateErrorText( "Connection to the server dropped" );
                connected = false;
                ec.enableRetry( true );
                //run();
            }catch( Exception ex ) {
                //ec.updateErrorText( "Stream Read Error" );
            }
            //openSocket();
        }
        }
    }
    
    /**
     * Opens a socket connection to the server 
     * to listen for incoming messages.
     */
    public void openSocket()
    {
        long start = System.currentTimeMillis();
        long diff = 0;
        
        while( !connected && RETRY_TIME > ( diff - start ) ) {
            try{
                CLIENT = new Socket( server, port );
                ec.enableRetry( false );
                connected = true;
            } catch (IOException ex) {
                diff = System.currentTimeMillis();
                ec.updateErrorText("Unable to establish a connection to the server.");
                // logging
                try {
                    Thread.sleep( CONNECT_RETRY );
                } catch(InterruptedException e) {
                // logging
                }
            }
        }
        
        if( diff >= RETRY_TIME ){ ec.enableRetry( true ); }
        
    }
}
