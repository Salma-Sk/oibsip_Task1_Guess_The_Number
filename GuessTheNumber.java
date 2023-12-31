import javax.swing.JOptionPane;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        int round = 1;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!");

        while (true) {
            String message = "Round " + round + "\n";
            Random random = new Random();
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            message += "A random number between " + minRange + " and " + maxRange + " has been generated.\n";

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                String guessStr = JOptionPane.showInputDialog(null, message + "Enter your guess:");
                int guess = Integer.parseInt(guessStr);
                attempts++;

                if (guess == targetNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    message = "Your guess is lower than the generated number.\n";
                } else {
                    message = "Your guess is higher than the generated number.\n";
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you didn't guess the number. The correct number was: " + targetNumber);
            }

            JOptionPane.showMessageDialog(null, "Round " + round + " ended. Your current score is: " + score);

            int option = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                break;
            }

            round++;
        }

        JOptionPane.showMessageDialog(null, "Game over! Your final score is: " + score);
    }
}