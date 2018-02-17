import javax.swing.ImageIcon;

/**
 * Create a Bishop object.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Bishop extends Piece {
    /** Declared ImageIcon pieceImage instance that stores image of Bishop based on colour. */
    private ImageIcon pieceImage;
    /** Declared xPos instance of the bishop. */
    int xPos;
    /** Declared yPos instance of the bishop. */
    int yPos;
    /** Declared type instance of the bishop. */
    private String type;
    /** Declared colour instance of bishop. */
    private String colour;
    
    /**
     * 
     * Constructs an object of type Bishop.
     * @param type of type string is required for the piece constructor 
     * which is automatically assigned a bishop in the constructor at this point.
     * @param colour of type String is required for the constructor to create the Bishop of either white or black.
     * @param xPos of type int is required for constructor to indicate horizontal position of the bishop on the board.
     * @param yPos of type int is required for constructor to indicate vertical position of bishop on the board.
     */
    public Bishop(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);      
        this.colour = colour;       
        this.type = "Bishop";       
        this.xPos = xPos;       
        this.yPos = yPos;      
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_bishop.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_bishop.png");
        }
    }

    
    /**
     * Defined the getXPos method which returns xPos of the created Bishop.
     */
    @Override
    int getXPos() {
        return xPos;
    }

    /**
     * Defined the getYPos method which returns yPos of the created bishop.
     */
    @Override
    int getYPos() {
        return yPos;
    }

    /**
     * Defined the setImage method which sets the image of the 
     * Bishop to the indicated Square on the board.
     */
    @Override
    void setImage() {
        Board.squares[xPos][yPos].setIcon(getImage());
        
    }

    /**
     * Defined the getImage method which returns the image of the bishop piece.
     */
    @Override
    ImageIcon getImage() {
        return pieceImage;
    }

    /**
     * Defined the getType method which returns the type of the bishop piece which is "bishop".
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
