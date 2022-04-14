import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Worble {
    public static ArrayList<String> words;
    public static ArrayList<Character> correctLetters = new ArrayList<Character>();
    public static ArrayList<Character> letterPool = new ArrayList<Character>();
    public static Scanner scanner = new Scanner(System.in);
    public boolean won = false;
    public static int numOfAttempts = 0;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        gameIntroduction();
        fillLetterPool();
        String wordToGuess = pickRandomWord();
        for (int i = 0; i < 6; i++) {
            correctLetters.clear();
            checkGuess(wordToGuess, readInput());
            if (correctLetters.size() == 6) break;
        }
        if (correctLetters.size() == 6) System.out.println("Correct! Game over!");
        else System.out.println("Sorry, but you lose :(");

    }

    /**
     * Reads a word from the player and will only accept it if it is six letters
     * @return A six letter word from the player
     */

    public static String readInput() {
        String word = "";
        numOfAttempts++;
        while (true) {
            System.out.print(numOfAttempts + ". Enter a six letter word: ");
            word = scanner.next();
            if (word.length() == 6) {
                return word.toLowerCase();
            } else {
                System.out.println("Your word has to be six letters!");
                continue;
            }
        }
    }

    /**
     * Adds words to an array for the player to guess
     */
    
    public static void addWords() {
        words = new ArrayList<String>();
        words.add("laptop");
        words.add("golfer");
        words.add("famous");
        words.add("goblin");
        words.add("fabric");
        words.add("burlap");
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
        ArrayList<Character> wordToGuessChars = new ArrayList<Character>();

        // Splits the String of the word to guess into an ArrayList of characters
        for (int i = 0; i < 6; i++) {
            wordToGuessChars.add(word.charAt(i));
        }

        
        for (int k = 0; k < 6; k++) {
            // Correct letter and in the correct spot
            if (wordToGuessChars.get(k).equals(playerGuess.charAt(k))) {
                printOutput(ANSI_GREEN, playerGuess.charAt(k));
                printOutput(ANSI_RESET, ' ');
            }
            // Correct letter, but in the wrong spot
            else if (wordToGuessChars.contains(playerGuess.charAt(k))) {
                printOutput(ANSI_YELLOW, playerGuess.charAt(k));
                printOutput(ANSI_RESET, ' ');
            }
            // Not a letter in the word
            else {
                printOutput(ANSI_RESET, playerGuess.charAt(k));
                printOutput(ANSI_RESET, ' ');
                removeLetter(playerGuess.charAt(k));
            }
        }

        System.out.println();
        System.out.println(letterPool);
    }

    /**
     * Takes in either yellow or green and then prints out the char in that color
     * @param printColor
     * @param letter
     */

    public static void printOutput(String printColor, char letter) {
        if (printColor.equals(ANSI_GREEN)) correctLetters.add(letter);
        System.out.print(printColor + letter);
    }

    /**
     * Introduces the rules and begins the game after the player hits Enter
     */

    public static void gameIntroduction() {
        System.out.println();
        System.out.println(ANSI_RESET+ "Welcome to Worble! The object of the game is to submit guess the SIX letter word that the computer knows."
        + " You will have six tries to guess the word and each time you enter a letter, the output will tell \nyou if the letters "
        + "you guessed are in the word, and if they are in the correct position based on letters that are in the word and in the "
        + "correct position are green, in the wrong position yellow, and \nletters not in the word at all white. Also, note that none of the "
        + "words have the same letter twice. If you're ready, hit Enter to start!");
        if (scanner.nextLine() == "") addWords(); else gameIntroduction();
    }

    public static void fillLetterPool() {
        for(char ch = 'a'; ch <= 'z'; ++ch)// fills alphabet array with the alphabet
        {
            letterPool.add(ch);
        } 
    }

    /**
     * Removes a letter from the pool of letters to guess
     */
    public static void removeLetter(char letter) {
        if (!letterPool.contains(letter)) return;
        else letterPool.remove(Character.valueOf(letter));
    }
}
