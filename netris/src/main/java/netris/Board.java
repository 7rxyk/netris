package netris;

import netris.Keyboard.TAdapter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JLabel;
import javax.swing.JPanel;
import netris.netrisGUI.Netris;

/**
* Board class makes the game frame
 */
public class Board extends JPanel {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 22;

    public Game game;
    Netris netris;
    public boolean pieceDown = false;
    public boolean gameOn = false;
    public boolean paused = false;
    public int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    public Shape currentPiece;
    public NetrisPieces[] board;
    public TAdapter keyListener;
    public final JLabel statusbar;
    private BufferStrategy strategy;
    
    public Board(){
        statusbar = netris.getStatusBar();
    }


    private int squareWidth() {
        return (int) getSize().getWidth() / WIDTH;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / HEIGHT;
    }

    public NetrisPieces shapeAt(int x, int y) {
        return board[(y * WIDTH) + x];
    }
    
    /**
     * Checks if the row is full
     */
    public void fullRow() {
        if (!game.move(currentPiece, currentX, currentY - 1)) {
            pieceDropped();
        }
    }

    /**
     * Clears the board
     */
    public void emptyBoard() {
        for (int i = 0; i < HEIGHT * WIDTH; ++i) {
            board[i] = NetrisPieces.Test;
        }
    }

    public void pieceDropped() {
        for (int i = 0; i < 4; ++i) {
            int x = currentX + currentPiece.x(i);
            int y = currentY - currentPiece.y(i);
            board[(y * WIDTH) + x] = currentPiece.getShape();
        }
        removeFullRow();
        if (!pieceDown) {
            game.newPiece();
        }
    }

    public void removeFullRow() {
        int numberOfFullRows = 0;
        for (int i = HEIGHT - 1; i >= 0; --i) {
            boolean fullRow = true;
            for (int j = 0; j < WIDTH; ++j) {
                if (shapeAt(j, i) == NetrisPieces.Test) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                ++numberOfFullRows;
                for (int k = i; k < HEIGHT - 1; ++k) {
                    for (int j = 0; j < WIDTH; ++j) {
                        board[(k * WIDTH) + j] = shapeAt(j, k + 1);
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

    public Graphics2D getGameGraphics() {
        return (Graphics2D) strategy.getDrawGraphics();
    }
    
    
    /**
     * paints the new piece and calls another method
     * @see drawSquare
     * @param g swing graphics
     */
    public void paintComponent(Graphics2D g) {
        g = getGameGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH * squareWidth(), WIDTH * squareHeight());
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                drawSquare(g, x, y);
            }
        }
    }

    /**
     * Draws new NetrisPiece by the parameter coordinates.
     *
     * @param g swing graphics
     * @param x pieces x coordinate
     * @param y pieces y coordinate
     */
    void drawSquare(Graphics2D g, int x, int y) {
        Color color = Color.LIGHT_GRAY;
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

    int getFullLines() {
        return linesRemoved;
    }
    
    public String getLevel() {
        return String.format("Your level: %1s", game.getLevel());
    }

    public String getLines() {
        return String.format("Full lines: %1s", game.getLines());
    }

    public String getScore() {
        return String.format("Score    %1s", game.getTotalScore());
    }
    
    public void drawStatus(Graphics2D g) {
        g.setFont(new Font("Dialog", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        g.drawString(getLevel(), 10, 20);
        g.drawString(getLines(), 10, 40);
        g.drawString(getScore(), 20, 80);
    }
    
    public void drawHelpBox(Graphics2D g) {
        g.setFont(new Font("Dialog", Font.BOLD, 16));
        g.setColor(Color.WHITE);
        g.drawString("H E L P", 50, 140);
        g.drawString("p: Pause Game", 10, 160);
        g.drawString("s: New Game", 10, 180);
    }
}
