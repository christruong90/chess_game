import javax.swing.ImageIcon;

public class Pawn extends Piece{
    /** Declared ImageIcon pieceImage instance that stores image of Pawn based on colour. */
    private ImageIcon pieceImage;
    /** Declared xPos instance of the pawn. */
    int xPos;
    /** Declared yPos instance of the pawn. */
    int yPos;
    /** Declared type instance of the pawn. */
    private String type;
    /** Declared colour instance of pawn. */
    private String colour;
    
    /**
     * 
     * Constructs an object of type Pawn.
     * @param type of type string is required for the piece constructor 
     * @param colour of type String is required for the constructor to create the Pawn of either white or black.
     * @param xPos of type int is required for constructor to indicate horizontal position of the pawn on the board.
     * @param yPos of type int is required for constructor to indicate vertical position of pawn on the board.
     */
    public Pawn(String type, String colour, int xPos, int yPos) {
        super(type, colour, xPos, yPos);
        this.colour = colour;
        this.type = type;
        this.xPos = xPos;
        this.yPos = yPos;
        
        if (colour.equalsIgnoreCase("white")) {
            pieceImage = new ImageIcon("src/images/w_pawn.png");
        } else {
            pieceImage = new ImageIcon("src/images/b_pawn.png");
        }
         
    }
    
    /**
    * Defined the getXPos method which returns xPos of the created Pawn.
    */
   @Override
   int getXPos() {
       return xPos;
   }

   /**
    * Defined the getYPos method which returns yPos of the created pawn.
    */
   @Override
   int getYPos() {
       return yPos;
   }

   /**
    * Defined the setImage method which sets the image of the 
    * Pawn to the indicated Square on the board.
    */
   @Override
   void setImage() {
       Board.squares[xPos][yPos].setIcon(getImage());
       
   }

   /**
    * Defined the getImage method which returns the image of the pawn piece.
    */
   @Override
   ImageIcon getImage() {
       return pieceImage;
   }

   /**
    * Defined the getType method which returns the type of the pawn piece which is "pawn".
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
