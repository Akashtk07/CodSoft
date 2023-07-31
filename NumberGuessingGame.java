import java.util.Scanner;
import java.util.Random;

 class GuessNumber{

    public void GuessingGame()
    {
       
       try{
            Scanner sc = new Scanner(System.in);
            Random rand= new Random();
            int RandomNumber=rand.nextInt(101);
            System.out.println("Guess Number Between 0 to 100 : ");
            int UserInput=sc.nextInt();
           // System.out.println("Random Number Are :"+RandomNumber);
            System.out.println(UserInput);
            int Count=0;
            boolean flag=true;

            do{

                if(RandomNumber == UserInput)
                {   
                    System.out.println("|-----------------------------|");
                    System.out.println(" Correct. You Win ");
                    System.out.println("|-----------------------------|");
                    System.out.println(" Score : "+(++Count));
                    System.out.println("|-----------------------------|");
                    break;
                }


                else if(RandomNumber < UserInput)
                {
                    System.out.println("Nope! Guess Lesser...");
                    UserInput=sc.nextInt();
                    Count++;
                }
                else
                {
                    System.out.println("Nope! Guess Higher...");
                    UserInput=sc.nextInt();
                    Count++;
                }

            }while(Count!=9);

            if(flag)
            {
                    System.out.println("Play Again  Y/N ");
                    System.out.println("|-----------------------------|");
                    String TryAgain=sc.next();
                if(TryAgain.equals("Y") || TryAgain.equals("y"))
                {
                    Count=0;
                    GuessingGame();
                }


            }

            
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}

public class NumberGuessingGame {
    public static void main(String[] args)
    {

        GuessNumber gsn = new GuessNumber();
        gsn.GuessingGame();
    }
    
}
