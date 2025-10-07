import java.util.Scanner;

public class InputUser
{
    private Scanner message;
    
    public InputUser() {
         message = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print("Chat: ");
        return message.nextLine().trim();
    }
    
}
