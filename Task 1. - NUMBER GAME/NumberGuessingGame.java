import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int lower_Bound = 1;
        int upper_Bound = 100;
        int secret_Number = ra.nextInt(upper_Bound - lower_Bound + 1) + lower_Bound;
        int max_Attempts = 10;
        int attempts = 0;

        while (attempts < max_Attempts) {
            System.out.print("Guess the number between " + lower_Bound + " and " + upper_Bound + ": ");
            int user_Guess = sc.nextInt();
            attempts++;

            if (user_Guess == secret_Number) {
                System.out.println("Congratulations! You guessed the number " + secret_Number + " in " + attempts + " attempts.");
                break;
            } else if (user_Guess < secret_Number) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (attempts >= max_Attempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + secret_Number + ".");
        }

        sc.close();
    }
}
