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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sheyla
 */
public class MessagingModel {
    
    EchoClientController view;
    
    public void addController( EchoClientController newController ){ view = newController; }
    public void updateValue( String value ){}
    
    public void logMessage( String txt )
    {
        BufferedWriter bw = null;
        File f = null;
        
        try {
            f = new File("log.txt");
            if(!f.exists()) f.createNewFile();
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            
            bw.append( txt + "\n");
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
