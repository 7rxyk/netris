package netris.domain;

import java.awt.Color;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetrisPiecesTest {

    @Test
    public void testValueOf() {
        String name = "I";
        assertNotNull(NetrisPieces.valueOf(name));
    }

    @Test
    public void testGetRandomShape() {
        assertNotNull(NetrisPieces.getRandomShape());
    }

    @Test
    public void testGetPositionsForI() {
        NetrisPieces i = NetrisPieces.I;
        assertEquals(2, i.getPositions());
    }

    @Test
    public void testGetPositionsForZ() {
        NetrisPieces i = NetrisPieces.Z;
        assertEquals(2, i.getPositions());
    }

    @Test
    public void testGetPositionsForJ() {
        NetrisPieces i = NetrisPieces.J;
        assertEquals(4, i.getPositions());
    }

    @Test
    public void testGetPositionsForL() {
        NetrisPieces i = NetrisPieces.L;
        assertEquals(4, i.getPositions());
    }

    @Test
    public void testGetPositionsForO() {
        NetrisPieces i = NetrisPieces.O;
        assertEquals(0, i.getPositions());
    }

    @Test
    public void testGetPositionsForS() {
        NetrisPieces i = NetrisPieces.S;
        assertEquals(2, i.getPositions());
    }

    @Test
    public void testGetPositionsForT() {
        NetrisPieces i = NetrisPieces.T;
        assertEquals(4, i.getPositions());
    }

    @Test
    public void testGetPointsForI() {
        NetrisPieces i = NetrisPieces.I;
        assertArrayEquals(NetrisPieces.I.getPoints(), i.getPoints());
    }

    @Test
    public void testGetPointsForZ() {
        NetrisPieces i = NetrisPieces.Z;
        assertArrayEquals(NetrisPieces.Z.getPoints(), i.getPoints());
    }

    @Test
    public void testGetPointsForS() {
        NetrisPieces i = NetrisPieces.S;
        assertArrayEquals(NetrisPieces.S.getPoints(), i.getPoints());
    }

    @Test
    public void testGetPointsForT() {
        NetrisPieces i = NetrisPieces.T;
        Assert.assertArrayEquals(NetrisPieces.T.getPoints(), i.getPoints());
    }

    @Test
    public void testGetPointsForO() {
        NetrisPieces i = NetrisPieces.O;
        Assert.assertArrayEquals(NetrisPieces.O.getPoints(), i.getPoints());
    }

    @Test
    public void testGetPointsForL() {
        NetrisPieces i = NetrisPieces.L;
        Assert.assertArrayEquals(NetrisPieces.L.getPoints(), i.getPoints());
    }

    @Test
    public void testPointsForJ() {
        NetrisPieces i = NetrisPieces.J;
        Assert.assertArrayEquals(NetrisPieces.J.getPoints(), i.getPoints());
    }

    @Test
    public void testGetColorToNetrisPiecesI() {
        NetrisPieces shape = NetrisPieces.I;
        NetrisPieces instance = NetrisPieces.I;
        Color expResult = Color.YELLOW;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesJ() {
        NetrisPieces shape = NetrisPieces.J;
        NetrisPieces instance = NetrisPieces.J;
        Color expResult = Color.GRAY;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesO() {
        NetrisPieces shape = NetrisPieces.O;
        NetrisPieces instance = NetrisPieces.O;
        Color expResult = Color.MAGENTA;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesL() {
        NetrisPieces shape = NetrisPieces.L;
        NetrisPieces instance = NetrisPieces.L;
        Color expResult = Color.GREEN;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesZ() {
        NetrisPieces shape = NetrisPieces.Z;
        NetrisPieces instance = NetrisPieces.Z;
        Color expResult = Color.CYAN;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesS() {
        NetrisPieces shape = NetrisPieces.S;
        NetrisPieces instance = NetrisPieces.S;
        Color expResult = Color.PINK;
        Color result = instance.getColorForNetrispieces(shape);;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetColorToNetrisPiecesT() {
        NetrisPieces shape = NetrisPieces.T;
        NetrisPieces instance = NetrisPieces.T;
        Color expResult = Color.ORANGE;
        Color result = instance.getColorForNetrispieces(shape);
        assertEquals(expResult, result);
    }
}
