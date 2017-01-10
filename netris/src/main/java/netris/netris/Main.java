package netris.netris;

import netris.gui.Netris;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * main creates new Netris object.
     *
     * @param args parameter
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Netris();
        });
    }
}
