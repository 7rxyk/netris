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
    Netris netris;
    
    public void BoardTest() {
        Board instance = new Board(new Netris());
        assertTrue(instance.setBoard(netris));
    }

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
    }
}
