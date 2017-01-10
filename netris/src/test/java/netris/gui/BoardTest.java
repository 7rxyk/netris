package netris.gui;

import netris.domain.NetrisPieces;
import netris.domain.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    public BoardTest() {
    }

    @Test
    public void testValuesAtBeginning() {
        assertFalse(board.gameOn);
        assertFalse(board.paused);
        assertFalse(board.pieceDown);
        assertEquals(NetrisPieces.Test, board.currentPiece);
        assertEquals(0, board.currentX);
        assertEquals(0, board.currentY);
    }

    /**
     * Test of shapeAt method, of class Board.
     */
    @Test
    public void testShapeAt() {
        int x = 0;
        int y = 0;
        Board instance = new Board(new Netris());
        NetrisPieces expResult = instance.shapeAt(x, y);
        NetrisPieces result = instance.shapeAt(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of start method, of class Board.
     */
    @Test
    public void testStart() {
        Board instance = new Board(new Netris());
        instance.start();
        assertTrue(instance.timer.isRunning());
    }

    /**
     * Test of pause method, of class Board.
     */
    @Test
    public void testPause() {
        Board instance = new Board(new Netris());
        instance.start();
        instance.pause();
        assertFalse(instance.timer.isRunning());
    }

    /**
     * Test of pieceDropped method, of class Board.
     */
    @Test
    public void testPieceDropped() {
        Board instance = new Board(new Netris());
        instance.pieceDropped();
        assertTrue(board.pieceDown);
    }

    /**
     * Test of move method, of class Board.
     */
    @Test
    public void testMoveTooMuchToTheLeft() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = -10;
        int newY = 0;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheRight() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 10;
        int newY = 0;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheUp() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 0;
        int newY = 23;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheDown() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 0;
        int newY = -23;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testToTheLeft() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = -3;
        int newY = 0;
        boolean expResult = true;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testToTheRight() {
        Board instance = new Board(new Netris());
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 3;
        int newY = 0;
        boolean expResult = true;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }
}
