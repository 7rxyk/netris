package netris;

import netris.Keyboard.TAdapter;
import netris.netrisGUI.Netris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Luokka on graafinen käyttöliittymä? tälle ohjelmalle. Liian pitkä tällä
 * hetkellä! ja etenkin visualisointiin liittyvät metodit vaatii työtä.
 */
public class Pelilauta extends JPanel {

    private final int leveys = 10;
    private final int korkeus = 22;

    private final Timer timer;
    private boolean palikkaAlhaalla = false;
    public boolean paalla = false;
    public boolean tauolla = false;
    private int poistetutRivit = 0;
    public int nykyinenX = 0;
    public int nykyinenY = 0;
    private final JLabel statusbar;
    public Shape nykyinenPalikka;
    public NetrisPalat[] pelilauta;
    public TAdapter keyListener;

    /**
     * Pelilauta metodi alustaa uuden pelin
     *
     * @param netris olio annetaan parametrinä metodille.
     */
    public Pelilauta(Netris netris) {
        setFocusable(true);
        nykyinenPalikka = new Shape();
        timer = new Timer(400, (ActionListener) this);
        timer.start();

        statusbar = netris.getStatusBar();
        pelilauta = new NetrisPalat[leveys * korkeus];
        this.keyListener = new TAdapter();
        addKeyListener(this.keyListener);
        tyhjennaPelilauta();
    }

    /**
     * Metodi havaitsee pelin kulussa tapahtuvaa toimintaa. Ehkä väärässä
     * luokassa tällä hetkellä ja
     *
     * @param e on tapahtunut tapahtuma, mutta mikään ei nyt tällä hetkellä
     * käytä kys. parametriä. Selvitellään miksi ja mitä
     */
    public void actionPerformed(ActionEvent e) {
        if (palikkaAlhaalla) {
            palikkaAlhaalla = false;
            uusiPalikka();
        } else {
            taysiRivi();
        }
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / leveys;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / korkeus;
    }

    private NetrisPalat shapeAt(int x, int y) {
        return pelilauta[(y * leveys) + x];
    }

    /**
     * Metodi aloittaa pelin
     */
    public void start() {
        if (tauolla) {
            return;
        }
        paalla = true;
        palikkaAlhaalla = false;
        poistetutRivit = 0;
        tyhjennaPelilauta();

        uusiPalikka();
        timer.start();
    }

    /**
     * Metodi pistää pelin tauolle
     */
    public void pause() {
        if (!paalla) {
            return;
        }
        tauolla = !tauolla;
        if (tauolla) {
            timer.stop();
            statusbar.setText("paused");
        } else {
            timer.start();
            statusbar.setText(String.valueOf(poistetutRivit));
        }
        repaint();
    }

    /**
     * Metodi pudottaa palikan
     */
    public void pudota() {
        int newY = nykyinenY;
        while (newY > 0) {
            if (!liikuta(nykyinenPalikka, nykyinenX, newY - 1)) {
                break;
            }
            --newY;
        }
        palaPudotettu();
    }

    /**
     * Metodi tarkistaa onko rivi täysi
     */
    public void taysiRivi() {
        if (!liikuta(nykyinenPalikka, nykyinenX, nykyinenY - 1)) {
            palaPudotettu();
        }
    }

    /**
     * Metodi tyhjentää pelialueen
     */
    private void tyhjennaPelilauta() {
        for (int i = 0; i < korkeus * leveys; ++i) {
            pelilauta[i] = NetrisPalat.Testi;
        }
    }

    /**
     * p
     */
    private void palaPudotettu() {
        for (int i = 0; i < 4; ++i) {
            int x = nykyinenX + nykyinenPalikka.x(i);
            int y = nykyinenY - nykyinenPalikka.y(i);
            pelilauta[(y * leveys) + x] = nykyinenPalikka.getMuoto();
        }
        poistaTaysiRivi();
        if (!palikkaAlhaalla) {
            uusiPalikka();
        }
    }

    /**
     * muodostaa uuden palikan nykyinenPalikka paikalle
     */
    private void uusiPalikka() {
        nykyinenPalikka.setRandomMuoto();
        nykyinenX = leveys / 2 + 1;
        nykyinenY = korkeus - 1 + nykyinenPalikka.minY();
        if (!liikuta(nykyinenPalikka, nykyinenX, nykyinenY)) {
            nykyinenPalikka.asetaMuoto(NetrisPalat.Testi);
            timer.stop();
            paalla = false;
            statusbar.setText("game over");
        }
    }

    /**
     * liikuta metodilla liikutetaan palikkaa
     *
     * @param uusiPalikka tulee parametrina
     * @param uusiX palalle uusi x koordinaatti eli mihin palaa liikutetaan
     * @param uusiY palalle uusi y koordinaatti eli mihin palaa halutaan
     * liikuttaa.
     * @return palauttaa true/false riippuen ehtolauseiden toteutumisesta
     */
    public boolean liikuta(Shape uusiPalikka, int uusiX, int uusiY) {
        for (int i = 0; i < 4; ++i) {
            int x = uusiX + uusiPalikka.x(i);
            int y = uusiY - uusiPalikka.y(i);
            if (x < 0 || x >= leveys || y < 0 || y >= korkeus) {
                return false;
            }
            if (shapeAt(x, y) != NetrisPalat.Testi) {
                return false;
            }
        }
        nykyinenPalikka = uusiPalikka;
        nykyinenX = uusiX;
        nykyinenY = uusiY;
        repaint();
        return true;
    }

    /**
     * Metodi poistaa täyden rivin peliruudulta
     */
    private void poistaTaysiRivi() {
        int taysienRivienMaara = 0;
        for (int i = korkeus - 1; i >= 0; --i) {
            boolean taysiRivi = true;
            for (int j = 0; j < leveys; ++j) {
                if (shapeAt(j, i) == NetrisPalat.Testi) {
                    taysiRivi = false;
                    break;
                }
            }
            if (taysiRivi) {
                ++taysienRivienMaara;
                for (int k = i; k < korkeus - 1; ++k) {
                    for (int j = 0; j < leveys; ++j) {
                        pelilauta[(k * leveys) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }
        if (taysienRivienMaara > 0) {
            poistetutRivit += taysienRivienMaara;
            statusbar.setText(String.valueOf(poistetutRivit));
            palikkaAlhaalla = true;
            nykyinenPalikka.asetaMuoto(NetrisPalat.Testi);
            repaint();
        }
    }

    /**
     * maalaa uutta palikkaa
     *
     * @param g on swingin grafiikkatyökalu
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, leveys * squareWidth(), korkeus * squareHeight());
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                drawSquare(g, x, y);
            }
        }
    }

    /**
     * maalaa uutta palikkaa x ja y koordinaattien mukaisesti. Metodi vaatii
     * työstämistä!
     *
     * @param g on swingin grafiikkatyökalu
     * @param x palikan x koordinaatti
     * @param y palikan y koordinaatti
     */
    void drawSquare(Graphics g, int x, int y) {
        Color vari = Color.PINK;
        int xMin = x * squareWidth();
        int yMin = y * squareHeight();
        int xMax = xMin + squareWidth() - 1;
        int yMax = yMin + squareHeight() - 1;
        int i;
        g.setColor(vari);
        g.fillRect(xMin, yMin, squareWidth(), squareHeight());
        g.setColor(vari.brighter());
        for (i = 0; i < squareWidth() / 10; i++) {
            g.drawLine(xMin + i, yMin + i, xMax - i, yMin + i);
            g.drawLine(xMin + i, yMin + i, xMin + i, yMax - i);
        }
        g.setColor(vari.darker());
        for (i = 0; i < squareWidth() / 10; i++) {
            g.drawLine(xMax - i, yMin + i, xMax - i, yMax - i);
            g.drawLine(xMin + i, yMax - i, xMax - i, yMax - i);
        }
    }
}
