package nl.qsd.tardis.tartare;

import java.io.IOException;

/**
 *
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
@FunctionalInterface
public interface Pusher {
    
    void push(String text) throws IOException;
}
