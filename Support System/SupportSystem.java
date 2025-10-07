public class SupportSystem
{
    private InputUser reader;
    private TechSupport responder;
    
    public SupportSystem()
    {
        reader = new InputUser();
        responder = new TechSupport();
    }
    
    public void start() {
        boolean finished = false;
        printWelcome();
        while(!finished) {
            String input = reader.getInput();
        
            if(input.startsWith("bye")) {
                finished = true;
            }
            else {
            String response = responder.getResponse(input);
            System.out.println(response);
            }
        }
        printGoodbye();
    }
    
    private void printWelcome() {
        System.out.println(
        "Welcome to FRS Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println(
        "We will assist you with any problem you might have.");
        System.out.println(
        "Please type 'bye' to exit our system.");
    }
    
    /**
    * Print a good-bye message to the screen.
    */
    private void printGoodbye() {
        System.out.println("Nice talking to you. Fighting, bye. . .");
    }
}
