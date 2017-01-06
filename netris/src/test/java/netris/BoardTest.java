/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netris;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import netris.Keyboard.TAdapter;
import netris.netrisGUI.Netris;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noora
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    /**
     * Test of actionPerformed method, of class Board.
     
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Board instance = null;
        instance.actionPerformed(e);
    }*/

    /**
     * Test of start method, of class Board.
     
    @Test
    public void testStart() {
        System.out.println("start");
        Board instance = null;
        instance.start();
    }*/

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
    }*/

    /**
     * Test of fullRow method, of class Board.
     
    @Test
    public void testFullRow() {
        System.out.println("fullRow");
        Board instance = null;
        instance.fullRow();
    }*/

    /**
     * Test of move method, of class Board.
     
    @Test
    public void testMove() {
        System.out.println("move");
        Shape newPiece = null;
        int newX = 0;
        int newY = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.move(newPiece, newX, newY);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of paintComponent method, of class Board.
     
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Board instance = null;
        instance.paintComponent(g);
    }*/

    /**
     * Test of drawSquare method, of class Board.
    
    @Test
    public void testDrawSquare() {
        System.out.println("drawSquare");
        Graphics g = null;
        int x = 0;
        int y = 0;
        Board instance = null;
        instance.drawSquare(g, x, y);
    } */
    
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
 
}
