/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netris;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noora
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class Board.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Board instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Board.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Board instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pause method, of class Board.
     */
    @Test
    public void testPause() {
        System.out.println("pause");
        Board instance = null;
        instance.pause();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class Board.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        Board instance = null;
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fullRow method, of class Board.
     */
    @Test
    public void testFullRow() {
        System.out.println("fullRow");
        Board instance = null;
        instance.fullRow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of liikuta method, of class Board.
     */
    @Test
    public void testLiikuta() {
        System.out.println("liikuta");
        Shape newPiece = null;
        int newX = 0;
        int newY = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.liikuta(newPiece, newX, newY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class Board.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        Board instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawSquare method, of class Board.
     */
    @Test
    public void testDrawSquare() {
        System.out.println("drawSquare");
        Graphics g = null;
        int x = 0;
        int y = 0;
        Board instance = null;
        instance.drawSquare(g, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
      /*  
    public TAdapter keyListener;

    @Test
    public void testThatPPausesGame() {
        Pelilauta peli = new Pelilauta(new Netris());
        peli.paalla = true;
        peli.nykyinenPalikka.asetaMuoto(NetrisPalat.Nelio);
        assertFalse(peli.tauolla);
        KeyEvent pPress = new KeyEvent(peli, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        peli.keyListener.keyPressed(pPress);
        assertTrue(peli.tauolla);
    }

    @Test
    public void testThatLeftCannotMoveBlockToNegative() {
        Pelilauta boardToTest = new Pelilauta(new Netris());
        boardToTest.paalla = true;
        boardToTest.nykyinenPalikka.asetaMuoto(NetrisPalat.Nelio);
        assertEquals(boardToTest.nykyinenX, 0);
        KeyEvent pPress = new KeyEvent(boardToTest, 0, 0, 0, 0, 'p');
        pPress.setKeyCode(KeyEvent.VK_LEFT);
        boardToTest.keyListener.keyPressed(pPress);
        assertEquals(boardToTest.nykyinenX, 0);
    }
*/
    
}
