/*
 */

package nl.qsd.tardis.tartare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Ivo Limmen <ivo.limmen@qsd.nl>
 */
public class TransformerTest {
    
    @Test
    public void testSomeMethod() throws IOException {
        
        final List<String> output = new ArrayList<>();
        
        Transformer transformer = new Transformer(
                "blaat", 
                (String text) -> { output.add(text); });
        
        transformer.push("dit is mijn data");
        
        String expected = "{\"event\": {\"metadata\":{\"timestamp\":XXXXXXXXXXXXX,\"source\":\"blaat\"}, \"data\":\"ZGl0IGlzIG1pam4gZGF0YQ==\"}}";
        
        assertEqualsMostly(expected, output.get(0), 'X');
    }
    
    private void assertEqualsMostly(String expected, String actual, char ignoreMask) {
        // must be of the same length
        Assert.assertEquals(expected.length(), actual.length());
                
        for (int index = 0; index < expected.length(); index++) {
            char letter = expected.charAt(index);
            if (letter != ignoreMask) {
                Assert.assertEquals(letter, actual.charAt(index));
            }
        }
    }
    
}
