/**
 * Write a description of class Term2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (19/05/22)
 */
import java.util.Scanner;
public class Term2Project
{
    Scanner kb = new Scanner (System.in);//Initiates new scanner
    
    boolean shipMove = false;//Allows ships to move
    boolean player1Placing = true;//Player 1 can place ships
    boolean player2Placing = false;//Player 2 can place ships
    
    private int ROWS = 10;//Sets how wide the grid is
    private int COLS = 10;//Sets how tall the grid is
    String setupBoardPlayer1[][] = new String[COLS][ROWS];
    String setupBoardPlayer2[][] = new String[COLS][ROWS];
    
    String[] shipChar = {"🛥 ","⛵ ","🚤 ","🚢 ","🛳 ","🌊 ","🕳 "};//All Special char's used
    private char setupBoardChar = 65;//Sets the char to the letter A
    
    int[] shipPosX = {0, 0, 0, 0, 0};//Ship movement on the X axis
    int[] shipPosY = {0, 1, 2, 3, 4};//Ship movement on the Y axis
    
    //Ship final pos on the board for player 1
    int[] ship1P1FinalX = new int[5];
    int[] ship2P1FinalX = new int[5];
    int[] ship3P1FinalX = new int[5];
    int[] ship4P1FinalX = new int[5];
    int[] ship5P1FinalX = new int[5];
    
    int[] ship1P1FinalY = new int[5];
    int[] ship2P1FinalY = new int[5];
    int[] ship3P1FinalY = new int[5];
    int[] ship4P1FinalY = new int[5];
    int[] ship5P1FinalY = new int[5];
    
    //Ship final pos on the board for player 2
    int[] ship1P2FinalX = new int[5];
    int[] ship2P2FinalX = new int[5];
    int[] ship3P2FinalX = new int[5];
    int[] ship4P2FinalX = new int[5];
    int[] ship5P2FinalX = new int[5];
    
    int[] ship1P2FinalY = new int[5];
    int[] ship2P2FinalY = new int[5];
    int[] ship3P2FinalY = new int[5];
    int[] ship4P2FinalY = new int[5];
    int[] ship5P2FinalY = new int[5];
    
    int[] shipLengthArray = {2, 3, 3, 4, 5};//this tells the ships how long they can be
    int shipLengthAdd = 0;//This is used as an index into the ship length array
    int shipLengthPrint = 0;//This is used to check what ships can be printed onto the board
    
    int shipTurn = 0;//Tells the ship what direction it can turn
    boolean canMoveL = false;//Tells the ship if it can move left
    boolean canMoveR = false;//Tells the ship if it can move right
    boolean canMoveU = false;//Tells the ship if it can move up
    boolean canMoveD = false;//Tells the ship if it can move down
    boolean canMoveT0 = false;//Tells the ship if it can turn horizontal
    boolean canMoveT1 = false;//Tells the ship if it can turn vertical
    /**
     * Constructor for objects of class Term2Project
     */
    public Term2Project()//The main part of the game
    {
        // initialise instance variables
        shipMove = true;//allows ships to move
        setupBoardPlayer1();//starts printing the board
        shipCtrl();//starts moving the ships
    }
    
    //setupBoardPlayer1 is used to make the board where player 1's ships are placed
    public void setupBoardPlayer1(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 1 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                setupBoardPlayer1[i][j] = shipChar[5];//places wave emoji onto the board
                if (shipLengthPrint>=1)for(int k=0;k<shipLengthArray[0];k++)setupBoardPlayer1[ship1P1FinalY[k]][ship1P1FinalX[k]] = shipChar[0];
                if (shipLengthPrint>=2)for(int k=0;k<shipLengthArray[1];k++)setupBoardPlayer1[ship2P1FinalY[k]][ship2P1FinalX[k]] = shipChar[1];
                if (shipLengthPrint>=3)for(int k=0;k<shipLengthArray[2];k++)setupBoardPlayer1[ship3P1FinalY[k]][ship3P1FinalX[k]] = shipChar[2];
                if (shipLengthPrint>=4)for(int k=0;k<shipLengthArray[3];k++)setupBoardPlayer1[ship4P1FinalY[k]][ship4P1FinalX[k]] = shipChar[3];
                if (shipLengthPrint>=5)for(int k=0;k<shipLengthArray[4];k++)setupBoardPlayer1[ship5P1FinalY[k]][ship5P1FinalX[k]] = shipChar[4];
                //indicates where a ship will be placed
                for(int l=0;l<shipLengthArray[shipLengthAdd];l++)setupBoardPlayer1[shipPosY[l]][shipPosX[l]] = shipChar[6];
                System.out.print(setupBoardPlayer1[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 charachter in the alphabet
            if (i==COLS-1)setupBoardChar = 65;//reset character to A
            System.out.println();
        }
        System.out.println(shipLengthAdd);
    }
    
    //shipCtrl is used to move all ships on the grid
    public void shipCtrl(){
        while (shipMove){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            shipCollision();
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]+=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]-=i;
                cmd0 = " ";
                shipTurn = 1;
                setupBoardPlayer1();              
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true || cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]-=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]+=i;
                cmd0 = " ";
                shipTurn = 0;
                setupBoardPlayer1();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                setFinalShipPos();
            }
        }
    } 
    
    //setFinalShipPos is used copy the temporary ship positions to the final board configuration
    public void setFinalShipPos(){
        shipLengthPrint++;
        
        if (player1Placing){
            if(shipLengthAdd<=3)shipLengthAdd++;
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P1FinalX[i] = shipPosX[i];
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P1FinalY[i] = shipPosY[i];
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P1FinalX[i] = shipPosX[i];
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P1FinalY[i] = shipPosY[i];
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P1FinalX[i] = shipPosX[i];
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P1FinalY[i] = shipPosY[i];
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P1FinalX[i] = shipPosX[i];
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P1FinalY[i] = shipPosY[i];
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P1FinalX[i] = shipPosX[i];
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P1FinalY[i] = shipPosY[i];
            if(shipLengthAdd>=5){
                while(shipLengthAdd>=4){
                    shipLengthPrint = 5;
                    setupBoardPlayer1();
                    System.out.println("Is this where you would like to\nplace your ships, PLAYER 1");
                    System.out.println("If YES, type Y and press RETURN");
                    System.out.println("If NO, type N and press RETURN");
                    String cmd0 = kb.nextLine();
                    cmd0 = cmd0.toLowerCase();
                    if(cmd0.equals("y")){
                        shipLengthAdd = 0;
                        shipLengthPrint = 0;
                    }
                    if(cmd0.equals("n")){
                        shipLengthAdd = 0;
                    }
                }
            }
        }
        for(int i=0;i<5;i++)shipPosX[i] = 0;
        for(int i=0;i<5;i++)shipPosY[i] = i;
        shipTurn = 0;
        if (player1Placing)setupBoardPlayer1();
        //if (player2Placing)setupBoardPlayer2();
    }
    
    //shipCollision is used to check if a ship can be moved in a certain direction
    public void shipCollision(){
        if (shipPosX[0] - 1 <= -1)canMoveL = false;
        else canMoveL = true;
        if (shipPosX[shipLengthArray[shipLengthAdd]-1] + 1 >= 10)canMoveR = false;
        else canMoveR = true;
        if (shipPosY[0] - 1 <= -1)canMoveU = false;
        else canMoveU = true;
        if (shipPosY[shipLengthArray[shipLengthAdd]-1] + 1 >= 10)canMoveD = false;
        else canMoveD = true;
        if (shipPosX[0] + shipLengthArray[shipLengthAdd] -1 >= 10)canMoveT0 = false;
        else canMoveT0 = true;
        if (shipPosY[0] + shipLengthArray[shipLengthAdd] -1 >= 10)canMoveT1 = false;
        else canMoveT1 = true;
    }
}