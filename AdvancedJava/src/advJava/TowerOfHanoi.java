package advJava;

import java.util.Scanner;


public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number of disks: ");
		
		int n = input.nextInt();
		
		System.out.println("The moves are: ");
		
		moveDisks(n, 'A', 'B', 'C');

	}
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		 if ( n == 1)
			 System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);		 
		 	else
		 {
			 moveDisks(n - 1, auxTower, toTower, fromTower);
			 System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			 
			 moveDisks(n - 1, auxTower, toTower, fromTower);
		 }
		
	}

}
