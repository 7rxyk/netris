package netris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ShapeTest {
    
    public ShapeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setMuoto method, of class Shape.
     */
    @Test
    public void testSetMuoto() {
        System.out.println("setMuoto");
        Shape.Palikka muoto = null;
        Shape instance = new Shape();
        instance.setMuoto(muoto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of x method, of class Shape.
     */
    @Test
    public void testX() {
        System.out.println("x");
        int index = 0;
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.x(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of y method, of class Shape.
     */
    @Test
    public void testY() {
        System.out.println("y");
        int index = 0;
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.y(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMuoto method, of class Shape.
     */
    @Test
    public void testGetMuoto() {
        System.out.println("getMuoto");
        Shape instance = new Shape();
        Shape.Palikka expResult = null;
        Shape.Palikka result = instance.getMuoto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRandomMuoto method, of class Shape.
     */
    @Test
    public void testSetRandomMuoto() {
        System.out.println("setRandomMuoto");
        Shape instance = new Shape();
        instance.setRandomMuoto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minX method, of class Shape.
     */
    @Test
    public void testMinX() {
        System.out.println("minX");
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.minX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of minY method, of class Shape.
     */
    @Test
    public void testMinY() {
        System.out.println("minY");
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.minY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vasemmalle method, of class Shape.
     */
    @Test
    public void testVasemmalle() {
        System.out.println("vasemmalle");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.vasemmalle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of oikealle method, of class Shape.
     */
    @Test
    public void testOikealle() {
        System.out.println("oikealle");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.oikealle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
