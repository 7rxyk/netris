package netris.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TAdapter implements KeyListener {

       private final Map<Integer, Boolean> currentStates = new ConcurrentHashMap<Integer, Boolean>();

    public TAdapter() {
        currentStates.put(KeyEvent.VK_LEFT, Boolean.FALSE);
        currentStates.put(KeyEvent.VK_RIGHT, Boolean.FALSE);
        currentStates.put(KeyEvent.VK_UP, Boolean.FALSE);
        currentStates.put(KeyEvent.VK_SPACE, Boolean.FALSE);
        currentStates.put(KeyEvent.VK_S, Boolean.FALSE);
        currentStates.put(KeyEvent.VK_P, Boolean.FALSE);
    }

    public boolean left() {
        return keyDown(KeyEvent.VK_LEFT);
    }

    public boolean right() {
        return keyDown(KeyEvent.VK_RIGHT);
    }

    public boolean drop() {
        return keyDown(KeyEvent.VK_SPACE);
    }

    public boolean rotate() {
        return keyDown(KeyEvent.VK_UP);
    }

    public boolean pauseGame() {
        return keyDown(KeyEvent.VK_P);
    }

    public boolean newGame() {
        return keyDown(KeyEvent.VK_S);
    }

    private boolean keyDown(int keyCode) {
        return currentStates.put(keyCode, Boolean.FALSE);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (currentStates.containsKey(keyEvent.getKeyCode())) {
            currentStates.put(keyEvent.getKeyCode(), Boolean.TRUE);
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
    
    @Override
    public void keyPressed(KeyEvent pressed) {
        int keycode = pressed.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_S:
                this.game = new Game();
                game.startGame();
                break;
            case KeyEvent.VK_LEFT:
                game.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                game.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                game.moveDown();
                break;
            case KeyEvent.VK_UP:
                game.rotate();
                break;
            case KeyEvent.VK_SPACE:
                game.drop();
                break;
            case KeyEvent.VK_P:
                game.pauseGame();
                break;
        }
    }*/
}