/**
 * User has to guess a five digit number
 * Unless they quit, the user will play a round until correctly guessing the answer or quitting
 * The game ends when the user quits
 * When the user quits the number of rounds won and average number of guesses will be displayed `
 */
import java.util.Scanner;
public class Game
{
    /**
     * Instance Variables
     */
    private Scanner scan;
    private int numGuesses;
    private int numRoundsWon;
    private boolean quitGame;
    /**
     * Game Constructors
     * Initialize instance variables:
     * scan - Scanner object to read user input
     * numGuesses - Number of guesses it takes the user to win
     * numRoundsWon - Number of rounds the user has won
     * quitGame - Whether or not the user wants to quit
     */
    public Game(){
        scan = new Scanner(System.in);
        numGuesses = 0;
        numRoundsWon = 0;
        quitGame = false;
    }
    /**
     * @param s scanner object used to read user's input
     */
    public Game(Scanner s){
        scan = s;
        numGuesses = 0;
        numRoundsWon = 0;
        quitGame = false;
    }
    /**
     * Accessor for scan instance variable
     * @return scan instance variable
     */
    public Scanner getScan(){
        return scan;
    }
    /**
     * Accessor for numGuesses instance variable
     * @return numGuesses instance variable
     */
    public int getNumGuesses(){
        return numGuesses;
    }
    /**
     * Accessor for numRoundsWon instance variable
     * @return numRoundsWon instance variable
     */
    public int getNumRoundsWon(){
        return numRoundsWon;
    }
    /**
     * Accessor for quitGame instance variable
     * @return quitGame instance variable
     */
    public boolean getQuitGame(){
        return quitGame;
    }
    /**
     * Plays game
     * While user hasn't quit game, keep asking for guesses
     * If guessed correctly, adds to a round won and adds number of guesses
     * Prompts user to play again
     * After player is finished, prints statement telling how many rounds won and average number of guesses
     */
    public void play(){
        while(!quitGame){
            Round game = new Round(scan);
            game.play();
            if(game.getWin()){
               numGuesses+=game.getNumGuesses();
               numRoundsWon++;
            }
            playAgain();
        }
        System.out.println("You won "+numRoundsWon+" rounds, and it took an average of "+getAverage()+" guesses per game");
    }
    /**
     * Prompts user to play again
     * If they enter 'n' then quitGame is set to true
     */
    private void playAgain(){
        System.out.println("Play again? Enter 'y' or 'n': ");
        String userInput = scan.next();
        if(userInput.equals("n")){
            quitGame = true;
        }
    }
    /**
     * Gets average number of guesses per round
     * @return average number of guesses per round
     */
    private double getAverage(){
        double avg = 0.0;
        if(numRoundsWon>0){
            avg = (numGuesses*1.0)/numRoundsWon;
        }
        return avg;
    }
}
