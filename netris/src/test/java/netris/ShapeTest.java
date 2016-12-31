package netris;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {
    @Test
    public void testThatMinXReturnsCoorectForSuora(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Suora);
        assertEquals(shapeToTest.minX(), 0);
    }
    
     @Test
    public void testThatMinXReturnsCorrectForNelio(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Nelio);
        assertEquals(shapeToTest.minX(), 0);
    }
    
    @Test
    public void testThatMinXReturnsCorrectForL(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.L);
        assertEquals(shapeToTest.minX(), -1);
    }
    
    @Test
    public void testThatMinXReturnsCorrectForS(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.S);
        assertEquals(shapeToTest.minX(), 0);
    }
    
    @Test
    public void testThatMinXReturnsCorrectForZ(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Z);
        assertEquals(shapeToTest.minX(), -1);
    }
    
    @Test
    public void testThatMinXReturnsCorrectForPeiliL(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.PeiliL);
        assertEquals(shapeToTest.minX(), 0);
    }
    
    @Test
    public void testThatMinYReturnsCorrectForSuora(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Suora);
        assertEquals(shapeToTest.minY(), -1);
    }
    
    @Test
    public void testThatMinYReturnsCorrectForL(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.L);
        assertEquals(shapeToTest.minY(), -1);
    }
    
    @Test
    public void testThatMinYReturnsCorrectForNelio(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Nelio);
        assertEquals(shapeToTest.minY(), 0);
    }
    
    @Test
    public void testThatMinYReturnsCorrectForPeiliL(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.PeiliL);
        assertEquals(shapeToTest.minY(), -1);
    }
    
    @Test
    public void testThatMinYReturnsCorrectForS(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.S);
        assertEquals(shapeToTest.minY(), -1);
    }
    @Test
    public void testThatMinYReturnsCorrectForT(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.T);
        assertEquals(shapeToTest.minY(), 0);
    }
    @Test
    public void testThatMinYReturnsCorrectForZ(){
        Shape shapeToTest = new Shape();
        shapeToTest.setMuoto(Shape.Palikka.Z);
        assertEquals(shapeToTest.minY(), -1);
    }
}
