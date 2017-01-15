
package netris.domain;

import netris.gui.Game;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetWidth() {
        Board instance = new Board();
        int result = instance.getWidth();
        assertEquals(10, result);
    }

    @Test
    public void testGetHeight() {
        Board instance = new Board();
        int result = instance.getHeight();
        assertEquals(20, result);
    }

    @Test
    public void testGetFullRows() {
        Board i = new Board();
        assertEquals(0, i.getFullRows());
    }
   
    @Test
    public void testRemoveFullRows() {
        Board i = new Board();
        i.removeFullRows();
        assertEquals(0, i.getFullRows());
    }

    @Test
    public void testSetCurrentPiece() {
        Shape i = new Shape(NetrisPieces.O, NetrisPieces.O.getPoints(), true);
        Board instance = new Board();
        instance.setCurrentPiece(i);
    }

    @Test
    public void testRotate() {
        Game a = new Game();
        a.startGame();
        a.rotate();
    }
    @Test
    public void testMoveLeft() {
        Game a = new Game();
        a.startGame();
        a.moveLeft();
    }
       @Test
    public void testMoveRight() {
        Game a = new Game();
        a.startGame();
        a.moveRight();
    }
    
    @Test
    public void testMoveDown() {
        Game a = new Game();
        a.startGame();
        a.moveDown();
        assertTrue(a.moveDown());
    }
}
