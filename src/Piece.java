import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;

abstract class Piece {
    /** Declared colour instance of string type. */
    private String colour;
    /** Declared xPos instance of type int.*/
    private int xPos;
    /** Declared yPos instance of type int. */
    private int yPos;
    /** Declared type instance of String type. */
    private String type;
    
    /**
     * 
     * Constructs an object of type Piece.
     * @param type of type string is required to construct a Piece object 
     * indicating what type of piece to instantiate.
     * @param colour of type String is required to indicate the colour of the Piece being instantiated.
     * @param xPos of type int is required to indicate horizontal position of the Piece object.
     * @param yPos of type int is required to indicate the vertical position of the Piece object.
     */
    public Piece(String type, String colour, int xPos, int yPos) {
        this.type = type;
        this.colour = colour;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /** Declared abstract method getXPos. */
    abstract int getXPos();
    /** Declared abstract method getYPos. */
    abstract int getYPos();
    /** Declared abstract method setImage. */
    abstract void setImage();
    /** Declared abstract method getImage. */
    abstract ImageIcon getImage();
    /** Declared abstract method getType. */
    abstract String getType();
    
    abstract String getColour();
}
