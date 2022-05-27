
/**
 * Write a description of class charTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class charTest
{
    // instance variables - replace the example below with your own
    Scanner kb = new Scanner (System.in);
    
    boolean go = true;
    
    int shootX = 0;
    int shootY = 0;
    /**
     * Constructor for objects of class charTest
     */
    public charTest()
    {
        while (go){ 
            char shootChar = 'a';
            System.out.println("Type coordinates to shoot");
            System.out.println("First type a number to choose the row (X) you will shoot\nThen type a letter to choose the column (Y) you will shoot\ne.g. 1A");
            String cmd0 = kb.nextLine();
            cmd0 = cmd0.toLowerCase();
            if (cmd0.length() == 2){
                System.out.print('\u000C');
                if (cmd0.charAt(0) >= '0' && cmd0.charAt(0) <= '9' && cmd0.charAt(1) >= 'a' && cmd0.charAt(1) <= 'j'){
                    shootX = cmd0.charAt(0);
                    shootX -= '1';
                    
                    shootChar = cmd0.charAt(1);
                    shootY = cmd0.charAt(1);
                    shootY -= 'a';
                    System.out.println("X " + shootX);
                    System.out.println("Y " + shootY);
                }else System.out.println("NO!");
            }else System.out.println("NO!");
        }
    }
}