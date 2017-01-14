package netris.domain;
import java.awt.Point;
import netris.domain.BoardCells;
import netris.domain.Shape;

public class Board {
    private static final int DROP_X = 5;
    private static final int DROP_Y = 19;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private Point pieceCenter = new Point(DROP_X, DROP_Y);
    private Shape currentPiece;
    private BoardCells[][] board = new BoardCells[WIDTH][HEIGHT];
    private int fullRows = 0;

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

    public void rotate() {
        Shape rot = currentPiece.rotate();
        if (fit(rot.getPoints(), 0, 0)) {

            currentPiece = rot;
        }
    }

    public void moveLeft() {
        if (fit(currentPiece.getPoints(), -1, 0)) {
            move(-1, 0);
        }
    }

    public void moveRight() {
        if (fit(currentPiece.getPoints(), 1, 0)) {
            move(1, 0);
        }
    }

    public boolean canCurrentPieceMoveDown() {
        return fit(currentPiece.getPoints(), 0, -1);
    }

    public void moveDown() {
        if (canCurrentPieceMoveDown()) {
            move(0, -1);
            removeFullRows();
        }
    }

    public boolean fit(Point[] points, int moveX, int moveY) {
        for (Point point : points) {
            int x = pieceCenter.x + point.x + moveX;
            int y = pieceCenter.y + point.y + moveY;

            if (x < 0 || x >= getWidth() || y >= getHeight() || y < 0) {
                return false;
            }

            if (!board[x][y].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public BoardCells[][] getBoardWithPiece() {
        BoardCells[][] gameBoard = new BoardCells[WIDTH][HEIGHT];

        for (int y = 0; y < WIDTH; y++) {
            System.arraycopy(board[y], 0, gameBoard[y], 0, board[0].length);
        }
        for (Point point : currentPiece.getPoints()) {
            int x = point.x + pieceCenter.x;
            int y = point.y + pieceCenter.y;
            gameBoard[x][y] = BoardCells.getCell(currentPiece.getShape());
        }

        return gameBoard;
    }

    private void addPieceToBoard() {
        for (Point point : currentPiece.getPoints()) {
            int x = pieceCenter.x + point.x;
            int y = pieceCenter.y + point.y;
            board[x][y] = BoardCells.getCell(currentPiece.getShape());
        }
    }

    private void move(int moveX, int moveY) {
        pieceCenter = new Point(pieceCenter.x + moveX, pieceCenter.y + moveY);
    }

    public void setCurrentPiece(Shape piece) {
        if (currentPiece != null) {
            addPieceToBoard();
        }
        currentPiece = piece;
        resetPieceCenter();
    }

    private void resetPieceCenter() {
        pieceCenter.x = DROP_X;
        pieceCenter.y = DROP_Y;
    }
}
