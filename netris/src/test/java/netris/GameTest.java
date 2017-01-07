package netris;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    private Game game;
    
    /**
     * Test of getNextPiece method, of class Game.
     */
    @Test
    public void testGetNextPiece() {
        assertNotNull(game.getNextPiece());
    }

    /**
     * Test of getScore method, of class Game.
     */
    @Test
    public void testGetScore() {
        int expResult = 0;
        assertEquals(expResult, game.getScore());
    }

    /**
     * Test of getTotalScore method, of class Game.
     */
    @Test
    public void testGetTotalScore() {
        int expResult = 0;
        assertEquals(expResult, game.getTotalScore());
    }

    /**
     * Test of getLines method, of class Game.
     */
    @Test
    public void testGetLines() {
        int expResult = 0;
        assertEquals(expResult, game.getLines());
    }

    /**
     * Test of getLevel method, of class Game.
     */
    @Test
    public void testGetLevel() {
        int expResult = 0;
        assertEquals(expResult, game.getLevel());
    }

    /**
     * Test of start method, of class Game.
     */
    @Test
    public void testStart() {
        game.start();
        assertTrue(game.gameOn);
    }

    /**
     * Test of pause method, of class Game.
     */
    @Test
    public void testPause() {
        game.pause();
        assertTrue(game.paused);
    }

    /**
     * Test of drop method, of class Game.
     */
    @Test
    public void testDrop() {
        game.drop();
        assertTrue(game.pieceDown);
    }

    /**
     * Test of newPiece method, of class Game.
     */
    @Test
    public void testNewPiece() {
        assertNotNull(game.getNextPiece());
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        Shape newPiece = new Shape();
        newPiece.setRandomShape();
        int newX = 2;
        int newY = -3;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }
}
