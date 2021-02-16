/*
 * Class: CMSC203 
 * Instructor:Griegory Grinberg
 * Description: present the user a movie summery
 * Due: 2/15/2021
 * Platform/compiler: eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emmanuel Abebe
*/

package packages;

import java.util.Scanner;

public class MovieDriver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		
		String check;
		do {
			System.out.println("Enter the name of a movie: ");
			String title = input.next();
			movie.setTitle(title);
			
			System.out.println("Enter the rating of the movie: ");
			String rating = input.next();
			movie.setRating(rating);
			
			System.out.println("Entekr the number of tickets sold for this movie: ");
			int soldTickets = input.nextInt();
			movie.setSoldTickets(soldTickets);
			
			System.out.println(movie.toString());
			
			System.out.println("Do you want to enter another movie? (y/n)");
			check = input.next();
			
		} while (check.equals("y"));
		System.out.println("Goodbye");
	}
}
