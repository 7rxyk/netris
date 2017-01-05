package netris.Keyboard;

import netris.netrisGUI.Netris;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.NetrisPieces;
import netris.Board;

public class TAdapter extends KeyAdapter {

    public Board game;

    /**
     * keyPressed metodi toimii välikätenä käyttäjän näppäimistö syötteen ja
     * niistä tapahtuvien toimintojen välillä. Todennäköisesti muutoksia
     * tarvitaan, kun ei välttämättä toimi tällä hetkellä.
     *
     * @param pressed on käyttäjän antama syöte näppäimistöllään, jonka mukaan
     * gamessä toimitaan
     */
    @Override
    public void keyPressed(KeyEvent pressed) {
        game = new Board(new Netris());
        if (!game.gameOn || game.currentPiece.getShape() == NetrisPieces.Test) {
            return;
        }
        int keycode = pressed.getKeyCode();
        if (keycode == 'p' || keycode == 'P') {
            game.pause();
            return;
        }
        if (game.paused) {
            return;
        }
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                game.liikuta(game.currentPiece, game.currentX - 1, game.currentY);
                break;
            case KeyEvent.VK_RIGHT:
                game.liikuta(game.currentPiece, game.currentX + 1, game.currentY);
                break;
            case KeyEvent.VK_DOWN:
                game.liikuta(game.currentPiece.toRight(), game.currentX, game.currentY);
                break;
            case KeyEvent.VK_UP:
                game.liikuta(game.currentPiece.toLeft(), game.currentX, game.currentY);
                break;
            case KeyEvent.VK_SPACE:
                game.drop();
                break;
            case 'd':
                game.fullRow();
                break;
            case 'D':
                game.fullRow();
                break;
        }
    }
}
