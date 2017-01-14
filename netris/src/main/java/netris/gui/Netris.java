package netris.gui;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import netris.domain.BoardCells;
import netris.domain.NetrisPieces;
import netris.keyboard.TAdapter;

public class Netris extends Canvas {
    private Game game = new Game();
    private BufferStrategy strategy;
    private final int BOARD_X = 240;
    private final int BOARD_Y = 20;
    public TAdapter keyboard = new TAdapter();
    private long iteration = System.currentTimeMillis();
    private static final int PIECESIZE = 20;

    public Netris() {
        JFrame gameWindow = new JFrame("Netris");
        JPanel panel = (JPanel) gameWindow.getContentPane();
        panel.setPreferredSize(new Dimension(520, 470));
        panel.setLayout(null);

        setBounds(0, 0, 520, 470);
        panel.add(this);
        setIgnoreRepaint(true);
        gameWindow.pack();
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        
        gameWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(keyboard);
        requestFocus();
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    void gameLoop() {
        while (true) {
            if (keyboard.newGame()) {
                game = new Game();
                game.startGame();
            }
            if (game.isPlaying()) {
                if (!game.isPaused()) {
                    tetrisLoop();
                } 
                if (keyboard.pauseGame()) {
                    game.pauseGame();
                }
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                }
            }
            draw();
        }
    }
    
    void tetrisLoop() {
        if (game.isDropping()) {
            game.moveDown();
        } else if (System.currentTimeMillis() - iteration >= game.getIterationDelay()) {
            game.moveDown();
            iteration = System.currentTimeMillis();
        }
        if (keyboard.rotate()) {
            game.rotate();
        } else if (keyboard.left()) {
            game.moveLeft();
        } else if (keyboard.right()) {
            game.moveRight();
        } else if (keyboard.drop()) {
            game.drop();
        }
    }
    
        public void draw() {
        Graphics2D g = getGameGraphics();
        drawEmptyBoard(g);
        drawHelp(g);
        if (game.isPlaying()) {
            drawCells(g);
            if (game.isPaused()) {
                drawGamePaused(g);
            }
        }
        if (game.isGameOver()) {
            drawCells(g);
            drawGameOver(g);
        }
        drawStatus(g);
        g.dispose();
        strategy.show();
    }

    private Graphics2D getGameGraphics() {
        return (Graphics2D) strategy.getDrawGraphics();
    }

    private void drawCells(Graphics2D g) {
        BoardCells[][] cells = game.getBoardCells();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                drawNetrisPiece(g, BOARD_X + i * 20, BOARD_Y + (19 - j) * 20, getBoardCellColor(cells[i][j]));
            }
        }
    }

    private void drawEmptyBoard(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 520, 470);
        g.setColor(Color.GRAY);
        g.drawRect(BOARD_X - 1, BOARD_Y - 1, 10 * PIECESIZE + 2, 20 * PIECESIZE + 2);
    }

    private void drawStatus(Graphics2D g) {
        g.setFont(new Font("Dialog", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        g.drawString(getLevel(), 30, 40);
        g.drawString(getLines(), 30, 80);
        g.drawString(getScore(), 30, 120);
    }

    private void drawGameOver(Graphics2D g) {
        Font font = new Font("Dialog", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("GAME OVER", 290, 250);
    }

    private void drawGamePaused(Graphics2D g) {
        Font font = new Font("Dialog", Font.PLAIN, 16);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString("GAME PAUSED", 280, 250);
    }

    private String getLevel() {
        return String.format("Your level: %1s", game.getLevel());
    }

    private String getLines() {
        return String.format("Full lines: %1s", game.getRows());
    }

    private String getScore() {
        return String.format("Score:    %1s", game.getTotalScore());
    }

    private void drawHelp(Graphics2D g) {
        g.setFont(new Font("Dialog", Font.PLAIN, 16));
        g.setColor(Color.WHITE);
        g.drawString("H E L P", 80, 170);
        g.drawString("S: New Game", 30, 190);
        g.drawString("P: Pause Game", 30, 210);
        g.drawString("UP: Rotate", 30, 230);
        g.drawString("ARROWS: Move left/right", 30, 250);
        g.drawString("SPACE: Drop", 30, 270);
    }

    private Color getBoardCellColor(BoardCells boardCell) {
        if (boardCell.isEmpty()) {
            return Color.DARK_GRAY;
        }
        return getPieceColor(boardCell.getNetrisPieces());
    }

    private Color getPieceColor(NetrisPieces piece) {
        return piece.getColorForNetrispieces(piece);
    }

    private void drawNetrisPiece(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x + 1, y + 1, PIECESIZE - 2, PIECESIZE - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + PIECESIZE - 1, x, y);
        g.drawLine(x, y, x + PIECESIZE - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + PIECESIZE - 1, x + PIECESIZE - 1, y + PIECESIZE - 1);
        g.drawLine(x + PIECESIZE - 1, y + PIECESIZE - 1, x + PIECESIZE - 1, y + 1);
    }
}
