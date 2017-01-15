package netris.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardCellsTest {

    @Test
    public void testIsEmpty() {
        NetrisPieces i = NetrisPieces.getRandomShape();
        BoardCells in = new BoardCells(i);
        assertEquals(false, in.isEmpty());
    }

    @Test
    public void testGetNetrisPieces() {
        NetrisPieces i = NetrisPieces.S;
        BoardCells in = new BoardCells(i);
        assertEquals(NetrisPieces.S, in.getNetrisPieces());
    }
}
