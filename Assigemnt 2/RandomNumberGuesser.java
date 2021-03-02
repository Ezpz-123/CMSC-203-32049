package packages;

/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: a simple game that asks the user to guess a random number b/n 0 and 100
 * Due: 2/23/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emmanuel Abebe
*/



import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer = null;  // variable that contorls the main loop
		
		do {
			int rand = RNG.rand(); // a random number is generated
			int guess, lower_limit = 0, upper_limit = 100; 	
			System.out.println("Enter your first guess b/n " + lower_limit + " and " + upper_limit);
			guess = scan.nextInt();
			
			RNG.inputValidation(guess, lower_limit, upper_limit); // checks if the currnent guess is in range
			System.out.println("Number of guesses " + RNG.getCount()); // display the number of guesses so far
			
			if (guess > rand) {
				if (guess < upper_limit) upper_limit = guess;
				System.out.println("your guess is too high");
			
			} else if (guess < rand) {
				if (guess > lower_limit) lower_limit = guess;
				System.out.println("Your guess is too low");
			
			}
			
			while(guess != rand) {
				System.out.println("\nEnter your next guess b/n " + lower_limit + " and " + upper_limit);
				guess = scan.nextInt();
				
				RNG.inputValidation(guess, lower_limit, upper_limit);// checks if the currnent guess is in range
				System.out.println("Number of guesses " + RNG.getCount());// display the number of guesses so far
				
				if (guess > rand) {
					if (guess < upper_limit) upper_limit = guess;
					System.out.println("your guess is too high");
				
				} else if (guess < rand) {
					if (guess > lower_limit) lower_limit = guess;
					System.out.println("Your guess is too low");
				
				}
			}
				
			System.out.println("Congratulations, you guessed correctly");
			
			System.out.println("Try again? (yes or no)\n"); 
			answer = scan.next();
			
		} while (answer.equals("yes"));
		
		System.out.println("Thanks for playing"); // end of program
		
	}

}
