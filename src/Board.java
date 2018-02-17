import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridLayout;
/**
 * chessBoard.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Board extends JFrame  {

    /** Declared squares 2d array of Square objects  */
    public static Square[][] squares = new Square[8][8];
    /** Dclared eventHandler object, myEvent which responds to the clicks on board 
     * and responds accordingly with an event in the eventHandler class.*/ 
    EventHandler myEvent = new EventHandler();    
    
    /**
     * 
     * Constructs an object of type Board.
     */
     public Board() {
         super("Chess Game");
         
         // Gridlayout used to setup the squares in a 8x8 board of squares.
         setLayout(new GridLayout(8,8));
         
         /** loop used to setup a new square with a 
         jbutton, white/grey colour and actionListener for each square. */
         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 
                 squares[i][j] = new Square(i, j);
                 if ((i + j) % 2 == 0) {
                     squares[i][j].setOpaque(true);
                     squares[i][j].setBackground(Color.LIGHT_GRAY);   
                     squares[i][j].setBorderPainted(false);
                 }
                 
                 add(squares[i][j]);
                 squares[i][j].addActionListener(myEvent);

             }
         }
         
         // white pieces are assigned to squares accordingly for a new game.
         squares[0][0].setPiece("castle", "white", 0, 0);
         squares[0][7].setPiece("castle", "white", 0, 7);
         squares[0][6].setPiece("knight", "white", 0, 6);
         squares[0][1].setPiece("knight", "white", 0, 1);
         squares[0][2].setPiece("bishop", "white", 0, 2);
         squares[0][3].setPiece("king", "white", 0, 3);
         squares[0][4].setPiece("queen", "white", 0, 4);
         squares[0][5].setPiece("bishop", "white", 0, 5);
         
         // white pawns are assigned to squares accordingly for a new game.
         for (int i = 1; i < 2; i++) {
             for (int j = 0; j < 8; j++ ) {
                 squares[i][j].setPiece("pawn", "white", i, j);
             }
         }
         
         // black pieces are assigned to squares accordingly for a new game.
         squares[7][0].setPiece("castle", "black", 7, 0);
         squares[7][7].setPiece("castle", "black", 7, 7);
         squares[7][6].setPiece("knight", "black", 7, 6);
         squares[7][1].setPiece("knight", "black", 7, 1);
         squares[7][2].setPiece("bishop", "black", 7, 2);
         squares[7][3].setPiece("queen", "black", 7, 3);
         squares[7][4].setPiece("king", "black", 7, 4);
         squares[7][5].setPiece("bishop", "black", 7, 5);
         
         // black pawns are assigned to squares accordingly 
         for (int x = 6; x < 7; x++) {
             for (int k = 0; k < 8; k++) {
                 squares[x][k].setPiece("pawn", "black", x, k);
             }
         }
         
         
         
         setSize(600,600);
         setResizable(false);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         
         
     }
     
     

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Board();
        

    }

}
