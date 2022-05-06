/**
 * Write a description of class Term2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (06/05/22)
 */
import java.util.Scanner;
public class Term2Project
{
    // instance variables - replace the example below with your own
    private boolean playing = true;
    
    Scanner kb = new Scanner(System.in); 
    
    private String o = "o ";
    private String ship = "x ";
    private char boardChar = 65;
    
    private int ROWS = 2;
    private int COLS = 2;
    String board[][] = new String[COLS][ROWS];
    
    
    // ship# | block#
    private int s2b1Y = 0;
    private int s2b1X = 0;
    private int s2b2Y = 1;
    private int s2b2X = 0;
    private boolean ship2 = false;
    
    /**
     * Constructor for objects of class arrays
     */
    public Term2Project()
    {
        // System.out.print('\u000C');
        // for(int i=0;i<COLS;i++){
            // System.out.print(i + " ");
        // }
        // System.out.print("🚢");
        // System.out.println();
        // for(int i=0;i<COLS;i++){
            // for(int j=0;j<ROWS;j++){    
                // board[i][j] = o;
                // System.out.print(board[i][j]);
            // }
            // System.out.print(boardChar);
            // boardChar++;
            // if (i==9) boardChar = 65;
            // System.out.println();
        // }
        ship2Print();
        while (playing){
            
        }
    }
    public void ship2Print(){
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
                System.out.print(i + " ");
            }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){    
                board[i][j] = o;
                board[s2b1Y][s2b1X] = ship;
                board[s2b2Y][s2b2X] = ship;
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==10)boardChar = 65;
            System.out.println();
        }
    }
    public void ship2CMD(){
        while (ship2){
            String cmd0 = kb.nextLine();
            cmd0.toLowerCase();
            if(cmd0.equals("up"))System.out.print(boardChar);
        }
    }   
}