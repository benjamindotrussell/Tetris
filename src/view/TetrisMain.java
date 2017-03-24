/*
 * TCSS 305 - Project Tetris 
 */
package view;

import java.awt.EventQueue;



/**
 * @author Ben Russell
 * @version 11/23/2015
 */
public final class TetrisMain {
    /**
     * private constructor that prevents instantiation.
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }
    /**
     * driver class.
     * 
     * @param theArgs used for command line access.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisGUI().start();
            }
        });

    }

}
