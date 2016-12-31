
package netris;

import java.awt.event.KeyEvent;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
    
    @Test
    public void testThatPPausesGame() {
        Board boardToTest = new Board(new Netris());
        boardToTest.paalla = true;
        boardToTest.nykyinenPalikka.setMuoto(Shape.Palikka.Nelio);
        assertFalse(boardToTest.tauolla);
        KeyEvent pPress = new KeyEvent(boardToTest, 0, 0, 0, 0, 'p');
        pPress.setKeyCode('p');
        boardToTest.keyListener.keyPressed(pPress);
        assertTrue(boardToTest.tauolla);
    }
    
    
    @Test
    public void testThatLeftCannotMoveBlockToNegative() {
        Board boardToTest = new Board(new Netris());
        boardToTest.paalla = true;
        boardToTest.nykyinenPalikka.setMuoto(Shape.Palikka.Nelio);
        assertEquals(boardToTest.nykyinenX, 0);
        KeyEvent pPress = new KeyEvent(boardToTest, 0, 0, 0, 0, 'p');
        pPress.setKeyCode(KeyEvent.VK_LEFT);
        boardToTest.keyListener.keyPressed(pPress);
        assertEquals(boardToTest.nykyinenX, 0);
    }
        
}
