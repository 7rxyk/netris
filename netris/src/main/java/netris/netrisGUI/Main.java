package netris.netrisGUI;
import javax.swing.SwingUtilities;

public class Main {
     /**
     * main creates new Netris object
     * @param args parameter
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Netris peli = new Netris();
            peli.setVisible(true);
        });
    }
}
