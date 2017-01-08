package netris;

import netris.netris.keyboard.TAdapter;
import netris.netris.gui.Netris;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

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
     * Board method makes the new game.
     *
     * @param netris given as parameter from Netris class.
     */
    public Board(Netris netris) {
        setFocusable(true);
        currentPiece = new Shape();
        timer = new Timer(400, null);
        timer.start();

        statusbar = netris.getStatusBar();
        board = new NetrisPieces[width * height];
        this.addKeyListener(new TAdapter(this));
        emptyBoard();
    }

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
     * Method starts the game.
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
     * Method puts game to paused mode.
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
     * Method drops the piece.
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
     * Checks if the row is full.
     */
    public void fullRow() {
        if (!move(currentPiece, currentX, currentY - 1)) {
            pieceDropped();
        }
    }

    /**
     * Clears the board.
     */
    public void emptyBoard() {
        for (int i = 0; i < height * width; ++i) {
            board[i] = NetrisPieces.Test;
        }
    }

    /**
     * Checks if the piece is down.
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
     * makes a new piece to board.
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
     * Move method is handling the piece moving in board side to side.
     *
     * @param newPiece is the piece which is moved.
     * @param newX new x coordinates.
     * @param newY new y coordinates.
     * @return true or false depending on if the piece moving can be done. Piece
     * cant't go outside gamearea.
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
     * Removes the full row.
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
     * Graphics and piece drawing done paint and drawSquare methods.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - height * squareHeight();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                NetrisPieces shape = shapeAt(j, height - i - 1);
                if (shape != NetrisPieces.Test) {
                    drawSquare(g, 0 + j * squareWidth(), boardTop + i * squareHeight(), shape);
                }
            }
        }
        if (currentPiece.getShape() != NetrisPieces.Test) {
            for (int i = 0; i < 4; ++i) {
                int x = currentX + currentPiece.x(i);
                int y = currentY - currentPiece.y(i);
                drawSquare(g, 0 + x * squareWidth(), boardTop + (height - y - 1) * squareHeight(), currentPiece.getShape());
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y, NetrisPieces shape) {
        Color color = shape.getColorToNetrisPieces(shape);
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }
}
