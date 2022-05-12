/**
 * Write a description of class improvedproject here.
 *
 * @author (Piper Inns Hall)
 * @version (06/05/22)
 */

import java.util.Scanner;
public class improvedproject
{
    // instance variables - replace the example below with your own
    private boolean startMenu = true;
    private boolean playing = false;
    
    Scanner kb = new Scanner (System.in);
    
    private String o = "🌊 ";
    private String ship = "🕳 ";
    
    private String ship2Final = "🛥 ";
    private String ship3AFinal = "⛵ ";
    private String ship3BFinal = "🚤 ";
    private String ship4Final = "🚢 ";
    private String ship5Final = "🛳 ";
    private char setupBoardPlayer1Char = 65;
    private char setupBoardPlayer2Char = 65;
    
    private int ROWS = 10;
    private int COLS = 10;
    String setupBoardPlayer1[][] = new String[COLS][ROWS];
    String setupBoardPlayer2[][] = new String[COLS][ROWS];
    
    // player 1 ships
    // ship# | block# | player#
    int[] shipPos2X = {0, 0};
    int[] shipPos2Y = {0, 1};
    
    int[] shipPos3AX = {0, 0, 0};
    int[] shipPos3AY = {0, 1, 2};
    
    int[] shipPos3BX = {0, 0, 0};
    int[] shipPos3BY = {0, 1, 2};
    
    int[] shipPos4X = {0, 0, 0, 0};
    int[] shipPos4Y = {0, 1, 2, 3};
    
    int[] shipPos5X = {0, 0, 0, 0, 0};
    int[] shipPos5Y = {0, 1, 2, 3, 4};
    
    private int s2TP1 = 0; //ship# turn direction
    private int s3ATP1 = 0; //ship# turn direction
    private int s3BTP1 = 0; //ship# turn direction
    private int s4TP1 = 0; //ship# turn direction
    private int s5TP1 = 0; //ship# turn direction
    private int s2TP2 = 0; //ship# turn direction
    private int s3ATP2 = 0; //ship# turn direction    
    private int s3BTP2 = 0; //ship# turn direction
    private int s4TP2 = 0; //ship# turn direction
    private int s5TP2 = 0; //ship# turn direction
    
    // Tells each ship if it can move or print on the board
    private boolean ship2P1 = false;
    private boolean ship2P1print = false;
    
    private boolean ship3AP1 = false;
    private boolean ship3AP1print = false;
    
    private boolean ship3BP1 = false;
    private boolean ship3BP1print = false;
    
    private boolean ship4P1 = false;
    private boolean ship4P1print = false;
    
    private boolean ship5P1 = false;
    private boolean ship5P1print = false;
    
    private boolean ship2P2 = false;
    private boolean ship2P2print = false;
    
    private boolean ship3AP2 = false;
    private boolean ship3AP2print = false;
    
    private boolean ship3BP2 = false;
    private boolean ship3BP2print = false;
    
    private boolean ship4P2 = false;
    private boolean ship4P2print = false;
    
    private boolean ship5P2 = false;
    private boolean ship5P2print = false;
    
    //checks if a boat can move in a certain direction (player 1)
    private boolean canMoveS2P1L = false;
    private boolean canMoveS2P1R = false;
    private boolean canMoveS2P1U = false;
    private boolean canMoveS2P1D = false;
    private boolean canMoveS2P1T0 = false;
    private boolean canMoveS2P1T1 = false;
    
    private boolean canMoveS3AP1L = false;
    private boolean canMoveS3AP1R = false;
    private boolean canMoveS3AP1U = false;
    private boolean canMoveS3AP1D = false;
    private boolean canMoveS3AP1T0 = false;
    private boolean canMoveS3AP1T1 = false;
    
    private boolean canMoveS3BP1L = false;
    private boolean canMoveS3BP1R = false;
    private boolean canMoveS3BP1U = false;
    private boolean canMoveS3BP1D = false;
    private boolean canMoveS3BP1T0 = false;
    private boolean canMoveS3BP1T1 = false;
    
    private boolean canMoveS4P1L = false;
    private boolean canMoveS4P1R = false;
    private boolean canMoveS4P1U = false;
    private boolean canMoveS4P1D = false;
    private boolean canMoveS4P1T0 = false;
    private boolean canMoveS4P1T1 = false;
    
    private boolean canMoveS5P1L = false;
    private boolean canMoveS5P1R = false;
    private boolean canMoveS5P1U = false;
    private boolean canMoveS5P1D = false;
    private boolean canMoveS5P1T0 = false;
    private boolean canMoveS5P1T1 = false;
    
    //checks if a boat can move in a certain direction (player 2)
    private boolean canMoveS2P2L = false;
    private boolean canMoveS2P2R = false;
    private boolean canMoveS2P2U = false;
    private boolean canMoveS2P2D = false;
    private boolean canMoveS2P2T0 = false;
    private boolean canMoveS2P2T1 = false;
   
    private boolean canMoveS3AP2L = false;
    private boolean canMoveS3AP2R = false;
    private boolean canMoveS3AP2U = false;
    private boolean canMoveS3AP2D = false;
    private boolean canMoveS3AP2T0 = false;
    private boolean canMoveS3AP2T1 = false;
    
    private boolean canMoveS3BP2L = false;
    private boolean canMoveS3BP2R = false;
    private boolean canMoveS3BP2U = false;
    private boolean canMoveS3BP2D = false;
    private boolean canMoveS3BP2T0 = false;
    private boolean canMoveS3BP2T1 = false;
    
    private boolean canMoveS4P2L = false;
    private boolean canMoveS4P2R = false;
    private boolean canMoveS4P2U = false;
    private boolean canMoveS4P2D = false;
    private boolean canMoveS4P2T0 = false;
    private boolean canMoveS4P2T1 = false;
    
    private boolean canMoveS5P2L = false;
    private boolean canMoveS5P2R = false;
    private boolean canMoveS5P2U = false;
    private boolean canMoveS5P2D = false;
    private boolean canMoveS5P2T0 = false;
    private boolean canMoveS5P2T1 = false;
    
    /**
     * Constructor for objects of class arrays
     */
    public improvedproject()
    {
        setupBoardPlayer1();
        System.out.println("Welcome to battleship.\nType 's' or 'start' to start the game");
        while(startMenu){
            String cmd = kb.nextLine();
            cmd = cmd.toLowerCase();
            if(cmd.equals("start") || cmd.equals("s")){
                startMenu = false;
                ship2P1 = true;
                setupBoardPlayer1();
                ship2P1CMD();
                playing = true;
            }
        }
    }
    public void setupBoardPlayer1(){
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++){
                System.out.print(i + "\u3002");
        } 
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                setupBoardPlayer1[i][j] = o;
                if(ship2P1){
                    setupBoardPlayer1[shipPos2Y[0]][shipPos2X[0]] = ship;
                    setupBoardPlayer1[shipPos2Y[1]][shipPos2X[1]] = ship;
                }
                if(ship2P1print){
                    setupBoardPlayer1[shipPos2Y[0]][shipPos2X[0]] = ship2Final;
                    setupBoardPlayer1[shipPos2Y[1]][shipPos2X[1]] = ship2Final;
                }
                if(ship3AP1){
                    setupBoardPlayer1[shipPos3AY[0]][shipPos3AX[0]] = ship;
                    setupBoardPlayer1[shipPos3AY[1]][shipPos3AX[1]] = ship;
                    setupBoardPlayer1[shipPos3AY[2]][shipPos3AX[2]] = ship;
                }
                if(ship3AP1print){
                    setupBoardPlayer1[shipPos3AY[0]][shipPos3AX[0]] = ship3AFinal;
                    setupBoardPlayer1[shipPos3AY[1]][shipPos3AX[1]] = ship3AFinal;
                    setupBoardPlayer1[shipPos3AY[2]][shipPos3AX[2]] = ship3AFinal;
                }
                if(ship3BP1){
                    setupBoardPlayer1[shipPos3BY[0]][shipPos3BX[0]] = ship;
                    setupBoardPlayer1[shipPos3BY[1]][shipPos3BX[1]] = ship;
                    setupBoardPlayer1[shipPos3BY[2]][shipPos3BX[2]] = ship;
                }
                if(ship3BP1print){
                    setupBoardPlayer1[shipPos3BY[0]][shipPos3BX[0]] = ship3BFinal;
                    setupBoardPlayer1[shipPos3BY[1]][shipPos3BX[1]] = ship3BFinal;
                    setupBoardPlayer1[shipPos3BY[2]][shipPos3BX[2]] = ship3BFinal;
                }
                if(ship4P1){    
                    setupBoardPlayer1[shipPos4Y[0]][shipPos4X[0]] = ship;
                    setupBoardPlayer1[shipPos4Y[1]][shipPos4X[1]] = ship;
                    setupBoardPlayer1[shipPos4Y[2]][shipPos4X[2]] = ship;
                    setupBoardPlayer1[shipPos4Y[3]][shipPos4X[3]] = ship;
                }
                if(ship4P1print){
                    setupBoardPlayer1[shipPos4Y[0]][shipPos4X[0]] = ship4Final;
                    setupBoardPlayer1[shipPos4Y[1]][shipPos4X[1]] = ship4Final;
                    setupBoardPlayer1[shipPos4Y[2]][shipPos4X[2]] = ship4Final;
                    setupBoardPlayer1[shipPos4Y[3]][shipPos4X[3]] = ship4Final;
                }
                if(ship5P1){     
                    setupBoardPlayer1[shipPos5Y[0]][shipPos5X[0]] = ship;
                    setupBoardPlayer1[shipPos5Y[1]][shipPos5X[1]] = ship;
                    setupBoardPlayer1[shipPos5Y[2]][shipPos5X[2]] = ship;
                    setupBoardPlayer1[shipPos5Y[3]][shipPos5X[3]] = ship;
                    setupBoardPlayer1[shipPos5Y[4]][shipPos5X[4]] = ship;
                }
                if(ship5P1print){
                    setupBoardPlayer1[shipPos5Y[0]][shipPos5X[0]] = ship5Final;
                    setupBoardPlayer1[shipPos5Y[1]][shipPos5X[1]] = ship5Final;
                    setupBoardPlayer1[shipPos5Y[2]][shipPos5X[2]] = ship5Final;
                    setupBoardPlayer1[shipPos5Y[3]][shipPos5X[3]] = ship5Final;
                    setupBoardPlayer1[shipPos5Y[4]][shipPos5X[4]] = ship5Final;
                }
                System.out.print(setupBoardPlayer1[i][j]);
            }
            System.out.print(setupBoardPlayer1Char + "\u3002");
            setupBoardPlayer1Char++;
            if (i==9)setupBoardPlayer1Char = 65;
            System.out.println();
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
                    setupBoardPlayer2[shipPos2Y[0]][shipPos2X[0]] = ship;
                    setupBoardPlayer2[shipPos2Y[1]][shipPos2X[1]] = ship;
                }
                if(ship2P2print){
                    setupBoardPlayer2[shipPos2Y[0]][shipPos2X[0]] = ship2Final;
                    setupBoardPlayer2[shipPos2Y[1]][shipPos2X[1]] = ship2Final;
                }
                if(ship3AP2){
                    setupBoardPlayer2[shipPos3AY[0]][shipPos3AX[0]] = ship;
                    setupBoardPlayer2[shipPos3AY[1]][shipPos3AX[1]] = ship;
                    setupBoardPlayer2[shipPos3AY[2]][shipPos3AX[2]] = ship;
                }
                if(ship3AP2print){
                    setupBoardPlayer2[shipPos3AY[0]][shipPos3AX[0]] = ship3AFinal;
                    setupBoardPlayer2[shipPos3AY[1]][shipPos3AX[1]] = ship3AFinal;
                    setupBoardPlayer2[shipPos3AY[2]][shipPos3AX[2]] = ship3AFinal;
                }
                if(ship3BP2){
                    setupBoardPlayer2[shipPos3BY[0]][shipPos3BX[0]] = ship;
                    setupBoardPlayer2[shipPos3BY[1]][shipPos3BX[1]] = ship;
                    setupBoardPlayer2[shipPos3BY[2]][shipPos3BX[2]] = ship;
                }
                if(ship3BP2print){
                    setupBoardPlayer2[shipPos3BY[0]][shipPos3BX[0]] = ship3BFinal;
                    setupBoardPlayer2[shipPos3BY[1]][shipPos3BX[1]] = ship3BFinal;
                    setupBoardPlayer2[shipPos3BY[2]][shipPos3BX[2]] = ship3BFinal;
                }
                if(ship4P2){    
                    setupBoardPlayer2[shipPos4Y[0]][shipPos4X[0]] = ship;
                    setupBoardPlayer2[shipPos4Y[1]][shipPos4X[1]] = ship;
                    setupBoardPlayer2[shipPos4Y[2]][shipPos4X[2]] = ship;
                    setupBoardPlayer2[shipPos4Y[3]][shipPos4X[3]] = ship;
                }
                if(ship4P2print){
                    setupBoardPlayer2[shipPos4Y[0]][shipPos4X[0]] = ship4Final;
                    setupBoardPlayer2[shipPos4Y[1]][shipPos4X[1]] = ship4Final;
                    setupBoardPlayer2[shipPos4Y[2]][shipPos4X[2]] = ship4Final;
                    setupBoardPlayer2[shipPos4Y[3]][shipPos4X[3]] = ship4Final;
                }
                if(ship5P2){     
                    setupBoardPlayer2[shipPos5Y[0]][shipPos5X[0]] = ship;
                    setupBoardPlayer2[shipPos5Y[1]][shipPos5X[1]] = ship;
                    setupBoardPlayer2[shipPos5Y[2]][shipPos5X[2]] = ship;
                    setupBoardPlayer2[shipPos5Y[3]][shipPos5X[3]] = ship;
                    setupBoardPlayer2[shipPos5Y[4]][shipPos5X[4]] = ship;
                }
                if(ship5P2print){
                    setupBoardPlayer2[shipPos5Y[0]][shipPos5X[0]] = ship5Final;
                    setupBoardPlayer2[shipPos5Y[1]][shipPos5X[1]] = ship5Final;
                    setupBoardPlayer2[shipPos5Y[2]][shipPos5X[2]] = ship5Final;
                    setupBoardPlayer2[shipPos5Y[3]][shipPos5X[3]] = ship5Final;
                    setupBoardPlayer2[shipPos5Y[4]][shipPos5X[4]] = ship5Final;
                }
                System.out.print(setupBoardPlayer2[i][j]);
            }
            System.out.print(setupBoardPlayer2Char + "\u3002");
            setupBoardPlayer2Char++;
            if (i==9)setupBoardPlayer2Char = 65;
            System.out.println();
        }
    }
    public void ship2P1CMD(){
        while (ship2P1){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            canMoveShips();
            if(cmd0.equals("right") && canMoveS2P1R == true || cmd0.equals("r") && canMoveS2P1R == true){
                shipPos2X[0]++;
                shipPos2X[1]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("left") && canMoveS2P1L == true || cmd0.equals("l") && canMoveS2P1L == true){
                shipPos2X[0]--;
                shipPos2X[1]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("up") && canMoveS2P1U == true || cmd0.equals("u") && canMoveS2P1U == true){
                shipPos2Y[0]--;
                shipPos2Y[1]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("down") && canMoveS2P1D == true || cmd0.equals("d") && canMoveS2P1D == true){
                shipPos2Y[0]++;
                shipPos2Y[1]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("turn") && s2TP1 == 0 && canMoveS2P1T0  == true || cmd0.equals("t") && s2TP1 == 0 && canMoveS2P1T0  == true){
                shipPos2X[1]++;
                shipPos2Y[1]--;
                cmd0 = " ";
                s2TP1 = 1;
                setupBoardPlayer1();              
            }
            if(cmd0.equals("turn") && s2TP1 == 1 && canMoveS2P1T1 == true|| cmd0.equals("t") && s2TP1 == 1 && canMoveS2P1T1 == true){
                shipPos2X[1]--;
                shipPos2Y[1]++;
                cmd0 = " ";
                s2TP1 = 0;
                setupBoardPlayer1();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                ship2P1 = false;
                ship2P1print = true;
                ship3AP1 = true;
                setupBoardPlayer1();
                ship3AP1CMD();
            }
        }
    }   
    public void ship3AP1CMD(){
        while (ship3AP1){
            String cmd1 = kb.nextLine();
            cmd1 = cmd1.toLowerCase();
            canMoveShips();
            if(cmd1.equals("right") && canMoveS3AP1R == true|| cmd1.equals("r") && canMoveS3AP1R == true){
                shipPos3AX[0]++;
                shipPos3AX[1]++;
                shipPos3AX[2]++;
                setupBoardPlayer1();
            }
            if(cmd1.equals("left") && canMoveS3AP1L == true || cmd1.equals("l") && canMoveS3AP1L == true){
                shipPos3AX[0]--;
                shipPos3AX[1]--;
                shipPos3AX[2]--;
                setupBoardPlayer1();
            }
            if(cmd1.equals("up") && canMoveS3AP1U == true || cmd1.equals("u") && canMoveS3AP1U == true){
                shipPos3AY[0]--;
                shipPos3AY[1]--;
                shipPos3AY[2]--;
                setupBoardPlayer1();
            }
            if(cmd1.equals("down") && canMoveS3AP1D == true || cmd1.equals("d") && canMoveS3AP1D == true){
                shipPos3AY[0]++;
                shipPos3AY[1]++;
                shipPos3AY[2]++;
                setupBoardPlayer1();
            }
            if(cmd1.equals("turn") && s3ATP1 == 0  && canMoveS3AP1T0 == true || cmd1.equals("t") && s3ATP1 == 0 && canMoveS3AP1T0 == true){
                shipPos3AX[1]++;
                shipPos3AY[1]--;
                
                shipPos3AX[2] += 2;
                shipPos3AY[2] -= 2;
                
                cmd1 = " ";
                s3ATP1 = 1;
                setupBoardPlayer1();              
            }
            if(cmd1.equals("turn") && s3ATP1 == 1 && canMoveS3AP1T0 == true|| cmd1.equals("t") && s3ATP1 == 1 && canMoveS3AP1T0 == true){
                shipPos3AX[1]--;
                shipPos3AY[1]++;
                
                shipPos3AX[2] -= 2;
                shipPos3AY[2] += 2;
                
                cmd1 = " ";
                s3ATP1 = 0;
                setupBoardPlayer1();
            }
            if(cmd1.equals("next") || cmd1.equals("n")){
                ship3AP1 = false;
                ship3AP1print = true;
                ship3BP1 = true;
                setupBoardPlayer1();
                ship3BP1CMD();
            }
        }
    }
    public void ship3BP1CMD(){
        while (ship3BP1){
            String cmd2 = kb.nextLine();
            cmd2 = cmd2.toLowerCase();
            if(cmd2.equals("right") || cmd2.equals("r")){
                shipPos3BX[0]++;
                shipPos3BX[1]++;
                shipPos3BX[2]++;
                setupBoardPlayer1();
            }
            if(cmd2.equals("left") || cmd2.equals("l")){
                shipPos3BX[0]--;
                shipPos3BX[1]--;
                shipPos3BX[2]--;
                setupBoardPlayer1();
            }
            if(cmd2.equals("up") || cmd2.equals("u")){
                shipPos3BY[0]--;
                shipPos3BY[1]--;
                shipPos3BY[2]--;
                setupBoardPlayer1();
            }
            if(cmd2.equals("down") || cmd2.equals("d")){
                shipPos3BY[0]++;
                shipPos3BY[1]++;
                shipPos3BY[2]++;
                setupBoardPlayer1();
            }
            if(cmd2.equals("turn") && s3BTP1 == 0|| cmd2.equals("t") && s3BTP1 == 0){
                shipPos3BX[1]++;
                shipPos3BY[1]--;
                
                shipPos3BX[2] += 2;
                shipPos3BY[2] -= 2;
                
                cmd2 = " ";
                s3BTP1 = 1;
                setupBoardPlayer1();              
            }
            if(cmd2.equals("turn") && s3BTP1 == 1|| cmd2.equals("t") && s3BTP1 == 1){
                shipPos3BX[1]--; 
                shipPos3BY[1]++;
                
                shipPos3BX[2] -= 2;
                shipPos3BY[2] += 2;
                
                cmd2 = " ";
                s3BTP1 = 0;
                setupBoardPlayer1();
            }
            if(cmd2.equals("next") || cmd2.equals("n")){
                ship3BP1 = false;
                ship3BP1print = true;
                ship4P1 = true;
                setupBoardPlayer1();
                ship4P1CMD();
            }
        }
    }
    public void ship4P1CMD(){
        while (ship4P1){
            String cmd3 = kb.nextLine();
            cmd3 = cmd3.toLowerCase();
            if(cmd3.equals("right") || cmd3.equals("r")){
                s4b1XP1++;
                s4b2XP1++;
                s4b3XP1++;
                s4b4XP1++;
                setupBoardPlayer1();
            }
            if(cmd3.equals("left") || cmd3.equals("l")){
                s4b1XP1--;
                s4b2XP1--;
                s4b3XP1--;
                s4b4XP1--;
                setupBoardPlayer1();
            }
            if(cmd3.equals("up") || cmd3.equals("u")){
                s4b1YP1--;
                s4b2YP1--;
                s4b3YP1--;
                s4b4YP1--;
                setupBoardPlayer1();
            }
            if(cmd3.equals("down") || cmd3.equals("d")){
                s4b1YP1++;
                s4b2YP1++;
                s4b3YP1++;
                s4b4YP1++;
                setupBoardPlayer1();
            }
            if(cmd3.equals("turn") && s4TP1 == 0|| cmd3.equals("t") && s4TP1 == 0){
                s4b2XP1++;
                s4b2YP1--;
                
                s4b3XP1 += 2;
                s4b3YP1 -= 2;
                
                s4b4XP1 += 3;
                s4b4YP1 -= 3;
                
                cmd3 = " ";
                s4TP1 = 1;
                setupBoardPlayer1();              
            }
            if(cmd3.equals("turn") && s4TP1 == 1|| cmd3.equals("t") && s4TP1 == 1){
                s4b2XP1--; 
                s4b2YP1++;
                
                s4b3XP1 -= 2;
                s4b3YP1 += 2;
                
                s4b4XP1 -= 3;
                s4b4YP1 += 3;
                
                cmd3 = " ";
                s4TP1 = 0;
                setupBoardPlayer1();
            }
            if(cmd3.equals("next") || cmd3.equals("n")){
                ship4P1 = false;
                ship4P1print = true;
                ship5P1 = true;
                setupBoardPlayer1();
                ship5P1CMD();
            }
        }
    }
    public void ship5P1CMD(){
        while (ship5P1){
            String cmd4 = kb.nextLine();
            cmd4 = cmd4.toLowerCase();
            if(cmd4.equals("right") || cmd4.equals("r")){
                s5b1XP1++;
                s5b2XP1++;
                s5b3XP1++;
                s5b4XP1++;
                s5b5XP1++;
                setupBoardPlayer1();
            }
            if(cmd4.equals("left") || cmd4.equals("l")){
                s5b1XP1--;
                s5b2XP1--;
                s5b3XP1--;
                s5b4XP1--;
                s5b5XP1--;
                setupBoardPlayer1();
            }
            if(cmd4.equals("up") || cmd4.equals("u")){
                s5b1YP1--;
                s5b2YP1--;
                s5b3YP1--;
                s5b4YP1--;
                s5b5YP1--;
                setupBoardPlayer1();
            }
            if(cmd4.equals("down") || cmd4.equals("d")){
                s5b1YP1++;
                s5b2YP1++;
                s5b3YP1++;
                s5b4YP1++;
                s5b5YP1++;
                setupBoardPlayer1();
            }
            if(cmd4.equals("turn") && s5TP1 == 0|| cmd4.equals("t") && s5TP1 == 0){
                s5b2XP1++;
                s5b2YP1--;
                
                s5b3XP1 += 2;
                s5b3YP1 -= 2;
                
                s5b4XP1 += 3;
                s5b4YP1 -= 3;
                
                s5b5XP1 += 4;
                s5b5YP1 -= 4;
                
                cmd4 = " ";
                s5TP1 = 1;
                setupBoardPlayer1();              
            }
            if(cmd4.equals("turn") && s5TP1 == 1|| cmd4.equals("t") && s5TP1 == 1){
                s5b2XP1--; 
                s5b2YP1++;
                
                s5b3XP1 -= 2;
                s5b3YP1 += 2;
                
                s5b4XP1 -= 3;
                s5b4YP1 += 3;
                
                s5b5XP1 -= 4;
                s5b5YP1 += 4;
                
                cmd4 = " ";
                s5TP1 = 0;
                setupBoardPlayer1();
            }
            if(cmd4.equals("next") || cmd4.equals("n")){
                ship5P1 = false;
                ship5P1print = true;
                ship2P2 = true;
                setupBoardPlayer1();
                //ship2P2CMD();
            }
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
    public void canMoveShips(){
        if (s2b1XP1 - 1 <= -1)canMoveS2P1L = false;
        else canMoveS2P1L = true;
        if (s2b2XP1 + 1 >= 10)canMoveS2P1R = false;
        else canMoveS2P1R = true;
        if (s2b1YP1 - 1 <= -1)canMoveS2P1U = false;
        else canMoveS2P1U = true;
        if (s2b2YP1 + 1 >= 10)canMoveS2P1D = false;
        else canMoveS2P1D = true;
        if (s2b2XP1 + 1 >= 10)canMoveS2P1T0 = false;
        else canMoveS2P1T0 = true;
        if (s2b2YP1 + 1 >= 10)canMoveS2P1T1 = false;
        else canMoveS2P1T1 = true;
        
        if (s3Ab1XP1 - 1 <= -1)canMoveS3AP1L = false;
        else canMoveS3AP1L = true;
        if (s3Ab3XP1 + 1 >= 10)canMoveS3AP1R = false;
        else canMoveS3AP1R = true;
        if (s3Ab1YP1 - 1 <= -1)canMoveS3AP1U = false;
        else canMoveS3AP1U = true;
        if (s3Ab3YP1 + 1 >= 10)canMoveS3AP1D = false;
        else canMoveS3AP1D = true;
        if (s3Ab3XP1 + 2 >= 10)canMoveS3AP1T0 = false;
        else canMoveS3AP1T0 = true;
        if (s3Ab3YP1 + 2 >= 10)canMoveS3AP1T1 = false;
        else canMoveS3AP1T1 = true;
        
        if (s3Bb1XP1 - 1 <= -1)canMoveS3BP1L = false;
        else canMoveS3BP1L = true;
        if (s3Bb3XP1 + 1 >= 10)canMoveS3BP1R = false;
        else canMoveS3BP1R = true;
        if (s3Bb1YP1 - 1 <= -1)canMoveS3BP1U = false;
        else canMoveS3BP1U = true;
        if (s3Bb3YP1 + 1 >= 10)canMoveS3BP1D = false;
        else canMoveS3BP1D = true;
        if (s3Bb3XP1 + 2 >= 10)canMoveS3BP1T0 = false;
        else canMoveS3BP1T0 = true;
        if (s3Bb3YP1 + 2 >= 10)canMoveS3BP1T1 = false;
        else canMoveS3BP1T1 = true;
    }
}