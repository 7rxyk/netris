
package netris;

import java.util.Random;
import java.lang.Math;

public class Shape {
    
    enum Pieces { EiMuotoa, Zeta, Assa, Suora, 
               Tee, Nelio, Alla, Ltoisinpain };

    private Pieces shape;
    private int coordinates[][];
    private int[][][] coordinatesTable;


    public Shape() {

        coordinates = new int[4][2];
        setShape(Pieces.EiMuotoa);

    }

    public void setShape(Pieces shape) {
        this.shape = shape;

         coordinatesTable = new int[][][] {
            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coordinates[i][j] = coordinatesTable[shape.ordinal()][i][j];
            }
        }
    }

    private void setX(int index, int x) { coordinates[index][0] = x; }
    private void setY(int index, int y) { coordinates[index][1] = y; }
    public int x(int index) { return coordinates[index][0]; }
    public int y(int index) { return coordinates[index][1]; }
    public Pieces getShape()  { return shape; }

    public void setRandomShape()
    {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Pieces[] values = Pieces.values(); 
        setShape(values[x]);
    }

    public int minX()
    {
      int m = coordinates[0][0];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coordinates[i][0]);
      }
      return m;
    }


    public int minY() 
    {
      int m = coordinates[0][1];
      for (int i=0; i < 4; i++) {
          m = Math.min(m, coordinates[i][1]);
      }
      return m;
    }

    public Shape rotateLeft() 
    {
        if (shape == Pieces.Nelio)
            return this;

        Shape result = new Shape();
        result.shape = shape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    public Shape rotateRight()
    {
        if (shape == Pieces.Nelio)
            return this;

        Shape result = new Shape();
        result.shape = shape;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}