/*
 */
package nl.qsd.tardis.tartare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class SocketReader {

    private final BufferedReader inputStream;

    private final Pusher pusher;
    
    public SocketReader(InputStream inputStream, Pusher pusher) throws IOException {

        this.pusher = pusher;        
        this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void push() throws IOException {

        String line = null;
        while ((line = this.inputStream.readLine()) != null) {            
            pusher.push(line);
        }
        
        this.inputStream.close();                       
    }
}
