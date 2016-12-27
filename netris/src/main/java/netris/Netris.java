package netris;

import javax.swing.JFrame;

public class Netris extends JFrame {

    public Netris() {

        //Board board = new Board(this);
        //add(board);
        //board.start();
        setSize(200, 400);
        setTitle("Netris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        Netris game = new Netris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
