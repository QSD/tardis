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
    
    private String source = "tartare";
    
    private String restUrl = "htpp://localhost:8080";
    
    public Tartare(String[] args) throws IOException, URISyntaxException {
        parseArgs(args);        
        listen(this.port, this.source, this.restUrl);
    }        
    
    private void parseArgs(String[] args) {
        if (args == null || args.length != 3) {
            System.err.print("Usage: <port> <source> <posturl>");
            System.exit(1);
        }
        
        this.port = Integer.parseInt(args[0]);
        this.source = args[1];
        this.restUrl = args[2];
    }
    
    private void listen(int port, String source, String restUrl) throws IOException, URISyntaxException {
        ServerSocket serverSocket = new ServerSocket(port);
        
        System.out.println("Listening to port " + port);
        while (true) {
            new SocketReader(serverSocket.accept().getInputStream(), 
                    new Transformer(this.source,
                            new Poster(
                                    new URI(this.restUrl))))
                    .push();
            
            System.out.println("Send event...");
        }                
    }
}
