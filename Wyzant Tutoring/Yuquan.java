import java.util.ArrayList;

public class Yuquan {


		public static void base5(int x, int i) { 
            int sum = 0;
            if(x < 5) {
                            System.out.print(x);                                       
            }
            else if(i < 10) {
                            int digit = x % 5;
                            sum += digit * Math.pow(10, i);
                            base5(x/5, i++);
            }
            //else if(i >= 10) {                              
            System.out.print(sum);
            //}
}

		

	


		



	public static void printWithCommas(int x, int placevalue, int xcopy) {
		if(xcopy < 1000) {
			System.out.print(x);
		}
		else if(x > 0){
			int digit = x % 10;
			x /= 10;

			if(placevalue % 3 == 0) {
				System.out.print(digit + ",");
			}
			else {
				System.out.print(digit);
			}
			placevalue++;

			printWithCommas(x, placevalue, xcopy);
		}
	}
	
	public static void main(String[] args) {
		base5(136,5);
		



	}
}

	
	

