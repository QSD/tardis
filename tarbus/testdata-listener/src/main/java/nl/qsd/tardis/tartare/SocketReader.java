/*
 */
package nl.qsd.tardis.tartare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class SocketReader {

    private final Socket socket;

    private final BufferedReader inputStream;

    private final Transformer transformer;
    
    public SocketReader(Socket socket, Transformer transformer) throws IOException {

        this.transformer = transformer;
        this.socket = socket;
        this.inputStream = new BufferedReader(
                new InputStreamReader(
                        this.socket.getInputStream()));
    }

    public void push() throws IOException {

        String line = null;
        while ((line = this.inputStream.readLine()) == null) {            
            transformer.transform(line);
        }
    }
}
