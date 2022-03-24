import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Wardle {
    public static boolean stop;
    public static ArrayList<String> words;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        gameIntroduction();
        if (!stop) {
            checkGuess("chairs", "czasih");
        }
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
     * @param word
     * @param playerGuess
     */

    public static void checkGuess(String word, String playerGuess) {
        ArrayList<Character> wordChars = new ArrayList<Character>();
        ArrayList<Character> playerGuessChars = new ArrayList<Character>();

        //Splits the String of the word to guess into an ArrayList of characters
        for (int i = 0; i < 6; i++) {
            wordChars.add(word.charAt(i));
        }

        //Splits the String of the players guess into an ArrayList of characters
        for (int j = 0; j < 6; j++) {
            playerGuessChars.add(playerGuess.charAt(j));
        }

        
        for (int k = 0; k < 6; k++) {
            if (wordChars.get(k).equals(playerGuessChars.get(k))) printOutput(ANSI_GREEN, playerGuessChars.get(k));
            else if (wordChars.contains(playerGuessChars.get(k))) printOutput(ANSI_YELLOW, playerGuessChars.get(k));
            else printOutput(ANSI_RESET, playerGuessChars.get(k));
        }

        System.out.println();
    }

    /**
     * Takes in either yellow or green and then prints out the char in that color
     * @param printColor
     * @param letter
     */

    public static void printOutput(String printColor, char letter) {
        System.out.print(printColor + letter + ANSI_RESET);
    }

    /**
     * Introduces the rules and begins the game after the player hits Enter
     */

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
