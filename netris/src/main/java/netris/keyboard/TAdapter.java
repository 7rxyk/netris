package netris.keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.domain.Game;
import netris.gui.Board;
import netris.domain.NetrisPieces;

public class TAdapter extends KeyAdapter {

    private Board game;
    private Game gGame;

    /**
     * TAdapter constructor.
     *
     * @param game from Board class is called.
     */
    public TAdapter(Board game) {
        this.game = game;
    }

    /**
     * Checks that performing the action goes trough.
     *
     * @param e is the actionevent given as a parameter.
     */
    public void actionPerformed(ActionEvent e) {
        if (gGame.pieceDown) {
            gGame.pieceDown = false;
            gGame.newPiece();
        } else {
            gGame.fullRow();
        }
    }

    /**
     * keyPressed method sends forward players keyboard input.
     *
     * @param pressed is the users input on keyboard
     */
    @Override
    public void keyPressed(KeyEvent pressed) {
        if (!gGame.gameOn || game.currentPiece.getShape() == NetrisPieces.Test) {
            return;
        }
        int keycode = pressed.getKeyCode();
        if (keycode == 'p' || keycode == 'P') {
            game.pause();
            return;
        }
        if (gGame.paused) {
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
                gGame.drop();
                break;
            case 'd':
                gGame.fullRow();
                break;
            case 'D':
                gGame.fullRow();
                break;
        }
    }
}
