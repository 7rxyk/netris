package netris.domain;

import netris.domain.NetrisPieces;
import java.awt.Color;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class NetrisPiecesTest {

    /**
     * Test of valueOf method, of class NetrisPieces.
     */
    @Test
    public void testValueOf() {
        String name = "I";
        assertNotNull(NetrisPieces.valueOf(name));
    }

    /**
     * Test of getRandomNetrisPieces method, of class NetrisPieces.
     */
    @Test
    public void testGetRandomNetrisPieces() {
            assertNotNull(NetrisPieces.getRandomNetrisPieces());
    }

    /**
     * Test of getCoordinates method, of class NetrisPieces.
     */
    @Test
    public void testGetCoordinatesForI() {
        NetrisPieces instance = NetrisPieces.I;
        Assert.assertArrayEquals(NetrisPieces.I.getCoordinates(), instance.getCoordinates());
    }
        
    @Test
    public void testGetCoordinatesForZ() {
        NetrisPieces instance = NetrisPieces.Z;
        Assert.assertArrayEquals(NetrisPieces.Z.getCoordinates(), instance.getCoordinates());
    }
       
    @Test
    public void testGetCoordinatesForS() {
        NetrisPieces instance = NetrisPieces.S;
        Assert.assertArrayEquals(NetrisPieces.S.getCoordinates(), instance.getCoordinates());
    }
        
    @Test
    public void testGetCoordinatesForT() {
        NetrisPieces instance = NetrisPieces.T;
        Assert.assertArrayEquals(NetrisPieces.T.getCoordinates(), instance.getCoordinates());
    }
        
    @Test
    public void testGetCoordinatesForO() {
        NetrisPieces instance = NetrisPieces.O;
        Assert.assertArrayEquals(NetrisPieces.O.getCoordinates(), instance.getCoordinates());
    }   
    @Test
    public void testGetCoordinatesForL() {
        NetrisPieces instance = NetrisPieces.L;
        Assert.assertArrayEquals(NetrisPieces.L.getCoordinates(), instance.getCoordinates());
    }    
    @Test
    public void testGetCoordinatesForJ() {
        NetrisPieces instance = NetrisPieces.J;
        Assert.assertArrayEquals(NetrisPieces.J.getCoordinates(), instance.getCoordinates());
    } 

    /**
     * Test of getColorToNetrisPieces method, of class NetrisPieces.
     */
    @Test
    public void testGetColorToNetrisPiecesI() {
        NetrisPieces shape = NetrisPieces.I;
        NetrisPieces instance = NetrisPieces.I;
        Color expResult = Color.GREEN;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesJ() {
        NetrisPieces shape = NetrisPieces.J;
        NetrisPieces instance = NetrisPieces.J;
        Color expResult = Color.BLUE;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesO() {
        NetrisPieces shape = NetrisPieces.O;
        NetrisPieces instance = NetrisPieces.O;
        Color expResult = Color.PINK;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesL() {
        NetrisPieces shape = NetrisPieces.L;
        NetrisPieces instance = NetrisPieces.L;
        Color expResult = Color.CYAN;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesZ() {
        NetrisPieces shape = NetrisPieces.Z;
        NetrisPieces instance = NetrisPieces.Z;
        Color expResult = Color.GRAY;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesS() {
        NetrisPieces shape = NetrisPieces.S;
        NetrisPieces instance = NetrisPieces.S;
        Color expResult = Color.YELLOW;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
        @Test
    public void testGetColorToNetrisPiecesT() {
        NetrisPieces shape = NetrisPieces.T;
        NetrisPieces instance = NetrisPieces.T;
        Color expResult = Color.ORANGE;
        Color result = instance.getColorToNetrisPieces(shape);
        assertEquals(expResult, result);
    }
}
