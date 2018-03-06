import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;


/**
 * EventHandler.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class EventHandler implements ActionListener{
    /** Declares currentPiece instance which stores initial piece clicked on board. */
    private Piece currentPiece = null;
    
    /**
     * Declared actionPerformed which processes pieces being clicked and 
     * responds accordingly with an event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(source == Board.squares[i][j] ) {
                    // user selects square with a piece on it
                    if (Board.squares[i][j].hasPiece()) {
                        // if user has already selected a piece and square selected to move to has a piece of the opposite colour to be captured.
                        if (currentPiece != null && currentPiece.move(currentPiece,i, j)
                                && currentPiece.getColour() != Board.squares[i][j].getPiece().getColour()) {
                            Board.squares[i][j].setPiece(currentPiece, i, j);
                            Board.squares[i][j].setIcon(currentPiece.getImage());
                            currentPiece = null;
                            System.out.println("piece captured!");
                        // if user selected a piece and attempts to move the piece to a square that has a piece of the same color, it will be a invalid move.    
                        } else if (currentPiece != null 
                                && currentPiece.getColour() == Board.squares[i][j].getPiece().getColour()) {
                            System.out.println("invalid move! try again");
                            Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setPiece(currentPiece, currentPiece.getXPos(), currentPiece.getYPos());
                            Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setIcon(currentPiece.getImage()); 
                            currentPiece = null;
                       // selected piece to place on empty square   
                        } else if(currentPiece != null) {
                            System.out.println("???");
                            Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setPiece(currentPiece, currentPiece.getXPos(), currentPiece.getYPos());
                            Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setIcon(currentPiece.getImage()); 
                            currentPiece = null;
                        }
                     // user selects piece and piece is removed from initial square and stored to be moved. 
                        else if(currentPiece == null) {
                          currentPiece = Board.squares[i][j].getPiece();   
                          Board.squares[i][j].removePiece(i, j);
                          System.out.println( "x: " + Board.squares[i][j].getXpos() + " y: " +  Board.squares[i][j].getYpos());
                          System.out.println("old x: " + currentPiece.getXPos() + " old y: " + currentPiece.getYPos() );
                          
                        }
                        
                    // if user has already selected a piece to be moved and moves piece to empty square.
                    } else if(currentPiece != null && currentPiece.move(currentPiece, i, j)){
                        Board.squares[i][j].setPiece(currentPiece, i, j);
                        Board.squares[i][j].setIcon(currentPiece.getImage());
                        System.out.println("new x: " + i + "new y: " + j);
                        currentPiece = null;
                    // if user tries to move selected piece to a invalid range    
                    } else if(currentPiece != null && !currentPiece.move(currentPiece, i, j)) {
                        Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setPiece(currentPiece, currentPiece.getXPos(), currentPiece.getYPos());
                        Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setIcon(currentPiece.getImage());
                        currentPiece = null;
                    // if user selects an empty square
                    } else {
                        return;
                    }
                }
                
            }
        }
    }

}
