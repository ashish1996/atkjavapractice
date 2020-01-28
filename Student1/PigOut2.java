
 import java.util.Scanner;
 
 public class PigOut2
 {

	
	 public static void main(String[] args)
	 {
		printOutput();
	 }
	 public static String getData()
	 {
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("What food would you like to eat? (\"Type I'm full\" to terminate) --> ");
		 String food=input.nextLine();
		 return food;
	 }
	 public static void printOutput()
	 {
		 	
		 String food = getData();
		 int numberOfLetters = food.length();
		 String noise="nom ";
		 String noise3="nom nom nom nom nom burp";
		 
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
			 System.out.print(noise);
		 }
		 System.out.println();
		 printOutput();
		 }
	 }
 }