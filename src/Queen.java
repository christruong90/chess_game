import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Queen.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Queen extends Piece implements Serializable{
    /** Declared ImageIcon pieceImage instance that 
     * stores image of bishop based on colour. */
    ImageIcon pieceImage;
    
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

    /**
     * We declare the move method which verifies the movement range of a queen piece.
     */
    @Override
    boolean move(Piece myPiece, int x, int y) {
        int xDifference =  Math.abs(x - myPiece.getXPos());
        int yDifference = Math.abs(y - myPiece.getYPos());
        if (Board.turn() == myPiece.getColour()) {
            // vertical path 
            if (x == myPiece.getXPos() && y >= 0 && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            } 
            // horizontal path         
            if (y == myPiece.getYPos() && x >= 0 && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            }
            // Diagonal Path
            if (xDifference == yDifference && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            } 
        }
        
        return false;
        
    }

    /**
     * we declare the clear method which checks the path of a queen piece's path.
     */
    @Override
    boolean clear(Piece myPiece, int x, int y) {
        
        
       // checking vertical path
        if (y == myPiece.getYPos()) {
            int max = Math.max(myPiece.getXPos(), x);
            int min = Math.min(myPiece.getXPos(), x);
            
            for (int i = min; i < max; i++) {
                if(Board.squares[i][y].hasPiece()) {
                    return false;
                }
            }
        }
        // checking horizontal path
        if (x == myPiece.getXPos()) {
            int max = Math.max(myPiece.getYPos(), y);
            int min = Math.min(myPiece.getYPos(), y);
            
            for (int i = min; i < max; i++) {
                if (Board.squares[x][i].hasPiece()) {
                    return false;
                }
            }
        }
        
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
