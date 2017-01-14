
package netris.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardCellsTest {
    
    public BoardCellsTest() {
    }

    /**
     * Test of isEmpty method, of class BoardCells.
     */
    @Test
    public void testIsEmpty() {
        BoardCells instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNetrisPieces method, of class BoardCells.
     */
    @Test
    public void testGetNetrisPieces() {
        BoardCells instance = null;
        NetrisPieces expResult = null;
        NetrisPieces result = instance.getNetrisPieces();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCell() {
        System.out.println("getCell");
        NetrisPieces piece = null;
        BoardCells expResult = null;
        BoardCells result = BoardCells.getCell(piece);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmptyArray method, of class BoardCells.
     */
    @Test
    public void testGetEmptyArray() {
        int size = 0;
        BoardCells[] expResult = null;
        BoardCells[] result = BoardCells.getEmptyArray(size);
        assertArrayEquals(expResult, result);

    }
    
}
