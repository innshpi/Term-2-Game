
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
    private char setupBoardChar = 65;
    
    int[] shipPosX = {0, 0, 0, 0, 0};
    int[] shipPosY = {0, 1, 2, 3, 4};
    
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
        for(int i=0;i<COLS;i++){
            System.out.print(i + "\u3002");
        } 
        System.out.println();
        for(int i=0;i<COLS;i++){
            for(int j=0;j<ROWS;j++){
                setupBoardPlayer1[i][j] = wave;
                System.out.print(setupBoardPlayer1[i][j]);
                setupBoardPlayer1[shipPosY[0]][shipPosX[0]] = ship;
                setupBoardPlayer1[shipPosY[1]][shipPosX[1]] = ship;
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
            canMoveShips();
            if(cmd0.equals("right") && canMoveR == true || cmd0.equals("r") && canMoveR == true){
                shipPosX[0]++;
                shipPosX[1]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("left") && canMoveL == true || cmd0.equals("l") && canMoveL == true){
                shipPosX[0]--;
                shipPosX[1]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("up") && canMoveU == true || cmd0.equals("u") && canMoveU == true){
                shipPosY[0]--;
                shipPosY[1]--;
                setupBoardPlayer1();
            }
            if(cmd0.equals("down") && canMoveD == true || cmd0.equals("d") && canMoveD == true){
                shipPosY[0]++;
                shipPosY[1]++;
                setupBoardPlayer1();
            }
            if(cmd0.equals("turn") && shipTurn == 0 && canMoveT0 == true || cmd0.equals("t") && shipTurn == 0 && canMoveT0  == true){
                shipPosX[1]++;
                shipPosY[1]--;
                cmd0 = " ";
                shipTurn = 1;
                setupBoardPlayer1();              
            }
            if(cmd0.equals("turn") && shipTurn == 1 && canMoveT1 == true|| cmd0.equals("t") && shipTurn == 1 && canMoveT1 == true){
                shipPosX[1]--;
                shipPosY[1]++;
                cmd0 = " ";
                shipTurn = 0;
                setupBoardPlayer1();
            }
            if(cmd0.equals("next") || cmd0.equals("n")){
                
            }
        }
    } 
    
    public void canMoveShips(){
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