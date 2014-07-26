package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Tartare {

    public static void main(String[] args) throws IOException, URISyntaxException {
        new Tartare(args);
    }
    
    public Tartare(String[] args) throws IOException, URISyntaxException {
        parseArgs(args);                
    }        
    
    private void parseArgs(String[] args) throws IOException, URISyntaxException {
        if (args == null || args.length != 3) {
            System.err.print("Usage: <port> <source> <posturl>");
            System.exit(1);
        }
        
        int port = Integer.parseInt(args[0]);
        String source = args[1];
        String restUrl = args[2];
        
        listen(port, source, restUrl);
    }
    
    private void listen(final int port, final String source, final String restUrl) throws IOException, URISyntaxException {
        ServerSocket serverSocket = new ServerSocket(port);
        
        System.out.println("Listening to port " + port);
        
        while (true) {
            final Socket socket = serverSocket.accept();
            
            new Thread(() -> {
                try {
                    new SocketReader(socket.getInputStream(), 
                        new Transformer(source,
                                new Poster(
                                        new URI(restUrl))))
                        .push();            
                    }
                    catch (Throwable t) {
                        throw new RuntimeException(t);
                    }
                }).start();
        }                
    }
}
