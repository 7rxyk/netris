package netris;

import java.awt.Color;
import java.util.Random;

/**
 * Enum used to collect pieceshape data: piece name, coordinates int[][] and color for each pieceshape
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
    private static final Random random = new Random();

    NetrisPieces(int[][] coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    public static NetrisPieces getRandomNetrisPieces() {
        return NetrisPieces.values()[random.nextInt(NetrisPieces.values().length)];
    }

    public int[][] getCoordinates() {
        return this.coordinates;
    }

    public Color getColorToNetrisPieces(NetrisPieces shape) {
        return shape.color;

    }
    /*
    Later color for the piece might be done by using this random color method
    public static Color randomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
     */
}
