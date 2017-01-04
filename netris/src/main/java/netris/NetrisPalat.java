package netris;

import java.awt.Color;
import java.util.Random;

/**
 * Alustetaan enumilla tetriksen käyttämät palat: palojen nimi, koordinaatit
 * int[][] ja kullekin palalle alustetaan myös väri
 */
public enum NetrisPalat {

    Testi(new int[][]{{0, 0}, {0, 0}, {0, 0}, {0, 0}}, Color.BLACK),
    Z(new int[][]{{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}, Color.GRAY),
    S(new int[][]{{0, -1}, {0, 0}, {1, 0}, {1, 1}}, Color.YELLOW),
    I(new int[][]{{0, -1}, {0, 0}, {0, 1}, {0, 2}}, Color.GREEN),
    T(new int[][]{{-1, 0}, {0, 0}, {1, 0}, {0, 1}}, Color.ORANGE),
    Nelio(new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}, Color.PINK),
    L(new int[][]{{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, Color.CYAN),
    J(new int[][]{{1, -1}, {0, -1}, {0, 0}, {0, 1}}, Color.BLUE);

    public int[][] koordinaatit;
    public Color vari;
    private static final Random random = new Random();

    NetrisPalat(int[][] koordinaatit, Color c) {
        this.koordinaatit = koordinaatit;
        this.vari = c;
    }

    public static NetrisPalat getRandomPala() {
        return NetrisPalat.values()[random.nextInt(NetrisPalat.values().length)];
    }

    public int[][] getKoordinaatit() {
        return this.koordinaatit;
    }

    public Color getVariPalalle(NetrisPalat muoto) {
        return muoto.vari;

    }
    /*
    Myöhemmin toivon mukaan palikoiden väri tulee alla olevan metodin tyylisesti
    public static Color satunnainenVari() {
        Random vari = new Random();
        float r = vari.nextFloat();
        float g = vari.nextFloat();
        float b = vari.nextFloat();
        Color satunnainenVari = new Color(r, g, b);
        return satunnainenVari;
    }
     */
}
