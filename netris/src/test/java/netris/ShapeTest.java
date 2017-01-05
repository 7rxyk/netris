package netris;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ShapeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testThatMinXReturnsCorrectForSuora() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.I);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForO() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.O);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForL() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.L);
        assertEquals(shapeToTest.minX(), -1);
    }

    @Test
    public void testThatMinXReturnsCorrectForS() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.S);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForZ() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.Z);
        assertEquals(shapeToTest.minX(), -1);
    }

    @Test
    public void testThatMinXReturnsCorrectForJ() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.J);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForSuora() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.I);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForL() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.L);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForO() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.O);
        assertEquals(shapeToTest.minY(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForJ() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.J);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForS() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.S);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForT() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.T);
        assertEquals(shapeToTest.minY(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForZ() {
        Shape shapeToTest = new Shape();
        shapeToTest.setShape(NetrisPieces.Z);
        assertEquals(shapeToTest.minY(), -1);
    }
    
    @Test
    public void testX() {
        int index = 0;
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.x(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testY() {
        int index = 0;
        Shape instance = new Shape();
        int expResult = 0;
        int result = instance.y(index);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetShape() {
        Shape instance = new Shape();
        NetrisPieces expResult = NetrisPieces.Test;
        NetrisPieces result = instance.getShape();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetRandomShape() {
        Shape instance = new Shape();
        instance.setRandomShape();
    }
 
    @Test
    public void testToLeftForI() {
        Shape i = new Shape();
        i.setShape(NetrisPieces.I);
        assertEquals(i.toLeft(), 0);
    }
   /*
        @Test
    public void testToLeftForJ() {
        Shape j = new Shape();
        Shape result = j.toLeft();
        assertEquals(j.toLeft(), result);
    }
        @Test
    public void testToLeftForL() {
        Shape l = new Shape();
        Shape result = l.toLeft();
        assertEquals(l.toLeft(), result);
    }
        @Test
    public void testToLeftForO() {
        Shape nelio = new Shape();
        Shape result = nelio.toLeft();
        assertEquals(nelio.toLeft(), result);
    }
        @Test
    public void testToLeftForT() {
        Shape t = new Shape();
        Shape result = t.toLeft();
        assertEquals(t.toLeft(), result);
    }
        @Test
    public void testToLeftForZ() {
        Shape z = new Shape();
        Shape result = z.toLeft();
        assertEquals(z.toLeft(), result);
    }
        @Test
    public void testToLeftForS() {
        Shape s = new Shape();
        Shape result = s.toLeft();
        assertEquals(s.toLeft(), result);
    }*/

    /**
     * Test of setShape method, of class Shape.
     */
    @Test
    public void testSetShape() {
        System.out.println("setShape");
        NetrisPieces shape = null;
        Shape instance = new Shape();
        instance.setShape(shape);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLeft method, of class Shape.
     */
    @Test
    public void testToLeft() {
        System.out.println("toLeft");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.toLeft();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRight method, of class Shape.
     */
    @Test
    public void testToRight() {
        System.out.println("toRight");
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.toRight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
