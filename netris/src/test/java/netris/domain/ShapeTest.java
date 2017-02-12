package netris.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {

    @Test
    public void testGetRandomShape() {
        Shape result = Shape.getRandomShape();
        assertNotNull(result);
    }

    @Test
    public void testGetPointsForS() {
        Shape i = new Shape(NetrisPieces.S, NetrisPieces.S.getPoints(), true);
        assertArrayEquals(NetrisPieces.S.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForZ() {
        Shape i = new Shape(NetrisPieces.Z, NetrisPieces.Z.getPoints(), true);
        assertArrayEquals(NetrisPieces.Z.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForO() {
        Shape i = new Shape(NetrisPieces.O, NetrisPieces.O.getPoints(), true);
        assertArrayEquals(NetrisPieces.O.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForJ() {
        Shape i = new Shape(NetrisPieces.J, NetrisPieces.J.getPoints(), true);
        assertArrayEquals(NetrisPieces.J.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForT() {
        Shape i = new Shape(NetrisPieces.T, NetrisPieces.T.getPoints(), true);
        assertArrayEquals(NetrisPieces.T.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForL() {
        Shape i = new Shape(NetrisPieces.L, NetrisPieces.L.getPoints(), true);
        assertArrayEquals(NetrisPieces.L.getPoints(), i.getPoints());
    }
        @Test
    public void testGetPointsForI() {
        Shape i = new Shape(NetrisPieces.I, NetrisPieces.I.getPoints(), true);
        assertArrayEquals(NetrisPieces.I.getPoints(), i.getPoints());
    }

    @Test
    public void testRotateI() {
        Shape irot = new Shape(NetrisPieces.I, NetrisPieces.I.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.I, NetrisPieces.I.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateS() {
        Shape irot = new Shape(NetrisPieces.S, NetrisPieces.S.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.S, NetrisPieces.S.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateZ() {
        Shape irot = new Shape(NetrisPieces.Z, NetrisPieces.Z.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.Z, NetrisPieces.Z.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateO() {
        Shape irot = new Shape(NetrisPieces.O, NetrisPieces.O.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.O, NetrisPieces.O.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateT() {
        Shape irot = new Shape(NetrisPieces.T, NetrisPieces.T.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.T, NetrisPieces.T.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateJ() {
        Shape irot = new Shape(NetrisPieces.J, NetrisPieces.J.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.J, NetrisPieces.J.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }
        @Test
    public void testRotateL() {
        Shape irot = new Shape(NetrisPieces.L, NetrisPieces.L.getPoints(), true);
        Shape inot = new Shape(NetrisPieces.L, NetrisPieces.L.getPoints(), true);
        irot.rotate();
        Assert.assertArrayEquals(inot.getPoints(), irot.getPoints());
    }

    @Test
    public void testGetShapeS() {
        Shape i = new Shape(NetrisPieces.S, NetrisPieces.S.getPoints(), true);
        assertEquals(NetrisPieces.S, i.getShape());
    }
        @Test
    public void testGetShapeI() {
        Shape i = new Shape(NetrisPieces.I, NetrisPieces.I.getPoints(), true);
        assertEquals(NetrisPieces.I, i.getShape());
    }
        @Test
    public void testGetShapeT() {
        Shape i = new Shape(NetrisPieces.T, NetrisPieces.T.getPoints(), true);
        assertEquals(NetrisPieces.T, i.getShape());
    }
        @Test
    public void testGetShapeZ() {
        Shape i = new Shape(NetrisPieces.Z, NetrisPieces.Z.getPoints(), true);
        assertEquals(NetrisPieces.Z, i.getShape());
    }
        @Test
    public void testGetShapeO() {
        Shape i = new Shape(NetrisPieces.O, NetrisPieces.O.getPoints(), true);
        assertEquals(NetrisPieces.O, i.getShape());
    }
        @Test
    public void testGetShapeL() {
        Shape i = new Shape(NetrisPieces.L, NetrisPieces.L.getPoints(), true);
        assertEquals(NetrisPieces.L, i.getShape());
    }
        @Test
    public void testGetShapeJ() {
        Shape i = new Shape(NetrisPieces.J, NetrisPieces.J.getPoints(), true);
        assertEquals(NetrisPieces.J, i.getShape());
    }
}
