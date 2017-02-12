package netris.domain;

import java.util.Arrays;

/**
 * BoardCells class makes the gameboard and fills it with empty cells.
 */
public class BoardCells {

    private final NetrisPieces piece;

    private BoardCells() {
        piece = null;
    }

    /**
     * Puts parameter NetrisPiece into to the this.piece object.
     *
     * @param piece a Netrispiece.
     */
    public BoardCells(NetrisPieces piece) {
        this.piece = piece;
    }

    /**
     * Method declares if the cell is empty.
     *
     * @return null for piece.
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     * Method to get the Netrispiece.
     *
     * @return Netrispiece.
     */
    public NetrisPieces getNetrisPieces() {
        return piece;
    }

    /**
     * Makes the cell for the piece.
     *
     * @param piece Netrispiece as a parameter
     * @return the new boardcell for the piece
     */
    public static BoardCells getCell(NetrisPieces piece) {
        return new BoardCells(piece);
    }

    /**
     * Boardcell method where the empty BoardCell array is returned.
     *
     * @param size of array as parameter.
     * @return the cells.
     */
    public static BoardCells[] getEmptyArray(int size) {
        BoardCells[] cells = new BoardCells[size];
        Arrays.fill(cells, new BoardCells());
        return cells;
    }
}
