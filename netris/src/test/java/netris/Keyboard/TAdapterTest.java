
package netris.Keyboard;

import java.awt.event.KeyEvent;
import netris.Board;
import netris.NetrisPieces;
import netris.netrisGUI.Netris;
import static org.junit.Assert.*;
import org.junit.Test;

public class TAdapterTest {
    
    public TAdapterTest() {
    }

    /**
     * Test of keyPressed method, of class TAdapter.
     
    @Test
    public void testKeyPressed() {
        Board game = new Board(new Netris());
        game.gameOn = true;
        game.currentPiece.setShape(NetrisPieces.O);
        assertFalse(game.paused);
        KeyEvent pPress = new KeyEvent(game, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        game.keyListener.keyPressed(pPress);
        assertTrue(game.paused);
    }*/
}
