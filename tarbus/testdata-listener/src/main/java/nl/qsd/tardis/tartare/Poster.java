package nl.qsd.tardis.tartare;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;

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
        URLConnection urlConn = this.restUrl.toURL().openConnection();
        urlConn.setDoOutput(true);
        urlConn.setUseCaches(false);
        urlConn.setRequestProperty("Content-Type", "application/json");
        
        try (DataOutputStream printout = new DataOutputStream(urlConn.getOutputStream())) {

            printout.writeBytes(URLEncoder.encode(text));
            printout.flush();
            printout.close();
        }
    }
}
