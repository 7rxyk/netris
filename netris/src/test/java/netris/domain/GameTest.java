package netris.domain;

import netris.gui.Game;
import javax.swing.JLabel;
import javax.swing.Timer;
import netris.gui.Netris;
import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {

    private Game game;
    private JLabel statusbar;
    private Timer timer;

    /*
    @Test
    public void testValuesAtBeginning() {
        game = new Game(new Board(new Netris()));
        assertTrue(game.gameOn);
        assertFalse(game.paused);
        assertFalse(game.pieceDown);
        assertNotNull(game.currentPiece);
        assertEquals(0, game.currentX);
        assertEquals(0, game.currentY);
    }*/
 /*
    @Test
    public void testPieceIsDown() {
        game = new Game(new Board(new Netris()));
        boolean expResult = false;
        boolean result = game.pieceIsDown();
        assertEquals(expResult, result);
    }

    @Test
    public void testNewPiece() {
        game = new Game(new Board(new Netris()));
        game.currentPiece.setRandomShape();
        if (game.currentPiece.getShape() == NetrisPieces.Test) {
            assertEquals(statusbar.getText(), "game over");
            assertFalse(timer.isRunning());
        }
        assertNotNull(game.currentPiece);
    }

    @Test
    public void testMovePieceOutside() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.S);
        int newX = -10;
        int newY = 0;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(false, result);
    }

    @Test
    public void testMovePieceInBounds() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.S);
        int newX = 2;
        int newY = 0;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(false, result);
    }
    
     @Test
    public void testMoveTooMuchToTheLeft() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = -10;
        int newY = 0;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheRight() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 10;
        int newY = 0;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheUp() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 0;
        int newY = 23;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveTooMuchToTheDown() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 0;
        int newY = -23;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testToTheLeft() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = -3;
        int newY = 0;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
    }

    @Test
    public void testToTheRight() {
        game = new Game(new Board(new Netris()));
        Shape newPiece = new Shape();
        newPiece.setShape(NetrisPieces.getRandomNetrisPieces());
        int newX = 3;
        int newY = 0;
        boolean expResult = false;
        boolean result = game.movePiece(newPiece, newX, newY);
        assertEquals(expResult, result);
     }*/
/*
    @Test
    public void testCheckFullRows() {
        game = new Game(new Board(new Netris()));
        game.removeFullRow();
        assertEquals(0, game.linesRemoved);
    }*/
    /*
    @Test
    public void testDrop() {
        game = new Game(new Board(new Netris()));
        game.drop();
        assertTrue(game.pieceDown);
    }

    @Test
    public void testFullRow() {
        game = new Game(new Board(new Netris()));
        game.fullRow();
        assertEquals(1, game.linesRemoved);
    }*/
}
