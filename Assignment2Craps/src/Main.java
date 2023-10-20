import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        String playAgain;
        int diceroll1;
        int diceroll2;
        int sum;
        int point;

        boolean doneA = false;

        do {
            System.out.println("Time to begin the game!");
            if (in.hasNext()) {
                diceroll1 = rnd.nextInt(6) + 1;
                diceroll2 = rnd.nextInt(6) + 1;
                sum = diceroll1 + diceroll2;
                System.out.println("Your result of the dice rolls was a " + diceroll1 + " and a " + diceroll2 + " which combined for " + sum);
                if (sum == 2 || sum == 3 || sum == 12) {
                    System.out.println("Oops! You crapped out!");
                    doneA = true;
                } else if (sum == 7 || sum == 11) {
                    System.out.println("Natural! You win!");
                    doneA = true;
                } else {
                    System.out.println("'The Point' is now: " + sum);
                    point = sum;
                    while (true) {
                        diceroll1 = rnd.nextInt(6) + 1;
                        diceroll2 = rnd.nextInt(6) + 1;
                        sum = diceroll1 + diceroll2;
                        System.out.println("Your result of the dice rolls was a " + diceroll1 + " and a " + diceroll2 + " which combined for " + sum);
                        if (sum == point) {
                            System.out.println("You matched the point, you win!");
                            doneA = true;
                            break;
                        } else if (sum == 7) {
                            System.out.println("You threw in a 7! You lose!");
                            doneA = true;
                            break;
                            // had to look this up to break the loop since it kept indefinitely repeating
                        }
                    }
                }
            }
            System.out.println("Would you like to play this again? [Y/N]: ");
            playAgain = in.next();
            in.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));
    }
}
