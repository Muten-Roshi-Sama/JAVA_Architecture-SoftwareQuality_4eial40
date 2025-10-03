// InputManager.java

package manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class InputManager implements KeyListener, MouseListener{

    private GameEngine engine;
    private final boolean useWASD = true;

    public InputManager(GameEngine engine) {
        this.engine = engine; }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        GameStatus status = engine.getGameStatus();
        ButtonAction currentAction = ButtonAction.NO_ACTION;

        int upKey = useWASD ? KeyEvent.VK_W : KeyEvent.VK_UP;
        int downKey = useWASD ? KeyEvent.VK_S : KeyEvent.VK_DOWN;
        int leftKey = useWASD ? KeyEvent.VK_A : KeyEvent.VK_LEFT;
        int rightKey = useWASD ? KeyEvent.VK_D : KeyEvent.VK_RIGHT;

        int fireKey = useWASD ? KeyEvent.VK_C : KeyEvent.VK_SPACE;
        int selectKey = KeyEvent.VK_L;
        int pauseKey = KeyEvent.VK_ESCAPE;




        if (keyCode == upKey) {
            if(status == GameStatus.START_SCREEN || status == GameStatus.MAP_SELECTION)
                currentAction = ButtonAction.GO_UP;
            else
                currentAction = ButtonAction.JUMP;
        }

        else if(keyCode == downKey){
            if(status == GameStatus.START_SCREEN || status == GameStatus.MAP_SELECTION)
                currentAction = ButtonAction.GO_DOWN;
        }

        else if (keyCode == rightKey) {
            currentAction = ButtonAction.M_RIGHT;
        }

        // A :: LEFT
        else if (keyCode == leftKey) {
            currentAction = ButtonAction.M_LEFT;
        }

        // ENTER(key broken, replaced by C) :: SELECT
        else if (keyCode == selectKey) {
            currentAction = ButtonAction.SELECT;
        }

        // ESCAPE :: PAUSE
        else if (keyCode == pauseKey) {
            if(status == GameStatus.RUNNING || status == GameStatus.PAUSED )
                currentAction = ButtonAction.PAUSE_RESUME;
            else
                currentAction = ButtonAction.GO_TO_START_SCREEN;

        }

        // SPACE (replaced by k) :: FIRE
        else if (keyCode == fireKey){
            currentAction = ButtonAction.FIRE;
        }


        notifyInput(currentAction);
    }


    @Override
    public void keyReleased(KeyEvent event) {
        int leftKey = useWASD ? KeyEvent.VK_A : KeyEvent.VK_LEFT;
        int rightKey = useWASD ? KeyEvent.VK_D : KeyEvent.VK_RIGHT;

        if (event.getKeyCode() == leftKey || event.getKeyCode() == rightKey)
            notifyInput(ButtonAction.ACTION_COMPLETED);
    }

    private void notifyInput(ButtonAction action) {
        if(action != ButtonAction.NO_ACTION)
            engine.uiManager.receiveInput(action);
    }


    // ----- Mouse Events -----

    @Override
    public void mousePressed(MouseEvent e) {
        if(engine.getGameStatus() == GameStatus.MAP_SELECTION){
            engine.uiManager.selectMapViaMouse();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
