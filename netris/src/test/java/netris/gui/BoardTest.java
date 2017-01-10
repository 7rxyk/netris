package netris.gui;

import java.awt.Graphics;
import netris.domain.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    
    public BoardTest() {
    }
    
    @Test
    public void test() {
        String name = "Hello";
        assertEquals(name, "Hello");
    }
/*
    /**
     * Test of start method, of class Board.
    
    @Test
    public void testStart() {
        System.out.println("start");
        Board instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of pause method, of class Board.
     
    @Test
    public void testPause() {
        System.out.println("pause");
        Board instance = null;
        instance.pause();
    }*/

    /**
     * Test of drop method, of class Board.
     
    @Test
    public void testDrop() {
        System.out.println("drop");
        Board instance = null;
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of fullRow method, of class Board.
     
    @Test
    public void testFullRow() {
        Board instance = null;
        instance.fullRow();
    }*/

    /**
     * Test of emptyBoard method, of class Board.
    
    @Test
    public void testEmptyBoard() {
        Board instance = null;
        instance.emptyBoard();

    } */

    /**
     * Test of pieceDropped method, of class Board.
    
    @Test
    public void testPieceDropped() {
        Board instance = null;
        instance.pieceDropped();
    } */

    /**
     * Test of newPiece method, of class Board.
     
    @Test
    public void testNewPiece() {
        Board instance = null;
        instance.newPiece();
    }*/

    /**
     * Test of move method, of class Board.
    
    @Test
    public void testMove() {
        Shape newPiece = null;
        int newX = 0;
        int newY = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    } */

    /**
     * Test of removeFullRow method, of class Board.
     
    @Test
    public void testRemoveFullRow() {
        Board instance = null;
        instance.removeFullRow();
    }*/

    /**
     * Test of paint method, of class Board.
    
    @Test
    public void testPaint() {
        Graphics g = null;
        Board instance = null;
        instance.paint(g);
    } */
}
