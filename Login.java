import java.net.PasswordAuthentication;
import java.util.*;

public class Login
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String password = "password";
        String passInput;
        int maxTries = 4;

        while(true)
        {
            try
        {
            System.out.println("Please type enter password:");
            passInput = input.nextLine();

            if(passInput.equals(password))
            {
                input.close();
                System.out.println("\nYou're logged in!");
                System.exit(0);
            }
            else if(passInput != password)
            {
                maxTries--;
                if(maxTries != 0)
                {
                    System.out.println();
                    throw new PasswordValidation("Number of tries left: " + maxTries);
                }
                else
                {
                    throw new TriesValidation("Ran out of tries!");
                }
                
            }   
            

        }
        catch(PasswordValidation e)
        {
            System.out.println(e.getMessage());
        }
        catch(TriesValidation e)
        {
            System.out.println("\n" + e.getMessage());
            input.close();
            System.exit(0);
        }
        
        
        
    }
}
}