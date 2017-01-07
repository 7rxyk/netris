package netris.Keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.NetrisPieces;
import netris.Board;

public class TAdapter extends KeyAdapter {

    private final Board game;

    public TAdapter(Board game) {
        this.game = game;
    }

    public void actionPerformed(ActionEvent e) {
        if (game.pieceDown) {
            game.pieceDown = false;
            game.newPiece();
        } else {
            game.fullRow();
        }
    }

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
                game.move(game.currentPiece, game.currentX - 1, game.currentY);
                break;
            case KeyEvent.VK_RIGHT:
                game.move(game.currentPiece, game.currentX + 1, game.currentY);
                break;
            case KeyEvent.VK_DOWN:
                game.move(game.currentPiece.toRight(), game.currentX, game.currentY);
                break;
            case KeyEvent.VK_UP:
                game.move(game.currentPiece.toLeft(), game.currentX, game.currentY);
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
