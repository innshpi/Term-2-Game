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
    boolean shipShoot = false;//Allows ships to move
    boolean player1Placing = false;//Player 1 can place ships
    boolean player2Placing = false;//Player 2 can place ships
    boolean player1Playing = false;//Player 1 can place ships
    boolean player2Playing = false;//Player 2 can place ships
    
    private int ROWS = 10;//Sets how wide the grid is
    private int COLS = 10;//Sets how tall the grid is
    String placingBoardPlayer1[][] = new String[COLS][ROWS];
    String placingBoardPlayer2[][] = new String[COLS][ROWS];
    String playingBoardPlayer1[][] = new String[COLS][ROWS];
    String playingBoardPlayer2[][] = new String[COLS][ROWS];
    
    String[] shipChar = {"🛥 ","⛵ ","🚤 ","🚢 ","🛳 ","🌊 ","🕳 ","🔥 "};//All Special char's used
    private char setupBoardChar = 'A';//Sets the char to the letter A
    
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
    
    //Gunshot final pos on the board
    int shootX = 0;
    int shootY = 0;
    
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
        player1Placing = true;//Check if player 1 can place ships
        shipMove = true;//Allows ships to move
        placingBoardPlayer1();//starts printing the board
        shipCtrl();//starts moving the ships
    }
    
    //placingBoardPlayer1 is used to make the board where player 1's ships are placed
    public void placingBoardPlayer1(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 1 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                placingBoardPlayer1[i][j] = shipChar[5];//places wave emoji onto the board
                if(shipLengthPrint>=1)for(int k=0;k<shipLengthArray[0];k++)placingBoardPlayer1[ship1P1FinalY[k]][ship1P1FinalX[k]] = shipChar[0];
                if(shipLengthPrint>=2)for(int k=0;k<shipLengthArray[1];k++)placingBoardPlayer1[ship2P1FinalY[k]][ship2P1FinalX[k]] = shipChar[1];
                if(shipLengthPrint>=3)for(int k=0;k<shipLengthArray[2];k++)placingBoardPlayer1[ship3P1FinalY[k]][ship3P1FinalX[k]] = shipChar[2];
                if(shipLengthPrint>=4)for(int k=0;k<shipLengthArray[3];k++)placingBoardPlayer1[ship4P1FinalY[k]][ship4P1FinalX[k]] = shipChar[3];
                if(shipLengthPrint>=5)for(int k=0;k<shipLengthArray[4];k++)placingBoardPlayer1[ship5P1FinalY[k]][ship5P1FinalX[k]] = shipChar[4];
                //indicates where a ship will be placed
                if(shipLengthPrint<=4 && shipLengthPrint > -1)for(int l=0;l<shipLengthArray[shipLengthAdd];l++)placingBoardPlayer1[shipPosY[l]][shipPosX[l]] = shipChar[6];
                System.out.print(placingBoardPlayer1[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';//reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 1 PLACING");//Tells the players who is placing
    }
    
    //placingBoardPlayer2 is used to make the board where player 2's ships are placed
    public void placingBoardPlayer2(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 2 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                placingBoardPlayer2[i][j] = shipChar[5];//places wave emoji onto the board
                if(shipLengthPrint>=1)for(int k=0;k<shipLengthArray[0];k++)placingBoardPlayer2[ship1P2FinalY[k]][ship1P2FinalX[k]] = shipChar[0];
                if(shipLengthPrint>=2)for(int k=0;k<shipLengthArray[1];k++)placingBoardPlayer2[ship2P2FinalY[k]][ship2P2FinalX[k]] = shipChar[1];
                if(shipLengthPrint>=3)for(int k=0;k<shipLengthArray[2];k++)placingBoardPlayer2[ship3P2FinalY[k]][ship3P2FinalX[k]] = shipChar[2];
                if(shipLengthPrint>=4)for(int k=0;k<shipLengthArray[3];k++)placingBoardPlayer2[ship4P2FinalY[k]][ship4P2FinalX[k]] = shipChar[3];
                if(shipLengthPrint>=5)for(int k=0;k<shipLengthArray[4];k++)placingBoardPlayer2[ship5P2FinalY[k]][ship5P2FinalX[k]] = shipChar[4];
                //indicates where a ship will be placed
                if(shipLengthPrint<=4 && shipLengthPrint > -1)for(int l=0;l<shipLengthArray[shipLengthAdd];l++)placingBoardPlayer2[shipPosY[l]][shipPosX[l]] = shipChar[6];
                System.out.print(placingBoardPlayer2[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';//reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 2 PLACING");//Tells the players who is placing
    }
    
    //playingBoardPlayer1 is used to keep track of what ships have been shot by player 1
    public void playingBoardPlayer1(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 2 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                playingBoardPlayer1[i][j] = shipChar[5];//places wave emoji onto the board
                System.out.print(playingBoardPlayer1[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';//reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 1 PLAYING");//Tells the players who is playing
    }
    
    //shipCtrl is used to move all ships on the grid
    public void shipCtrl(){
        while (shipMove){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            shipCollision();
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]++;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]--;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]--;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]++;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]+=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]-=i;
                cmd0 = " ";
                shipTurn = 1;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true || cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]-=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]+=i;
                cmd0 = " ";
                shipTurn = 0;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                setFinalShipPos();
            }
        }
    } 
    
    //shipShoot is used copy the temporary ship positions to the final board configuration
    public void shipWeapon(){
        while(shipShoot){
            char shootChar = 'a';
            System.out.println("Type coordinates to shoot");
            System.out.println("First type a number to choose the row you will shoot\nThen type a letter to choose the column you will shoot\ne.g. 1A");
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            
            shootChar = cmd0.charAt(1);
            System.out.println(shootChar);
        
            shootX = cmd0.charAt(1);
            shootX -= 'a';
            
            //shootY = cmd0.charAt(0);
            
            System.out.println(shootX);
            //System.out.println(shootY);
        }
    }
    
    //setFinalShipPos is used copy the temporary ship positions to the final board configuration
    public void setFinalShipPos(){
        if (player1Placing==true){
            shipLengthPrint++;
            if(shipLengthAdd<4)shipLengthAdd++;
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
            for(int i=0;i<5;i++)shipPosX[i] = 0;
            for(int i=0;i<5;i++)shipPosY[i] = i;
            shipTurn = 0;
            placingBoardPlayer1();
            if(shipLengthPrint==5){
                turnEnd();
            }
        }else if (player2Placing==true){
            shipLengthPrint++;
            if(shipLengthAdd<4)shipLengthAdd++;
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P2FinalX[i] = shipPosX[i];
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P2FinalY[i] = shipPosY[i];
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P2FinalX[i] = shipPosX[i];
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P2FinalY[i] = shipPosY[i];
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P2FinalX[i] = shipPosX[i];
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P2FinalY[i] = shipPosY[i];
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P2FinalX[i] = shipPosX[i];
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P2FinalY[i] = shipPosY[i];
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P2FinalX[i] = shipPosX[i];
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P2FinalY[i] = shipPosY[i];
            for(int i=0;i<5;i++)shipPosX[i] = 0;
            for(int i=0;i<5;i++)shipPosY[i] = i;
            shipTurn = 0;
            placingBoardPlayer2();
            if(shipLengthPrint==5){
                turnEnd();
            }
        }
    }
    
    public void turnEnd(){
        while(shipLengthPrint==5){
            int i = 0;
            if(player1Placing)i=1;
            if(player2Placing)i=2;
            System.out.println("Is this where you would like to\nplace your ships, PLAYER " + i);
            System.out.println("If YES, type Y and press RETURN");
            System.out.println("If NO, type N and press RETURN");
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("y") && player1Placing){
                shipLengthAdd = 0;
                shipLengthPrint = 0;
                placingBoardPlayer2();
                player1Placing = false;//Check if player 1 can place ships
                player2Placing = true;//Check if player 2 can place ships
            }
            else if(cmd0.equals("y") && player2Placing){
                shipLengthAdd = 0;
                shipLengthPrint = 0;
                player2Placing = false;//Check if player 2 can place ships
                playingBoardPlayer1();
                shipShoot = true;//Check if the player can shoot ships
                shipWeapon();//Start the ship shooting phase of the game
            }
            if(cmd0.equals("n") && player1Placing){
                shipLengthAdd = 0;
                shipLengthPrint = 0;
                placingBoardPlayer1();
            }
            else if(cmd0.equals("n") && player2Placing){
                shipLengthAdd = 0;
                shipLengthPrint = 0;
                placingBoardPlayer2();
            }
        }
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