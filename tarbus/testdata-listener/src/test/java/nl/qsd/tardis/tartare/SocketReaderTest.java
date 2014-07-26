package nl.qsd.tardis.tartare;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class SocketReaderTest {
    
    @Test
    public void testSomeMethod() throws IOException {
        
        final String input = "data";
        final List<String> output = new ArrayList<>();
        
        SocketReader reader = new SocketReader(
                new ByteArrayInputStream(input.getBytes()), 
                (String text) -> { output.add(text); });
        
        reader.push();
        
        Assert.assertEquals("", input, output.get(0));
    }    
}
