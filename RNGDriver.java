/*
 * Class: CMSC203 
 * Instructor: Professor_Eivazi
 * Description:  Build an application that will receive a guess and report if your guess is the random number that was generated.  
 Your application will narrow down the choices according to your previous guesses and continue to prompt 
 you to enter a guess until you guess correctly. 
 * Due: 2/23/2021
 * Platform/compiler: 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kamyavalli_Mopidevi.
*/

import java.util.Scanner;

public class RNGDriver {
	
	public static void main (String[] args) {
		Scanner keyboard= new Scanner (System.in);
     //   RNG rng= new RNG();
		
		int randNum, nextGuess, lowGuess, highGuess;
		String choice = "";
		
		
		do{
			// reset everything
			RNG.resetCount();
			lowGuess = 0;
			highGuess = 100;
			 
			// generate a new number
			randNum = RNG.rand();
			
			
			
			//check if guess is between low and high guess number
			do{
				if(RNG.getCount() == 0)
					System.out.println("Enter your first guess");
				else
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				
				nextGuess = keyboard.nextInt();//get the number
				
				if(!RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
					System.out.println("Enter your next guess between " + nextGuess + " and " + highGuess);
					//System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					continue;
				}else {
					if(nextGuess == randNum) {
						System.out.println("Number of guesses is " + RNG.getCount());
						System.out.println("Congratulations, you guessed correctly");
					}
					else if(nextGuess > randNum) {
						System.out.println("Number of guesses is " + RNG.getCount());
						System.out.println("Your guess is too high");
						//highGuess = nextGuess;
					}
					else {
						System.out.println("Number of guesses is " + RNG.getCount());
						System.out.println("Your guess is too low.");
						//lowGuess = nextGuess;
					}
				}
			}while(nextGuess != randNum);
			System.out.println("Try again? (yes or no)");
			choice = keyboard.next();
		}while(choice.equalsIgnoreCase("yes"));
		System.out.println("Thanks for playing...");
	}
}
		