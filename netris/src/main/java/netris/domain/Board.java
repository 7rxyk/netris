package netris.domain;

import java.awt.Point;

public class Board {
    private static final int DROP_X = 5;
    private static final int DROP_Y = 19;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private Point pieceRotationAxel = new Point(DROP_X, DROP_Y);
    private Shape currentPiece;
    private BoardCells[][] board = new BoardCells[WIDTH][HEIGHT];
    private int fullRows = 0;

    /**
     * Creates the empty board to board object.
     */
    public Board() {
        board = createEmptyBoard();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getFullRows() {
        return fullRows;
    }

    /**
     * Boardcell coords where shape is set.
     * @param x coordinate.
     * @param y coordinate.
     * @return board coordinates.
     */
    public BoardCells getShapeAt(int x, int y) {
        return board[x][y];
    }

    private boolean isRowFull(int y) {
        for (int x = 0; x < WIDTH; x++) {
            if (getShapeAt(x, y).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method removes all the removable rows from the board.
     */
    public void removeFullRows() {
        BoardCells[][] boardX = createEmptyBoard();
        int full = 0;
        for (int y = 0; y < HEIGHT; y++) {
            if (isRowFull(y)) {
                full++;
            } else {
                copyRow(boardX, y, y - full);
            }
        }
        fullRows += full;
        board = boardX;
    }

    private void copyRow(BoardCells[][] to, int y, int toy) {
        for (int x = 0; x < WIDTH; x++) {
            to[x][toy] = board[x][y];
        }
    }

    private BoardCells[][] createEmptyBoard() {
        BoardCells[][] boardX = new BoardCells[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            boardX[x] = BoardCells.getEmptyArray(HEIGHT);
        }
        return boardX;
    }

    /**
     * Method rotetes the piece.
     */
    public void rotate() {
        Shape rot = currentPiece.rotate();
        if (fit(rot.getPoints(), 0, 0)) {
            currentPiece = rot;
        }
    }

    /**
     * Moves piece to the left.
     */
    public void moveLeft() {
        if (fit(currentPiece.getPoints(), -1, 0)) {
            move(-1, 0);
        }
    }

    /**
     * Moves piece to the left.
     */
    public void moveRight() {
        if (fit(currentPiece.getPoints(), 1, 0)) {
            move(1, 0);
        }
    }

    /**
     * Validates if piece can move down.
     * @return true or false;
     */
    public boolean canCurrentPieceMoveDown() {
        return fit(currentPiece.getPoints(), 0, -1);
    }

    /**
     * Method moves piece down and calls another method to check full rows..
     */
    public void moveDown() {
        if (canCurrentPieceMoveDown()) {
            move(0, -1);
            removeFullRows();
        }
    }

    /**
     * Method checks if the piece fits to move down, left or right.
     * @param points for the current piece on the board.
     * @param moveX how much to move left or right
     * @param moveY how much to move down (up not possible).
     * @return true or false if fitted or not.
     */
    public boolean fit(Point[] points, int moveX, int moveY) {
        for (Point point : points) {
            int x = pieceRotationAxel.x + point.x + moveX;
            int y = pieceRotationAxel.y + point.y + moveY;
            if (x < 0 || x >= getWidth() || y >= getHeight() || y < 0) {
                return false;
            }
            if (!board[x][y].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Meturns new board where is all the current pieces in it in array form.
     * @return the new array with piece in it.
     */
    public BoardCells[][] getBoardWithPiece() {
        BoardCells[][] gameBoard = new BoardCells[WIDTH][HEIGHT];
        for (int y = 0; y < WIDTH; y++) {
            System.arraycopy(board[y], 0, gameBoard[y], 0, board[0].length);
        }
        for (Point point : currentPiece.getPoints()) {
            int x = point.x + pieceRotationAxel.x;
            int y = point.y + pieceRotationAxel.y;
            gameBoard[x][y] = BoardCells.getCell(currentPiece.getShape());
        }
        return gameBoard;
    }

    private void addPieceToBoard() {
        for (Point point : currentPiece.getPoints()) {
            int x = pieceRotationAxel.x + point.x;
            int y = pieceRotationAxel.y + point.y;
            board[x][y] = BoardCells.getCell(currentPiece.getShape());
        }
    }

    private void move(int moveX, int moveY) {
        pieceRotationAxel = new Point(pieceRotationAxel.x + moveX, pieceRotationAxel.y + moveY);
    }

    /**
     * Sets the shape piece to current piece.
     * @param piece is the new piece to be current piece.
     */
    public void setCurrentPiece(Shape piece) {
        if (currentPiece != null) {
            addPieceToBoard();
        }
        currentPiece = piece;
        resetPieceCenter();
    }

    private void resetPieceCenter() {
        pieceRotationAxel.x = DROP_X;
        pieceRotationAxel.y = DROP_Y;
    }
}
