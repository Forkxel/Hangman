import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is for hard difficulty
 */
public class Hard {

    private String word;
    private ArrayList<String> words = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    private ArrayList<Character> guesses = new ArrayList<>();

    /**
     * this constructor adds words to the ArrayList and then selects a random word from the ArrayList
     * @param sc this Scanner is used to give words from File into ArrayList
     */
    public Hard(Scanner sc) {
        while (sc.hasNext()){
            words.add(sc.next());
        }
        this.word = words.get(rd.nextInt(words.size()));
    }

    /**
     * The method is used to get the player's letter and then find out if it is in the search word
     * @return true if the letter is in the word that is player searching
     */
    private boolean difficulty() {
        char letter = sc.next().charAt(0);
        guesses.add(letter);

        for (int i = 0; i < word.length();i++){
            if (word.charAt(i) == letter){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print the state of the word
     * @return return true if the word length is as long as the correct answers
     */
    private boolean state() {
        int a = 0;
        for (int i = 0; i < word.length();i++){
            if (guesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                a++;
            }else{
                System.out.print("_");
            }
        }
        System.out.println();
        if (word.length() == a){
            return true;
        }else {
            return false;
        }
    }

    /**
     * This method is used to print the hangman
     * @param wrong this parameter is used to print out hangman
     */
    private void hangman(int wrong) {
        System.out.println();
        if (wrong >=1){
            System.out.println(" ------");
        }
        if (wrong >= 2){
            System.out.println(" |");
        }
        if (wrong >= 3){
            System.out.println(" O");
        }
        if (wrong >= 4){
            System.out.println("/|\\");
        }
        if (wrong >= 5){
            System.out.println(" |");
        }
        if (wrong == 6){
            System.out.println("/ \\");
        }
        System.out.println();
    }

    /**
     * This method is used to print out hard difficulty
     */
    public void out() {
        state();
        int wrong = 0;
        boolean game = true;
        int atempt = 1;
        while (game){
            System.out.println("Enter letter");
            if (!difficulty()){
                wrong++;
            }

            hangman(wrong);
            if (state()){
                System.out.println("You win");
                System.out.println("To win you needed a " + atempt + " attempts");
                game = false;
            }

            if (wrong == 6){
                System.out.println("You lose");
                System.out.println("Your word was " + word);
                game = false;
            }
            atempt++;
        }
    }
}