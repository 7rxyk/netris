package netris;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import netris.Keyboard.TAdapter;
import netris.netrisGUI.Netris;

public class Game extends JPanel {
    
    private static final int WIDTH = 10;
    private static final int HEIGHT = 22;

    private final Board game;
    public NetrisPieces[] board;
    private Shape nextPiece;
    public boolean pieceDown = false;
    public boolean gameOn = false;
    public boolean paused = false;
    public boolean dropping = false;
    private int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    public Shape currentPiece;
    private final Timer timer;
    public final JLabel statusbar;

    private int totalScore;

    public Game(Netris netris) {
        game = new Board();
        setFocusable(true);
        currentPiece = new Shape();
        timer = new Timer(400, null);
        timer.start();

        statusbar = netris.getStatusBar();
        board = new NetrisPieces[WIDTH * HEIGHT];
        this.addKeyListener(new TAdapter(this));
    }

    public Shape getNextPiece() {
        return nextPiece;
    }

    public int getScore() {
        return (21 + (3 * getLevel()));
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getLines() {
        return game.linesRemoved;
    }

    public int getLevel() {
        if ((game.getFullLines() >= 1) && (game.getFullLines() <= 90)) {
            return 1 + ((game.getFullLines() - 1) / 10);
        } else if (game.getFullLines() >= 91) {
            return 10;
        } else {
            return 1;
        }
    }

     /**
     * Method starts the game
     */
    public void start() {
        if (paused) {
            return;
        }
        gameOn = true;
        pieceDown = false;
        linesRemoved = 0;
        game.emptyBoard();

        newPiece();
        timer.start();
    }

    /**
     * Method puts game to paused mode
     */
    public void pause() {
        if (!gameOn) {
            return;
        }
        paused = !paused;
        if (paused) {
            timer.stop();
            game.statusbar.setText("paused");
        } else {
            timer.start();
            game.statusbar.setText(String.valueOf(linesRemoved));
        }
    }

    /**
     * Method drops the piece
     */
    public void drop() {
        int newY = currentY;
        while (newY > 0) {
            if (!move(currentPiece, currentX, newY - 1)) {
                break;
            }
            --newY;
        }
        game.pieceDropped();
    }
    
    /**
     * makes a new piece to board
     */
    public void newPiece() {
        currentPiece.setRandomShape();
        currentX = WIDTH / 2 + 1;
        currentY = HEIGHT - 1 + currentPiece.minY();
        if (!move(currentPiece, currentX, currentY)) {
            currentPiece.setShape(NetrisPieces.Test);
            timer.stop();
            gameOn = false;
            game.statusbar.setText("game over");
        }
    }
    /**
     * Method moves the piece left or right
     *
     * @param newPiece given as a parameter
     * @param newX new X coordinate
     * @param newY new Y coordinate
     * @return 's true/false
     */
    public boolean move(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) {
                return false;
            }
            if (game.shapeAt(x, y) != NetrisPieces.Test) {
                return false;
            }
        }
        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        return true;
    }
}
