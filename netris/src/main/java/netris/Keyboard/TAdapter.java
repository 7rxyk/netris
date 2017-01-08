package netris.Keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.Board;
import netris.NetrisPieces;

public class TAdapter extends KeyAdapter {

    private Board game;

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
     * keyPressed method sends forward players keyboard input.
     *
     * @param pressed is the users input on keyboard
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
