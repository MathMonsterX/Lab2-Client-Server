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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Sheyla
 */
public class MessagingModel {
    
    EchoClientController view;
    
    /**
     * Sets the controller of the messagingModel.
     * @param newController     The controller for the model
     */
    public void addController( EchoClientController newController ){ view = newController; }

    /**
     * Creates a log file where server messages are kept track of. 
     * If the file ("log.txt") does not exist, one is created.
     * Also informs the controller of errors in logging messages.
     * Errors are also saved within the log.
     * @param msg   The message to be logged
     */
    public void logMessage( String msg )
    {
        BufferedWriter bw = null;
        File f = null;
        
        try {
            f = new File("log.txt");
            if(!f.exists()) f.createNewFile();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            
            bw.append(msg + "\n");
        } catch (IOException ex) {
            // report
            view.updateErrorText(ex.getMessage());
            //Can I be sure that the file is always there?
            //Assuming I can...this should be ok...
            //Assuming I can't...that's a lot of memory...
            //logMessage(ex.getMessage());
        } finally {
            try {bw.close();} catch (Exception ex) { view.updateErrorText(ex.getMessage());}
        }
    }
    
    
}
