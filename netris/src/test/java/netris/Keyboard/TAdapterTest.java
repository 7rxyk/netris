
package netris.Keyboard;

import java.awt.event.KeyEvent;
import netris.NetrisPalat;
import netris.Pelilauta;
import netris.netrisGUI.Netris;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TAdapterTest {
    
    public TAdapterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of keyPressed method, of class TAdapter.
   
    @Test
    public void testKeyPressedPause() {
        Pelilauta peli = new Pelilauta(new Netris());
        peli.paalla = true;
        peli.nykyinenPalikka.asetaMuoto(NetrisPalat.Nelio);
        assertFalse(peli.tauolla);
        KeyEvent pPress = new KeyEvent(peli, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        peli.keyListener.keyPressed(pPress);
        assertTrue(peli.tauolla);
    }  */
}
