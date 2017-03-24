/*
 * TCSS 305 - Project Tetris 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


import model.AbstractPiece;
import model.Block;
import model.Board;
import model.Piece;
/** 
 * Class that displays the graphics of the game on a panel.
 * 
 * @author Ben Russell
 * @version 12/10/2015
 *
 */
public class TetrisPanel extends JPanel implements Observer {

    /** needed for some reason. */    
    private static final long serialVersionUID = 5779064686408370535L;
    /** constant for the size of a block. */
    private static final int BLOCK_SIZE = 20;
    
    /** field for the board. */
    private final Board myTetris;
    
    /**
     * constructor.
     * @param theBoard instance of the board.
     */
    public TetrisPanel(final Board theBoard) {
        super();
        myTetris = theBoard;
        repaint();
    }
    @Override 
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.LIGHT_GRAY);
        if (FileMenuBar.isGrid) {
            for (int i = 0; i < getWidth(); i += BLOCK_SIZE) {
                g2d.drawLine(i, 0, i, getHeight());                
            }
            for (int i = 0; i < getHeight(); i += BLOCK_SIZE) {
                g2d.drawLine(0, i, getWidth(), i);                
            }
        }
        
        
        final Piece p = myTetris.getCurrentPiece();
        
        final int[][] coords = ((AbstractPiece) p).getBoardCoordinates();
        final Block r = ((AbstractPiece) p).getBlock();
        g2d.setColor(paintBrick(r));
        if (coords != null) {
            for (int i = 0; i < coords.length; i++) {
                g2d.fillRect(coords[i][0] * BLOCK_SIZE
                          , (myTetris.getHeight() - coords[i][1]) 
                                   * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
        g2d.setColor(Color.BLACK);
        if (coords != null) {
            for (int i = 0; i < coords.length; i++) {
                g2d.drawRect(coords[i][0] * BLOCK_SIZE
                          , (myTetris.getHeight() - coords[i][1]) 
                                   * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
            }
        }
        g2d.setColor(Color.MAGENTA);
        final List<Block[]> f = myTetris.getFrozenBlocks();
        
        for (int i = 0; i < f.size(); i++) {
            final Block[] b = f.get(i);
            for (int j = 0; j < b.length; j++) {
                final Block v = b[j];
                if (v != Block.EMPTY) {
                    g2d.fillRect(j * BLOCK_SIZE, (getHeight() -  i 
                                 * BLOCK_SIZE) - BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        } 
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < f.size(); i++) {
            final Block[] b = f.get(i);
            for (int j = 0; j < b.length; j++) {
                final Block v = b[j];
                if (v != Block.EMPTY) {
                    g2d.drawRect(j * BLOCK_SIZE, (getHeight() -  i 
                                 * BLOCK_SIZE) - BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        } 
        if (myTetris.isGameOver()) { 
          
            final int fontSize = 18;
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            g2d.drawString("GAME OVER!!", getWidth() / 2 - (BLOCK_SIZE * 2), getHeight() / 2);
        }
    }
    @Override
    public void update(final Observable arg0, final Object arg1) {
        
        repaint();
    }
    /** 
     * method that sets the color of each brick.
     * 
     * @param theBlock the current block.
     * @return color the color of the brick
     */
    public Color paintBrick(final Block theBlock) {
        Color color = Color.WHITE;
        if (theBlock == Block.L) {        
            color = Color.BLUE;
        } else if (theBlock == Block.S) {
            color = Color.RED;
        } else if (theBlock == Block.Z) {
            color = Color.BLACK;
        } else if (theBlock == Block.J) {
            color = Color.YELLOW;
        } else if (theBlock == Block.T) {
            color = Color.PINK;
        } else if (theBlock == Block.I) {
            color = Color.ORANGE;
        } else if (theBlock == Block.O) {
            color = Color.GREEN;
        }
        return color;
    }
    
}
