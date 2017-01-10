package netris.keyboard;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import netris.domain.Game;
import netris.gui.Board;
import netris.domain.NetrisPieces;

public class TAdapter extends KeyAdapter {

    private final Board game;
    private final Game gGame;

    /**
     * TAdapter constructor.
     *
     * @param game from Board class is called.
     */
    public TAdapter(Board game) {
        this.game = game;
        this.gGame = new Game(this.game);
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
        if (!gGame.gameOn || gGame.currentPiece.getShape() == NetrisPieces.Test) {
            return;
        }
        int keycode = pressed.getKeyCode();
        if (keycode == 'p' || keycode == 'P') {
            this.game.pause();
            return;
        }
        if (gGame.paused) {
            return;
        }
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                this.game.move(gGame.currentPiece, gGame.currentX - 1, gGame.currentY);
                break;
            case KeyEvent.VK_RIGHT:
                this.game.move(gGame.currentPiece, gGame.currentX + 1, gGame.currentY);
                break;
            case KeyEvent.VK_DOWN:
                this.game.move(gGame.currentPiece.toRight(), gGame.currentX, gGame.currentY);
                break;
            case KeyEvent.VK_UP:
                this.game.move(gGame.currentPiece.toLeft(), gGame.currentX, gGame.currentY);
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
