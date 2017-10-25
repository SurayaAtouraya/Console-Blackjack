package BlackjackFunctions;

public class Blackjack 

{
    
    public static void Predraw() 
    
    {
        
        System.out.println("Cash Left: " + BlackjackSetup.startingCash);
        System.out.println("[1]: Place Bet ");
        System.out.println("[2]: Game Stats ");
        System.out.println("[0]: Quit");
        System.out.println("");
        BlackjackSetup.response=BlackjackSetup.reader.nextInt();
        System.out.println("_________________________________________________");
        
        switch (BlackjackSetup.response) 
        
        {
            
            case 0: System.exit(0);
                    break;
            case 1: BlackjackFunctions.DrawList();
                    BlackjackFunctions.Bet();
                    break;
            case 2: Blackjack.ShowStats();
                    break;
       
        }     
   
    }  
    
    public static void ShowStats()
    
    {
    
        //TODO______________________________________________
   
    }
    
    public static void main(String[] arg) 
    
    {
        
        Blackjack.Predraw();
    
    }

}
