import java.util.Scanner;

public class Main {

    public static final String pathDict = "/home/maciej/Desktop/Pracaownia_programowania/src/main/dict/";

    public static void main(String[] args) {
        while (true){

            Scanner input = new Scanner(System.in);  //scanner object
            menuDisplay();
            String userMenuInput = input.nextLine();  // save user input

            switch(userMenuInput) {
                case "1":
                    //Core
                    Core.coreFunction(pathDict);
                    break;
                case "2":
                    //Insert new lib
                    NewLib.newLibFunction(pathDict);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    // code block
            }
        }
    }
    //Menu
    public static void menuDisplay() {
        System.out.println("Menu:");
        System.out.println("Choose 1 to search,");
        System.out.println("Choose 2 to insert,");
        System.out.print("Choose 3 to exit. --> ");
    }

}


