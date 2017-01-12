package netris.domain;

/**
 * Shape class: meant to put NetrisPieces into the shape object and handle the
 * coordinates.
 */
public final class Shape {

    public NetrisPieces shape;
    public int coordinates[][];

    /**
     * Shape sets the coordinates into Shape object.
     *
     * @see calls setShape method.
     */
    public Shape() {
        coordinates = new int[4][2];
        setShape(NetrisPieces.Test);
    }

    /**
     * NetrisPiece shape is set to the coordinates.
     *
     * @param shape is the NetrisPiece shape.
     */
    public void setShape(NetrisPieces shape) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                coordinates[i][j] = shape.coordinates[i][j];
            }
        }
        this.shape = shape;
    }

    private void setX(int index, int x) {
        coordinates[index][0] = x;
    }

    private void setY(int index, int y) {
        coordinates[index][1] = y;
    }

    /**
     * x returns x coordinate given as index parameter.
     *
     * @param index parameter for the wanted x coordinate.
     * @return returns the x coordinate.
     */
    public int x(int index) {
        return coordinates[index][0];
    }

    /**
     * y returns y coordinate given as index parameter.
     *
     * @param index parameter for the wanted y coordinate.
     * @return returns the y coordinate.
     */
    public int y(int index) {
        return coordinates[index][1];
    }

    public NetrisPieces getShape() {
        return shape;
    }

    /**
     * Random NetrisPiece shape is got from NetrisPieces class.
     *
     * @see Random-shape is set through setShape method
     */
    public void setRandomShape() {
        this.shape = NetrisPieces.getRandomNetrisPieces();
        if (this.shape != NetrisPieces.Test) {
            setShape(this.shape);
        }
    }

    /**
     * minX checks the X coordinates and return smallest one.
     *
     * @return returns smallest coordinate for X.
     */
    public int minX() {
        int m = coordinates[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][0]);
        }
        return m;
    }

    /**
     * minY checks the Y coordinates and return smallest one.
     *
     * @return returns smallest coordinate for Y.
     */
    public int minY() {
        int m = coordinates[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][1]);
        }
        return m;
    }

    /**
     * toLeft method spins the shape to the left and return new coordinates for
     * piece.
     *
     * @return return new coordinates.
     */
    public Shape toLeft() {
        if (shape == NetrisPieces.O) {
            return this;
        }
        Shape result = new Shape();
        result.shape = shape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    /**
     * toRight method spins the shape to the right and return new coordinates
     * for piece.
     *
     * @return return new coordinates.
     */
    public Shape toRight() {
        if (shape == NetrisPieces.O) {
            return this;
        }
        Shape result = new Shape();
        result.shape = shape;
        for (int i = 0; i < 4; i++) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}
