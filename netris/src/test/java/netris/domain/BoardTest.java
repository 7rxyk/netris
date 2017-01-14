
package netris.domain;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    public BoardTest() {
    }
    
    @Test
    public void testGetWidth() {
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetHeight() {
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullRows method, of class Board.
     */
    @Test
    public void testGetFullRows() {
        System.out.println("getFullRows");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getFullRows();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShapeAt method, of class Board.
     */
    @Test
    public void testGetShapeAt() {
        System.out.println("getShapeAt");
        int x = 0;
        int y = 0;
        Board instance = new Board();
        BoardCells expResult = null;
        BoardCells result = instance.getShapeAt(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFullRows method, of class Board.
     */
    @Test
    public void testRemoveFullRows() {
        System.out.println("removeFullRows");
        Board instance = new Board();
        instance.removeFullRows();
    }

    /**
     * Test of rotate method, of class Board.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");
        Board instance = new Board();
        instance.rotate();
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        Board instance = new Board();
        instance.moveLeft();
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight");
        Board instance = new Board();
        instance.moveRight();
    }

    /**
     * Test of canCurrentPieceMoveDown method, of class Board.
     */
    @Test
    public void testCanCurrentPieceMoveDown() {
        System.out.println("canCurrentPieceMoveDown");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.canCurrentPieceMoveDown();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown() {
        System.out.println("moveDown");
        Board instance = new Board();
        instance.moveDown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fit method, of class Board.
     */
    @Test
    public void testFit() {
        System.out.println("fit");
        Point[] points = null;
        int moveX = 0;
        int moveY = 0;
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.fit(points, moveX, moveY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardWithPiece method, of class Board.
     */
    @Test
    public void testGetBoardWithPiece() {
        System.out.println("getBoardWithPiece");
        Board instance = new Board();
        BoardCells[][] expResult = null;
        BoardCells[][] result = instance.getBoardWithPiece();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPiece method, of class Board.
     */
    @Test
    public void testSetCurrentPiece() {
        System.out.println("setCurrentPiece");
        Shape piece = null;
        Board instance = new Board();
        instance.setCurrentPiece(piece);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
    
    @Test
    public void testStart() {
        Board instance = new Board(new Netris());
        instance.start();
        assertTrue(instance.timer.isRunning());
        assertNotNull(instance.game.currentPiece.getShape());
        assertEquals(true, instance.game.gameOn);
        assertEquals(false, instance.game.paused);
    }

    @Test
    public void testPause() {
        Board instance = new Board(new Netris());
        instance.start();
        instance.pause();
        assertFalse(instance.timer.isRunning());
        assertEquals(true, instance.game.gameOn);
        assertEquals(true, instance.game.paused);
    }

    @Test
    public void testShapeAt() {
        int x = 1;
        int y = 1;
        Board instance = new Board(new Netris());
        NetrisPieces expResult = NetrisPieces.Test;
        NetrisPieces result = instance.shapeAt(x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testEmptyBoard() {
        Board i = new Board(new Netris());
        i.emptyBoard();
        assertNotNull(i.board.length);
    }
    
    @Test
    public void testSquareWidth() {
        Board i = new Board(new Netris());
        int expResult = 0;
        int result = i.squareWidth();
        assertEquals(expResult, result);
    }

    @Test
    public void testSquareHeight() {
        Board i = new Board(new Netris());
        int expResult = 0;
        int result = i.squareHeight();
        assertEquals(expResult, result);
    }*/
}
