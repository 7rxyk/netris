package netris.gui;

import netris.domain.Board;
import netris.domain.BoardCells;
import netris.domain.Shape;

/**
 * Contains the game logic, which Netris uses to perform tasks.
 */
public class Game {

    public boolean pieceDown = false;
    public boolean gameOn = false;
    private final Board board;
    public Shape nextShape;

    private boolean paused = false;
    public boolean dropping = false;
    private boolean gameOver = false;

    public int droppingIterations;
    private int totalScore;

    /**
     * Constructor calls Board.
     */
    public Game() {
        board = new Board();
    }

    public BoardCells[][] getBoardCells() {
        return board.getBoardWithPiece();
    }

    public Shape getNextShape() {
        return nextShape;
    }

    public long getIterationDelay() {
        return (long) (((11 - getLevel()) * 0.05) * 1000);
    }

    public int getScore() {
        return ((10 + (2 * getLevel())));
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getRows() {
        return board.getFullRows();
    }

    /**
     * Calculates level based on the rows player has got off the gamearea.
     *
     * @return level.
     */
    public int getLevel() {
        if ((board.getFullRows() >= 1) && (board.getFullRows() <= 90)) {
            return 1 + ((board.getFullRows() - 1) / 10);
        } else if (board.getFullRows() >= 91) {
            return 10;
        } else {
            return 1;
        }
    }

    /**
     * Starts the game and sets parameter true or false and get next piece.
     */
    public void startGame() {
        paused = false;
        dropping = false;
        nextShape = Shape.getRandomShape();
        board.setCurrentPiece(Shape.getRandomShape());
        gameOn = true;
    }

    public boolean isPlaying() {
        return gameOn;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Pauses the game.
     */
    public void pauseGame() {
        paused = !paused;
    }

    /**
     * Starts the game and sets parameter true or false and get next piece.
     *
     * @return true is passes the command to another method.
     */
    public boolean moveLeft() {
        board.moveLeft();
        return true;
    }

    /**
     * Moves piece to the right.
     *
     * @return true is passes the command to another method.
     */
    public boolean moveRight() {
        board.moveRight();
        return true;
    }

    /**
     * Moves the piece down.
     *
     * @return true if goes through the if else things.
     */
    public boolean moveDown() {
        if (!board.canCurrentPieceMoveDown()) {
            if (droppingIterations == 0) {
                gameOn = false;
                gameOver = true;
            } else {
                dropping = false;
                board.setCurrentPiece(nextShape);
                nextShape = Shape.getRandomShape();
                totalScore += getScore();
                droppingIterations = 0;
            }
        } else {
            board.moveDown();
            droppingIterations++;
        }
        return true;
    }

    /**
     * Rotates the piece.
     *
     * @return true is passes the command to another method.
     */
    public boolean rotate() {
        board.rotate();
        return true;
    }

    /**
     * Drops the piece.
     */
    public void drop() {
        dropping = true;
    }

    public boolean isDropping() {
        return dropping;
    }
}
