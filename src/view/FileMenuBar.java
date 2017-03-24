
 /*
 * TCSS 305 - Project Tetris 
 */
 
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.Board;
/**
 * class that generates a menu bar for the JFrame.
 * 
 * @author Ben Russell
 * @version 11/6/2015
 */
public class FileMenuBar extends JMenuBar {
    

    /** check for the undo button. */
    protected static boolean myUndoAll;
    /** check for the grid button.*/
    protected static boolean isGrid;
    /** A generated serialization ID. */
    private static final long serialVersionUID = -8420058521162304426L;

    /** A button to exit the program. */
    private final JMenuItem myExitButton;
    /** array to hold the tools that will be set up in the tool bar. */
    private ArrayList<ToolActions> myToolActions;
    
    private Board myTetris;
    /**
     * Construct the menu bar.
     * 
     * @param theFrame the JFrame which will contain this JMenuBar
     */
    public FileMenuBar(final JFrame theFrame) {
        super();
        setUpToolActions();
        //myColor = Color.BLACK;
       
        myExitButton = new JMenuItem("Exit");
       
        setUpMenu(theFrame);
        
    }
    /** 
     * sets up the action for the tool bar.
     * 
     */
    private void setUpToolActions() {
        myToolActions = new ArrayList<ToolActions>();
        myToolActions.add(new ToolActions("Pencil"));
        myToolActions.add(new ToolActions("Line"));
        myToolActions.add(new ToolActions("Rectangle"));
        myToolActions.add(new ToolActions("Ellipse"));
        
    }
    /**
     * Sets up the components of the menu.
     * 
     * @param theFrame the JFrame containing this menu.
     */
    private void setUpMenu(final JFrame theFrame) {
        myUndoAll = false;
        //myEnabled = false;
        add(fileMenu(theFrame));
        add(optionMenu(theFrame));
        //add(toolsMenu(theFrame));
        add(helpMenu(theFrame));
    }
   
    /**
     * method to generate and return a JMenu.
     * 
     * @param theFrame the JFrame that the menu is placed on.
     * @return fileMenu a Menu with the header File that hold the buttons undo and exit.
     */
    public JMenu fileMenu(final JFrame theFrame) {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
//        
        myExitButton.setMnemonic(KeyEvent.VK_X);
        myExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame,
                                          WindowEvent.WINDOW_CLOSING));
            }
        });
        
        fileMenu.add(myExitButton);
        return fileMenu;
    }
    /**
     * method to generate and return a JMenu.
     * 
     * @param theFrame theFrame the JFrame that the menu is placed on.
     * @return myMenu a Menu with the header Option that holds a check box for the Grid a 
     * sub-menu for Thickness and a sub-menu for the color chooser.
     */
    public JMenu optionMenu(final JFrame theFrame) {
        
        final JMenu option = new JMenu("Options");
        option.setMnemonic(KeyEvent.VK_O);
        
        final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
        grid.setMnemonic(KeyEvent.VK_G);
        grid.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                isGrid ^= true;
            }
        });
        
        final JMenu thick = new JMenu("Thickness");
        thick.setMnemonic(KeyEvent.VK_T);
        
        option.add(grid);
        
        return option;
    }

    /**
     * method to generate and return a JMenu.
     * 
     * @param theFrame theFrame the JFrame that the menu is placed on.
     * @return tools a Menu with the header tools that holds a radio buttons for Pencil, Line, 
     * Rectangle and Ellipse.
     */
    public JMenu helpMenu(final JFrame theFrame) {
        final JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("Key Info...");
        about.setMnemonic(KeyEvent.VK_A);
        final String n = "\n";
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "KEY INFO: " + n + "Move Left: left "
                                + "arrow" + n + "Move right: right arrow" + n + "Move "
                                + "down: down arrow " + n  + "Rotate: up arrow" + n 
                                + "Hard drop: space bar" + n + "Pause: p "
                                , null, JOptionPane.ERROR_MESSAGE);
            }
        });

        help.add(about);
        return help;
    }
//   
//    
    /**
     * sets the state of the undo button after something has been drawn on the panel.
     * @param theB the state of the undo panel
     */
    public static void setMyUndo(final boolean theB) {
        myUndoAll = theB;
    }
    /**
     * inner class for the tools loaded onto the tool menu.
     * 
     * @author ben russell
     */
    public final class ToolActions extends AbstractAction {
        /** A generated serialization ID. */
        private static final long serialVersionUID = 5378597116905801274L;
        /**
         * constructs a tool item with a name.
         * 
         * @param theName the name of the tool
         */
        public ToolActions(final String theName) {
            super(theName);
            putValue(Action.SELECTED_KEY, true);
            
        }
        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            
        }
    }
}
