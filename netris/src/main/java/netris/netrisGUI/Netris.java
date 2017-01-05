package netris.netrisGUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import netris.Board;

public class Netris extends JFrame {

    private JLabel statusbar;
    public Board game;

    /**
     * Netris constructor calls newGame method
     *
     * @see newGame object
     */
    public Netris() {
        newGame();
    }

    /**
     * newGame method sets game ready and call Board object
     * @see Board constructor
     */
    private void newGame() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        game = new Board(this);
        add(game);
        game.start();

        setSize(200, 400);
        setTitle("Netris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }
}
