package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Tartare {

    public static void main(String[] args) throws IOException, URISyntaxException {
        new Tartare(args);
    }

    private int port = 2020;
    
    private String restUrl = "htpp://localhost:8080";
    
    public Tartare(String[] args) throws IOException, URISyntaxException {
        parseArgs(args);        
        listen(this.port, this.restUrl);
    }        
    
    private void parseArgs(String[] args) {
        if (args == null || args.length != 2) {
            System.err.print("Usage: <port> <posturl>");
            System.exit(1);
        }
        
        this.port = Integer.parseInt(args[0]);
        this.restUrl = args[1];
    }
    
    private void listen(int port, String restUrl) throws IOException, URISyntaxException {
        ServerSocket serverSocket = new ServerSocket(port);
        
        while (true) {
            new SocketReader(serverSocket.accept(), 
                    new Transformer("ivo",
                            new Poster(
                                    new URI("http://localhost:8080"))));
        }                
    }
}
