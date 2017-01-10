package netris.domain;

import javax.swing.JLabel;
import javax.swing.Timer;
import netris.gui.Board;
import netris.keyboard.TAdapter;

/**
 * This class will be taking some methods from Board class.
 */
public class Game {

    private final int width = 10;
    private final int height = 22;

    private Timer timer;
    public boolean pieceDown = false;
    public boolean gameOn = false;
    public boolean paused = false;
    private int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    private JLabel statusbar;
    public Shape currentPiece;
    public NetrisPieces[] board;
    public TAdapter keyListener;
    public Board gameBoard;

    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void pauseGame() {
        if (!gameOn) {
            return;
        }
        paused = !paused;
        if (paused) {
            timer.stop();
            statusbar.setText("paused");
        } else {
            timer.start();
            statusbar.setText(String.valueOf(linesRemoved));
        }
    }

    public void startGame() {
        if (paused) {
            return;
        }
        gameOn = true;
        pieceDown = false;
        linesRemoved = 0;
    }


    public boolean pieceIsDown() {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            board[(y * width) + x] = currentPiece.getShape();
            return true;
        }
        return false;
    }

    /**
     * makes a new piece to board.
     */
    public void newPiece() {
        currentPiece.setRandomShape();
        currentX = width / 2 + 1;
        currentY = height - 1 + currentPiece.minY();
        if (!gameBoard.move(currentPiece, currentX, currentY)) {
            currentPiece.setShape(NetrisPieces.Test);
            timer.stop();
            gameOn = false;
            statusbar.setText("game over");
        }
    }

    /**
     * Move method is handling the piece moving in board side to side.
     *
     * @param newPiece is the piece which is moved.
     * @param newX new x coordinates.
     * @param newY new y coordinates.
     * @return true or false depending on if the piece moving can be done. Piece
     * cant't go outside gamearea.
     */
    public boolean movePiece(Shape newPiece, int newX, int newY) {

        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= width || y < 0 || y >= height) {
                return false;
            }
            if (shapeAt(x, y) != NetrisPieces.Test) {
                return false;
            }
        }
        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        return true;
    }

    public void checkFullRows() {
        int fullRows = 0;
        for (int i = height - 1; i >= 0; i--) {
            boolean FullRow = true;
            for (int j = 0; j < width; j++) {
                if (shapeAt(j, i) == NetrisPieces.Test) {
                    FullRow = false;
                    break;
                }
            }
            if (FullRow) {
                fullRows++;
                for (int k = i; k < height - 1; k++) {
                    for (int j = 0; j < width; j++) {
                        board[(k * width) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }
        if (fullRows > 0) {
            linesRemoved += fullRows;
            statusbar.setText(String.valueOf(linesRemoved));
            pieceDown = true;
            currentPiece.setShape(NetrisPieces.Test);
        }
    }

    public NetrisPieces shapeAt(int x, int y) {
        return board[(y * width) + x];
    }

    /**
     * Method drops the piece.
     */
    public void drop() {
        int newY = currentY;
        while (newY > 0) {
            if (!gameBoard.move(currentPiece, currentX, newY - 1)) {
                break;
            }
            newY--;
        }
        pieceDropped();
    }

    /**
     * Checks if the row is full.
     */
    public void fullRow() {
        if (!gameBoard.move(currentPiece, currentX, currentY - 1)) {
            pieceDropped();
        }
    }

    /**
     * Checks if the piece is down.
     */
    public void pieceDropped() {
        if (pieceIsDown() == true) {
            gameBoard.removeFullRow();
            if (!pieceDown) {
                newPiece();
            }
        }
    }
}
