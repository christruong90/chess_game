import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * Generates a Knight object.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Knight extends Piece implements Serializable{
    /** Declared ImageIcon pieceImage instance that stores image of Knight based on colour. */
    private ImageIcon pieceImage;
    /** Declared type instance of the knight. */
    private String type;
    /** Declared colour instance of knight. */
    private String colour;
    
    /**
     * 
     * Constructs an object of type Knight.
     * @param type of type string is required for the piece constructor 
     * which is automatically assigned a knight in the constructor at this point.
     * @param colour of type String is required for the constructor to create the Knight of either white or black.
     * @param xPos of type int is required for constructor to indicate horizontal position of the knight on the board.
     * @param yPos of type int is required for constructor to indicate vertical position of knight on the board.
     */
    public Knight(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);
        this.colour = colour;
        this.type = "knight";
        this.xPos = xPos;
        this.yPos = yPos;
    
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_knight.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_knight.png");
        }
       
    }


    /**
     * Defined the getXPos method which returns xPos of the created Knight.
     */
    @Override
    int getXPos() {
        return xPos;
    }

    /**
     * Defined the getYPos method which returns yPos of the created knight.
     */
    @Override
    int getYPos() {
        return yPos;
    }

    /**
     * Defined the setImage method which sets the image of the 
     * Knight to the indicated Square on the board.
     */
    @Override
    void setImage() {
        Board.squares[xPos][yPos].setIcon(getImage());
        
    }

    /**
     * Defined the getImage method which returns the image of the knight piece.
     */
    @Override
    ImageIcon getImage() {
        return pieceImage;
    }

    /**
     * Defined the getType method which returns the type of the knight piece which is "knight".
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

    /**
     * checks if the movement of a knight piece is valid.
     */
    @Override
    boolean move(Piece myPiece, int x, int y) {
        int xDiff = Math.abs(x - myPiece.getXPos());
        int yDiff = Math.abs(y - myPiece.getYPos());
        
        
        
        if (Board.turn() == myPiece.getColour()) {
            if ((xDiff == 1) && (yDiff == 2)) {
                Board.turn++;
                return true;
            }
            
            if ((yDiff == 1) && (xDiff == 2)) {
                Board.turn++;
                return true;
            }
        }
        
        
        return false;
        
        
    }

    /**
     * checks if the pathway of a knight piece is clear.
     */
    @Override
    boolean clear(Piece myPiece, int x, int y) {
        // TODO Auto-generated method stub
        return true;
    }
}
