package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.AbstractPiece;
import model.Board;
import model.Piece;
/**
 * Class that displays a preview of the next piece on a JPanel.
 * 
 * @author Ben Russell
 * @version 12/10/2015
 *
 */
public class PreviewPanel extends JPanel implements Observer {
    /** serial id number. */
    private static final long serialVersionUID = 1L;
    /** constant for the size of the blocks. */
    private static final int BLOCK_SIZE = 20;
    /** field to hold this instance of the game board. */
    private final Board myBoard;
    /**
     * class constructor.
     * 
     * @param theBoard the current instance of the game board.
     */
    public PreviewPanel(final Board theBoard) {
        super();
        myBoard = theBoard;
    }
    @Override 
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        final Piece p  = myBoard.getNextPiece();
        
        final int[][] coords = ((AbstractPiece) p).getBoardCoordinates();
        if (coords != null) {
            g2d.setColor(Color.MAGENTA);
            for (int i = 0; i < coords.length; i++) {
                g2d.fillRect(coords[i][0] * BLOCK_SIZE - BLOCK_SIZE + BLOCK_SIZE
                             , (myBoard.getHeight() - coords[i][1]) * BLOCK_SIZE 
                             + BLOCK_SIZE + BLOCK_SIZE + BLOCK_SIZE
                             , BLOCK_SIZE, BLOCK_SIZE);
            }
            g2d.setColor(Color.BLACK);
            for (int i = 0; i < coords.length; i++) {
                g2d.drawRect(coords[i][0] * BLOCK_SIZE - BLOCK_SIZE + BLOCK_SIZE
                             , (myBoard.getHeight() - coords[i][1]) * BLOCK_SIZE 
                             + BLOCK_SIZE + BLOCK_SIZE + BLOCK_SIZE
                             , BLOCK_SIZE, BLOCK_SIZE);
            }
        }
    }
    @Override
    public void update(final Observable arg0, final Object arg1) {
       
        repaint();
    }
}
