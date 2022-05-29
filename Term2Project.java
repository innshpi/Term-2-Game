/**
 * Write a description of class Term2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (19/05/22)
 */

//win condition if ship hit counter -1 if counter = 0 game win for other player
import java.util.Scanner;
public class Term2Project
{
    Scanner kb = new Scanner (System.in);//Initiates new scanner
    
    boolean shipMove = false;//Allows ships to move
    boolean shipShoot = false;//Allows ships to move
    boolean player1PlayingSetup = false;//sets up the player 1 playing board by placing waves where they need to be
    boolean player2PlayingSetup = false;//sets up the player 2 playing board by placing waves where they need to be
    boolean player1Placing = false;//Player 1 can place ships
    boolean player2Placing = false;//Player 2 can place ships
    boolean player1Playing = false;//Player 1 can shoot ships
    boolean player2Playing = false;//Player 2 can shoot ships
    
    private int ROWS = 10;//Sets how wide the grid is
    private int COLS = 10;//Sets how tall the grid is
    String placingBoardPlayer1[][] = new String[COLS][ROWS];
    String placingBoardPlayer2[][] = new String[COLS][ROWS];
    String playingBoardPlayer1[][] = new String[COLS][ROWS];
    String playingBoardPlayer2[][] = new String[COLS][ROWS];
    
    String[] shipChar = {"🛥 ","⛵ ","🚤 ","🚢 ","🛳 ","🌊 ","🕳 ","🔥 ","❌ "};//All Special char's used
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
    boolean canPlace = false;//Tells the ship if it can be placed
    
    int winConditionP1 = 17;//Tells the game when player 1 has won
    int winConditionP2 = 17;//Tells the game when player 1 has won
    /**
     * Constructor for objects of class Term2Project
     */
    public Term2Project()//The main part of the game
    {
        // initialise instance variables
        System.out.print("Welcome to ship-battle!\nType s or start to play");
        String cmd0 = kb.nextLine();
        cmd0 = cmd0.toLowerCase();
        if(cmd0.equals("s") || cmd0.equals("start")){
            player1Placing = true;//Check if player 1 can place ships
            shipMove = true;//Allows ships to move
            canPlace = true;//Tells the ship if it can be placed
            placingBoardPlayer1();//Starts printing the board
            shipCtrl();//Starts moving the ships
            shipCollision();
        }
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
        System.out.println(ship1P1FinalX[4]);
        System.out.println("Type r,l,u,d or right,left,up,down\nto move a ship and press n to place a ship");
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
        System.out.println();
        System.out.println("Type r,l,u,d or right,left,up,down\nto move a ship and press n to place a ship");
    }
    
    //playingBoardPlayer1 is used to keep track of what ships have been shot by player 1
    public void playingBoardPlayer1(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 1 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                if (player1PlayingSetup == true)playingBoardPlayer1[i][j] = shipChar[5];   //places wave emoji onto the board
                System.out.print(playingBoardPlayer1[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';   //reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 1 PLAYING");//Tells the players who is playing
    }
    
    public void playingBoardPlayer2(){
        System.out.print('\u000C');//clears the screen
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");//prints out the numbers above the board
        System.out.println();
        //player 2 board for loop, prints out the board
        for(int i=0;i<COLS;i++){//prints board cols
            for(int j=0;j<ROWS;j++){//prints board rows
                if (player2PlayingSetup == true)playingBoardPlayer2[i][j] = shipChar[5];//places wave emoji onto the board
                System.out.print(playingBoardPlayer2[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';//reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 2 PLAYING");//Tells the players who is playing
    }
    
    //shipCtrl is used to move all ships on the grid
    public void shipCtrl(){
        while (shipMove){
            shipCollision();
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){
                shipCollision();
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]++;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){
                shipCollision();
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]--;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){
                shipCollision();
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]--;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){
                shipCollision();
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]++;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){
                shipCollision();
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]+=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]-=i;
                cmd0 = " ";
                shipTurn = 1;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true || cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){
                shipCollision();
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]-=i;
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]+=i;
                cmd0 = " ";
                shipTurn = 0;
                if(player1Placing)placingBoardPlayer1();
                if(player2Placing)placingBoardPlayer2();
            }
            if(cmd0.equals("next") && canPlace == true || cmd0.equals("n") && canPlace == true){
                setFinalShipPos();
            }else if(cmd0.equals("next") && canPlace == false|| cmd0.equals("n") && canPlace == false)System.out.println("Cannot place here");
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
            shipCollision();
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
            shipCollision();
            if(shipLengthPrint==5){
                turnEnd();
            }
        }
    }
    
    //This tells the game what to do when the turn is ended for both players
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
                
                player2PlayingSetup = true;
                playingBoardPlayer2();
                player2PlayingSetup = false;
                
                player1PlayingSetup = true;
                playingBoardPlayer1();
                player1PlayingSetup = false;
                
                player1Playing = true;//Check if player 1 can shoot ships
                shipShoot = true;//Check if the player can shoot ships
                shipWeapon();//Start the ship shooting phase of the game
            }
            if(cmd0.equals("n") && player1Placing){
                shipLengthAdd = 0;
                shipLengthPrint = 0;
                placingBoardPlayer1();shipCollision();
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
        //for(int i=0;i<5;i++){
            if (shipPosX[0] == ship1P1FinalX[0] || shipPosY[0] == ship1P1FinalX[0]){
                canPlace = false;
                //break;
            }else canPlace = true;
        //}
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
    
    //shipShoot is used copy the temporary ship positions to the final board configuration
    public void shipWeapon(){
        while(shipShoot){
            if(winConditionP1 == 0 || winConditionP2 == 0)winGame();
            System.out.println("Type coordinates to shoot");
            System.out.println("First type a number to choose\nthe row (X) you will shoot\n\nThen type a letter to choose\nthe column (Y) you will shoot\ne.g. 1A");
            System.out.println();
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if (cmd0.length() == 2 && cmd0.charAt(0) >= '0' && cmd0.charAt(0) <= '9' && cmd0.charAt(1) >= 'a' && cmd0.charAt(1) <= 'j'){
                char shootChar = 'a';
                
                shootX = cmd0.charAt(0);
                shootX -= '0';
                
                shootChar = cmd0.charAt(1);
                shootY = cmd0.charAt(1);
                shootY -= 'a';
                
                if(player1Playing)player1Shoot();
                if(player2Playing)player2Shoot();
            }else{
                System.out.println('\u000C');
                playingBoardPlayer1();
                System.out.println("This is not a valid command");
            }
        }
    }
    
    public void player1Shoot(){
        System.out.println('\u000C');
        playingBoardPlayer1();
        if (placingBoardPlayer2[shootY][shootX] == shipChar[0]
         || placingBoardPlayer2[shootY][shootX] == shipChar[1]
         || placingBoardPlayer2[shootY][shootX] == shipChar[2]
         || placingBoardPlayer2[shootY][shootX] == shipChar[3]
         || placingBoardPlayer2[shootY][shootX] == shipChar[4]){
            System.out.println('\u000C');
            playingBoardPlayer1[shootY][shootX] = shipChar[7];
            playingBoardPlayer1();
            System.out.println();
            System.out.println("Type n or next to start player 2's turn");
            String cmd1 = kb.nextLine();
            cmd1 = cmd1.toLowerCase();
            if(cmd1.equals("n") || cmd1.equals("next")){
                player1Playing = false;//Check if player 1 can shoot ships
                player2Playing = true;//Check if player 2 can shoot ships
                System.out.println('\u000C');
                playingBoardPlayer2();
                shipWeapon();
                winConditionP1--;
            }
        }else if(placingBoardPlayer2[shootY][shootX] == shipChar[5]){
            System.out.println('\u000C');
            playingBoardPlayer1[shootY][shootX] = shipChar[8];
            playingBoardPlayer1();
            System.out.println();
            System.out.println("Type n or next to start player 2's turn");
            String cmd2 = kb.nextLine();
            cmd2 = cmd2.toLowerCase();
            if(cmd2.equals("n") || cmd2.equals("next")){
                player1Playing = false;//Check if player 1 can shoot ships
                player2Playing = true;//Check if player 2 can shoot ships
                System.out.println('\u000C');
                playingBoardPlayer2();
                shipWeapon();
            }
        }else{
            System.out.println('\u000C');
            playingBoardPlayer1();
            System.out.println("You cannot shoot here");
        }
    }
    
    public void player2Shoot(){
        System.out.println('\u000C');
        playingBoardPlayer2();
        if (placingBoardPlayer1[shootY][shootX] == shipChar[0]
         || placingBoardPlayer1[shootY][shootX] == shipChar[1]
         || placingBoardPlayer1[shootY][shootX] == shipChar[2]
         || placingBoardPlayer1[shootY][shootX] == shipChar[3]
         || placingBoardPlayer1[shootY][shootX] == shipChar[4]){
            System.out.println('\u000C');
            playingBoardPlayer2[shootY][shootX] = shipChar[7];
            playingBoardPlayer2();
            System.out.println();
            System.out.println("Type n or next to start player 1's turn");
            String cmd1 = kb.nextLine();
            cmd1 = cmd1.toLowerCase();
            if(cmd1.equals("n") || cmd1.equals("next")){
                player2Playing = false;//Check if player 2 can shoot ships
                player1Playing = true;//Check if player 1 can shoot ships
                System.out.println('\u000C');
                playingBoardPlayer1();
                shipWeapon();
                winConditionP2--;
            }
        }else if(placingBoardPlayer1[shootY][shootX] == shipChar[5]){
            System.out.println('\u000C');
            playingBoardPlayer2[shootY][shootX] = shipChar[8];
            playingBoardPlayer2();
            System.out.println();
            System.out.println("Type n or next to start player 1's turn");
            String cmd2 = kb.nextLine();
            cmd2 = cmd2.toLowerCase();
            if(cmd2.equals("n") || cmd2.equals("next")){
                player2Playing = false;//Check if player 2 can shoot ships
                player1Playing = true;//Check if player 1 can shoot ships
                System.out.println('\u000C');
                playingBoardPlayer1();
                shipWeapon();
            }
        }else{
            System.out.println('\u000C');
            playingBoardPlayer2();
            System.out.println("You cannot shoot here");
        }
    }
    
    public void winGame(){
        int i = 0;
        if(winConditionP1 == 0)i = 1;
        if(winConditionP2 == 0)i = 2;
        System.out.println("Player " + i + " has won the game\n");
        System.out.println("Type r or restart to play again");
        String cmd0 = kb.nextLine();
        cmd0 = cmd0.toLowerCase();
        if(cmd0.equals("r") || cmd0.equals("restart")){
            placingBoardPlayer1();//Check if player 1 can place ships
            shipCtrl();//Starts moving the ships
            shipMove = true;//Allows ships to move
            shipShoot = false;//Allows ships to move
            player1PlayingSetup = false;//sets up the player 1 playing board by placing waves where they need to be
            player2PlayingSetup = false;//sets up the player 2 playing board by placing waves where they need to be
            player1Placing = true;//Player 1 can place ships
            player2Placing = false;//Player 2 can place ships
            player1Playing = false;//Player 1 can shoot ships
            player2Playing = false;//Player 2 can shoot ships
            for(int j=0;j<5;j++)shipPosX[i] = 0;
            for(int j=0;j<5;j++)shipPosY[i] = i;
            shootX = 0;
            shootY = 0;
            shipLengthAdd = 0;//This is used as an index into the ship length array
            shipLengthPrint = 0;//This is used to check what ships can be printed onto the board
            shipTurn = 0;//Tells the ship what direction it can turn
            canPlace = true;//Tells the ship if it can be placed
            winConditionP1 = 17;//Tells the game when player 1 has won
            winConditionP2 = 17;//Tells the game when player 1 has won
        }
    }
}