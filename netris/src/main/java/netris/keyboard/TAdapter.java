package netris.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;

public class TAdapter implements KeyListener {

    private final Map<Integer, Boolean> state = new HashMap<Integer, Boolean>();

    /**
     * Constructor for TAdapter to put Keyevents to a hashmap.
     */
    public TAdapter() {
        state.put(KeyEvent.VK_LEFT, Boolean.FALSE);
        state.put(KeyEvent.VK_RIGHT, Boolean.FALSE);
        state.put(KeyEvent.VK_UP, Boolean.FALSE);
        state.put(KeyEvent.VK_SPACE, Boolean.FALSE);
        state.put(KeyEvent.VK_S, Boolean.FALSE);
        state.put(KeyEvent.VK_P, Boolean.FALSE);
    }

    /**
     * Gets a new game, when left arrow is pressed.
     *
     * @return true or false;
     */
    public boolean left() {
        return keyDown(KeyEvent.VK_LEFT);
    }

    /**
     * Gets a new game, when right arrow is pressed.
     *
     * @return true or false;
     */
    public boolean right() {
        return keyDown(KeyEvent.VK_RIGHT);
    }

    /**
     * Gets a new game, when spacebar is pressed.
     *
     * @return true or false;
     */
    public boolean drop() {
        return keyDown(KeyEvent.VK_SPACE);
    }

    /**
     * Gets a new game, when up arrow is pressed.
     *
     * @return true or false;
     */
    public boolean rotate() {
        return keyDown(KeyEvent.VK_UP);
    }

    /**
     * Pauses a game, when P is pressed.
     *
     * @return true or false;
     */
    public boolean pauseGame() {
        return keyDown(KeyEvent.VK_P);
    }

    /**
     * Gets a new game, when S is pressed.
     *
     * @return true or false;
     */
    public boolean newGame() {
        return keyDown(KeyEvent.VK_S);
    }

    private boolean keyDown(int keyCode) {
        return state.put(keyCode, Boolean.FALSE);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (state.containsKey(keyEvent.getKeyCode())) {
            state.put(keyEvent.getKeyCode(), Boolean.TRUE);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * keyPressed method sends forward players keyboard input.
     *
     * @param pressed is the users input on keyboard
     *
     * @Override public void keyPressed(KeyEvent pressed) { int keycode =
     * pressed.getKeyCode(); switch (keycode) { case KeyEvent.VK_S: this.game =
     * new Game(); game.startGame(); break; case KeyEvent.VK_LEFT:
     * game.moveLeft(); break; case KeyEvent.VK_RIGHT: game.moveRight(); break;
     * case KeyEvent.VK_DOWN: game.moveDown(); break; case KeyEvent.VK_UP:
     * game.rotate(); break; case KeyEvent.VK_SPACE: game.drop(); break; case
     * KeyEvent.VK_P: game.pauseGame(); break; } }
     */
}
