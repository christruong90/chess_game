import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * EventHandler.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class EventHandler implements ActionListener {
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
                    // if user clicks square with a piece on it
                    if (Board.squares[i][j].hasPiece()) {
                        // if user has already selected a piece and square selected to move to has a piece of the opposite colour to be captured.
                        if (currentPiece != null && currentPiece.getColour() != Board.squares[i][j].getPiece().getColour()) {
                            Board.squares[i][j].setPiece(currentPiece.getType(), currentPiece.getColour(), i, j);
                            currentPiece = null;
                            System.out.println("piece captured!");
                        // if user selected a piece and attempts to move the piece to a square that has a piece of the same color, it will be a invalid move.    
                        } else if (currentPiece != null && currentPiece.getColour() ==Board.squares[i][j].getPiece().getColour()) {
                            System.out.println("invalid move! try again");
                            Board.squares[currentPiece.getXPos()][currentPiece.getYPos()].setPiece(currentPiece.getType(),
                                    currentPiece.getColour(),currentPiece.getXPos(), currentPiece.getYPos());
                            currentPiece = null;
                        // user selects piece and piece is removed from initial square and stored to be moved.    
                        } else {
                          currentPiece = Board.squares[i][j].getPiece();                        
                          Board.squares[i][j].removePiece(i, j);
                        }
                        
                    // if user has already selected a piece to be moved.
                    } else if(currentPiece != null){
                        Board.squares[i][j].setPiece(currentPiece.getType(), currentPiece.getColour(), i, j);
                        Board.squares[i][j].setIcon(currentPiece.getImage());
                        currentPiece = null;
                    } else {
                       return; 
                    }
                }
                
            }
        }
    }

}
