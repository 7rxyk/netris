package netris.domain;

import java.awt.Color;
import java.util.Random;

/**
 * Enum used to collect piece shape data: piece name, coordinates int[][] and
 * color for each piece shape.
 */
public enum NetrisPieces {

    Test(new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}, Color.BLACK),
    Z(new int[][]{{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}, Color.GRAY),
    S(new int[][]{{0, -1}, {0, 0}, {1, 0}, {1, 1}}, Color.YELLOW),
    I(new int[][]{{0, -1}, {0, 0}, {0, 1}, {0, 2}}, Color.GREEN),
    T(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, Color.ORANGE),
    O(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}, Color.PINK),
    L(new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, Color.CYAN),
    J(new int[][]{{1, -1}, {0, -1}, {0, 0}, {0, 1}}, Color.BLUE);

    public int[][] coordinates;
    public Color color;
    private static final Random RANDOM_PIECE = new Random();

    NetrisPieces(int[][] coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    public static NetrisPieces getRandomNetrisPieces() {
        return NetrisPieces.values()[RANDOM_PIECE.nextInt(NetrisPieces.values().length)];
    }

    public int[][] getCoordinates() {
        return this.coordinates;
    }

    /**
     * Method gets the color for given NetrisPiece.
     *
     * @param shape is the wanted NetrisPiece.
     * @return returns the color.
     */
    public Color getColorToNetrisPieces(NetrisPieces shape) {
        return shape.color;

    }
}
