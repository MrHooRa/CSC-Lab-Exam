/*
 * 
 * Salman Alessa
 * UID: 439100011
 * 
 */
import java.util.Scanner;
public class Q2 {

	//Static input
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Ask user to enter the number of students (most be 5 or more)
        System.out.print("Enter the number of students (5 or more): ");
        int stNum = input.nextInt();

        // If user entered number less than 5
        while(stNum < 5) {
	        System.out.println("ERROR: Number of students must be 5 or more");
	        System.out.print("Enter the number of students: ");
	        stNum = input.nextInt();
        }

        // if stNum is more 5 or more!
        // New array A size = stNum
        int[] A = new int[stNum];
        
        // Count array A
        // Ask the user to enter their marks
        // Add their marks into array A
        System.out.print("Enter their marks: ");
        for(int count = 0; count < A.length; count++) {
            A[count] = input.nextInt();
        }
        
        // The maximum
        // Start from first value
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
        	if(A[i] > max)
        		max = A[i];
        }
        
        // Print maximum value in array A
        System.out.println("The maximum is: " + max);
        
        
        // The average
        double average;
        int total = 0;
        for(int i = 0; i < A.length; i++) {
        	total += A[i];
        }
        
        average = total / A.length;
        
        // Print average value
        System.out.println("The average is: " + average);
        
        
        // Even numbers 
        System.out.print("Even: ");
        for(int i = 0; i < A.length; i++) {
        	if(A[i] % 2 == 0)
        		System.out.print(A[i] + ", ");
        }
        
        // Line
        System.out.println();
        
        // Odd numbers 
        System.out.print("Odd: ");
        for(int i = 0; i < A.length; i++) {
        	if(A[i] % 2 != 0)
        		System.out.print(A[i] + ", ");
        }
        
        // Line
        System.out.println();
        
        // The number of students above the average
        int counter = 0;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] > average)
        		counter++;
        }
        
        // Print
        System.out.println("The number of student above the avarage (" + average + ") is: " + counter);
        
        
        // Print student marks above the average (By using array B)
        int[] B = new int[counter];
        
        System.out.print("B: ");
        
        // By using array A
        counter = 0;
        for(int i = 0; i < A.length; i++) {
        	if(A[i] > average) {
        		System.out.print(A[i] + ", ");
        		B[counter] = A[i];
        		counter++;
        	}
        }
        
        // The minimum
        // By using max variable
        int min = B[0];
        for(int i = 1; i < B.length; i++) {
        	if(B[i] < min)
        		min = B[i];
        }
        
        // Line
        System.out.println();
        
        // Print the minimum
        System.out.println("The minimum in B: " + min);
        
	}

}