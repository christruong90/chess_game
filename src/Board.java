import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.GridLayout;
/**
 * chessBoard.
 *
 * @author Chris Truong 
 * @version 2018
 */
public class Board extends JFrame implements Serializable{
    public static int turn;
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
         
         // adding the menu bar with menu items to the jFrame window
         JMenuBar mb = new JMenuBar();
         JMenu menu = new JMenu("Menu");
         JMenuItem save = new JMenuItem("Save");
         JMenuItem load = new JMenuItem("Open");
         JMenuItem newGame = new JMenuItem("New Game");
         JMenuItem exit = new JMenuItem("Exit Game");
         
         mb.add(menu);
         menu.add(newGame);
         menu.add(exit);
         menu.add(save);
         menu.add(load);
         
         
         this.setJMenuBar(mb);
         
         // adding actionEvent to start a new game.
         class newGame implements ActionListener {
             public void actionPerformed (ActionEvent e) {
                 for (int i = 0; i < 8; i++) {
                     for (int k= 0; k< 8; k++) {
                         squares[i][k].removePiece(i, k);
                     }
                 }
                 newSetup();
             }
         }
         
         // adding actionEvent that closes the chess game.
         class exitGame implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         }
         
         // Declaring actionEvent that saves the game.
         class saveEvent implements ActionListener {
             public void actionPerformed (ActionEvent e) {
                 try {
                     FileOutputStream fileOut =
                     new FileOutputStream("src/tmp/mySave.ser");
                     ObjectOutputStream out = new ObjectOutputStream(fileOut);
                     
                     for (int i = 0; i < 8; i++) {
                         for (int j = 0; j < 8; j++) {
                             out.writeObject(squares[i][j].getPiece());
                         }
                     }
                     out.writeObject(turn);
                     out.close();
                     fileOut.close();
                     System.out.printf("Serialized data is saved in src/tmp/mySave.ser");
                  } catch (IOException i) {
                     i.printStackTrace();
                  }
             }
         }
         
         // Declared actionEvent that loads the game. 
         class loadEvent implements ActionListener {
             public void actionPerformed (ActionEvent e) {
                 Board b = null;
                 try {
                     FileInputStream fileIn = new FileInputStream("src/tmp/mySave.ser");
                     ObjectInputStream in = new ObjectInputStream(fileIn);
                     for (int i = 0; i < 8; i++) {
                         for (int j = 0; j < 8; j++) {
                             squares[i][j].removePiece(i, j);
                             
                         }
                     }
                     for (int i = 0; i < 8; i++) {
                         for (int j = 0; j < 8; j++) {
                             Piece myPiece = (Piece) in.readObject();
                             if (myPiece != null) {
                                 squares[i][j].setPiece(myPiece.getType(), myPiece.getColour(), i, j);
                                 //myPiece.setImage();
                             }
                         }
                     }

                     
                     turn = (int) in.readObject();
                     in.close();
                     fileIn.close();
                  } catch (IOException i) {
                     i.printStackTrace();
                     return;
                  } catch (ClassNotFoundException c) {
                     System.out.println("Board class not found");
                     c.printStackTrace();
                     return;
                  }
             }
         }
         
         
         save.addActionListener(new saveEvent());
         load.addActionListener(new loadEvent());
         newGame.addActionListener(new newGame());
         exit.addActionListener(new exitGame());
         
         
         
         setSize(600,600);
         setResizable(false);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         
     }
     
     public void newSetup() {
         
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
     }
     
     /**
      * declared turn method that checks the turn instance which returns which player's turn it is.
      * if the turn instance is even, then it is white player's turn.
      * if the turn instance is uneven, then it is black player's turn.
      * @return
      */
     public static String turn() {
         if (turn % 2 == 0)  {
             return "white";
         } else {
             return "black";
         }
         
     }
     
     

    /**
     * @param args unused.
     */
    public static void main(String[] args) {
        new Board();
    }

}
