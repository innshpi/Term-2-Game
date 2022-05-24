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
    
    int[] ship1FinalX = new int[5];
    int[] ship2FinalX = new int[5];
    int[] ship3FinalX = new int[5];
    int[] ship4FinalX = new int[5];
    int[] ship5FinalX = new int[5];
    
    int[] ship1FinalY = new int[5];
    int[] ship2FinalY = new int[5];
    int[] ship3FinalY = new int[5];
    int[] ship4FinalY = new int[5];
    int[] ship5FinalY = new int[5];
    
    int[] shipLengthArray = {2, 3, 3, 4, 5};
    int shipLengthAdd = 0;
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
                for(int p=0;p<shipLength;p++)setupBoardPlayer1[shipPosY[p]][shipPosX[p]] = ship;
                if (ship1Print)for(int k=0;k<2;k++)setupBoardPlayer1[ship1FinalY[k]][ship1FinalX[k]] = ship1Final;
                
                if (ship2Print)for(int l=0;l<3;l++)setupBoardPlayer1[ship2FinalX[l]][ship2FinalY[l]] = ship2Final;
                if (ship3Print)for(int m=0;m<3;m++)setupBoardPlayer1[ship3FinalX[m]][ship3FinalY[m]] = ship3Final;
                if (ship4Print)for(int n=0;n<4;n++)setupBoardPlayer1[ship4FinalX[n]][ship4FinalY[n]] = ship4Final;
                if (ship5Print)for(int o=0;o<5;o++)setupBoardPlayer1[ship5FinalX[o]][ship5FinalY[o]] = ship5Final;
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
                shipPrint();
                setupBoardPlayer1();
            }
        }
    } 
    
    public void shipPrint(){
        if(shipLengthAdd==0){
            ship1Print = true;
            for(int i=0;i<2;i++)ship1FinalX[i] = shipPosX[i];
            for(int i=0;i<2;i++)ship1FinalY[i] = shipPosY[i];
        }
        
        if(shipLengthAdd==1){
            ship2Print = true; 
            ship2FinalX[2] = shipPosX[2]; 
            ship1FinalY[2] = shipPosY[2];
        }
        if(shipLengthAdd==2){
            ship3Print = true; 
            ship3FinalX[3] = shipPosX[3]; 
            ship1FinalY[3] = shipPosY[3];
        }
        // if(shipLengthAdd==3){ship4Print = true; ship4FinalX[4] = shipPosX[4]; ship1FinalY[4] = shipPosY[4];}
        // if(shipLengthAdd==4){ship5Print = true; ship5FinalX[5] = shipPosX[5]; ship1FinalY[5] = shipPosY[5];}
        
        for(int i=0;i<5;i++)shipPosX[i] = 0;
        for(int i=0;i<5;i++)shipPosY[i] = i;
        
        shipLengthAdd++;
        shipLength = shipLengthArray[shipLengthAdd];
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