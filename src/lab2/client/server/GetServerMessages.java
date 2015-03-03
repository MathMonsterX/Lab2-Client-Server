/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Sources Consulted: 
    http://www.javabeginner.com/learn-java/java-threads-tutorial
 */
package lab2.client.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sheyla
 */
public class GetServerMessages implements Runnable{

    Thread worker;
    int PORT;
    InetAddress addr;
    
    public GetServerMessages(){}
    public GetServerMessages( String threadName, String host, int port )
    {
        worker = new Thread(this, threadName);
        try {
            addr = InetAddress.getByName(host);
        } catch (UnknownHostException ex) {
            Logger.getLogger(GetServerMessages.class.getName()).log(Level.SEVERE, null, ex);
        }
        PORT = port;
        worker.start();
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        
    }
    
}
