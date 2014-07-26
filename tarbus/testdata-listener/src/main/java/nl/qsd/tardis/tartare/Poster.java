package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URI;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Poster implements Pusher {

    private final URI restUrl;

    public Poster(URI restUrl) {
        this.restUrl = restUrl;
    }

    @Override
    public void push(String text) throws IOException {
        HttpURLConnection urlConn = (HttpURLConnection) this.restUrl.toURL().openConnection();
        urlConn.setDoOutput(true);
        urlConn.setDoInput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestMethod("PUT");        
        urlConn.connect();
        
        try (PrintStream printout = new PrintStream(urlConn.getOutputStream())) {

            printout.print(text);
            printout.flush();
        }     
        
        if (urlConn.getResponseCode() != 200) {
            System.err.println("Response code = " + urlConn.getResponseCode());
            System.err.println("Response code = " + urlConn.getResponseMessage());
        }
        else {
            System.err.println("--OK--");        
        }
        
        urlConn.disconnect();
    }
}
