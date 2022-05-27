
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
    
    int shootX = 0;
    int shootY = 0;
    /**
     * Constructor for objects of class charTest
     */
    public charTest()
    {
        char shootChar = 'a';
        System.out.println("Type coordinates to shoot");
        System.out.println("First type a number to choose the row you will shoot\nThen type a letter to choose the column you will shoot\ne.g. 1A");
        String cmd0 = kb.nextLine();
        cmd0 = cmd0.toLowerCase();
        
        shootChar = cmd0.charAt(1);
        System.out.println(shootChar);
        
        shootX = cmd0.charAt(1);
        shootX -= 'a';
        
        
        shootY = cmd0.charAt(0);
        shootY -= '0';
        
        System.out.println(shootX);
        System.out.println(shootY);
    }
}