import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used to play game
 */
public class Hangman {

    private int players;
    private int choice;
    Scanner sc = new Scanner(System.in);

    /**
     * This method is used to select how many players will play the game
     * @return number of players
     */
    private int players(){
            while (players == 0 || players > 2){
                System.out.println("If you want to play single player type 1 \nIf you want to play multiplayer type 2");
                try {
                    int i = sc.nextInt();
                    if (i <= 2 && i != 0){
                        players = i;
                    } else if (i > 2){
                        System.out.println("Number is bigger than 2");
                        System.out.println();
                    }else {
                        System.out.println("Number can not be 0");
                        System.out.println();
                    }
                } catch (InputMismatchException e){
                    System.out.println("Please write a number");
                    break;
                }
            }
        return players;
    }

    /**
     * this method is used to select the difficulty of the game
     * @return difficulty of the game
     */
    private int choice(){
            while (choice == 0 || choice > 3){
                System.out.println("What difficulty you want to play \n type 1 if you want to play easy \n type 2 if you want to play normal \n type 3 if you want to play hard");
                try {
                    int i = sc.nextInt();
                    if (i <= 3 && i != 0){
                        choice = i;
                    } else if (i > 3){
                        System.out.println("Number is bigger than 3");
                        System.out.println();
                    } else {
                        System.out.println("Number can not be 0");
                        System.out.println();
                    }
                } catch (InputMismatchException e){
                    System.out.println("Please write number");
                    break;
                }
            }
        return choice;
    }

    /**
     * this method is used to play the game
     */
    public void out(){
        boolean again = true;
        while (again){
            players();
            if (players == 1) {
                try {
                    choice();
                    Scanner sc1 = new Scanner(new File("words1.txt"));
                    Scanner sc2 = new Scanner(new File("words2.txt"));
                    Scanner sc3 = new Scanner(new File("words3.txt"));
                    if (choice == 1){
                        Easy e = new Easy(sc1);
                        e.out();
                    }

                    if (choice == 2){
                        Normal n = new Normal(sc2);
                        n.out();
                    }

                    if(choice == 3){
                        Hard h = new Hard(sc3);
                        h.out();
                    }
                } catch (FileNotFoundException e){
                    System.out.println("File is not existing");
                }
            } else if (players == 2) {
                TwoPlayers t = new TwoPlayers();
                t.out();
                choice = 4;
            }

            try {
                if (choice == 0){
                    break;
                }
                System.out.println();
                System.out.println("Do you want to play again? \n If yes type 1 \n If no type 2");
                int i = sc.nextInt();
                if (i == 1){
                    again = true;
                    System.out.println("If you want to play single player type 1 \nIf you want to play multiplayer type 2");
                    players = sc.nextInt();
                    if (players == 1){
                        System.out.println("What difficulty you want to play \n type 1 if you want to play easy \n type 2 if you want to play normal \n type 3 if you want to play hard");
                        choice = sc.nextInt();
                    }
                } else if (i == 2) {
                    again = false;
                } else {
                    System.out.println("Please write number 1 or 2");
                    again = false;
                }
            } catch (InputMismatchException e){
                System.out.println("Please write number");
                again = false;
            }
        }
    }
}