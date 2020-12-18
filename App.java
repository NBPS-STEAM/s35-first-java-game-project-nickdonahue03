import java.util.Scanner;
import java.util.ArrayList;

public class App {
  public static final Scanner Input = new Scanner(System.in);
    public static void main(String[] args) {
      MainMenu();
    }

    public static void MainMenu() {
      clearScreen();
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
      boolean Playing = true;
      boolean player = true;
      while (Playing) {
        boolean correctSpot = false;
        while (!correctSpot) {
          drawBoard(Board);
          System.out.println((player ? PlayerNames.get(0) : PlayerNames.get(1)) + " pick a spot!");
          int slot = getSlot(Input.nextLine().toLowerCase());
          if (Board.get(slot) == 0) {
            if (player) {
              Board.set(slot, 1);
              player = false;
            } else {
              Board.set(slot, 2);
               player = true;
            }
            correctSpot = true;
          }
        }

        int Winner = checkForWinner(Board);
        if (Winner == 1 || Winner == 2) {
          Playing = false;
          clearScreen();
          System.out.println((PlayerNames.get(Winner - 1).toUpperCase())+ " WINS!");
        }

        if (Winner == 3) {
          Playing = false;
          clearScreen();
          System.out.println(PlayerNames.get(0).toUpperCase() + " and " + PlayerNames.get(1).toUpperCase() + " WIN... BECAUSE ITS A TIE!!!!");
        }
      }
    }
    public static int getSlot(String inp) {
      
      String[] sp = inp.split("(?!^)");/*https://stackoverflow.com/questions/5235401/split-string-into-array-of-character-strings*/
      int nmbr = 0;
      if (sp[0].equals("a")) {
        nmbr += 0;
      }
      if (sp[0].equals("b")) {
        nmbr += 3;
      }
            if (sp[0].equals("c")) {
        nmbr += 6;
      }
      nmbr += Integer.parseInt(sp[1]) - 1;
      return nmbr;
    }
    public static int checkForWinner(ArrayList<Integer> brd) {
      
      for (int i = 0; i < brd.size(); i++) {
        if (brd.get(i) == 0) {
          return 0;
        }
      }
      return 3;
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
        String put = "";
        int z = brd.get(i);
        if (z == 1) {
          put = "x";
        }

        if (z == 2) {
          put = "o";
        }

        if (z == 0) {
          if (i == 0  || i == 1 || i == 2) {
            put = "a" + (i+1);
          }
          if (i == 3  || i == 4 || i == 5) {
            put = "b" + ((i-3) + 1);
          }
          if (i == 6  || i == 7 || i == 8) {
            put = "c" + ((i-6) + 1);
          }
        }

        p += "| " + put + " ";
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
