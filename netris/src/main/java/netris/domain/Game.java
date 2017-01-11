package netris.domain;

import javax.swing.JLabel;
import javax.swing.Timer;
import netris.gui.Board;
import netris.keyboard.TAdapter;

/**
 * Contains the game logic, which Board uses to perform tasks.
 */
public class Game {

    private Timer timer;
    public boolean pieceDown = false;
    public boolean gameOn = false;
    public boolean paused = false;
    public int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    private JLabel statusbar;
    public Shape currentPiece;
    public TAdapter keyListener;
    public Board gameBoard;

    /**
     * Constructor calls Board.
     *
     * @param gameBoard the Board class.
     */
    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * Checks if the falling piece is down.
     *
     * @return returns true or false.
     */
    public boolean pieceIsDown() {
        for (int i = 0; i < 4; i++) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            gameBoard.board[(y * gameBoard.width) + x] = currentPiece.getShape();
            return true;
        }
        return false;
    }

    /**
     * makes a new piece to board.
     */
    public void newPiece() {
        currentPiece.setRandomShape();
        currentX = gameBoard.width / 2 + 1;
        currentY = gameBoard.height - 1 + currentPiece.minY();
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

        for (int i = 0; i < 4; i++) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= gameBoard.width || y < 0 || y >= gameBoard.height) {
                return false;
            }
            if (gameBoard.shapeAt(x, y) != NetrisPieces.Test) {
                return false;
            }
        }
        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        return true;
    }

    /**
     * Check full rows in the game board. If there is, calls another method to
     * delete them.
     *
     */
    public void checkFullRows() {
        int fullRows = 0;
        for (int i = gameBoard.height - 1; i >= 0; i--) {
            boolean fullRow = true;
            for (int j = 0; j < gameBoard.width; j++) {
                if (gameBoard.shapeAt(j, i) == NetrisPieces.Test) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                fullRows++;
                for (int k = i; k < gameBoard.height - 1; k++) {
                    for (int j = 0; j < gameBoard.width; j++) {
                        gameBoard.board[(k * gameBoard.width) + j] = gameBoard.shapeAt(j, k + 1);
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
