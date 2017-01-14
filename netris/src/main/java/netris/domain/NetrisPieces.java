package netris.domain;

import java.awt.Color;
import java.util.Random;
import java.awt.Point;

/**
 * Enum used to collect piece shape data: piece name, shape rotation positions
 * and points[].
 */
public enum NetrisPieces {

    O(0, p(-1, 0), p(0, 0), p(-1, -1), p(0, -1)),
    I(2, p(-2, 0), p(-1, 0), p(0, 0), p(1, 0)),
    S(2, p(0, 0), p(1, 0), p(-1, -1), p(0, -1)),
    Z(2, p(-1, 0), p(0, 0), p(0, -1), p(1, -1)),
    L(4, p(-1, 0), p(0, 0), p(1, 0), p(-1, -1)),
    J(4, p(-1, 0), p(0, 0), p(1, 0), p(1, -1)),
    T(4, p(-1, 0), p(0, 0), p(1, 0), p(0, -1));

    private static final Random random = new Random();
    private final int positions;
    private final Point points[];

    NetrisPieces(int positions, Point... points) {
        this.positions = positions;
        this.points = points;
    }

    public static NetrisPieces getRandomShape() {
        return NetrisPieces.values()[random.nextInt(NetrisPieces.values().length)];
    }

    public Point[] getPoints() {
        return points;
    }

    public int getPositions() {
        return positions;
    }

    private static Point p(int x, int y) {
        return new Point(x, y);
    }

    /**
     * Method gets the color for given NetrisPiece.
     *
     * @param shape is the wanted NetrisPiece.
     * @return returns the color.
     */
    public Color getColorForNetrispieces(NetrisPieces shape) {
        switch (shape) {
            case I:
                return Color.YELLOW;
            case J:
                return Color.GRAY;
            case L:
                return Color.GREEN;
            case O:
                return Color.MAGENTA;
            case S:
                return Color.PINK;
            case Z:
                return Color.CYAN;
            default:
                return Color.ORANGE;
        }
    }
}
