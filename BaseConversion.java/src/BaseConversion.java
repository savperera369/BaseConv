// Base Conversion Program
// Created by Saviru Perera-260966369
// The code below, as well as the code for the methods
// was taken from ECSE 202, Winter 2021, Assignment 1

import acm.program.*;
public class BaseConversion extends ConsoleProgram {
	public void run() {
		println("This is a base conversion program that converts positive integers to a target base.");
		println("Enter number to be converted and target base on seperate lines following the prompt");
		println("A blank input for either input terminates the program.");
		
		while(true) {
			String integerString = readLine("Enter a Positive Integer String: "); // prompt user to enter a number in the form of a string
			if (integerString.equals("")) {
				println("Program Terminated.");
				break; // terminate program if blank input
			}
			int number = String2Int(integerString); // convert string input to integer form
			if (number<0) {
				println("Error! " + integerString + " does not correspond to a positive integer!"); // error check - output error message if number is not positive
			}
			else {
				integerString = readLine("Enter a target base: "); // prompt user to enter a string for a desired base
				if (integerString.equals("")) {
					println("Program Terminated."); // terminate program if blank input
					break;
				}
				int targetBase = String2Int(integerString); // convert string for base into an integer
				if (targetBase<2||targetBase>16) {
					println("The target base must be between 2 and 16 inclusive."); // error message if the value for base does not fall between 2 & 16 inclusive
				} 
				else {
					String result = baseConv(number,targetBase); // convert number from earlier into its representation in the desired base
					println(number + " expressed in base " + targetBase + " is " + result); // display string in the console
				}
			}
		}
	}
	
	private int String2Int(String input) { // method to convert a string input into its integer form
		int sum = 0; // set sum counter to 0
		int powerOfTen = 1; // set power of 10 counter to 1
		for (int i=input.length()-1; i>=0; i--) { // loop from last character in string to the first
				int conv = input.charAt(i)-'0'; // convert character to its integer form
				if (conv<0 || conv>9) return -1; // return -1 if character does correspond to a positive integer in [0,9]
				conv*=powerOfTen; // multiply integer by its power of 10
				sum+=conv; // add result of previous line to sum counter
				powerOfTen*=10; // multiply power of 10 by 10
			}
		return sum; // return the string in its integer form
	}
	
	private String baseConv(int num, int base) { // method to convert a number to its desired base, output a string
		String outputString = ""; // set string counter to an empty string
		String LUT = "0123456789ABCDEF"; // character string which is a convenient tool to convert numbers from 0-15 to their desired form
		while(num>0) { // loop while the input number is still greater than 0
			int digit = num%base; // this loop adds the digits of the output string to the empty string counter
			num/=base;
			outputString=LUT.charAt(digit)+outputString;
		}
		return outputString; // returns the number in its desired base in string form
	}
}
