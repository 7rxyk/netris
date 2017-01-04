package netris.netrisGUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import netris.Pelilauta;

public class Netris extends JFrame {

    private JLabel statusbar;
    public Pelilauta pelilauta;

    /**
     * Kutsuu uusipeli metodia
     *
     * @see uusiPeli olio
     */
    public Netris() {
        uusiPeli();
    }

    /**
     * uusiPeli metodi luo alustukset uutta peliä varten ja kutsuu pelilauta
     * oliota.
     *
     * @see Pelilauta konstruktori
     */
    private void uusiPeli() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        pelilauta = new Pelilauta(this);
        add(pelilauta);
        pelilauta.start();

        setSize(200, 400);
        setTitle("Netris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }

    /**
     * main luo uuden Netris olion
     *
     * @param args parametrinä
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Netris peli = new Netris();
            peli.setVisible(true);
        });
    }
}
