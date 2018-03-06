import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * Generates a Castle object.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Castle extends Piece implements Serializable{
    /** Declared ImageIcon pieceImage instance that stores image of Castle based on colour. */
    private ImageIcon pieceImage;
   
    /** Declared type instance of the castle. */
    private String type;
    /** Declared colour instance of castle. */
    private String colour;
    
    /**
    * 
    * Constructs an object of type Castle.
    * @param type of type string is required for the piece constructor 
    * which is automatically assigned a castle in the constructor at this point.
    * @param colour of type String is required for the constructor to create the castle of either white or black.
    * @param xPos of type int is required for constructor to indicate horizontal position of the castle on the board.
    * @param yPos of type int is required for constructor to indicate vertical position of castle on the board.
    */
    public Castle(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);
        
        this.colour = colour;
        
        this.type = "castle";
        
        this.xPos = xPos;
        
        this.yPos = yPos;
        
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_castle.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_castle.png");
        }
    }
    
    


    /**
     * Defined the getXPos method which returns xPos of the created Castle.
     */
    @Override
    int getXPos() {
        return xPos;
    }

    /**
     * Defined the getYPos method which returns yPos of the created Castle.
     */
    @Override
    int getYPos() {
        return yPos;
    }

    /**
     * Defined the setImage method which sets the image of the 
     * Castle to the indicated Square on the board.
     */
    @Override
    void setImage() {
        Board.squares[xPos][yPos].setIcon(getImage());
        
    }

    /**
     * Defined the getImage method which returns the image of the Castle piece.
     */
    @Override
    ImageIcon getImage() {
        return pieceImage;
    }

    /**
     * Defined the getType method which returns the type of the castle piece which is "castle".
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
     * checks if a the movement of a castle piece is valid.
     */
    @Override
    boolean move(Piece myPiece, int x, int y) {
        
        if (Board.turn() == myPiece.getColour()) {
            if (x == myPiece.getXPos() && y >= 0 && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            } 
            if (y == myPiece.getYPos() && x >= 0 && clear(myPiece, x, y)) {
                Board.turn++;
                return true;
            } 
        }
        return false;
    }




    /**
     * checks if the path of a castle's movement path is clear.
     */
    @Override
    boolean clear(Piece myPiece, int x, int y) {
        
        if (myPiece.getColour() == Board.turn()) {
            
        }
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
        return true;
    }
    
}