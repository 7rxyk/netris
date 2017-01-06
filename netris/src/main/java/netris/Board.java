package netris;

import netris.Keyboard.TAdapter;
import netris.netrisGUI.Netris;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Luokka on graafinen käyttöliittymä? tälle ohjelmalle. Liian pitkä tällä
 * hetkellä! ja etenkin visualisointiin liittyvät metodit vaatii työtä.
 */
public class Board extends JPanel {

    private final int width = 10;
    private final int height = 22;

    private final Timer timer;
    public boolean pieceDown = false;
    public boolean gameOn = false;
    public boolean paused = false;
    private int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    private final JLabel statusbar;
    public Shape currentPiece;
    public NetrisPieces[] board;
    public TAdapter keyListener;

    /**
     * Board metodi alustaa uuden pelin
     *
     * @param netris olio annetaan parametrinä metodille.
     */
    public Board(Netris netris) {
        setFocusable(true);
        currentPiece = new Shape();
        timer = new Timer(400, (ActionListener) this);
        timer.start();

        statusbar = netris.getStatusBar();
        board = new NetrisPieces[width * height];
        this.keyListener = new TAdapter();
        addKeyListener(this.keyListener);
        emptyBoard();
    }

    /**
     * Metodi havaitsee pelin kulussa tapahtuvaa toimintaa. Ehkä väärässä
     * luokassa tällä hetkellä ja
     *
     * @param e on tapahtunut tapahtuma, mutta mikään ei nyt tällä hetkellä
     * käytä kys. parametriä. Selvitellään miksi ja mitä
     */

    private int squareWidth() {
        return (int) getSize().getWidth() / width;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / height;
    }

    private NetrisPieces shapeAt(int x, int y) {
        return board[(y * width) + x];
    }

    /**
     * Method starts the game
     */
    public void start() {
        if (paused) {
            return;
        }
        gameOn = true;
        pieceDown = false;
        linesRemoved = 0;
        emptyBoard();

        newPiece();
        timer.start();
    }

    /**
     * Method puts game to paused mode
     */
    public void pause() {
        if (!gameOn) {
            return;
        }
        paused = !paused;
        if (paused) {
            timer.stop();
            statusbar.setText("paused");
        } else {
            timer.start();
            statusbar.setText(String.valueOf(linesRemoved));
        }
        repaint();
    }

    /**
     * Method drops the piece
     */
    public void drop() {
        int newY = currentY;
        while (newY > 0) {
            if (!move(currentPiece, currentX, newY - 1)) {
                break;
            }
            --newY;
        }
        pieceDropped();
    }

    /**
     * Checks if the row is full
     */
    public void fullRow() {
        if (!move(currentPiece, currentX, currentY - 1)) {
            pieceDropped();
        }
    }

    /**
     * Clears the board
     */
    public void emptyBoard() {
        for (int i = 0; i < height * width; ++i) {
            board[i] = NetrisPieces.Test;
        }
    }

    /**
     * 
     */
    public void pieceDropped() {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            board[(y * width) + x] = currentPiece.getShape();
        }
        removeFullRow();
        if (!pieceDown) {
            newPiece();
        }
    }

    /**
     * makes a new piece to board
     */
    public void newPiece() {
        currentPiece.setRandomShape();
        currentX = width / 2 + 1;
        currentY = height - 1 + currentPiece.minY();
        if (!move(currentPiece, currentX, currentY)) {
            currentPiece.setShape(NetrisPieces.Test);
            timer.stop();
            gameOn = false;
            statusbar.setText("game over");
        }
    }

    /**
     * move metodilla liikutetaan palikkaa
     *
     * @param newPiece tulee parametrina
     * @param newX palalle new x koordinaatti eli mihin palaa liikutetaan
     * @param newY palalle new y koordinaatti eli mihin palaa halutaan
     * liikuttaa.
     * @return palauttaa true/false riippuen ehtolauseiden toteutumisesta
     */
    public boolean move(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= width || y < 0 || y >= height) {
                return false;
            }
            if (shapeAt(x, y) != NetrisPieces.Test) {
                return false;
            }
        }
        currentPiece = newPiece;
        currentX = newX;
        currentY = newY;
        repaint();
        return true;
    }

    /**
     * Removes the full row
     */
    public void removeFullRow() {
        int numberOfFullRows = 0;
        for (int i = height - 1; i >= 0; --i) {
            boolean fullRow = true;
            for (int j = 0; j < width; ++j) {
                if (shapeAt(j, i) == NetrisPieces.Test) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                ++numberOfFullRows;
                for (int k = i; k < height - 1; ++k) {
                    for (int j = 0; j < width; ++j) {
                        board[(k * width) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }
        if (numberOfFullRows > 0) {
            linesRemoved += numberOfFullRows;
            statusbar.setText(String.valueOf(linesRemoved));
            pieceDown = true;
            currentPiece.setShape(NetrisPieces.Test);
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
        g.fillRect(0, 0, width * squareWidth(), height * squareHeight());
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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
        Color color = Color.PINK;
        int xMin = x * squareWidth();
        int yMin = y * squareHeight();
        int xMax = xMin + squareWidth() - 1;
        int yMax = yMin + squareHeight() - 1;
        int i;
        g.setColor(color);
        g.fillRect(xMin, yMin, squareWidth(), squareHeight());
        g.setColor(color.brighter());
        for (i = 0; i < squareWidth() / 10; i++) {
            g.drawLine(xMin + i, yMin + i, xMax - i, yMin + i);
            g.drawLine(xMin + i, yMin + i, xMin + i, yMax - i);
        }
        g.setColor(color.darker());
        for (i = 0; i < squareWidth() / 10; i++) {
            g.drawLine(xMax - i, yMin + i, xMax - i, yMax - i);
            g.drawLine(xMin + i, yMax - i, xMax - i, yMax - i);
        }
    }
}
