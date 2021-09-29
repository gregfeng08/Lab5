/**Author: Gregory Feng
 * Filename: Lab5.java
 * Specification: Code that uses loops to print Rows, Pyramids, and Diamonds given the middle character, side character, side length, middle
 * length, height, and the amount of symbols in the middle row depending on user input.
 * For: CSE 110-Lab5
 * Time Spent: 30 minutes
 */
import java.util.*;
public class Lab5 {
	public static void main(String[] args) {
		//variable definitions
		Scanner scanner = new Scanner(System.in);
		char shape;
		boolean running = true;
		final char sideChar='-',midChar='*';
		int sideLength,midLength,height;
		//Keep the code running unless the user enters q
		while(running) {
			System.out.println("What shape would you like to create?[r/p/d/q]");
			shape=scanner.next().toUpperCase().charAt(0);
			switch(shape) {
			//Builds a row with side characters as '-' and middle characters as '*'.
			case 'R':
				System.out.println("What would you like the side length to be?");
				sideLength=scanner.nextInt();
				System.out.println("What would you like the middle length to be?");
				midLength=scanner.nextInt();
				buildRow(sideChar,midChar,sideLength,midLength);
				break;
			//Builds a pyramid with side characters as '-' and middle characters as '*'.
			case 'P':
				System.out.println("What would you like the amount of symbols in the lowest row of the pyramid to be?");
				height=scanner.nextInt();
				buildPyramid(sideChar,midChar,height);
				break;
			//Builds a diamond with side characters '*' and middle characters as ' '.
			case 'D':
				System.out.println("What would you like the amount of symbols in the middle row of the diamond to be?");
				height=scanner.nextInt();
				buildDiamond('*',' ',height);
				break;
			//Quit function
			case 'Q':
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
	//Builds a pyramid with the buildRow function
	static void buildPyramid(char sideSymb,char midSymb,int height) {
		//If the input is an even number use the first odd number below
		if(height%2==0) {
			height-=1;
		}
		//Conversion from initially calculated height to number of symbols
		height=height/2+1;
		//Uses a for loop to build a pyramid
		for(int i=0;i<height;i++) {
			buildRow(sideSymb,midSymb,height-i-1,2*i+1);
		}
	}
	//Builds a diamond with the buildRow function
	static void buildDiamond(char sideSymb,char midSymb,int height) {
		//If the input i san even number use the first odd number below
		if(height%2==0) {
			height-=1;
		}
		//Conversion from height of the pyramid to number of symbols in the row
		height=height/2+1;
		//Builds the pyramid using buildRow
		for(int i=0;i<height-1;i++) {
			buildRow(sideSymb,midSymb,height-i-1,2*i+1);
		}
		//Inverts the outer for loop to build the inverted pyramid
		for(int i=height-1;i>=0;i--) {
			buildRow(sideSymb,midSymb,height-i-1,2*i+1);
		}
	}
}
