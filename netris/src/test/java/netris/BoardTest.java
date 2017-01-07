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
