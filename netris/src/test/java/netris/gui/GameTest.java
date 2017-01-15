package netris.gui;

import java.awt.Point;
import netris.domain.Board;
import netris.domain.BoardCells;
import netris.domain.Shape;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    Board board;

    @Test
    public void testGetIterationDelay() {
        Game i = new Game();
        assertEquals(500, i.getIterationDelay());
    }

    @Test
    public void testGetScore() {
        Game i = new Game();
        assertEquals(12, i.getScore());
    }

    @Test
    public void testGetTotalScore() {
        Game i = new Game();
        assertEquals(0, i.getTotalScore());
    }

    @Test
    public void testGetRows() {
        Game i = new Game();
        assertEquals(0, i.getRows());
    }

    @Test
    public void testGetLevel() {
        Game i = new Game();
        assertEquals(1, i.getLevel());
    }

    @Test
    public void testStartGame() {
        Game i = new Game();
        i.startGame();
        assertTrue(i.gameOn);
        assertFalse(i.dropping);
        assertFalse(i.isPaused());
    }

    @Test
    public void testIsPlaying() {
        Game i = new Game();
        assertEquals(false, i.isPlaying());
    }

    @Test
    public void testIsPaused() {
        Game i = new Game();
        assertEquals(false, i.isPaused());
    }

    @Test
    public void testIsGameOver() {
        Game i = new Game();
        assertEquals(false, i.isGameOver());
    }

    @Test
    public void testPauseGame() {
        Game i = new Game();
        i.pauseGame();
        assertTrue(i.isPaused());
    }

    @Test
    public void testDrop() {
        Game i = new Game();
        i.drop();
        assertTrue(i.dropping);
    }

    @Test
    public void testIsDropping() {
        Game i = new Game();
        assertEquals(false, i.isDropping());
    }

    @Test
    public void testGetNextShape() {
        Game i = new Game();
        i.startGame();
        i.getNextShape();
        Assert.assertNotNull(i.nextShape);
    }

    @Test
    public void testMoveLeft() {
        Game i = new Game();
        Board b = new Board();
        i.startGame();
        BoardCells expResult = b.getShapeAt(0, 0);
        i.moveLeft();
        assertNotEquals(expResult, i.getBoardCells());
        assertTrue(i.moveLeft());
    }

    @Test
    public void testMoveRight() {
        Game i = new Game();
        Board b = new Board();
        i.startGame();
        BoardCells expResult = b.getShapeAt(0, 0);
        i.moveRight();
        assertNotEquals(expResult, i.getBoardCells());
        assertTrue(i.moveRight());
    }
/**
    @Test
    public void testMoveDownWhenNoSpace() {
        Game i = new Game();
        i.startGame();
        i.moveDown();
        if (board.canCurrentPieceMoveDown()== false) {
            if (i.droppingIterations == 0) {
                assertTrue(i.isGameOver());
                assertFalse(i.gameOn);
                assertTrue(i.moveDown());
            }
        }
    }*/

    @Test
    public void testMoveDownWhenSpace() {
        Game i = new Game();
        i.startGame();
        i.moveDown();
        assertFalse(i.dropping);
        assertEquals(1, i.droppingIterations);
        assertNotNull(i.nextShape);
        assertNotNull(i.getTotalScore());
        assertNotNull(i.droppingIterations);
    }
}
