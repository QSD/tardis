package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Tartare {

    public void main(String[] args) throws IOException, URISyntaxException {
        
        // parse arguments
        int port = 2020;
                
        ServerSocket serverSocket = new ServerSocket(port);
        
        while (true) {
            new SocketReader(serverSocket.accept(), 
                    new Transformer("ivo",
                            new Poster(
                                    new URI("http://localhost:8080"))));
        }        
    }
}
