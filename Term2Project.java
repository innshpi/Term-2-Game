/**
 * Write a description of class printTest here.
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
    int[] ship1P1FinalX = new int[2];
    int[] ship2P1FinalX = new int[3];
    int[] ship3P1FinalX = new int[3];
    int[] ship4P1FinalX = new int[4];
    int[] ship5P1FinalX = new int[5];
    
    int[] ship1P1FinalY = new int[2];
    int[] ship2P1FinalY = new int[3];
    int[] ship3P1FinalY = new int[3];
    int[] ship4P1FinalY = new int[4];
    int[] ship5P1FinalY = new int[5];
    
    //Ship final pos on the board for player 2
    int[] ship1P2FinalX = new int[2];
    int[] ship2P2FinalX = new int[3];
    int[] ship3P2FinalX = new int[3];
    int[] ship4P2FinalX = new int[4];
    int[] ship5P2FinalX = new int[5];
    
    int[] ship1P2FinalY = new int[2];
    int[] ship2P2FinalY = new int[3];
    int[] ship3P2FinalY = new int[3];
    int[] ship4P2FinalY = new int[4];
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
    
    //Tells the game if a ship has been sunk
    int[] shipP1Sink = {0, 0, 0, 0, 0};
    int[] shipP2Sink = {0, 0, 0, 0, 0};
    
    //Tells the game if a ship has been hit
    int s1P1Hit = 2;
    int s2P1Hit = 3;
    int s3P1Hit = 3;
    int s4P1Hit = 4;
    int s5P1Hit = 5;
    
    int s1P2Hit = 2;
    int s2P2Hit = 3;
    int s3P2Hit = 3;
    int s4P2Hit = 4;
    int s5P2Hit = 5;
    
    int winConditionP1 = 17;//Tells the game when player 1 has won
    int winConditionP2 = 17;//Tells the game when player 2 has won
    /**
     * Constructor for objects of class printTest
     */
    public Term2Project()//The main part of the game
    {
        // initialise instance variables
        System.out.print("Welcome to ship-battle!\nType s or start to play");
        boolean menu = true;
        while (menu){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("s") || cmd0.equals("start")){
                menu = false;
                player1Placing = true;//Check if player 1 can place ships
                shipMove = true;//Allows ships to move
                placingBoardPlayer1();//Starts printing the board
                shipCtrl();//Starts moving the ships
            }
        }
    }
    
    //placingBoardPlayer1 is used to make the board where player 1's ships are placed
    public void placingBoardPlayer1(){
        canPlace();
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
                if(shipLengthPrint<=4 && shipLengthPrint >  -1)for(int l=0;l<shipLengthArray[shipLengthAdd];l++)placingBoardPlayer1[shipPosY[l]][shipPosX[l]] = shipChar[6];
                //place player on the board
                System.out.print(placingBoardPlayer1[i][j]);//prints out everything placed on the board
            }
            System.out.print(setupBoardChar + "\u3002");//print character onto the right of the board
            setupBoardChar++;//go forward 1 character in the alphabet
            if (i==COLS-1)setupBoardChar = 'A';//reset character to A
            System.out.println();
        }
        System.out.println("PLAYER 1 PLACING");//Tells the players who is placing
        System.out.println();
        System.out.println("Type r,l,u,d or right,left,up,down\nto move a ship and press n to place a ship");
        System.out.println("PLAYER 2 make sure you look away while PLAYER 1 is placing");
    }
    
    //placingBoardPlayer2 is used to make the board where player 2's ships are placed
    public void placingBoardPlayer2(){
        canPlace();
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
        System.out.println("PLAYER 1 make sure you look away while PLAYER 2 is placing");
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
    
    //playingBoardPlayer1 is used to keep track of what ships have been shot by player 2
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
            shipCollision();//starts checking if the ships are hitting the walls
            String cmd0 = kb.nextLine();//makes new textbox
            cmd0 = cmd0.toLowerCase();//makes textbox lowercase
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){//if cmd = r move right
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]++;//move all pos of ship
                if(player1Placing)placingBoardPlayer1();//if player 1 change player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){//if cmd = l move left
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]--;//move all pos of ship
                if(player1Placing)placingBoardPlayer1();//if player 1 change player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){//if cmd = u move up
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]--;//move all pos of ship
                if(player1Placing)placingBoardPlayer1();//if player 1 change player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){//if cmd = d move down
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=0;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]++;//move all pos of ship
                if(player1Placing)placingBoardPlayer1();//if player 1 chnage player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){//if cmd = t turn
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]+=i;//turn all pos of ship
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]-=i;//turn all pos of ship
                cmd0 = " ";//reset textbox
                shipTurn = 1;//set ship turn state
                if(player1Placing)placingBoardPlayer1();//if player 1 chnage player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true || cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){//if cmd = t turn
                shipCollision();//starts checking if the ships are hitting the walls
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosX[i]-=i;//turn all pos of ship
                for(int i=1;i<shipLengthArray[shipLengthAdd];i++)shipPosY[i]+=i;//turn all pos of ship
                cmd0 = " ";//reset textbox
                shipTurn = 0;//set ship turn state
                if(player1Placing)placingBoardPlayer1();//if player 1 chnage player 1 board
                if(player2Placing)placingBoardPlayer2();//if player 2 change player 2 board
            }
            if(cmd0.equals("next") || cmd0.equals("n")){//place ships
                if (canPlace()){//if the ship is not colliding
                    setFinalShipPos();//place ship
                }
                else if(!canPlace()){//otherwise
                    System.out.println("Cannot place here");//dont place
                }
            }
        }
    } 
    
    //setFinalShipPos is used copy the temporary ship positions to the final board configuration
    public void setFinalShipPos(){
        if (player1Placing==true){//if you are playing as player 1
            shipLengthPrint++;//checks what ship you are placing
            if(shipLengthAdd<4)shipLengthAdd++;//This is used as an index into the ship length array
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P1FinalX[i] = shipPosX[i];//sets ship 1 pos on the final board
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P1FinalY[i] = shipPosY[i];//sets ship 1 pos on the final board
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P1FinalX[i] = shipPosX[i];//sets ship 2 pos on the final board
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P1FinalY[i] = shipPosY[i];//sets ship 2 pos on the final board
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P1FinalX[i] = shipPosX[i];//sets ship 3 pos on the final board
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P1FinalY[i] = shipPosY[i];//sets ship 3 pos on the final board
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P1FinalX[i] = shipPosX[i];//sets ship 4 pos on the final board
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P1FinalY[i] = shipPosY[i];//sets ship 4 pos on the final board
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P1FinalX[i] = shipPosX[i];//sets ship 5 pos on the final board
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P1FinalY[i] = shipPosY[i];//sets ship 5 pos on the final board
            for(int i=0;i<5;i++)shipPosX[i] = 0;//reset ships position on the gameboard 
            for(int i=0;i<5;i++)shipPosY[i] = i;//reset ships position on the gameboard 
            shipTurn = 0;//resets the ship turn state
            placingBoardPlayer1();//prints player 1's board
            if(shipLengthPrint==5){//when the final ship is placed
                turnEnd();//go to next players turn
            }
        }else if (player2Placing==true){//if you are playing as player 2
            shipLengthPrint++;//checks what ship you are placing
            if(shipLengthAdd<4)shipLengthAdd++;//This is used as an index into the ship length array
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P2FinalX[i] = shipPosX[i];//sets ship 1 pos on the final board
            if(shipLengthPrint==1)for(int i=0;i<2;i++)ship1P2FinalY[i] = shipPosY[i];//sets ship 1 pos on the final board
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P2FinalX[i] = shipPosX[i];//sets ship 2 pos on the final board
            if(shipLengthPrint==2)for(int i=0;i<3;i++)ship2P2FinalY[i] = shipPosY[i];//sets ship 2 pos on the final board
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P2FinalX[i] = shipPosX[i];//sets ship 3 pos on the final board
            if(shipLengthPrint==3)for(int i=0;i<3;i++)ship3P2FinalY[i] = shipPosY[i];//sets ship 3 pos on the final board
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P2FinalX[i] = shipPosX[i];//sets ship 4 pos on the final board
            if(shipLengthPrint==4)for(int i=0;i<4;i++)ship4P2FinalY[i] = shipPosY[i];//sets ship 4 pos on the final board
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P2FinalX[i] = shipPosX[i];//sets ship 5 pos on the final board
            if(shipLengthPrint==5)for(int i=0;i<5;i++)ship5P2FinalY[i] = shipPosY[i];//sets ship 5 pos on the final board
            for(int i=0;i<5;i++)shipPosX[i] = 0;//reset ships position on the gameboard 
            for(int i=0;i<5;i++)shipPosY[i] = i;//reset ships position on the gameboard 
            shipTurn = 0;//resets the ship turn state
            placingBoardPlayer2();//prints player 2's board
            if(shipLengthPrint==5){//when the final ship is placed
                turnEnd();//go to next players turn
            }
        }
    }
    
    //This tells the game what to do when the turn is ended for both players
    public void turnEnd(){
        while(shipLengthPrint==5){//check if all ships have been placed
            int i = 0;//playername
            if(player1Placing)i=1;
            if(player2Placing)i=2;
            System.out.println("Is this where you would like to\nplace your ships, PLAYER " + i);
            System.out.println("If YES, type Y and press RETURN");
            System.out.println("If NO, type N and press RETURN");
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if(cmd0.equals("y") && player1Placing){//if you do place your ships
                shipLengthAdd = 0;//reset ship length index plugin
                shipLengthPrint = 0;//reset ship length checker
                placingBoardPlayer2();
                player1Placing = false;//Check if player 1 can place ships
                player2Placing = true;//Check if player 2 can place ships
            }
            else if(cmd0.equals("y") && player2Placing){//if you do place your ships
                shipLengthAdd = 0;//reset ship length index plugin
                shipLengthPrint = 0;//reset ship length checker
                player2Placing = false;//Check if player 2 can place ships
                
                player2PlayingSetup = true;
                playingBoardPlayer2();//setup player 2 playing board
                player2PlayingSetup = false;
                
                player1PlayingSetup = true;
                playingBoardPlayer1();//setup player 1 playing board
                player1PlayingSetup = false;
                
                player1Playing = true;//Check if player 1 can shoot ships
                shipShoot = true;//Check if the player can shoot ships
                shipWeapon();//Start the ship shooting phase of the game
            }
            if(cmd0.equals("n") && player1Placing){//if you don't place your ships
                shipLengthAdd = 0;//reset ship length index plugin
                shipLengthPrint = 0;//reset ship length checker
                placingBoardPlayer1();shipCollision();
            }
            else if(cmd0.equals("n") && player2Placing){//if you don't place your ships
                shipLengthAdd = 0;//reset ship length index plugin
                shipLengthPrint = 0;//reset ship length checker
                placingBoardPlayer2();
            }
        }
    }
    
    //shipCollision is used to check if a ship can be moved in a certain direction
    public void shipCollision(){
        if (shipPosX[0] - 1 <= -1)canMoveL = false;//if hittting l wall
        else canMoveL = true;
        if (shipPosX[shipLengthArray[shipLengthAdd]-1] + 1 >= 10)canMoveR = false;//if hittting r wall
        else canMoveR = true;
        if (shipPosY[0] - 1 <= -1)canMoveU = false;//if hittting uwall
        else canMoveU = true;
        if (shipPosY[shipLengthArray[shipLengthAdd]-1] + 1 >= 10)canMoveD = false;//if hittting d wall
        else canMoveD = true;
        if (shipPosX[0] + shipLengthArray[shipLengthAdd] -1 >= 10)canMoveT0 = false;//if hittting r wall
        else canMoveT0 = true;
        if (shipPosY[0] + shipLengthArray[shipLengthAdd] -1 >= 10)canMoveT1 = false;//if hittting d wall
        else canMoveT1 = true;
    }
    
    //canPlace is used to check if a ship can be placed in a certain position
    public boolean canPlace(){
        boolean canPlace = true;
        for(int i=0;i<shipLengthArray[0];i++){
            if(player1Placing){        
                //player 1 - ship 1 collisions
                if (shipLengthPrint==1)for(int j=0;j<shipLengthArray[1];j++){if(ship1P1FinalX[i]==shipPosX[j] && ship1P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==2)for(int j=0;j<shipLengthArray[2];j++){if(ship1P1FinalX[i]==shipPosX[j] && ship1P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship1P1FinalX[i]==shipPosX[j] && ship1P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship1P1FinalX[i]==shipPosX[j] && ship1P1FinalY[i]==shipPosY[j])canPlace = false;}
            }    
            if(player2Placing){       
                //player 2 - ship 1 collisions
                if (shipLengthPrint==1)for(int j=0;j<shipLengthArray[1];j++){if(ship1P2FinalX[i]==shipPosX[j] && ship1P2FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==2)for(int j=0;j<shipLengthArray[2];j++){if(ship1P2FinalX[i]==shipPosX[j] && ship1P2FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship1P2FinalX[i]==shipPosX[j] && ship1P2FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship1P2FinalX[i]==shipPosX[j] && ship1P2FinalY[i]==shipPosY[j])canPlace = false;}
            }   
        }    
        for(int i=0;i<shipLengthArray[2];i++){
            if(player1Placing){          
                //player 1 - ship 2 collisions
                if (shipLengthPrint==2)for(int j=0;j<shipLengthArray[2];j++){if(ship2P1FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship2P1FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship2P1FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                //player 1 - ship 3 collisions
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship3P1FinalX[i]==shipPosX[j] && ship3P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship3P1FinalX[i]==shipPosX[j] && ship3P1FinalY[i]==shipPosY[j])canPlace = false;}
            }        
            if(player2Placing){      
                //player 2 - ship 2 collisions
                if (shipLengthPrint==2)for(int j=0;j<shipLengthArray[2];j++){if(ship2P2FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship2P2FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship2P2FinalX[i]==shipPosX[j] && ship2P1FinalY[i]==shipPosY[j])canPlace = false;}
                //player 2 - ship 3 collisions
                if (shipLengthPrint==3)for(int j=0;j<shipLengthArray[3];j++){if(ship3P2FinalX[i]==shipPosX[j] && ship3P1FinalY[i]==shipPosY[j])canPlace = false;}
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship3P2FinalX[i]==shipPosX[j] && ship3P1FinalY[i]==shipPosY[j])canPlace = false;}
            }
        }
        for(int i=0;i<shipLengthArray[3];i++){
            if(player1Placing){  
                //player 1 - ship 4 collisions
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship4P1FinalX[i]==shipPosX[j] && ship4P1FinalY[i]==shipPosY[j])canPlace = false;}
            }    
            if(player1Placing){      
                //player 2 - ship 4 collisions
                if (shipLengthPrint==4)for(int j=0;j<shipLengthArray[4];j++){if(ship4P1FinalX[i]==shipPosX[j] && ship4P1FinalY[i]==shipPosY[j])canPlace = false;}
            }
        }
        return canPlace;
    }
    
    //shipWeapon starts the shooting process
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
                
                if(
                playingBoardPlayer1[shootY][shootX] == shipChar[5] && player1Playing ||
                playingBoardPlayer2[shootY][shootX] == shipChar[5] && player2Playing){
                    if(player1Playing)player1Shoot();
                    if(player2Playing)player2Shoot();
                }
                else{
                    System.out.println('\u000C');
                    playingBoardPlayer1();
                    System.out.println("This is not a valid command");
                    System.out.println();
                }
            }else{
                System.out.println('\u000C');
                playingBoardPlayer1();
                System.out.println("This is not a valid command");
            }
        }
    }
    
    //player1Shoot operates player 1's turn to shoot
    public void player1Shoot(){
        System.out.println('\u000C');
        playingBoardPlayer1();
        if (placingBoardPlayer2[shootY][shootX] == shipChar[0]
         || placingBoardPlayer2[shootY][shootX] == shipChar[1]
         || placingBoardPlayer2[shootY][shootX] == shipChar[2]
         || placingBoardPlayer2[shootY][shootX] == shipChar[3]
         || placingBoardPlayer2[shootY][shootX] == shipChar[4]){
            winConditionP1--;
            System.out.println('\u000C');
            playingBoardPlayer1[shootY][shootX] = shipChar[7];
            sink1Ship();
            if(shipP1Sink[0] == 1)for(int i=0;i<shipLengthArray[0];i++)playingBoardPlayer1[ship1P2FinalY[i]][ship1P2FinalX[i]] = shipChar[0];
            if(shipP1Sink[1] == 1)for(int i=0;i<shipLengthArray[1];i++)playingBoardPlayer1[ship2P2FinalY[i]][ship2P2FinalX[i]] = shipChar[1];
            if(shipP1Sink[2] == 1)for(int i=0;i<shipLengthArray[2];i++)playingBoardPlayer1[ship3P2FinalY[i]][ship3P2FinalX[i]] = shipChar[2];
            if(shipP1Sink[3] == 1)for(int i=0;i<shipLengthArray[3];i++)playingBoardPlayer1[ship4P2FinalY[i]][ship4P2FinalX[i]] = shipChar[3];
            if(shipP1Sink[4] == 1)for(int i=0;i<shipLengthArray[4];i++)playingBoardPlayer1[ship5P2FinalY[i]][ship5P2FinalX[i]] = shipChar[4];
            playingBoardPlayer1();
            System.out.println();
            System.out.println("Type n or next to start player 2's turn");
            boolean cmdN = true;
            while (cmdN){
                String cmd1 = kb.nextLine();
                cmd1 = cmd1.toLowerCase();
                if(cmd1.equals("n") || cmd1.equals("next")){
                    cmdN = false;
                    player1Playing = false;//Check if player 1 can shoot ships
                    player2Playing = true;//Check if player 2 can shoot ships
                    System.out.println('\u000C');
                    playingBoardPlayer2();
                    shipWeapon();
                }
            }
        }else if(placingBoardPlayer2[shootY][shootX] == shipChar[5]){
            System.out.println('\u000C');
            playingBoardPlayer1[shootY][shootX] = shipChar[8];
            playingBoardPlayer1();
            System.out.println();
            System.out.println("Type n or next to start player 2's turn");
            boolean cmdN = true;
            while (cmdN){
                String cmd2 = kb.nextLine();
                cmd2 = cmd2.toLowerCase();
                if(cmd2.equals("n") || cmd2.equals("next")){
                    cmdN = false;
                    player1Playing = false;//Check if player 1 can shoot ships
                    player2Playing = true;//Check if player 2 can shoot ships
                    System.out.println('\u000C');
                    playingBoardPlayer2();
                    shipWeapon();
                }
            }
        }
    }
    
    //player2Shoot operates player 2's turn to shoot
    public void player2Shoot(){
        System.out.println('\u000C');
        playingBoardPlayer2();
        if (placingBoardPlayer1[shootY][shootX] == shipChar[0]
         || placingBoardPlayer1[shootY][shootX] == shipChar[1]
         || placingBoardPlayer1[shootY][shootX] == shipChar[2]
         || placingBoardPlayer1[shootY][shootX] == shipChar[3]
         || placingBoardPlayer1[shootY][shootX] == shipChar[4]){
            winConditionP2--;
            System.out.println('\u000C');
            playingBoardPlayer2[shootY][shootX] = shipChar[7];
            sink2Ship();
            if(shipP2Sink[0] == 1)for(int i=0;i<shipLengthArray[0];i++)playingBoardPlayer2[ship1P1FinalY[i]][ship1P1FinalX[i]] = shipChar[0];
            if(shipP2Sink[1] == 1)for(int i=0;i<shipLengthArray[1];i++)playingBoardPlayer2[ship2P1FinalY[i]][ship2P1FinalX[i]] = shipChar[1];
            if(shipP2Sink[2] == 1)for(int i=0;i<shipLengthArray[2];i++)playingBoardPlayer2[ship3P1FinalY[i]][ship3P1FinalX[i]] = shipChar[2];
            if(shipP2Sink[3] == 1)for(int i=0;i<shipLengthArray[3];i++)playingBoardPlayer2[ship4P1FinalY[i]][ship4P1FinalX[i]] = shipChar[3];
            if(shipP2Sink[4] == 1)for(int i=0;i<shipLengthArray[4];i++)playingBoardPlayer2[ship5P1FinalY[i]][ship5P1FinalX[i]] = shipChar[4];
            playingBoardPlayer2();
            System.out.println();
            System.out.println("Type n or next to start player 1's turn");
            boolean cmdN = true;
            while (cmdN){
                String cmd1 = kb.nextLine();
                cmd1 = cmd1.toLowerCase();
                if(cmd1.equals("n") || cmd1.equals("next")){
                    cmdN = false;
                    player2Playing = false;//Check if player 2 can shoot ships
                    player1Playing = true;//Check if player 1 can shoot ships
                    System.out.println('\u000C');
                    playingBoardPlayer1();
                    shipWeapon();
                }
            }
        }else if(placingBoardPlayer1[shootY][shootX] == shipChar[5]){
            System.out.println('\u000C');
            playingBoardPlayer2[shootY][shootX] = shipChar[8];
            playingBoardPlayer2();
            System.out.println();
            System.out.println("Type n or next to start player 1's turn");
            boolean cmdN = true;
            while (cmdN){
                String cmd2 = kb.nextLine();
                cmd2 = cmd2.toLowerCase();
                if(cmd2.equals("n") || cmd2.equals("next")){
                    cmdN = false;
                    player2Playing = false;//Check if player 2 can shoot ships
                    player1Playing = true;//Check if player 1 can shoot ships
                    System.out.println('\u000C');
                    playingBoardPlayer1();
                    shipWeapon();
                }
            }
        }
    }
    
    public void sink1Ship(){
        //check if a ship has been sunk
        if (placingBoardPlayer2[shootY][shootX] == shipChar[0])s1P1Hit--;if (s1P1Hit == 0)shipP1Sink[0] = 1;
        if (placingBoardPlayer2[shootY][shootX] == shipChar[1])s2P1Hit--;if (s2P1Hit == 0)shipP1Sink[1] = 1;
        if (placingBoardPlayer2[shootY][shootX] == shipChar[2])s3P1Hit--;if (s3P1Hit == 0)shipP1Sink[2] = 1;
        if (placingBoardPlayer2[shootY][shootX] == shipChar[3])s4P1Hit--;if (s4P1Hit == 0)shipP1Sink[3] = 1;
        if (placingBoardPlayer2[shootY][shootX] == shipChar[4])s5P1Hit--;if (s5P1Hit == 0)shipP1Sink[4] = 1;
    }
    
    public void sink2Ship(){
        //check if a ship has been sunk
        if (placingBoardPlayer1[shootY][shootX] == shipChar[0])s1P2Hit--;if (s1P1Hit == 0)shipP2Sink[0] = 1;
        if (placingBoardPlayer1[shootY][shootX] == shipChar[1])s2P2Hit--;if (s2P1Hit == 0)shipP2Sink[1] = 1;
        if (placingBoardPlayer1[shootY][shootX] == shipChar[2])s3P2Hit--;if (s3P1Hit == 0)shipP2Sink[2] = 1;
        if (placingBoardPlayer1[shootY][shootX] == shipChar[3])s4P2Hit--;if (s4P1Hit == 0)shipP2Sink[3] = 1;
        if (placingBoardPlayer1[shootY][shootX] == shipChar[4])s5P2Hit--;if (s5P1Hit == 0)shipP2Sink[4] = 1;
    }
    
    //tell the player who won the game
    public void winGame(){
        player1Placing = false;
        player2Placing = false;
        player1Playing = false;
        player2Playing = false;
        System.out.println('\u000C');
        int i = 0;
        if(winConditionP1 == 0)i = 1;
        if(winConditionP2 == 0)i = 2;
        System.out.println("Player " + i + " has won the game\n");
        System.out.println("Please restart the game to play again");
        kb.close();
        System.exit(0);
    }
}