/**Author: Gregory Feng
 * Filename: Lab5.java
 * Specification: Code that uses loops to print Rows, Pyramids, and Diamonds given the middle character, side character, side length, middle
 * length, height, and the amount of symbols in the middle row depending on user input.
 * For: CSE 110-Lab5
 * Time Spent: 40 minutes
 */
import java.util.*;
public class Lab5 {
	public static void main(String[] args) {
		//variable definitions
		Scanner scanner = new Scanner(System.in);
		String shape;
		boolean running = true;
		final char sideChar='-',midChar='*';
		int sideLength,midLength,height;
		while(running) {
			System.out.println("What shape would you like to create?[r/p/d/q]");
			shape=scanner.next().toUpperCase();
			switch(shape) {
			//Builds a row with side characters as '-' and middle characters as '*'.
			case "R":
				System.out.println("What would you like the side length to be?");
				sideLength=scanner.nextInt();
				System.out.println("What would you like the middle length to be?");
				midLength=scanner.nextInt();
				buildRow(sideChar,midChar,sideLength,midLength);
				break;
			//Builds a pyramid with side characters as '-' and middle characters as '*'.
			case "P":
				System.out.println("What would you like the amount of symbols in the lowest row of the pyramid to be?");
				height=scanner.nextInt();
				buildPyramid(sideChar,midChar,height);
				break;
			//Builds a diamond with side characters '*' and middle characters as ' '.
			case "D":
				System.out.println("What would you like the amount of symbols in the middle row of the diamond to be?");
				height=scanner.nextInt();
				buildDiamond('*',' ',height);
				break;
			//Quit function
			case "Q":
				running=false;
				break;
			//Input validation
			default:
				System.out.println("Invalid input !");
				break;
			}
		}
		
	}
	//Builds a row
	static void buildRow(char sideSymb,char midSymb,int sideLength,int midLength) {
		//First section of side characters
		for(int i=0;i<sideLength;i++) {
			System.out.print(sideSymb);
		}
		//Middle section of middle characters
		for(int i=0;i<midLength;i++) {
			System.out.print(midSymb);
		}
		//Last section of side characters
		for(int i=0;i<sideLength;i++) {
			System.out.print(sideSymb);
		}
		//Goes to the next line.
		System.out.print("\n");
	}
	static void buildPyramid(char sideSymb,char midSymb,int height) {
		//Only works with odd numbered digits and according to the assignment page, must round down if even.
		if(height%2==0) {
			height=height-1;
		}
		//Converts from number of symbols to height of the pyramid because that is how I originally wrote the method
		height=height/2+1;
		//Nested for loops to increase efficiency
		for(int i=1;i<=height;i++) {
			//First part of pyramid w/ side characters
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			//Middle part of pyramid w/ middle characters
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			//Middle of pyramid
			System.out.print(midSymb);
			//Other middle part of pyramid w/ middle characters
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			//Last part of pyramid w/ side characters
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			System.out.print("\n");
		}
	}
	static void buildDiamond(char sideSymb,char midSymb,int height) {
		//Converts to rounding down to the first odd number according to assignment rules
		if(height%2==0) {
			height=height-1;
		}
		//Converts from number of symbols to height of the pyramid
		height=height/2+1;
		//Took the code from the pyramid for the top half
		for(int i=1;i<=height;i++) {
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			System.out.print(midSymb);
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			System.out.print("\n");
		}
		//Used the pyramid code and inverted the outer for loop for the bottom half
		for(int i=height-1;i>=1;i--) {
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			System.out.print(midSymb);
			for(int j=0;j<i-1;j++) {
				System.out.print(midSymb);
			}
			for(int j=height-i-1;j>=0;j--) {
				System.out.print(sideSymb);
			}
			System.out.print("\n");
		}
	}
	
}
