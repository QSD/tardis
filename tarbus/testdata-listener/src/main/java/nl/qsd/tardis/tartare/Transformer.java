package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Transformer implements Pusher {
            
    private final String source;
    
    private final Pusher pusher;
    
    public Transformer(final String source, final Pusher pusher) {
        this.source= source;
        this.pusher = pusher;
    }

    @Override
    public void push(String text) throws IOException {
        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"event\": {");
        sb.append("\"metadata\":{");
        sb.append("\"timestamp\":");
        sb.append(new Date().getTime());
        sb.append(",\"source\":\"");
        sb.append(this.source);
        sb.append("\"}, \"data\":\"");
        sb.append(encoded);
        sb.append("\"}}");
                
        this.pusher.push(sb.toString());
    }
}
