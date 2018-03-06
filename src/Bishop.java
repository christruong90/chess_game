import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Create a Bishop object.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Bishop extends Piece implements Serializable{
    /** Declared ImageIcon pieceImage instance that stores image of Bishop based on colour. */
    private ImageIcon pieceImage;
    
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

    /**
     * checks if the movement of a bishop piece is valid.
     */
    @Override
    boolean move(Piece myPiece, int x, int y) {
        int xDifference = Math.abs(x - myPiece.getXPos());
        int yDifference = Math.abs(y - myPiece.getYPos());
        
        
        if(Board.turn() == myPiece.getColour()) {
            if (xDifference == yDifference && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            }
        }
        
            return false;
        
    }

    /**
     * checks if the path of a bishop piece is valid.
     */
    @Override
    boolean clear(Piece myPiece, int x, int y) {
        
        // Checking direction going downwards
        if (x - myPiece.getXPos() > 0) {
            for (int i = myPiece.getXPos(), j = myPiece.getYPos(); i < x && j < y; i++, j++) {
                if (Board.squares[i][j].hasPiece()) {
                    return false;
                }
            }
            
            for (int i = myPiece.getXPos(), j = myPiece.getYPos(); i < x && j > y; i++, j-- ) {
                if (Board.squares[i][j].hasPiece()) {
                    return false;
                }
            }
        }
        
        // checking for direction going upwards
        if (x - myPiece.getXPos() < 0) {
            for (int i = myPiece.getXPos(), j = myPiece.getYPos(); i > x && j > y; i--, j--) {
                if (Board.squares[i][j].hasPiece()) {
                    return false;
                }
            }
            
            for (int i = myPiece.getXPos(), j = myPiece.getYPos(); i > x && j < y; i--, j++ ) {
                if (Board.squares[i][j].hasPiece()) {
                    return false;
                }
            }
            
        }
        
        
        
        return true;
    }
    
   
}
