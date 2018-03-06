import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.GridLayout;

/**
 * Generates a square object.
 * @author Chris Truong 
 * @version 2018
 */
public class Square extends JButton implements Serializable {
    
    /** Declared myPiece instance of type Piece. */
    private Piece myPiece = null;
    /** Declared xPos instance of type int. */
    private int xPos;
    /** Declared yPos instance of type int. */
    private int yPos;
    /** Declared pieceImage of type ImageIcon. */
    private ImageIcon pieceImage;
        
    
    /**
     * 
     * Constructs an object of type Square.
     * @param xWay required to indicate horizontal position on board.
     * @param yWay required to indicate vertical position on board.
     */
    public Square(int xWay, int yWay) {
        if (xWay > 0 && xWay < 8) {
            xWay = xPos;
            
        }
        
        if (yWay > 0 && xWay < 8) {
            yWay = yPos;
        }
  
    }
    
    /**
     * Declared getImage method.
     * @return returns a ImageIcon object which stores the image 
     * of the piece of the square if the square has a piece.
     */
    public ImageIcon getImage() {
        ImageIcon theImage = null;
        
        if (hasPiece()) {
            theImage = myPiece.getImage();
        }
        
        return theImage;
    }
    
    /**
     * Declared removePiece method.
     * @param x required to indicate horizontal position of square where piece is being removed.
     * @param y required to indicate vertical position of square where piece is being removed.
     */
    public void removePiece(int x, int y) {
        Board.squares[x][y].setIcon(null);
        myPiece = null;
        pieceImage = null;
        
    }
    
    /**
     * Declared getXpos method.
     * @return returns xPos of square indicating horizontal position of the square.
     */
    public int getXpos() {
        return xPos;
    }
    
    /**
     * Declared getYpos method.
     * @return returns yPos of square indicating vertical position of the square.
     */
    public int getYpos() {
        return yPos;
    }
    
    /**
     * Declared getPiece method.
     * @return returns myPiece instance which stores 
     * the current Piece of the square if the square has a piece.
     */
    public Piece getPiece() {
        return myPiece;
    }
    
    
    
    /**
     * Declared hasPiece method.
     * @return returns boolean indicating whether current square has a piece or not.
     */
    public Boolean hasPiece() {
        if (myPiece == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Declared setPiece method.
     * @param piece required for method to indicate what type of piece is being assigned to the square.
     * @param colour required for method to indicate what colour of the piece being assigned to the square.
     * @param xCoordinate required for method to indicate horizontal position 
     * of the square piece is being assigned to
     * @param yCoordinate required for method to indicate vertical position 
     * of the square the piece is being assigned to
     * 
     */
    public void setPiece(Piece piece, int x, int y) {
        if (piece != null) {
            piece.setXPos(x);
            piece.setYPos(y);
        }
        
        Board.squares[x][y].myPiece = piece;
        myPiece = piece;
    }
    
    public void setPiece(String piece, String colour, int xCoordinate, int yCoordinate) {
        if (piece.equalsIgnoreCase("pawn")) {
            myPiece = new Pawn("pawn", colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
        
        if (piece.equalsIgnoreCase("castle")) {
            myPiece = new Castle(piece, colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
        
        if (piece.equalsIgnoreCase("knight")) {
            myPiece = new Knight(piece, colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
        
        if (piece.equalsIgnoreCase("bishop")) {
            myPiece = new Bishop(piece, colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
        
        if (piece.equalsIgnoreCase("king")) {
            myPiece = new King(piece, colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
        
        if (piece.equalsIgnoreCase("queen")) {
            myPiece = new Queen(piece, colour, xCoordinate, yCoordinate);
            myPiece.setImage();
        }
    }
    

}
