/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.client.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sheyla
 */
public class MessagingModel {
    
    List<Controller> views;
    
    public void addController( Controller newController ){ views.add(newController); }
    public void updateValue( String value ){}
    private void updateControllers(){}
    
    public void logMessage( String txt )
    {
        BufferedWriter bw = null;
        File f = null;
        txt = (new Date()).toString() + ": " + txt;
        
        try {
            f = new File("log.txt");
            if(!f.exists()) f.createNewFile();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
            bw.append(txt);
        } catch (IOException ex) {
            // report
            System.out.println("Error logging message");
        } finally {
            try {bw.close();} catch (Exception ex) {}
        }
    }
    
    
}
