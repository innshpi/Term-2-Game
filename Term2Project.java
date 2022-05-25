/**
 * Write a description of class Term2Project here.
 *
 * @author (Piper Inns Hall)
 * @version (19/05/22)
 */
import java.util.Scanner;
public class Term2Project
{
    Scanner kb = new Scanner (System.in);
    
    boolean shipCtrl = true;
    boolean player1Play = true;
    boolean player2Play = false;
    
    private int ROWS = 10;
    private int COLS = 10;
    String setupBoardPlayer1[][] = new String[COLS][ROWS];
    String setupBoardPlayer2[][] = new String[COLS][ROWS];
    
    private String wave = "🌊 ";
    private String ship = "🕳 ";
    private String ship1Final = "🛥 ";
    private String ship2Final = "⛵ ";
    private String ship3Final = "🚤 ";
    private String ship4Final = "🚢 ";
    private String ship5Final = "🛳 ";
    private char setupBoardChar = 65;
    
    boolean ship1Print = false;
    boolean ship2Print = false;
    boolean ship3Print = false;
    boolean ship4Print = false;
    boolean ship5Print = false;
    
    int[] shipPosX = {0, 0, 0, 0, 0};
    int[] shipPosY = {0, 1, 2, 3, 4};
    
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
    
    int[] shipLengthArray = {2, 3, 3, 4, 5};
    int shipLengthAdd = 0;//This is used as an index into the ship length array
    int shipLength = 2;
    
    int shipTurn = 0;
    boolean canMoveL = false;
    boolean canMoveR = false;
    boolean canMoveU = false;
    boolean canMoveD = false;
    boolean canMoveT0 = false;
    boolean canMoveT1 = false;
    /**
     * Constructor for objects of class Term2Project
     */
    public Term2Project()
    {
        // initialise instance variables
        setupBoardPlayer1();
        shipCtrl();
        shipCtrl = true;
    }
    
    public void setupBoardPlayer1(){
        System.out.print('\u000C');
        for(int i=0;i<COLS;i++)System.out.print(i + "\u3002");
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                setupBoardPlayer1[i][j] = wave;
                //for(int k=0;k<shipLengthArray[shipLengthAdd]
                if (ship1Print)for(int k=0;k<shipLengthArray[shipLengthAdd];k++)setupBoardPlayer1[ship1P1FinalY[k]][ship1P1FinalX[k]] = ship1Final;
                if (ship2Print)for(int l=0;l<3;l++)setupBoardPlayer1[ship2P1FinalY[l]][ship2P1FinalX[l]] = ship2Final;
                if (ship3Print)for(int m=0;m<3;m++)setupBoardPlayer1[ship3P1FinalY[m]][ship3P1FinalX[m]] = ship3Final;
                if (ship4Print)for(int n=0;n<4;n++)setupBoardPlayer1[ship4P1FinalY[n]][ship4P1FinalX[n]] = ship4Final;
                if (ship5Print)for(int o=0;o<5;o++)setupBoardPlayer1[ship5P1FinalY[o]][ship5P1FinalX[o]] = ship5Final;
                for(int p=0;p<shipLength;p++)setupBoardPlayer1[shipPosY[p]][shipPosX[p]] = ship;
                System.out.print(setupBoardPlayer1[i][j]);
            }
            System.out.print(setupBoardChar + "\u3002");
            setupBoardChar++;
            if (i==9)setupBoardChar = 65;
            System.out.println();
        }
    }
    
    public void shipCtrl(){
        while (shipCtrl){
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            shipCollision();
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){
                for(int i=0;i<shipLength;i++)shipPosX[i]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){
                for(int i=0;i<shipLength;i++)shipPosX[i]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){
                for(int i=0;i<shipLength;i++)shipPosY[i]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){
                for(int i=0;i<shipLength;i++)shipPosY[i]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){
                shipPosX[1]++;
                shipPosY[1]--;
                
                shipPosX[2]+= 2;
                shipPosY[2] -= 2;

                shipPosX[3]+= 3;
                shipPosY[3]-= 3;

                shipPosX[4]+= 4;
                shipPosY[4]-= 4;
                
                cmd0 = " ";
                shipTurn = 1;
                
                setupBoardPlayer1();              
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true|| cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){
                shipPosX[1]--;
                shipPosY[1]++;
                
                shipPosX[2]-= 2;
                shipPosY[2]+= 2;

                shipPosX[3]-= 3;
                shipPosY[3]+= 3;

                shipPosX[4]-= 4;
                shipPosY[4]+= 4;
                
                cmd0 = " ";
                shipTurn = 0;
                
                setupBoardPlayer1();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                setFinalShipPos(shipLengthArray[shipLengthAdd]);
                setupBoardPlayer1();
            }
        }
    } 
    
    //setFinalShipPos is used copy the temporary ship positions to the final board configuration
    public void setFinalShipPos(int length){
        if (player1Play){
            ship1Print = true;
            for(int i=0;i<length;i++)ship1P1FinalX[i] = shipPosX[i];
            for(int i=0;i<length;i++)ship1P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==0 && player1Play){
            ship1Print = true;
            for(int i=0;i<2;i++)ship1P1FinalX[i] = shipPosX[i];
            for(int i=0;i<2;i++)ship1P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==1 && player1Play){
            ship2Print = true;
            for(int i=0;i<3;i++)ship2P1FinalX[i] = shipPosX[i];
            for(int i=0;i<3;i++)ship2P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==2 && player1Play){
            ship3Print = true; 
            for(int i=0;i<3;i++)ship3P1FinalX[i] = shipPosX[i];
            for(int i=0;i<3;i++)ship3P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==3 && player1Play){
            ship4Print = true; 
            for(int i=0;i<4;i++)ship4P1FinalX[i] = shipPosX[i];
            for(int i=0;i<4;i++)ship4P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==4 && player1Play){
            ship5Print = true;
            for(int i=0;i<5;i++)ship5P1FinalX[i] = shipPosX[i];
            for(int i=0;i<5;i++)ship5P1FinalY[i] = shipPosY[i];
        }
        if(shipLengthAdd==5 && player1Play){
            
        }
        if (shipLengthAdd<6){
            shipLengthAdd++;
            shipLength = shipLengthArray[shipLengthAdd];
        }
        for(int i=0;i<5;i++)shipPosX[i] = 0;
        for(int i=0;i<5;i++)shipPosY[i] = i;
    }
    
    public void shipCollision(){
        if (shipPosX[0] - 1 <= -1)canMoveL = false;
        else canMoveL = true;
        if (shipPosX[1] + 1 >= 10)canMoveR = false;
        else canMoveR = true;
        if (shipPosY[0] - 1 <= -1)canMoveU = false;
        else canMoveU = true;
        if (shipPosY[1] + 1 >= 10)canMoveD = false;
        else canMoveD = true;
        if (shipPosX[1] + 1 >= 10)canMoveT0 = false;
        else canMoveT0 = true;
        if (shipPosY[1] + 1 >= 10)canMoveT1 = false;
        else canMoveT1 = true;
    }
}