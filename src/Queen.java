import javax.swing.ImageIcon;

/**
 * Queen.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Queen extends Piece{
    /** Declared ImageIcon pieceImage instance that 
     * stores image of bishop based on colour. */
    ImageIcon pieceImage;
    /** Declared xPos instance of queen object.*/
    int xPos;
    /** Declared yPos instance of the queen object. */
    int yPos;
    /** Declared type instance of the queen object.*/
    String type;
    /** Declared colour instance of the queen object. */
    String colour;
    
    /**
     * 
     * Constructs an object of type Queen.
     * @param type of type String is required for the piece constructor
     * @param colour of type string is required for the constructor 
     * create the bishop of either white or black.
     * @param xPos of type int is required for constructor to 
     * indicate horizontal position of the bishop on the board.
     * @param yPos of type int is required for constructor to 
     * indicate vertical position of bishop on the board.
     */
    public Queen(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);
        this.colour = colour;
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_queen.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_queen.png");
        }
        
    }

    /**
     * Defined the getXPos method which returns xPos of the created queen.
     */
    @Override
    int getXPos() {
        return xPos;
    }

    /**
     * Defined the yPos method which returns yPos of the created queen.
     */
    @Override
    int getYPos() {
        return yPos;
    }

    /**
     * Defined the setImage method which sets the image of 
     * the bishop to the indicated square on the board.
     */
    @Override
    void setImage() {
        Board.squares[xPos][yPos].setIcon(getImage());
    }

    /**
     * Defined the getImage method which returns the image of the queen piece.
     */
    @Override
    ImageIcon getImage() {
        return pieceImage;
    }

    /**
     * Defined the getType method which returns the type of queen object.
     */
    @Override
    String getType() {
        return type;
    }

    /**
     * Defined the getColour method which returns the colour of the object.
     */
    @Override
    String getColour() {
        return colour;
    }
    
}
