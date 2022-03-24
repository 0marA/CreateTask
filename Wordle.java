import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wordle {
    private static ArrayList<String> words;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        gameIntroduction();
    }

    /**
     * Adds random words to an array for the player to guess
     */
    
    public static void addWords() {
        words = new ArrayList<String>();
        words.add("laptop");
        words.add("abacus");
        words.add("baboon");
        words.add("cabana");
        words.add("fabric");
        words.add("rabbit");
    }

    /**
    * @return A random word from the word list
    */

    public static String pickRandomWord() {
        Collections.shuffle(words);
        return words.get(0);
    }

    /**
     * Takes in the word to guess and the players guess and checks each letter
     * 
     */

    public static void checkGuess(String word, String playerGuess) {
        ArrayList<Character> playerGuessChar = new ArrayList<Character>();
        for (int i = 0; i < playerGuess.length(); i++) {
            playerGuessChar.add(playerGuess.charAt(i));
        }
    }


    public static void gameIntroduction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Wordle! The object of the game is to submit guess the SIX letter word that the computer knows."
        + " You will have six tries to guess the word and each time you enter a letter, the output will tell you if the letters "
        + "you guessed are in the word, and if they are in the correct position. If you're ready, hit Enter to start!");
        if (scanner.nextLine() == "") {
            addWords();
        }
        scanner.close();
    }
}
