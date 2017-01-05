package netris;

import java.awt.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetrisPiecesTest {
    
    public NetrisPiecesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class NetrisPieces.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        NetrisPieces[] expResult = null;
        NetrisPieces[] result = NetrisPieces.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class NetrisPieces.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        NetrisPieces expResult = null;
        NetrisPieces result = NetrisPieces.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRandomNetrisPieces method, of class NetrisPieces.
     */
    @Test
    public void testGetRandomNetrisPieces() {
        System.out.println("getRandomNetrisPieces");
        NetrisPieces expResult = null;
        NetrisPieces result = NetrisPieces.getRandomNetrisPieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCoordinates method, of class NetrisPieces.
     */
    @Test
    public void testGetCoordinates() {
        System.out.println("getCoordinates");
        NetrisPieces instance = null;
        int[][] expResult = null;
        int[][] result = instance.getCoordinates();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColorToNetrisPieces method, of class NetrisPieces.
     */
    @Test
    public void testGetColorToNetrisPieces() {
        System.out.println("getColorToNetrisPieces");
        NetrisPieces shape = null;
        NetrisPieces instance = null;
        Color expResult = null;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
