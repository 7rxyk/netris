package netris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import netris.Shape.Palikka;

public class Board extends JPanel implements ActionListener {

    private final int Leveys = 10;
    private final int Korkeus = 22;

    private Timer timer;
    private boolean palikkaAlhaalla = false;
    public boolean paalla = false;
    public boolean tauolla = false;
    private int poistetutRivit = 0;
    public int nykyinenX = 0;
    public int nykyinenY = 0;
    private JLabel statusbar;
    public Shape nykyinenPalikka;
    private Palikka[] board;

    public Board(Netris parent) {

        initBoard(parent);
    }
    
    public TAdapter keyListener;

    private void initBoard(Netris parent) {

        setFocusable(true);
        nykyinenPalikka = new Shape();
        timer = new Timer(400, this);
        timer.start();

        statusbar = parent.getStatusBar();
        board = new Palikka[Leveys * Korkeus];
        this.keyListener = new TAdapter();
        addKeyListener(this.keyListener);
        clearBoard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (palikkaAlhaalla) {
            palikkaAlhaalla = false;
            uusiPalikka();
        } else {
            taysiRivi();
        }
    }

    private int squareWidth() {
        return (int) getSize().getWidth() / Leveys;
    }

    private int squareHeight() {
        return (int) getSize().getHeight() / Korkeus;
    }

    private Palikka shapeAt(int x, int y) {
        return board[(y * Leveys) + x];
    }

    public void start() {

        if (tauolla) {
            return;
        }
        paalla = true;
        palikkaAlhaalla = false;
        poistetutRivit = 0;
        clearBoard();

        uusiPalikka();
        timer.start();
    }

    private void pause() {

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

    private void doDrawing(Graphics g) {

        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - Korkeus * squareHeight();

        for (int i = 0; i < Korkeus; ++i) {
            for (int j = 0; j < Leveys; ++j) {
                Palikka Palikka = shapeAt(j, Korkeus - i - 1);
                if (Palikka != Palikka.TestiMuoto) {
                    drawSquare(g, 0 + j * squareWidth(),
                            boardTop + i * squareHeight(), Palikka);
                }
            }
        }

        if (nykyinenPalikka.getMuoto() != Palikka.TestiMuoto) {
            for (int i = 0; i < 4; ++i) {
                int x = nykyinenX + nykyinenPalikka.x(i);
                int y = nykyinenY - nykyinenPalikka.y(i);
                drawSquare(g, 0 + x * squareWidth(),
                        boardTop + (Korkeus - y - 1) * squareHeight(),
                        nykyinenPalikka.getMuoto());
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void dropDown() {

        int newY = nykyinenY;
        while (newY > 0) {
            if (!tryMove(nykyinenPalikka, nykyinenX, newY - 1)) {
                break;
            }
            --newY;
        }

        palaPudotettu();
    }

    private void taysiRivi() {

        if (!tryMove(nykyinenPalikka, nykyinenX, nykyinenY - 1)) {
            palaPudotettu();
        }
    }

    private void clearBoard() {

        for (int i = 0; i < Korkeus * Leveys; ++i) {
            board[i] = Palikka.TestiMuoto;
        }
    }

    private void palaPudotettu() {

        for (int i = 0; i < 4; ++i) {

            int x = nykyinenX + nykyinenPalikka.x(i);
            int y = nykyinenY - nykyinenPalikka.y(i);
            board[(y * Leveys) + x] = nykyinenPalikka.getMuoto();
        }
        poistaTaysiRivi();
        if (!palikkaAlhaalla) {
            uusiPalikka();
        }
    }

    private void uusiPalikka() {

        nykyinenPalikka.setRandomMuoto();
        nykyinenX = Leveys / 2 + 1;
        nykyinenY = Korkeus - 1 + nykyinenPalikka.minY();

        if (!tryMove(nykyinenPalikka, nykyinenX, nykyinenY)) {

            nykyinenPalikka.setMuoto(Palikka.TestiMuoto);
            timer.stop();
            paalla = false;
            statusbar.setText("game over");
        }
    }

    private boolean tryMove(Shape uusiPalikka, int newX, int newY) {

        for (int i = 0; i < 4; ++i) {

            int x = newX + uusiPalikka.x(i);
            int y = newY - uusiPalikka.y(i);

            if (x < 0 || x >= Leveys || y < 0 || y >= Korkeus) {
                return false;
            }
            if (shapeAt(x, y) != Palikka.TestiMuoto) {
                return false;
            }
        }

        nykyinenPalikka = uusiPalikka;
        nykyinenX = newX;
        nykyinenY = newY;

        repaint();
        return true;
    }

    private void poistaTaysiRivi() {

        int taysienRivienMaara = 0;

        for (int i = Korkeus - 1; i >= 0; --i) {
            boolean TaysiRivi = true;

            for (int j = 0; j < Leveys; ++j) {
                if (shapeAt(j, i) == Palikka.TestiMuoto) {
                    TaysiRivi = false;
                    break;
                }
            }
            if (TaysiRivi) {
                ++taysienRivienMaara;
                for (int k = i; k < Korkeus - 1; ++k) {
                    for (int j = 0; j < Leveys; ++j) {
                        board[(k * Leveys) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }
        if (taysienRivienMaara > 0) {
            poistetutRivit += taysienRivienMaara;
            statusbar.setText(String.valueOf(poistetutRivit));
            palikkaAlhaalla = true;
            nykyinenPalikka.setMuoto(Palikka.TestiMuoto);
            repaint();
        }
    }

    private void drawSquare(Graphics g, int x, int y, Palikka Palikka) {

        Color varit[] = {new Color(0, 0, 0), new Color(204, 102, 102),
            new Color(102, 204, 102), new Color(102, 102, 204),
            new Color(204, 204, 102), new Color(204, 102, 204),
            new Color(102, 204, 204), new Color(218, 170, 0)
        };
        Color vari = varit[Palikka.ordinal()];
        g.setColor(vari);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(vari.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(vari.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);

    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent painallus) {

            System.out.println("asdasdasdasd"+ paalla +" ((( "+ nykyinenPalikka.getMuoto());
            if (!paalla || nykyinenPalikka.getMuoto() == Palikka.TestiMuoto) {
                return;
            }
            System.out.println("asdasdasdasd");
            int keycode = painallus.getKeyCode();
            if (keycode == 'p' || keycode == 'P') {
                pause();
                return;
            }
            System.out.println("asdasdasdasd");
            if (tauolla) {
                return;
            }
            System.out.println("asdasdasdasd" + keycode);
            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    tryMove(nykyinenPalikka, nykyinenX - 1, nykyinenY);
                    break;

                case KeyEvent.VK_RIGHT:
                    tryMove(nykyinenPalikka, nykyinenX + 1, nykyinenY);
                    break;

                case KeyEvent.VK_DOWN:
                    tryMove(nykyinenPalikka.oikealle(), nykyinenX, nykyinenY);
                    break;

                case KeyEvent.VK_UP:
                    tryMove(nykyinenPalikka.vasemmalle(), nykyinenX, nykyinenY);
                    break;

                case KeyEvent.VK_SPACE:
                    dropDown();
                    break;

                case 'd':
                    taysiRivi();
                    break;

                case 'D':
                    taysiRivi();
                    break;
            }
        }
    }
}
