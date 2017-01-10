
package netris.domain;

import netris.gui.Board;
import netris.gui.Netris;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameTest {
    
    private Game game;
    private Board board;
    
    public GameTest() {
    }

    @Test
    public void testValuesAtBeginning() {
        assertFalse(game.gameOn);
        assertFalse(game.paused);
        assertFalse(game.pieceDown);
        assertEquals(NetrisPieces.Test, game.currentPiece);
        assertEquals(0, game.currentX);
        assertEquals(0, game.currentY);
    }
    
        /**
     * Test of shapeAt method, of class Board.
     */
    @Test
    public void testShapeAt() {
        int x = 0;
        int y = 0;
        Game instance = new Game(new Board(new Netris()));
        NetrisPieces expResult = board.shapeAt(x, y);
        NetrisPieces result = instance.gameBoard.shapeAt(x, y);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of pieceDropped method, of class Board.
     */
    @Test
    public void testPieceDropped() {
        Game instance = new Game(new Board(new Netris()));
        instance.pieceDropped();
        assertTrue(game.pieceDown);
    }
}
