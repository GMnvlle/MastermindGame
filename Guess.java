/**
 * Each guess is checked whether or not it is a valid guess
 * If it is then apples and oranges will be counted
 * Apples are when the user correctly guesses the exact digit in the exact place
 * Oranges are when the user correctly guesses a digit but in the wrong place
 * Also checks whether or not a number has unique digits
 */
public class Guess
{
    /**
     * Checks if the guess is valid or not
     * If it has 5 unique digits, then returns true
     * Otherwise returns false and displays that the user must enter 5 unique digits
     * @param g user's guess
     * @return true or false whether or not it is a valid guess
     */
    public static boolean checkGuess(int g){
        if((String.valueOf(g).length()!=5||!hasUniqueDigits(g))&&g!=-1){
            System.out.println("Error – guess must have 5 unique digits");
            return false;
        }
        return true;
    }
    /**
     * Counts the number of apples in a guess
     * @param guess user's guess
     * @param secret number user is trying to guess
     * @return number of apples
     */
    public static int countApples(int guess, int secret){
        int apples = 0;
        String guessStr = String.valueOf(guess);
        String secretStr = String.valueOf(secret);
        for(int i=0;i<secretStr.length();i++){
            if(guessStr.substring(i,i+1).equals(secretStr.substring(i,i+1))){
                apples++;
            }
        }
        return apples;
    }
    /**
     * Counts the number of oranges in a guess
     * @param guess user's guess
     * @param secret number user is trying to guess
     * @return number of oranges
     */
    public static int countOranges(int guess, int secret){
        int oranges = 0;
        String guessStr = String.valueOf(guess);
        String secretStr = String.valueOf(secret);
        
        for(int i=0;i<secretStr.length();i++){
            if(!guessStr.substring(i,i+1).equals(secretStr.substring(i,i+1))){   
                for(int j=0;j<secretStr.length();j++){
                    if(guessStr.substring(i,i+1).equals(secretStr.substring(j,j+1))){
                        oranges++;
                    }
                }
            }
        }
        return oranges;
    }
    /**
     * Checks if a number has unique digits or not
     * @param num number we're trying to check
     * @return true or false whether or not that number has unique digits
     */
    public static boolean hasUniqueDigits(int num){
        String numStr = String.valueOf(num);
        for(int i=0;i<numStr.length();i++){
            String currDigit = numStr.substring(i,i+1);
            for(int j=0;j<numStr.length();j++){
                if(j!=i){
                    if(currDigit.equals(numStr.substring(j,j+1))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}