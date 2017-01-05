
package netris.Keyboard;

import java.awt.event.KeyEvent;
import org.junit.After;
import static org.junit.Assert.*;
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
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent pressed = null;
        TAdapter instance = new TAdapter();
        instance.keyPressed(pressed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class TAdapter.
   
    @Test
    public void testKeyPressedPause() {
        Board game = new Board(new Netris());
        game.gameOn = true;
        game.currentPiece.setshape(NetrisPalat.O);
        assertFalse(game.paused);
        KeyEvent pPress = new KeyEvent(game, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        game.keyListener.keyPressed(pPress);
        assertTrue(game.paused);
    }  */
}
