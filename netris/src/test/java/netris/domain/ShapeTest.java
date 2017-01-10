package netris.domain;

import netris.domain.Shape;
import netris.domain.NetrisPieces;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void testThatMinXReturnsCorrectForI() {
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
    public void testThatMinYReturnsCorrectForI() {
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
    public void testXForI() {
        //X is always zero, in all positions
        int index = 0;
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.I);
        int result = instance.x(index);
        assertEquals(0, result); 
    }
    
    @Test
    public void testXForZ() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.Z);
        int index = 0;
        int result = instance.x(index);
        assertEquals(0, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(-1, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(-1, result);
    }
    
    @Test
    public void testXForS() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.S);
        int index = 0;
        int result = instance.x(index);
        assertEquals(0, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(1, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(1, result);
    }
    
        @Test
    public void testXForT() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.T);
        int index = 0;
        int result = instance.x(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(1, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(0, result);
    }
    
        @Test
    public void testXForO() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.O);
        int index = 0;
        int result = instance.x(index);
        assertEquals(0, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(1, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(1, result);
    }
    
        @Test
    public void testXForJ() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.J);
        int index = 0;
        int result = instance.x(index);
        assertEquals(1, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(0, result);
    }
    
        @Test
    public void testXForL() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.L);
        int index = 0;
        int result = instance.x(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.x(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.x(index);
        assertEquals(0, result);
    }

    @Test
    public void testYForI() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.I);
        int index = 0;
        int result = instance.y(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(1, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(2, result);
    }
        @Test
    public void testYForO() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.O);
        int index = 0;
        int result = instance.y(index);
        assertEquals(0, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(1, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
        @Test
    public void testYForT() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.T);
        int index = 0;
        int result = instance.y(index);
        assertEquals(0, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
        @Test
    public void testYForJ() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.J);
        int index = 0;
        int result = instance.y(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(-1, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
        @Test
    public void testYForL() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.L);
        int index = 0;
        int result = instance.y(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(-1, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
        @Test
    public void testYForS() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.S);
        int index = 0;
        int result = instance.y(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
        @Test
    public void testYForZ() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.Z);
        int index = 0;
        int result = instance.y(index);
        assertEquals(-1, result);
        
        index = 1;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 2;
        result = instance.y(index);
        assertEquals(0, result);
        
        index = 3;
        result = instance.y(index);
        assertEquals(1, result);
    }
    
        @Test
    public void testGetShapeTest() {
        Shape instance = new Shape();
        assertEquals(NetrisPieces.Test, instance.getShape());
    }

    @Test
    public void testGetShapeS() {
        Shape instance = new Shape();
        instance.setShape(NetrisPieces.S);
        assertEquals(NetrisPieces.S, instance.getShape());
    }

    @Test
    public void testSetRandomShape() {
        Shape instance = new Shape();
        instance.setRandomShape();
        assertNotNull(instance.getShape());
    }
 
    @Test
    public void testToLeftForI() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.S);
        s.toLeft();
        assertEquals(1, s.x(2));
    }
   
        @Test
    public void testToLeftForJ() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.J);
        s.toLeft();
        assertEquals(0, s.x(2));
    }
        @Test
    public void testToLeftForL() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.L);
        s.toLeft();
        assertEquals(0, s.x(2));
    }
        @Test
    public void testToLeftForO() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.O);
        assertNotNull(s.toLeft());
    } 
   
        @Test
    public void testToLeftForT() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.T);
        s.toLeft();
        assertEquals(1, s.x(2));
    }
        @Test
    public void testToLeftForZ() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.Z);
        s.toLeft();
        assertEquals(-1, s.x(2));
    }
        @Test
    public void testToLeftForS() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.S);
        s.toLeft();
        assertEquals(1, s.x(2));
    }

    /**
     * Test of setShape method, of class Shape.
     */
    @Test
    public void testSetShapeI() {
        NetrisPieces shape = NetrisPieces.I;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeJ() {
        NetrisPieces shape = NetrisPieces.J;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeL() {
        NetrisPieces shape = NetrisPieces.L;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeO() {
        NetrisPieces shape = NetrisPieces.O;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeT() {
        NetrisPieces shape = NetrisPieces.T;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeZ() {
        NetrisPieces shape = NetrisPieces.Z;
        Shape instance = new Shape();
        instance.setShape(shape);
    }
        @Test
    public void testSetShapeS() {
        NetrisPieces shape = NetrisPieces.S;
        Shape instance = new Shape();
        instance.setShape(shape);
    }

    /**
     * Test of toRight method, of class Shape.
     */
    @Test
    public void testToRightS() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.S);
        s.toRight();
        assertEquals(1, s.x(2));
    }
    @Test
    public void testToRightT() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.T);
        s.toRight();
        assertEquals(1, s.x(2));
    }
    @Test
    public void testToRightJ() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.J);
        s.toRight();
        assertEquals(0, s.x(2));
    }
    @Test
    public void testToRightL() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.L);
        s.toRight();
        assertEquals(0, s.x(2));
    }
    @Test
    public void testToRightZ() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.Z);
        s.toRight();
        assertEquals(-1, s.x(2));
    }
        @Test
    public void testToRightI() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.I);
        s.toRight();
        assertEquals(0, s.x(2));
    }
        @Test
    public void testToRightForO() {
        Shape s = new Shape();
        s.setShape(NetrisPieces.O);
        assertNotNull(s.toRight());
    } 
}
