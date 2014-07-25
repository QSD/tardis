package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class Transformer {
            
    private final String source;
    
    private final Poster poster;
    
    public Transformer(final String source, final Poster poster) {
        this.source= source;
        this.poster = poster;
    }
    
    public void transform(String text) throws IOException {
        
        String encoded = Base64.getEncoder().encodeToString(text.getBytes());
        
        StringBuilder sb = new StringBuilder();
        sb.append("{event: {");
        sb.append("metadata:{");
        sb.append("timestamp:");
        sb.append(new Date().getTime());
        sb.append(",source:\"");
        sb.append(this.source);
        sb.append("\"}, data:\"");
        sb.append(encoded);
        sb.append("\"}}");
                
        this.poster.post(sb.toString());
    }
}
