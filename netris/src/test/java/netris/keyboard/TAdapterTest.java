package netris.keyboard;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TAdapterTest {

    @Test
    public void test() {
        String name = "Hello";
        assertEquals(name, "Hello");
    }

    /**
     * Test of actionPerformed method, of class TAdapter.
     *
     * @Test public void testActionPerformed() { ActionEvent e = null; TAdapter
     * instance = null; instance.actionPerformed(e);
    }
     */
    /**
     * Test of keyPressed method, of class TAdapter.
     *
     * @Test public void testKeyPressed() { Board game = new Board(new
     * Netris()); game.gameOn = true;
     * game.currentPiece.setShape(NetrisPieces.O); assertFalse(game.paused);
     * KeyEvent pPress = new KeyEvent(game, 0, 0, 0, 0, 'p');
     * pPress.setKeyCode('p'); game.keyListener.keyPressed(pPress);
     * assertTrue(game.paused);
    }
     */
}
