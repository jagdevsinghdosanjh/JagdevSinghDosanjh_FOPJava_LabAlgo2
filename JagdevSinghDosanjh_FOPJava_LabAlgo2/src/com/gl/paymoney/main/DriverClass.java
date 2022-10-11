/*Problem No 1: (Marks 8)
 * PayMoney processes thousands of transactions daily amounting to crores of Rupees. They also have
 * a daily target that they must achieve. Given a list of transactions done by PayMoney and a daily
 * target, your task is to determine at which transaction PayMoney achieves the same. If the target
 * is not achievable, then display the target is not achieved.
 * 
 */
package com.gl.paymoney.main;

import java.util.Scanner;

public class DriverClass {

    private static int getNoOfTransactions(int[] transArray, int target) {
	int sum = 0;
	for (int i = 0; i < transArray.length; i++) {
	    sum += transArray[i];

	    if (sum >= target) {
		return i + 1;
	    }
	}
	return -1;
    }

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

	System.out.println("Enter the size of transaction array");
	int noOfTransaction = s.nextInt();
	int[] transArray = new int[noOfTransaction];
	System.out.println("Enter the values of array");
	for (int i = 0; i < noOfTransaction; i++) {
	    transArray[i] = s.nextInt();
	}
	
	System.out.println("Enter the total no of targets that needs to be achieved");
	int noOfTargets = s.nextInt();

	for (int i = 0; i < noOfTargets; i++) // input targets
	{
	    System.out.println("Enter the value of target " + (i + 1));
	    int target = s.nextInt();
	    int transCount = getNoOfTransactions(transArray, target);
	    if (transCount < 0) {
		System.out.println("Given target is not achieved");
	    } else {
		System.out.println("Target achieved after " + transCount + " transactions");
	    }

	}
	s.close();
    }

}