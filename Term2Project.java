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
    
    Scanner kb = new Scanner (System.in);
    
    private String o = "🌊 ";
    private String ship = "🕳 ";
    private String shipFinal = "🚢 ";
    private char boardChar = 65;
    
    private int ROWS = 10;
    private int COLS = 10;
    String board[][] = new String[COLS][ROWS];
    
    
    // ship# | block#
    private int s2b1Y = 0;
    private int s2b1X = 0;
    private int s2b2Y = 1;
    private int s2b2X = 0;
    private int s2T = 0; //ship# turn
    private boolean ship2 = true;
    
    private int s3Ab1Y = 0;
    private int s3Ab1X = 0;
    private int s3Ab2Y = 1;
    private int s3Ab2X = 0;
    private int s3Ab3Y = 2;
    private int s3Ab3X = 0;
    private int s3A = 0; //ship# turn
    private boolean ship3A = true;
    
    /**
     * Constructor for objects of class arrays
     */
    public Term2Project()
    {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
                System.out.print(i+ " ");
            }
        System.out.print("🚢");
        System.out.println();
            for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){    
                board[i][j] = o;
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
        ship2Print();
        ship2CMD();
    }
    public void ship2Print() {
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
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
    public void ship3APrint() {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
            System.out.print(i + " ");
        }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){    
                board[i][j] = o;
                board[s2b1Y][s2b1X] = shipFinal;
                board[s2b2Y][s2b2X] = shipFinal;
                
                board[s3Ab1Y][s3Ab1X] = ship;
                board[s3Ab2Y][s3Ab2X] = ship;
                board[s3Ab3Y][s3Ab3X] = ship;
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
    public void ship2CMD(){
         while (ship2){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("right") || cmd0.equals("r")){
                s2b1X++;
                s2b2X++;
                ship2Print();
            }
            if(cmd0.equals("left") || cmd0.equals("l")){
                s2b1X--;
                s2b2X--;
                ship2Print();
            }
            if(cmd0.equals("up") || cmd0.equals("u")){
                s2b1Y--;
                s2b2Y--;
                ship2Print();
            }
            if(cmd0.equals("down") || cmd0.equals("d")){
                s2b1Y++;
                s2b2Y++;
                ship2Print();
            }
            if(cmd0.equals("turn") && s2T == 0|| cmd0.equals("t") && s2T == 0){
                s2b2X++;
                s2b2Y--;
                cmd0 = " ";
                s2T = 1;
                ship2Print();              
            }
            if(cmd0.equals("turn") && s2T == 1|| cmd0.equals("t") && s2T == 1){
                s2b2X--;
                s2b2Y++;
                cmd0 = " ";
                s2T = 0;
                ship2Print();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                //ship3ACMD();
                ship3APrint();
                ship2 = false;
            }
        }
    }   
    public void ship3ACMD(){
         while (ship3A){
            String cmd1 = kb.nextLine();
            cmd1 = cmd1.toLowerCase();
            if(cmd1.equals("right") || cmd1.equals("r")){
                s3Ab1X++;
                s3Ab2X++;
                s3Ab3X++;
                ship3APrint();
            }
            if(cmd1.equals("left") || cmd1.equals("l")){
                s3Ab1X--;
                s3Ab2X--;
                s3Ab3X--;
                ship3APrint();
            }
            if(cmd1.equals("up") || cmd1.equals("u")){
                s3Ab1Y++;
                s3Ab2Y++;
                s3Ab3Y++;
                ship3APrint();
            }
            if(cmd1.equals("down") || cmd1.equals("d")){
                s3Ab1Y--;
                s3Ab2Y--;
                s3Ab3Y--;
                ship3APrint();
            }
            if(cmd1.equals("turn") && s2T == 0|| cmd1.equals("t") && s2T == 0){
                s3Ab2X++;
                s3Ab2Y--;
                cmd1 = " ";
                s2T = 1;
                ship2Print();              
            }
            if(cmd1.equals("turn") && s2T == 1|| cmd1.equals("t") && s2T == 1){
                s3Ab2X--;
                s3Ab2Y++;
                cmd1 = " ";
                s2T = 0;
                ship2Print();
            }
            if(cmd1.equals("lock") || cmd1.equals("l")){
                board[s2b1Y][s2b1X] = shipFinal;
                board[s2b2Y][s2b2X] = shipFinal;
            }
        }
    }   
}