package netris.domain;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void testGetRandomShape() {
        Shape expResult = null;
        Shape result = Shape.getRandomShape();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetShape_NetrisPieces() {
        System.out.println("getShape");
        NetrisPieces piece = null;
        Shape expResult = null;
        Shape result = Shape.getShape(piece);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Shape instance = null;
        Point[] expResult = null;
        Point[] result = instance.getPoints();
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testRotate() {
        System.out.println("rotate");
        Shape instance = null;
        Shape expResult = null;
        Shape result = instance.rotate();
        assertEquals(expResult, result);
    }
    /**

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
    }*/
}
