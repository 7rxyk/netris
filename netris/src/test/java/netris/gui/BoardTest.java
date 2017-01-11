package netris.gui;

import java.awt.Graphics;
import netris.domain.Game;
import netris.domain.NetrisPieces;
import netris.domain.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    Graphics g;
    Game game;

    @Test
    public void testStart() {
        Board instance = new Board(new Netris());
        instance.start();
        assertTrue(instance.timer.isRunning());
    }

    @Test
    public void testPause() {
        Board instance = new Board(new Netris());
        instance.start();
        instance.pause();
        assertFalse(instance.timer.isRunning());
    }

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
        boolean expResult = false;
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
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
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
    public void testRemoveFullRow() {
        Board i = new Board(new Netris());
        i.removeFullRow();
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
    }
}
