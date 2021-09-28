/**Author: Gregory Feng
 * Filename: Lab5.java
 * Specification: Code that uses loops to print Rows, Pyramids, and Diamonds given the middle character, side character, side length, middle
 * length, height, and the amount of symbols in the middle row.
 * For: CSE 110-Lab5
 * Time Spent: 40 minutes
 */
import java.util.*;
public class Lab5 {
	//BYAC 190 ASU 101 class
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String shape;
		boolean running = true;
		final char sideChar='-',midChar='*';
		int sideLength,midLength,height;
		while(running) {
			System.out.println("What shape would you like to create?[r/p/d/q]");
			shape=scanner.next().toUpperCase();
			switch(shape) {
			case "R":
				System.out.println("What would you like the side length to be?");
				sideLength=scanner.nextInt();
				System.out.println("What would you like the middle length to be?");
				midLength=scanner.nextInt();
				buildRow(sideChar,midChar,sideLength,midLength);
				break;
			case "P":
				System.out.println("What would you like the amount of symbols in the lowest row of the pyramid to be?");
				height=scanner.nextInt();
				buildPyramid(sideChar,midChar,height);
				break;
			case "D":
				System.out.println("What would you like the amount of symbols in the middle row of the diamond to be?");
				height=scanner.nextInt();
				buildDiamond('*',' ',height);
				break;
			case "Q":
				running=false;
				break;
			default:
				System.out.println("Invalid input !");
			}
		}
		
	}
	static void buildRow(char sideSymb,char midSymb,int sideLength,int midLength) {
		for(int i=0;i<sideLength;i++) {
			System.out.print(sideSymb);
		}
		for(int i=0;i<midLength;i++) {
			System.out.print(midSymb);
		}
		for(int i=0;i<sideLength;i++) {
			System.out.print(sideSymb);
		}
		System.out.print("\n");
	}
	static void buildPyramid(char sideSymb,char midSymb,int height) {
		if(height%2==0) {
			height=height-1;
		}
		//Converts from number of symbols to height of the pyramid
		height=height/2+1;
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
	}
	static void buildDiamond(char sideSymb,char midSymb,int height) {
		if(height%2==0) {
			height=height-1;
		}
		height=height/2+1;
		//Converts from number of symbols to height of the pyramid
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
