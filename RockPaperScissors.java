import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (rock, paper, or scissors):");
        String userChoice = scanner.nextLine().toLowerCase();

        if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
            System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
            return;
        }

        int computerChoiceIndex = random.nextInt(3); // 0 for rock, 1 for paper, 2 for scissors
        String[] choices = {"rock", "paper", "scissors"};
        String computerChoice = choices[computerChoiceIndex];

        System.out.println("Computer chooses: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (userChoice.equals("rock") && computerChoice.equals("scissors")
                || userChoice.equals("paper") && computerChoice.equals("rock")
                || userChoice.equals("scissors") && computerChoice.equals("paper")) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Sorry! Computer wins!");
        }

        scanner.close();
    }
}
