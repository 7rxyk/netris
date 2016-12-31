package netris;

import java.util.Random;

public class Shape {

    protected enum Palikka {
        TestiMuoto, Z, S, Suora, T, Nelio, L, PeiliL
    };

    private Palikka palikanMuoto;
    private int koordinaatit[][];
    private int[][][] koordinaatitTaulukko;

    public Shape() {
        koordinaatit = new int[4][2];
        setMuoto(Palikka.TestiMuoto);
    }

    public void setMuoto(Palikka muoto) {
        koordinaatitTaulukko = new int[][][]{
            {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; ++j) {
                koordinaatit[i][j] = koordinaatitTaulukko[muoto.ordinal()][i][j];
            }
        }
        palikanMuoto = muoto;
    }

    private void setX(int index, int x) {
        koordinaatit[index][0] = x;
    }

    private void setY(int index, int y) {
        koordinaatit[index][1] = y;
    }

    public int x(int index) {
        return koordinaatit[index][0];
    }

    public int y(int index) {
        return koordinaatit[index][1];
    }

    public Palikka getMuoto() {
        return palikanMuoto;
    }

    public void setRandomMuoto() {

        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Palikka[] values = Palikka.values();
        setMuoto(values[x]);
    }

    public int minX() {
        int m = koordinaatit[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, koordinaatit[i][0]);
        }
        return m;
    }

    public int minY() {
        int m = koordinaatit[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, koordinaatit[i][1]);
        }
        return m;
    }

    public Shape vasemmalle() {
        if (palikanMuoto == Palikka.Nelio) {
            return this;
        }
        Shape tulos = new Shape();
        tulos.palikanMuoto = palikanMuoto;
        for (int i = 0; i < 4; ++i) {
            tulos.setX(i, y(i));
            tulos.setY(i, -x(i));
        }
        return tulos;
    }

    public Shape oikealle() {
        if (palikanMuoto == Palikka.Nelio) {
            return this;
        }
        Shape tulos = new Shape();
        tulos.palikanMuoto = palikanMuoto;

        for (int i = 0; i < 4; ++i) {
            tulos.setX(i, -y(i));
            tulos.setY(i, x(i));
        }
        return tulos;
    }
}
