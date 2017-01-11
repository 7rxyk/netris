package netris.gui;

import javax.swing.JLabel;
import static org.junit.Assert.*;
import org.junit.Test;

public class NetrisTest {

    private JLabel statusbar;

    @Test
    public void testGetStatusBar() {
        Netris instance = new Netris();
        assertNotNull(instance.getStatusBar());
        assertEquals(instance.getTitle(), "Netris");
    }

    @Test
    public void testGetGame() {
        Netris instance = new Netris();
        assertNotNull(instance.getGame());
    }
}
