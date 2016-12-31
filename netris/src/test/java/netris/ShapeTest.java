package netris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {

    private Object Object;

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
     * Test of T method, of class Shape.
     */
    @Test
    public void testT() {
        System.out.println("T");
        Object = null;
        Shape instance = new Shape();
        instance.T(<error>);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Square method, of class Shape.
     */
    @Test
    public void testSquare() {
        System.out.println("Nelio");
        Object = null;
        Shape instance = new Shape();
        instance.Nelio(<error>);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of L method, of class Shape.
     */
    @Test
    public void testL() {
        System.out.println("L");
        Object = null;
        Shape instance = new Shape();
        instance.L(<error>);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MirrorL method, of class Shape.
     */
    @Test
    public void testMirrorL() {
        System.out.println("PeiliL");
        Object = null;
        Shape instance = new Shape();
        instance.PeiliL(<error>);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setShape method, of class Shape.
     */
    @Test
    public void testSetShape() {
        System.out.println("setShape");
        Shape.Pieces shape = null;
        Shape instance = new Shape();
        instance.setShape(shape);
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
     * Test of getShape method, of class Shape.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        Shape instance = new Shape();
        Shape.Pieces expResult = null;
        Shape.Pieces result = instance.getShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRandomShape method, of class Shape.
     */
    @Test
    public void testSetRandomShape() {
        System.out.println("setRandomShape");
        Shape instance = new Shape();
        instance.setRandomShape();
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
     * Test of rotateLeft method, of class Shape.
     */
    @Test
    public void testRotateLeft() {
        System.out.println("rotateLeft");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.rotateLeft();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateRight method, of class Shape.
     */
    @Test
    public void testRotateRight() {
        System.out.println("rotateRight");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.rotateRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
