package netris;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Netris extends JFrame {

    private JLabel statusbar;

    public Netris() {
        uusiPeli();
    }

    public Board pelilauta;

    private void uusiPeli() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        pelilauta = new Board(this);
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

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Netris peli = new Netris();
                peli.setVisible(true);
            }
        });
    }
}
