import java.util.Scanner;
import java.util.ArrayList;

public class App {
  public static final Scanner Input = new Scanner(System.in);
    public static void main(String[] args) {
      while (true) {
        MainMenu();
      }
    }

    public static void MainMenu() {
      //clearScreen();
      System.out.println("WELCOME TO TIC-TAC-TOE!\n\nEnter an option's number: (ex. 1, 2, ...)");
      System.out.println("1. Play");

      String Choice = Input.nextLine().toLowerCase();
      if (Choice.equals("1") || Choice.equals("1. play") || Choice.equals("play")) {
        PlayGame();
      }
    }

    public static void PlayGame() {
      ArrayList<String> PlayerNames = getPlayerInformation();
      ArrayList<Integer> Board = new ArrayList<Integer>();
      for (int i = 0; i < 9; i++) {
        Board.add(0);
      } 
      drawBoard(Board);
      System.out.println("Pick a spot");
      Input.nextLine();
    }

    public static void drawBoard(ArrayList<Integer> brd){
      clearScreen();
      /*
       | | | |
       | | | |
       | | | |
      */
      String p = "";
      for (int i = 0; i < brd.size(); i++) {
        p += "| " + brd.get(i) + " ";
        if (i == 2 || i == 5 || i == 8) {
          p += "|\n";
  
        }
        //System.out.println(i + " " + brd.get(i));
      }
      System.out.println(p);
    }

    public static ArrayList<String> getPlayerInformation() {
      clearScreen();
      ArrayList<String> Names = new ArrayList<String>();
      for (int i = 1; i < 3; i++) {
        System.out.println("Player " + i + "'s Name:");
        Names.add(Input.nextLine());
        clearScreen();
      }
      return Names;
    }

    /*
      https://stackoverflow.com/questions/2979383/java-clear-the-console
    */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
