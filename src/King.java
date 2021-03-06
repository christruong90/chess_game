import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Generates the King object.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class King extends Piece implements Serializable{
    /** Declared ImageIcon pieceImage instance that stores of king based on colour.*/
    private ImageIcon pieceImage;
    
    /** Declared type instance of the king object. */
    private String type;
    /** Declared colour instance of the king object. */
    private String colour;

    /**
     * 
     * Constructs an object of type King.
     * @param type of the string is required for the piece constructor which is 
     * automatically assigned "king" at this point.
     * @param colour of type String is required for the constructor to create the bishop in either white or black.
     * @param xPos of type int is required for constructor to indicate 
     * horizontal position of the King object on the board.
     * @param yPos of type int is required for constructor to indicate vertical position of king object.
     */
    public King(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);
        this.colour = colour;
        this.type = "king";
        this.xPos = xPos;
        this.yPos = yPos;
        
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_king.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_king.png");
        }
    }
    
    /**
     * Defined getXPos method which returns xPos of the king object.
     */
    @Override
    int getXPos() {
        return xPos;
    }

    /**
     * Defined getYPos method which returns yPos of the king object.
     */
    @Override
    int getYPos() {
        return yPos;
    }

    /**
     * defined setImage method which sets the image of 
     * the King in the indicated squres of the board.
     */
    @Override
    void setImage() {
        Board.squares[xPos][yPos].setIcon(getImage());
    }

    /**
     * Defined the getImage method which returns the image of the king object.
     */
    @Override
    ImageIcon getImage() {
        return pieceImage;
    }

    /**
     * Defined the getType method which returns the type of the King object.
     */
    @Override
    String getType() {
        return type;
    }

    /**
     * Defined the getColour method which returns the colour of the King object.
     */
    @Override
    String getColour() {
        return colour;
    }

    /**
     * we implement the move method which verifies the the movement range of a king piece.
     */
    @Override
    boolean move(Piece myPiece, int x, int y) {
        int xDiff = Math.abs(x - myPiece.getXPos());
        int yDiff = Math.abs(y - myPiece.getYPos());

        
        if (Board.turn() == myPiece.getColour()) {
            if (xDiff == 1 && yDiff == 1) {
                Board.turn++;
                return true;
            } 
            
            if (xDiff == 1 && yDiff == 0) {
                Board.turn++;
                return true;
            } 
            
            if (xDiff == 0 && yDiff == 1) {
                Board.turn++;
                return true;
            } 
            
        }
        return false;
    }

    /**
     * clear method verifies whether the the movement path of a king piece is clear.
     */
    @Override
    boolean clear(Piece myPiece, int x, int y) {
        if (Board.squares[x][y].getPiece().getColour() == myPiece.getColour()) {
            return false;
        }
        
        return true;
    }

}
