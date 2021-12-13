import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Forumala1ChampionshipManager fcm = new Forumala1ChampionshipManager();
        Scanner input = new Scanner(System.in);
        int uInput=0;
        System.out.println("***********************************************************");
       System.out.println("Welcome to the F1 racing Program :) ");
        while (uInput != -1){
            try{
                System.out.println("01) Create a new Driver");
                System.out.println("02) Delete a Driver");
                System.out.println("03) Change a Driver's Team");
                System.out.println("04) Display Driver Stats");
                System.out.println("05) Display Sorted Table ");
                System.out.println("06) Add Race details and Update the data");
                System.out.println("07) Save all the data");
                System.out.println("08) Load all the Data ");
                System.out.println("09) Generate the GUI");
                System.out.println("-1) To exit the program");
                System.out.println("***********************************************************");
                uInput =Integer.parseInt(input.nextLine());
                switch(uInput){
                    case 1:
                    fcm.CreateDriver();
                    break;
                    case 2:
                    fcm.DeleteDriver();
                    break;
                    case 3:
                    fcm.ChangeDriver();
                    case 4:
                    fcm.ShowStats();
                    break;
                    case 5:
                    fcm.ShowTable();
                    break;
                    case 6:
                    fcm.AddRace();
                    break;
                    case 7:
                    fcm.Store();
                    break;
                    case 8:
                    fcm.LoadFile();
                    break;
                    case 9 :
                    Gui.main(args);
                    break;
                    default:
                    System.out.println("Please Enter a number in the menu");

                }
                System.out.println("***********************************************************");
                System.out.println("What would you like to do next?");
            } catch (NumberFormatException e) {
               System.out.println("Please enter an integer >:-| ");
               System.out.println("***********************************************************");
            }
            //when outputting the -1

        }
        System.out.println("Thank you for using this service");
        System.out.println("Have a nice day");
        
    }
}