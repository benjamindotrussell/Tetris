package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import model.Board;
/**
 * class that overrides KeyListener.
 * 
 * @author ben Russell
 * @version 12/1/2015
 */
public class KeyPress implements KeyListener {
    /** field for the board. */
    private final Board myBoard; 
    /** filed to hold the current state of the timer. */
    private final Timer myTimer;
    /**
     * constructor.
     * 
     * @param theBoard the current instance of the board.
     * @param theTimer the current state of the Timer.
     */
    public KeyPress(final Board theBoard, final Timer theTimer) {
        super();
        myBoard = theBoard;
        myTimer = theTimer;
    }
    /** 
     * method to check which key was pressed and then perform an action accordingly.
     * @param theEvent the key press.
     */
    public void keyPressed(final KeyEvent theEvent) {
        
        final int key = theEvent.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            myBoard.moveLeft();
        } else if (key == KeyEvent.VK_RIGHT) {
            myBoard.moveRight();
        } else if (key == KeyEvent.VK_DOWN) {
            myBoard.moveDown();
        } else if (key == KeyEvent.VK_UP) {
            myBoard.rotate();
        } else if (key == KeyEvent.VK_SPACE) {
            if (myTimer.isRunning()) {
                myBoard.hardDrop();
            }
        } else if (key == KeyEvent.VK_P) {
            
            if (myTimer.isRunning()) {
                myTimer.stop();
            } else { 
                myTimer.start();
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent theE) {
        
    }

    @Override
    public void keyTyped(final KeyEvent theE) {
        
    }

}
