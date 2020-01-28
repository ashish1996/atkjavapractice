/***********
 * Leia Phipps
 * 11/1/17
 * PigOut.java
 **********/
 import java.util.Scanner;
 
 public class PigOut
 {
	 static String food;
	 static String noise;
	 static String noise2;
	 static int x;
	 
	 public PigOut()
	 {
		 food="";
		 noise="";
		 noise2="";
		 x=5;
	 }
	 public static void main(String[] args)
	 {
		printOutput();
	 }
	 public static void getData()
	 {
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("What food would you like to eat? (\"Type I'm full\" to terminate) --> ");
		 food=input.nextLine();
	 }
	 public static void printOutput()
	 {
		 int numberOfLetters = food.length();
		 noise="nom";
		 noise2="burp";
		 String noise3="nom nom nom nom nom burp";
		 x=numberOfLetters;
		 
		 if (food.equalsIgnoreCase("I'm full"))
		 {
			 System.out.print("\n\n\n");
			 
		 }
		 else
		 {
		 int numberOfFives= numberOfLetters/5;
		 int leftovers = numberOfLetters%5;
		 for (int i = 0; i<numberOfFives; i++) {
			 System.out.println(noise3);
		 }
		 for (int j =0; j<leftovers; j++) {
			 System.out.println(noise);
		 }
		 getData();
		 }
	 }
 }
	 