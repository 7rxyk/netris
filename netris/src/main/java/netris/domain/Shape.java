package netris.domain;

import java.awt.Point;

/**
 * Shape class: meant to put NetrisPieces into the shape object and handle the
 * point coordinates and piece rotation.
 */
public final class Shape {

    private final Point point[];
    private final NetrisPieces shape;
    private final boolean startRotPosition;

    /**
     * Creates the Shape object.
     *
     * @param piece, the Netrispiece type.
     * @param points for the piece.
     * @param position on how the piece is on the board.
     */
    private Shape(NetrisPieces shape, Point[] point, boolean position) {
        startRotPosition = position;
        this.point = point;
        this.shape = shape;
    }

    public static Shape getRandomShape() {
        NetrisPieces piece = NetrisPieces.getRandomShape();
        return new Shape(piece, piece.getPoints(), true);
    }

    public static Shape getShape(NetrisPieces piece) {
        return new Shape(piece, piece.getPoints(), true);
    }

    public NetrisPieces getShape() {
        return shape;
    }

    public Point[] getPoints() {
        return point;
    }

    /**
     * Rotate method deals with the piece rotation. By the shape positions it
     *
     * @return returns the new rotated piece to shape object to create new shape
     * again.
     */
    public Shape rotate() {
        if (shape.getPositions() == 0) {
            return this;
        } else if (shape.getPositions() == 2) {
            if (startRotPosition) {
                return new Shape(shape, rotateRight(point), false);
            } else {
                return new Shape(shape, rotateLeft(point), true);
            }
        }
        return new Shape(shape, rotateRight(point), true);
    }

    private Point[] rotateLeft(Point toRotate[]) {
        return rotate(toRotate, 1, -1);
    }

    private Point[] rotateRight(Point toRotate[]) {
        return rotate(toRotate, -1, 1);
    }

    private Point[] rotate(Point toRotate[], int x, int y) {
        Point rotated[] = new Point[4];
        for (int i = 0; i < 4; i++) {
            int temp = toRotate[i].x;
            rotated[i] = new Point(x * toRotate[i].y, y * temp);
        }
        return rotated;
    }
}
