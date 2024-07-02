import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int attempts = 0;
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it.");

        // hints based on the random number
        System.out.println("Hints:");
        if (randomNumber % 2 == 0) {
            System.out.println("- The number is even.");
        } else {
            System.out.println("- The number is odd.");
        }

        if (randomNumber % 3 == 0 && !isPrime(randomNumber)) {
            System.out.println("- The number is divisible by 3.");
        }
        if (randomNumber % 5 == 0 && !isPrime(randomNumber)) {
            System.out.println("- The number is divisible by 5.");
        }
        if (randomNumber % 7 == 0 && !isPrime(randomNumber)) {
            System.out.println("- The number is divisible by 7.");
        }
        if (randomNumber % 10 == 0 && !isPrime(randomNumber)) {
            System.out.println("- The number is divisible by 10.");
        }
        if (isPerfectSquare(randomNumber)) {
            System.out.println("- The number is a perfect square.");
        }
        if (isFibonacci(randomNumber)) {
            System.out.println("- The number is a Fibonacci number.");
        }
        if (isPrime(randomNumber)) {
            System.out.println("- The number is a prime number.");
        }
        System.out.println();
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break; // Exit loop if guess is correct
            }

        } while (guess != randomNumber);

        scanner.close();
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private static boolean isFibonacci(int n) {
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}

