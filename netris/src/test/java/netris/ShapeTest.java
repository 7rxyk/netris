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
        shapeToTest.asetaMuoto(NetrisPalat.I);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForNelio() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.Nelio);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForL() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.L);
        assertEquals(shapeToTest.minX(), -1);
    }

    @Test
    public void testThatMinXReturnsCorrectForS() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.S);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinXReturnsCorrectForZ() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.Z);
        assertEquals(shapeToTest.minX(), -1);
    }

    @Test
    public void testThatMinXReturnsCorrectForJ() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.J);
        assertEquals(shapeToTest.minX(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForSuora() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.I);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForL() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.L);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForNelio() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.Nelio);
        assertEquals(shapeToTest.minY(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForJ() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.J);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForS() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.S);
        assertEquals(shapeToTest.minY(), -1);
    }

    @Test
    public void testThatMinYReturnsCorrectForT() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.T);
        assertEquals(shapeToTest.minY(), 0);
    }

    @Test
    public void testThatMinYReturnsCorrectForZ() {
        Shape shapeToTest = new Shape();
        shapeToTest.asetaMuoto(NetrisPalat.Z);
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
    public void testGetMuoto() {
        Shape instance = new Shape();
        NetrisPalat expResult = NetrisPalat.Testi;
        NetrisPalat result = instance.getMuoto();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetRandomMuoto() {
        Shape instance = new Shape();
        instance.setRandomMuoto();
    }
 /*
    @Test
    public void testVasemmalleForI() {
        Shape i = new Shape();
        i.asetaMuoto(Shape.Palikka.I);
        assertEquals(i.vasemmalle(), 0);
    }
   
        @Test
    public void testVasemmalleForJ() {
        Shape j = new Shape();
        Shape result = j.vasemmalle();
        assertEquals(j.vasemmalle(), result);
    }
        @Test
    public void testVasemmalleForL() {
        Shape l = new Shape();
        Shape result = l.vasemmalle();
        assertEquals(l.vasemmalle(), result);
    }
        @Test
    public void testVasemmalleForNelio() {
        Shape nelio = new Shape();
        Shape result = nelio.vasemmalle();
        assertEquals(nelio.vasemmalle(), result);
    }
        @Test
    public void testVasemmalleForT() {
        Shape t = new Shape();
        Shape result = t.vasemmalle();
        assertEquals(t.vasemmalle(), result);
    }
        @Test
    public void testVasemmalleForZ() {
        Shape z = new Shape();
        Shape result = z.vasemmalle();
        assertEquals(z.vasemmalle(), result);
    }
        @Test
    public void testVasemmalleForS() {
        Shape s = new Shape();
        Shape result = s.vasemmalle();
        assertEquals(s.vasemmalle(), result);
    }*/

    /**
     * Test of oikealle method, of class Shape.
     
    @Test
    public void testOikealle() {
        Shape instance = new Shape();
        Shape expResult = null;
        Shape result = instance.oikealle();
        assertEquals(expResult, result);
    }*/
}
