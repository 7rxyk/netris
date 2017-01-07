
package netris;

import java.awt.Graphics2D;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    Board board;

     /*
    public TAdapter keyListener;

    @Test
    public void testThatPPausesGame() {
        Board peli = new Board(new Netris());
        peli.gameOn = true;
        peli.currentPiece.setShape(NetrisPieces.O);
        assertFalse(peli.paused);
        KeyEvent pPress = new KeyEvent(peli, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        peli.keyListener.keyPressed(pPress);
        assertTrue(peli.paused);
    }

    @Test
    public void testThatLeftCannotMoveBlockToNegative() {
        Board boardToTest = new Board(new Netris());
        boardToTest.gameOn = true;
        boardToTest.currentPiece.setShape(NetrisPieces.O);
        assertEquals(boardToTest.currentX, 0);
        KeyEvent pPress = new KeyEvent(boardToTest, 0, 0, 0, 0, 'p');
        pPress.setKeyCode(KeyEvent.VK_LEFT);
        boardToTest.keyListener.keyPressed(pPress);
        assertEquals(boardToTest.currentX, 0);
    }*/

    /**
     * Test of shapeAt method, of class Board.
     */
    @Test
    public void testShapeAt() {
        int x = 0;
        int y = 0;
        Board instance = new Board();
        NetrisPieces expResult = null;
        NetrisPieces result = instance.shapeAt(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of fullRow method, of class Board.
     */
    @Test
    public void testFullRow() {
        Board instance = new Board();
        instance.fullRow();
    }

    /**
     * Test of emptyBoard method, of class Board.
     */
    @Test
    public void testEmptyBoard() {
        Board instance = new Board();
        instance.emptyBoard();

    }

    /**
     * Test of pieceDropped method, of class Board.
     */
    @Test
    public void testPieceDropped() {
        Board instance = new Board();
        instance.pieceDropped();
    }

    /**
     * Test of removeFullRow method, of class Board.
     */
    @Test
    public void testRemoveFullRow() {
        Board instance = new Board();
        instance.removeFullRow();
    }

    /**
     * Test of getGameGraphics method, of class Board.
     */
    @Test
    public void testGetGameGraphics() {
        Board instance = new Board();
        Graphics2D expResult = null;
        Graphics2D result = instance.getGameGraphics();
        assertEquals(expResult, result);
    }

    /**
     * Test of paintComponent method, of class Board.
     */
    @Test
    public void testPaintComponent() {
        Graphics2D g = null;
        Board instance = new Board();
        instance.paintComponent(g);
    }

    /**
     * Test of drawSquare method, of class Board.
     */
    @Test
    public void testDrawSquare() {
        Graphics2D g = null;
        int x = 0;
        int y = 0;
        Board instance = new Board();
        instance.drawSquare(g, x, y);
    }

    /**
     * Test of getFullLines method, of class Board.
     */
    @Test
    public void testGetFullLines() {
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getFullLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLevel method, of class Board.
     */
    @Test
    public void testGetLevel() {
        Board instance = new Board();
        String expResult = "1";
        String result = instance.getLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLines method, of class Board.
     */
    @Test
    public void testGetLines() {
        Board instance = new Board();
        String expResult = "0";
        String result = instance.getLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScore method, of class Board.
     */
    @Test
    public void testGetScore() {
        Board instance = new Board();
        String expResult = "0";
        String result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of drawStatus method, of class Board.
     */
    @Test
    public void testDrawStatus() {
        Board instance = new Board();
        Graphics2D g = null;
        instance.drawStatus(g);
    }

    /**
     * Test of drawHelpBox method, of class Board.
     */
    @Test
    public void testDrawHelpBox() {
        Graphics2D g = null;
        Board instance = new Board();
        instance.drawHelpBox(g);
    }
}
