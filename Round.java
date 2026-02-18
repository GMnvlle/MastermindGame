/**
 * In each round the player guesses numbers
 * If they guess correctly then they win
 * They must guess a 5 digit number with unique digits
 */
import java.util.Scanner;
import java.util.Random;
public class Round{
    /**
     * Instance Variables
     */
    private int secret;
    private int numGuesses;
    private boolean win;
    private boolean quit;
    private Scanner scan;
    /**
     * Round Constructor
     * Initialize instance variables:
     * secret - random 5 unique digit secret number
     * numGuesses - number of guesses the player takes to guess secret number
     * win - whether or not the player won
     * quit - whether or not the user quits
     * @param s scanner object used to read user's guess
     */
    public Round(Scanner s){
        secret = generateSecret();
        numGuesses = 0;
        win = false;
        quit = false;
        scan = s;
    }
    /**
     * Accessor for secret instance variable
     * @return secret instance variable
     */
    public int getSecret(){
        return secret;
    }
    /**
     * Accessor for numGuesses instance variable
     * @return numGuesses instance variable
     */
    public int getNumGuesses(){
        return numGuesses;
    }
    /**
     * Accessor for win instance variable
     * @return win instance variable
     */
    public boolean getWin(){
        return win;
    }
    /**
     * Accessor for quit instance variable
     * @return quit instance variable
     */
    public boolean getQuit(){
        return quit;
    }
    /**
     * Accessor for scan instance variable
     * @return scan instance variable
     */
    public Scanner getScan(){
        return scan;
    }
    /**
     * Asks user for a valid guess
     * Checks whether or not the guess is valid
     * If not then prompts player to enter a valid guess
     * If they enter -1 then quit is set to true
     * Otherwise adds 1 to numGuesses and returns that guess
     * @return user's guess
     */
    private int askForGuess(){
        boolean validGuess = false;
        System.out.println("Enter a guess or type -1 to quit: ");
        int guess = scan.nextInt();
        validGuess = Guess.checkGuess(guess);
        while(!validGuess){
            System.out.println("Enter a guess or type -1 to quit: ");
            guess = scan.nextInt();
            validGuess = Guess.checkGuess(guess);
        }
        if(guess==-1){
            quit = true;
        }else{
            numGuesses++;
        }
        return guess;
    }
    /**
     * Checks if the player's guess is equal to the secret number
     * If not then displays the number of apples and oranges
     * @param g user's guess
     */
    private void checkWin(int g){
        if(g!=-1){
            if(g==secret){
                win = true;
            }
            else{
                printResults(Guess.countApples(g,secret), Guess.countOranges(g,secret));
            }
        }
    }
    /**
     * Plays rounds
     * While the player hasn't quit or won the game, it will continue to ask the player for a guess
     * If that guess is correct then displays a win message that confirms the winning of that round
     * Otherwise displays a message that confirms that the player quit that round
     */
    public void play(){
        while(!win&&!quit){
            int guess = askForGuess();
            System.out.println("Your guess is: "+guess);
            checkWin(guess);
        }
        if(win){
            System.out.println("You won!!");
            System.out.println("It took you "+numGuesses+" guesses");
        }
        else{
            System.out.println("You quit :(");
            System.out.println("It took you "+numGuesses+" guesses");
        }
    }
    /**
     * Prints the result of a round
     * If no apples or oranges are counted then 'nada' is displayed
     * Otherwise displays the number of apples and oranges
     * @param apples number of apples in a guess
     * @param oranges number of oranges in a guess
     */
    private void printResults(int apples, int oranges){
        if(apples==0&&oranges==0){
            System.out.println("nada");
        }
        else{
            for(int i=0;i<apples;i++){
                System.out.println("apples ");
            }
            for(int i=0;i<oranges;i++){
                System.out.println("oranges ");
            }
        }
    }
    /**
     * Generates 5 digit number with unique digits for one round
     * @return randomly generated secret number
     */
    private int generateSecret(){
        Random rng = new Random();
        int num = rng.nextInt(90000)+10000;
        while(!Guess.hasUniqueDigits(num)){
            num = rng.nextInt(90000)+10000;
        }
        return num;
    }
}
