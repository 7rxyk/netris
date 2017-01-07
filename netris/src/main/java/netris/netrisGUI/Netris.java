package netris.netrisGUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import netris.Board;
import netris.Game;

public final class Netris extends JFrame {

    private final JLabel statusbar;
    private Game game;

    /**
     * Netris constructor
     *
     * @see netris.Board
     */
    public Netris() {
        this.statusbar = new JLabel(" 0");
        this.add(statusbar, BorderLayout.SOUTH);
        this.game = new Game(this);
        this.add(game);
        this.game.start();

        this.setSize(200, 400);
        this.setTitle("Netris");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JLabel getStatusBar() {
        return statusbar;
    }

    public Game getGame() {
        return game;
    }
}
