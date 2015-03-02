/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Sources Consulted: 
    http://www.javabeginner.com/learn-java/java-threads-tutorial
 */
package lab2.client.server;

/**
 *
 * @author Sheyla
 */
public class RunnableThread implements Runnable{

    Thread worker;
    
    public RunnableThread(){}
    public RunnableThread( String threadName )
    {
        worker = new Thread(this, threadName);
        worker.start();
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
    
}
