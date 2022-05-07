/**
 * Write a description of class CopyOfTerm2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (06/05/22)
 */

import java.util.Scanner;
public class CopyOfTerm2Project
{
    // instance variables - replace the example below with your own
    private boolean playing = true;
    
    Scanner kb = new Scanner (System.in);
    
    private String o = "🌊 ";
    private String ship = "🕳 ";
    private String ship2Final = "🚤 ";
    private String ship3AFinal = "⛵ ";
    private String ship3BFinal = "🛥 ";
    private String ship4Final = "🚢 ";
    private String ship5Final = "🛳 ";
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
    private int s3AT = 0; //ship# turn
    private boolean ship3A = true;
    
    private int s3Bb1Y = 0;
    private int s3Bb1X = 0;
    private int s3Bb2Y = 1;
    private int s3Bb2X = 0;
    private int s3Bb3Y = 2;
    private int s3Bb3X = 0;
    private int s3BT = 0; //ship# turn
    private boolean ship3B = true;
    
    private int s4b1Y = 0;
    private int s4b1X = 0;
    private int s4b2Y = 1;
    private int s4b2X = 0;
    private int s4b3Y = 2;
    private int s4b3X = 0;
    private int s4b4Y = 3;
    private int s4b4X = 0;
    private int s4T = 0; //ship# turn
    private boolean ship4 = true;
    
    private int s5b1Y = 0;
    private int s5b1X = 0;
    private int s5b2Y = 1;
    private int s5b2X = 0;
    private int s5b3Y = 2;
    private int s5b3X = 0;
    private int s5b4Y = 3;
    private int s5b4X = 0;
    private int s5b5Y = 4;
    private int s5b5X = 0;
    private int s5T = 0; //ship# turn
    private boolean ship5 = true;
    
    /**
     * Constructor for objects of class arrays
     */
    public CopyOfTerm2Project()
    {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
                System.out.print(i + "\u3002");
        } 
        System.out.println();
            for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                board[i][j] = o;
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar + "\u3002");
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
        ship2Print();
        ship2CMD();
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
                ship3APrint();
                ship3ACMD();
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
                s3Ab1Y--;
                s3Ab2Y--;
                s3Ab3Y--;
                ship3APrint();
            }
            if(cmd1.equals("down") || cmd1.equals("d")){
                s3Ab1Y++;
                s3Ab2Y++;
                s3Ab3Y++;
                ship3APrint();
            }
            if(cmd1.equals("turn") && s3AT == 0|| cmd1.equals("t") && s3AT == 0){
                s3Ab2X++;
                s3Ab2Y--;
                
                s3Ab3X += 2;
                s3Ab3Y -= 2;
                
                cmd1 = " ";
                s3AT = 1;
                ship3APrint();              
            }
            if(cmd1.equals("turn") && s3AT == 1|| cmd1.equals("t") && s3AT == 1){
                s3Ab2X--;
                s3Ab2Y++;
                
                s3Ab3X -= 2;
                s3Ab3Y += 2;
                
                cmd1 = " ";
                s3AT = 0;
                ship3APrint();
            }
            if(cmd1.equals("next") || cmd1.equals("n")){
                ship3BPrint();
                ship3BCMD();
                ship3A = false;
            }
        }
    }
    public void ship3BCMD(){
        while (ship3B){
            String cmd2 = kb.nextLine();
            cmd2 = cmd2.toLowerCase();
            if(cmd2.equals("right") || cmd2.equals("r")){
                s3Bb1X++;
                s3Bb2X++;
                s3Bb3X++;
                ship3BPrint();
            }
            if(cmd2.equals("left") || cmd2.equals("l")){
                s3Bb1X--;
                s3Bb2X--;
                s3Bb3X--;
                ship3BPrint();
            }
            if(cmd2.equals("up") || cmd2.equals("u")){
                s3Bb1Y--;
                s3Bb2Y--;
                s3Bb3Y--;
                ship3BPrint();
            }
            if(cmd2.equals("down") || cmd2.equals("d")){
                s3Bb1Y++;
                s3Bb2Y++;
                s3Bb3Y++;
                ship3BPrint();
            }
            if(cmd2.equals("turn") && s3BT == 0|| cmd2.equals("t") && s3BT == 0){
                s3Bb2X++;
                s3Bb2Y--;
                
                s3Bb3X += 2;
                s3Bb3Y -= 2;
                
                cmd2 = " ";
                s3BT = 1;
                ship3BPrint();              
            }
            if(cmd2.equals("turn") && s3BT == 1|| cmd2.equals("t") && s3BT == 1){
                s3Bb2X--; 
                s3Bb2Y++;
                
                s3Bb3X -= 2;
                s3Bb3Y += 2;
                
                cmd2 = " ";
                s3BT = 0;
                ship3BPrint();
            }
            if(cmd2.equals("next") || cmd2.equals("n")){
                ship4Print();
                ship4CMD();
                ship3B = false;
            }
        }
    }
    public void ship4CMD(){
        while (ship4){
            String cmd3 = kb.nextLine();
            cmd3 = cmd3.toLowerCase();
            if(cmd3.equals("right") || cmd3.equals("r")){
                s4b1X++;
                s4b2X++;
                s4b3X++;
                s4b4X++;
                ship4Print();
            }
            if(cmd3.equals("left") || cmd3.equals("l")){
                s4b1X--;
                s4b2X--;
                s4b3X--;
                s4b4X--;
                ship4Print();
            }
            if(cmd3.equals("up") || cmd3.equals("u")){
                s4b1Y--;
                s4b2Y--;
                s4b3Y--;
                s4b4Y--;
                ship4Print();
            }
            if(cmd3.equals("down") || cmd3.equals("d")){
                s4b1Y++;
                s4b2Y++;
                s4b3Y++;
                s4b4Y++;
                ship4Print();
            }
            if(cmd3.equals("turn") && s4T == 0|| cmd3.equals("t") && s4T == 0){
                s4b2X++;
                s4b2Y--;
                
                s4b3X += 2;
                s4b3Y -= 2;
                
                s4b4X += 3;
                s4b4Y -= 3;
                
                cmd3 = " ";
                s4T = 1;
                ship4Print();              
            }
            if(cmd3.equals("turn") && s4T == 1|| cmd3.equals("t") && s4T == 1){
                s4b2X--; 
                s4b2Y++;
                
                s4b3X -= 2;
                s4b3Y += 2;
                
                s4b4X -= 3;
                s4b4Y += 3;
                
                cmd3 = " ";
                s4T = 0;
                ship4Print();
            }
            if(cmd3.equals("next") || cmd3.equals("n")){
                ship5Print();
                ship5CMD();
                ship4 = false;
            }
        }
    }
    public void ship5CMD(){
        while (ship5){
            String cmd4 = kb.nextLine();
            cmd4 = cmd4.toLowerCase();
            if(cmd4.equals("right") || cmd4.equals("r")){
                s5b1X++;
                s5b2X++;
                s5b3X++;
                s5b4X++;
                s5b5X++;
                ship5Print();
            }
            if(cmd4.equals("left") || cmd4.equals("l")){
                s5b1X--;
                s5b2X--;
                s5b3X--;
                s5b4X--;
                s5b5X--;
                ship5Print();
            }
            if(cmd4.equals("up") || cmd4.equals("u")){
                s5b1Y--;
                s5b2Y--;
                s5b3Y--;
                s5b4Y--;
                s5b5Y--;
                ship5Print();
            }
            if(cmd4.equals("down") || cmd4.equals("d")){
                s5b1Y++;
                s5b2Y++;
                s5b3Y++;
                s5b4Y++;
                s5b5Y++;
                ship5Print();
            }
            if(cmd4.equals("turn") && s5T == 0|| cmd4.equals("t") && s5T == 0){
                s5b2X++;
                s5b2Y--;
                
                s5b3X += 2;
                s5b3Y -= 2;
                
                s5b4X += 3;
                s5b4Y -= 3;
                
                s5b5X += 4;
                s5b5Y -= 4;
                
                cmd4 = " ";
                s5T = 1;
                ship5Print();              
            }
            if(cmd4.equals("turn") && s5T == 1|| cmd4.equals("t") && s5T == 1){
                s5b2X--; 
                s5b2Y++;
                
                s5b3X -= 2;
                s5b3Y += 2;
                
                s5b4X -= 3;
                s5b4Y += 3;
                
                s5b5X -= 4;
                s5b5Y += 4;
                
                cmd4 = " ";
                s5T = 0;
                ship5Print();
            }
            if(cmd4.equals("next") || cmd4.equals("n")){
                shipFinishedPrint();
                ship5 = false;
            }
        }
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
                
                board[s2b1Y][s2b1X] = ship2Final;
                board[s2b2Y][s2b2X] = ship2Final;
                
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
    public void ship3BPrint() {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
            System.out.print(i + " ");
        }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                board[i][j] = o;
                
                board[s2b1Y][s2b1X] = ship2Final;
                board[s2b2Y][s2b2X] = ship2Final;
                
                board[s3Ab1Y][s3Ab1X] = ship3AFinal;
                board[s3Ab2Y][s3Ab2X] = ship3AFinal;
                board[s3Ab3Y][s3Ab3X] = ship3AFinal;
                
                board[s3Bb1Y][s3Bb1X] = ship;
                board[s3Bb2Y][s3Bb2X] = ship;
                board[s3Bb3Y][s3Bb3X] = ship;
                
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
    public void ship4Print() {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
            System.out.print(i + " ");
        }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                board[i][j] = o;
                
                board[s2b1Y][s2b1X] = ship2Final;
                board[s2b2Y][s2b2X] = ship2Final;
                
                board[s3Ab1Y][s3Ab1X] = ship3AFinal;
                board[s3Ab2Y][s3Ab2X] = ship3AFinal;
                board[s3Ab3Y][s3Ab3X] = ship3AFinal;
                
                board[s3Bb1Y][s3Bb1X] = ship3BFinal;
                board[s3Bb2Y][s3Bb2X] = ship3BFinal;
                board[s3Bb3Y][s3Bb3X] = ship3BFinal;
                
                board[s4b1Y][s4b1X] = ship;
                board[s4b2Y][s4b2X] = ship;
                board[s4b3Y][s4b3X] = ship;
                board[s4b4Y][s4b4X] = ship;
                
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
    public void ship5Print() {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
            System.out.print(i + " ");
        }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                board[i][j] = o;
                
                board[s2b1Y][s2b1X] = ship2Final;
                board[s2b2Y][s2b2X] = ship2Final;
                
                board[s3Ab1Y][s3Ab1X] = ship3AFinal;
                board[s3Ab2Y][s3Ab2X] = ship3AFinal;
                board[s3Ab3Y][s3Ab3X] = ship3AFinal;
                
                board[s3Bb1Y][s3Bb1X] = ship3BFinal;
                board[s3Bb2Y][s3Bb2X] = ship3BFinal;
                board[s3Bb3Y][s3Bb3X] = ship3BFinal;
                
                board[s4b1Y][s4b1X] = ship4Final;
                board[s4b2Y][s4b2X] = ship4Final;
                board[s4b3Y][s4b3X] = ship4Final;
                board[s4b4Y][s4b4X] = ship4Final;
                
                board[s5b1Y][s5b1X] = ship;
                board[s5b2Y][s5b2X] = ship;
                board[s5b3Y][s5b3X] = ship;
                board[s5b4Y][s5b4X] = ship;
                board[s5b5Y][s5b5X] = ship;
                
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
    public void shipFinishedPrint() {
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
            System.out.print(i + " ");
        }
        System.out.print("🚢");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                board[i][j] = o;
                
                board[s2b1Y][s2b1X] = ship2Final;
                board[s2b2Y][s2b2X] = ship2Final;
                
                board[s3Ab1Y][s3Ab1X] = ship3AFinal;
                board[s3Ab2Y][s3Ab2X] = ship3AFinal;
                board[s3Ab3Y][s3Ab3X] = ship3AFinal;
                
                board[s3Bb1Y][s3Bb1X] = ship3BFinal;
                board[s3Bb2Y][s3Bb2X] = ship3BFinal;
                board[s3Bb3Y][s3Bb3X] = ship3BFinal;
                
                board[s4b1Y][s4b1X] = ship4Final;
                board[s4b2Y][s4b2X] = ship4Final;
                board[s4b3Y][s4b3X] = ship4Final;
                board[s4b4Y][s4b4X] = ship4Final;
                
                board[s5b1Y][s5b1X] = ship5Final;
                board[s5b2Y][s5b2X] = ship5Final;
                board[s5b3Y][s5b3X] = ship5Final;
                board[s5b4Y][s5b4X] = ship5Final;
                board[s5b5Y][s5b5X] = ship5Final;
                
                System.out.print(board[i][j]);
            }
            System.out.print(boardChar);
            boardChar++;
            if (i==9)boardChar = 65;
            System.out.println();
        }
    }
}