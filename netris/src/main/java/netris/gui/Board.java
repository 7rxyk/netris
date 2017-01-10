package netris.gui;

import netris.keyboard.TAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import netris.domain.Game;
import netris.domain.NetrisPieces;
import netris.domain.Shape;

public class Board extends JPanel {

    private final int width = 10;
    private final int height = 22;

    public Timer timer;
    private int linesRemoved = 0;
    public int currentX = 0;
    public int currentY = 0;
    private JLabel statusbar;
    public Shape currentPiece;
    public NetrisPieces[] board;
    public TAdapter keyListener;
    private Game game;

    /**
     * Board method makes the new game.
     *
     * @param netris given as parameter from Netris class.
     */
    public Board (Netris netris) {
        game = new Game(this);
        setBoard(netris);
        
    }
    
    
    private void setBoard(Netris netris) {
        setFocusable(true);
        currentPiece = new Shape();
        timer = new Timer(400, null);
        timer.start();

        statusbar = netris.getStatusBar();
        board = new NetrisPieces[width * height];
        this.addKeyListener(new TAdapter(this));
        emptyBoard();
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
     * Method starts the game by calling other methods from Game class.
     */
    public void start() {
        game.startGame();
        emptyBoard();
        game.newPiece();
        timer.start();
    }

    /**
     * Method puts game to paused mode by calling pauseGame method from Game class.
     */
    public void pause() {
        game.pauseGame();
        repaint();
    }

    /**
     * Removes the full row.
     */
    public void removeFullRow() {
        game.checkFullRows();
        repaint();
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / width;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / height;
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
        if (game.movePiece(newPiece, newX, newY)== true){
            repaint();
            return true;
        }
        return false;
    }
    /**
     * Graphics and piece drawing done paint and drawSquare methods.
     * @param g graphics as swing library
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - height * squareHeight();
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                NetrisPieces shape = game.shapeAt(j, height - i - 1);
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