package netris.netrisGUI;

import javax.swing.JLabel;
import org.junit.Test;

public class NetrisTest {
    
    /**
     * Test of getStatusBar method, of class Netris.
     */
    @Test
    public void testGetStatusBar() {

        Netris instance = new Netris();
        JLabel expResult = null;
        JLabel result = instance.getStatusBar();
        assertEquals(expResult, result);
    }
}
