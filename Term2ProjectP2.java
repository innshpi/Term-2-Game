/**
 * Write a description of class Term2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (06/05/22)
 */

import java.util.Scanner;
public class Term2ProjectP2
{
    // instance variables - replace the example below with your own
    private boolean startMenu = true;
    
    Scanner kb = new Scanner (System.in);
    
    private String o = "🌊 ";
    private String ship = "🕳 ";
    private String ship2P2Final = "🛥 ";
    private String ship3AP2Final = "⛵ ";
    private String ship3BP2Final = "🚤 ";
    private String ship4P2Final = "🚢 ";
    private String ship5P2Final = "🛳 ";
    private char setupBoardPlayer1Char = 65;
    private char setupBoardPlayer2Char = 65;
    
    private int ROWS = 10;
    private int COLS = 10;
    String setupBoardPlayer1[][] = new String[COLS][ROWS];
    String setupBoardPlayer2[][] = new String[COLS][ROWS];
    
    // player 1 ships
    // ship# | block# | player#
    private int s2b1YP2 = 0;
    private int s2b1XP2 = 0;
    private int s2b2YP2 = 1;
    private int s2b2XP2 = 0;
    private int s2TP2 = 0; //ship# turn direction
    private boolean ship2P2 = false;
    private boolean ship2P2print = false;
    
    private int s3Ab1YP2 = 0;
    private int s3Ab1XP2 = 0;
    private int s3Ab2YP2 = 1;
    private int s3Ab2XP2 = 0;
    private int s3Ab3YP2 = 2;
    private int s3Ab3XP2 = 0;
    private int s3ATP2 = 0; //ship# turn direction
    private boolean ship3AP2 = false;
    private boolean ship3AP2print = false;
    
    private int s3Bb1YP2 = 0;
    private int s3Bb1XP2 = 0;
    private int s3Bb2YP2 = 1;
    private int s3Bb2XP2 = 0;
    private int s3Bb3YP2 = 2;
    private int s3Bb3XP2 = 0;
    private int s3BTP2 = 0; //ship# turn direction
    private boolean ship3BP2 = false;
    private boolean ship3BP2print = false;
    
    private int s4b1YP2 = 0;
    private int s4b1XP2 = 0;
    private int s4b2YP2 = 1;
    private int s4b2XP2 = 0;
    private int s4b3YP2 = 2;
    private int s4b3XP2 = 0;
    private int s4b4YP2 = 3;
    private int s4b4XP2 = 0;
    private int s4TP2 = 0; //ship# turn direction
    private boolean ship4P2 = false;
    private boolean ship4P2print = false;
    
    private int s5b1YP2 = 0;
    private int s5b1XP2 = 0;
    private int s5b2YP2 = 1;
    private int s5b2XP2 = 0;
    private int s5b3YP2 = 2;
    private int s5b3XP2 = 0;
    private int s5b4YP2 = 3;
    private int s5b4XP2 = 0;
    private int s5b5YP2 = 4;
    private int s5b5XP2 = 0;
    private int s5TP2 = 0; //ship# turn direction
    private boolean ship5P2 = false;
    private boolean ship5P2print = false;
    
    // player 1 ships
    
    /**
     * Constructor for objects of class arrays
     */
    public Term2ProjectP2()
    {
        setupBoardPlayer2();
        System.out.println("Welcome to battleship.\nType 's' or 'start' to start the game");
        while(startMenu){
            String cmd = kb.nextLine();
            cmd = cmd.toLowerCase();
            if(cmd.equals("start") || cmd.equals("s")){
                startMenu = false;
                ship2P2 = true;
                setupBoardPlayer2();
                ship2P2CMD();
            }
        }
    }
    public void setupBoardPlayer2(){
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
                System.out.print(i + "\u3002");
        } 
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                setupBoardPlayer2[i][j] = o;
                if(ship2P2){
                    setupBoardPlayer2[s2b1YP2][s2b1XP2] = ship;
                    setupBoardPlayer2[s2b2YP2][s2b2XP2] = ship;
                }
                if(ship2P2print){
                    setupBoardPlayer2[s2b1YP2][s2b1XP2] = ship2P2Final;
                    setupBoardPlayer2[s2b2YP2][s2b2XP2] = ship2P2Final;
                }
                if(ship3AP2){
                    setupBoardPlayer2[s3Ab1YP2][s3Ab1XP2] = ship;
                    setupBoardPlayer2[s3Ab2YP2][s3Ab2XP2] = ship;
                    setupBoardPlayer2[s3Ab3YP2][s3Ab3XP2] = ship;
                }
                if(ship3AP2print){
                    setupBoardPlayer2[s3Ab1YP2][s3Ab1XP2] = ship3AP2Final;
                    setupBoardPlayer2[s3Ab2YP2][s3Ab2XP2] = ship3AP2Final;
                    setupBoardPlayer2[s3Ab3YP2][s3Ab3XP2] = ship3AP2Final;
                }
                if(ship3BP2){
                    setupBoardPlayer2[s3Bb1YP2][s3Bb1XP2] = ship;
                    setupBoardPlayer2[s3Bb2YP2][s3Bb2XP2] = ship;
                    setupBoardPlayer2[s3Bb3YP2][s3Bb3XP2] = ship;
                }
                if(ship3BP2print){
                    setupBoardPlayer2[s3Bb1YP2][s3Bb1XP2] = ship3BP2Final;
                    setupBoardPlayer2[s3Bb2YP2][s3Bb2XP2] = ship3BP2Final;
                    setupBoardPlayer2[s3Bb3YP2][s3Bb3XP2] = ship3BP2Final;
                }
                if(ship4P2){    
                    setupBoardPlayer2[s4b1YP2][s4b1XP2] = ship;
                    setupBoardPlayer2[s4b2YP2][s4b2XP2] = ship;
                    setupBoardPlayer2[s4b3YP2][s4b3XP2] = ship;
                    setupBoardPlayer2[s4b4YP2][s4b4XP2] = ship;
                }
                if(ship4P2print){
                    setupBoardPlayer2[s4b1YP2][s4b1XP2] = ship4P2Final;
                    setupBoardPlayer2[s4b2YP2][s4b2XP2] = ship4P2Final;
                    setupBoardPlayer2[s4b3YP2][s4b3XP2] = ship4P2Final;
                    setupBoardPlayer2[s4b4YP2][s4b4XP2] = ship4P2Final;
                }
                if(ship5P2){     
                    setupBoardPlayer2[s5b1YP2][s5b1XP2] = ship;
                    setupBoardPlayer2[s5b2YP2][s5b2XP2] = ship;
                    setupBoardPlayer2[s5b3YP2][s5b3XP2] = ship;
                    setupBoardPlayer2[s5b4YP2][s5b4XP2] = ship;
                    setupBoardPlayer2[s5b5YP2][s5b5XP2] = ship;
                }
                if(ship5P2print){
                    setupBoardPlayer2[s5b1YP2][s5b1XP2] = ship5P2Final;
                    setupBoardPlayer2[s5b2YP2][s5b2XP2] = ship5P2Final;
                    setupBoardPlayer2[s5b3YP2][s5b3XP2] = ship5P2Final;
                    setupBoardPlayer2[s5b4YP2][s5b4XP2] = ship5P2Final;
                    setupBoardPlayer2[s5b5YP2][s5b5XP2] = ship5P2Final;
                }
                System.out.print(setupBoardPlayer2[i][j]);
            }
            System.out.print(setupBoardPlayer2Char + "\u3002");
            setupBoardPlayer2Char++;
            if (i==9)setupBoardPlayer2Char = 65;
            System.out.println();
        }
    }
    public void ship2P2CMD(){
        while (ship2P2){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("right") || cmd0.equals("r")){
                s2b1XP2++;
                s2b2XP2++;
                setupBoardPlayer2();
            }
            if(cmd0.equals("left") || cmd0.equals("l")){
                s2b1XP2--;
                s2b2XP2--;
                setupBoardPlayer2();
            }
            if(cmd0.equals("up") || cmd0.equals("u")){
                s2b1YP2--;
                s2b2YP2--;
                setupBoardPlayer2();
            }
            if(cmd0.equals("down") || cmd0.equals("d")){
                s2b1YP2++;
                s2b2YP2++;
                setupBoardPlayer2();
            }
            if(cmd0.equals("turn") && s2TP2 == 0|| cmd0.equals("t") && s2TP2 == 0){
                s2b2XP2++;
                s2b2YP2--;
                cmd0 = " ";
                s2TP2 = 1;
                setupBoardPlayer2();              
            }
            if(cmd0.equals("turn") && s2TP2 == 1|| cmd0.equals("t") && s2TP2 == 1){
                s2b2XP2--;
                s2b2YP2++;
                cmd0 = " ";
                s2TP2 = 0;
                setupBoardPlayer2();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                ship2P2 = false;
                ship2P2print = true;
                ship3AP2 = true;
                setupBoardPlayer2();
                ship3AP2CMD();
            }
        }
    }   
    public void ship3AP2CMD(){
        while (ship3AP2){
            String cmd1 = kb.nextLine();
            cmd1 = cmd1.toLowerCase();
            if(cmd1.equals("right") || cmd1.equals("r")){
                s3Ab1XP2++;
                s3Ab2XP2++;
                s3Ab3XP2++;
                setupBoardPlayer2();
            }
            if(cmd1.equals("left") || cmd1.equals("l")){
                s3Ab1XP2--;
                s3Ab2XP2--;
                s3Ab3XP2--;
                setupBoardPlayer2();
            }
            if(cmd1.equals("up") || cmd1.equals("u")){
                s3Ab1YP2--;
                s3Ab2YP2--;
                s3Ab3YP2--;
                setupBoardPlayer2();
            }
            if(cmd1.equals("down") || cmd1.equals("d")){
                s3Ab1YP2++;
                s3Ab2YP2++;
                s3Ab3YP2++;
                setupBoardPlayer2();
            }
            if(cmd1.equals("turn") && s3ATP2 == 0|| cmd1.equals("t") && s3ATP2 == 0){
                s3Ab2XP2++;
                s3Ab2YP2--;
                
                s3Ab3XP2 += 2;
                s3Ab3YP2 -= 2;
                
                cmd1 = " ";
                s3ATP2 = 1;
                setupBoardPlayer2();              
            }
            if(cmd1.equals("turn") && s3ATP2 == 1|| cmd1.equals("t") && s3ATP2 == 1){
                s3Ab2XP2--;
                s3Ab2YP2++;
                
                s3Ab3XP2 -= 2;
                s3Ab3YP2 += 2;
                
                cmd1 = " ";
                s3ATP2 = 0;
                setupBoardPlayer2();
            }
            if(cmd1.equals("next") || cmd1.equals("n")){
                ship3AP2 = false;
                ship3AP2print = true;
                ship3BP2 = true;
                setupBoardPlayer2();
                ship3BP2CMD();
            }
        }
    }
    public void ship3BP2CMD(){
        while (ship3BP2){
            String cmd2 = kb.nextLine();
            cmd2 = cmd2.toLowerCase();
            if(cmd2.equals("right") || cmd2.equals("r")){
                s3Bb1XP2++;
                s3Bb2XP2++;
                s3Bb3XP2++;
                setupBoardPlayer2();
            }
            if(cmd2.equals("left") || cmd2.equals("l")){
                s3Bb1XP2--;
                s3Bb2XP2--;
                s3Bb3XP2--;
                setupBoardPlayer2();
            }
            if(cmd2.equals("up") || cmd2.equals("u")){
                s3Bb1YP2--;
                s3Bb2YP2--;
                s3Bb3YP2--;
                setupBoardPlayer2();
            }
            if(cmd2.equals("down") || cmd2.equals("d")){
                s3Bb1YP2++;
                s3Bb2YP2++;
                s3Bb3YP2++;
                setupBoardPlayer2();
            }
            if(cmd2.equals("turn") && s3BTP2 == 0|| cmd2.equals("t") && s3BTP2 == 0){
                s3Bb2XP2++;
                s3Bb2YP2--;
                
                s3Bb3XP2 += 2;
                s3Bb3YP2 -= 2;
                
                cmd2 = " ";
                s3BTP2 = 1;
                setupBoardPlayer2();              
            }
            if(cmd2.equals("turn") && s3BTP2 == 1|| cmd2.equals("t") && s3BTP2 == 1){
                s3Bb2XP2--; 
                s3Bb2YP2++;
                
                s3Bb3XP2 -= 2;
                s3Bb3YP2 += 2;
                
                cmd2 = " ";
                s3BTP2 = 0;
                setupBoardPlayer2();
            }
            if(cmd2.equals("next") || cmd2.equals("n")){
                ship3BP2 = false;
                ship3BP2print = true;
                ship4P2 = true;
                setupBoardPlayer2();
                ship4P2CMD();
            }
        }
    }
    public void ship4P2CMD(){
        while (ship4P2){
            String cmd3 = kb.nextLine();
            cmd3 = cmd3.toLowerCase();
            if(cmd3.equals("right") || cmd3.equals("r")){
                s4b1XP2++;
                s4b2XP2++;
                s4b3XP2++;
                s4b4XP2++;
                setupBoardPlayer2();
            }
            if(cmd3.equals("left") || cmd3.equals("l")){
                s4b1XP2--;
                s4b2XP2--;
                s4b3XP2--;
                s4b4XP2--;
                setupBoardPlayer2();
            }
            if(cmd3.equals("up") || cmd3.equals("u")){
                s4b1YP2--;
                s4b2YP2--;
                s4b3YP2--;
                s4b4YP2--;
                setupBoardPlayer2();
            }
            if(cmd3.equals("down") || cmd3.equals("d")){
                s4b1YP2++;
                s4b2YP2++;
                s4b3YP2++;
                s4b4YP2++;
                setupBoardPlayer2();
            }
            if(cmd3.equals("turn") && s4TP2 == 0|| cmd3.equals("t") && s4TP2 == 0){
                s4b2XP2++;
                s4b2YP2--;
                
                s4b3XP2 += 2;
                s4b3YP2 -= 2;
                
                s4b4XP2 += 3;
                s4b4YP2 -= 3;
                
                cmd3 = " ";
                s4TP2 = 1;
                setupBoardPlayer2();              
            }
            if(cmd3.equals("turn") && s4TP2 == 1|| cmd3.equals("t") && s4TP2 == 1){
                s4b2XP2--; 
                s4b2YP2++;
                
                s4b3XP2 -= 2;
                s4b3YP2 += 2;
                
                s4b4XP2 -= 3;
                s4b4YP2 += 3;
                
                cmd3 = " ";
                s4TP2 = 0;
                setupBoardPlayer2();
            }
            if(cmd3.equals("next") || cmd3.equals("n")){
                ship4P2 = false;
                ship4P2print = true;
                ship5P2 = true;
                setupBoardPlayer2();
                ship5P2CMD();
            }
        }
    }
    public void ship5P2CMD(){
        while (ship5P2){
            String cmd4 = kb.nextLine();
            cmd4 = cmd4.toLowerCase();
            if(cmd4.equals("right") || cmd4.equals("r")){
                s5b1XP2++;
                s5b2XP2++;
                s5b3XP2++;
                s5b4XP2++;
                s5b5XP2++;
                setupBoardPlayer2();
            }
            if(cmd4.equals("left") || cmd4.equals("l")){
                s5b1XP2--;
                s5b2XP2--;
                s5b3XP2--;
                s5b4XP2--;
                s5b5XP2--;
                setupBoardPlayer2();
            }
            if(cmd4.equals("up") || cmd4.equals("u")){
                s5b1YP2--;
                s5b2YP2--;
                s5b3YP2--;
                s5b4YP2--;
                s5b5YP2--;
                setupBoardPlayer2();
            }
            if(cmd4.equals("down") || cmd4.equals("d")){
                s5b1YP2++;
                s5b2YP2++;
                s5b3YP2++;
                s5b4YP2++;
                s5b5YP2++;
                setupBoardPlayer2();
            }
            if(cmd4.equals("turn") && s5TP2 == 0|| cmd4.equals("t") && s5TP2 == 0){
                s5b2XP2++;
                s5b2YP2--;
                
                s5b3XP2 += 2;
                s5b3YP2 -= 2;
                
                s5b4XP2 += 3;
                s5b4YP2 -= 3;
                
                s5b5XP2 += 4;
                s5b5YP2 -= 4;
                
                cmd4 = " ";
                s5TP2 = 1;
                setupBoardPlayer2();              
            }
            if(cmd4.equals("turn") && s5TP2 == 1|| cmd4.equals("t") && s5TP2 == 1){
                s5b2XP2--; 
                s5b2YP2++;
                
                s5b3XP2 -= 2;
                s5b3YP2 += 2;
                
                s5b4XP2 -= 3;
                s5b4YP2 += 3;
                
                s5b5XP2 -= 4;
                s5b5YP2 += 4;
                
                cmd4 = " ";
                s5TP2 = 0;
                setupBoardPlayer2();
            }
            if(cmd4.equals("next") || cmd4.equals("n")){
                ship5P2 = false;
                ship5P2print = true;
                setupBoardPlayer2();
            }
        }
    }
    public boolean canTurnRight(boolean canR){
        return canR;
    }
}