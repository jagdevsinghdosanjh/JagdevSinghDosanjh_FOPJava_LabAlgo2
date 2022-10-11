/*Problem No 2: (Marks 12) 
 * You are a traveler and traveling to a country where the currency denomination are unknown and 
 * as you travel you get to know about the denomination in random order. You want to make a payment
 * of amount x, in such a way that the the higher denomination is used to make exact payment.
 * 
 */
package com.gl.notescounter.main;

import java.util.Scanner;

import com.gl.notescounter.util.ArrayUtil;

public class DriverClass {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations");
		int numberOfDenominations = s.nextInt();
		
		int [] arrDenominations = new int[numberOfDenominations];
		System.out.println("Enter the currency denominations value");
		for(int i = 0; i< numberOfDenominations; i++)
		{
			arrDenominations[i] = s.nextInt();
		}
		
		ArrayUtil.mergeSort(arrDenominations);
		int [] counter = new int[numberOfDenominations];

		
		System.out.println("Enter the amount you want to pay");
		int amountToPay = s.nextInt();
		
		int remainingAmount = countNotes(arrDenominations, counter, 0, numberOfDenominations - 1, amountToPay);
		
		if (remainingAmount > 0)
		{
			System.out.println("Amount cannot be paid in give denominations!");
		}
		else
		{
		    System.out.println("Your payment approach in order to give min no of notes will be");
			//for(int i = numberOfDenominations-1; i>=0; i--)
			for(int i = 0; i<=numberOfDenominations-1; i++)
			{
				if(counter[i] != 0)
				{
					//System.out.println("Denomination of " + arrDenominations[i] + ":" + counter[i]);
				    System.out.println(arrDenominations[i] + " x " + counter[i]+" = "+arrDenominations[i]*counter[i]);
				}
			}
			s.close();		
		}
	}
	

public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay )
{
	if (amountToPay == 0)
	{
		return 0;
	}
	if (amountToPay < arrDenominations[0])
	{
		return amountToPay;
	}
	
	
	if(amountToPay >= arrDenominations[high])
	{
		counter[high] = amountToPay / arrDenominations[high];
		amountToPay %= arrDenominations[high];
		//return countNotes(arrDenominations, counter, 0, high-1, amountToPay);
		//high-1 in line 72 instead of high in line 73 throwing exception to d1=6, d1d2=16, d1d2=26,...d1d2d36 
		//Try this code by uncommenting line 72 and commenting line 73
		//Discuss why it is happening
		return countNotes(arrDenominations, counter, 0, high, amountToPay);
	}
	int mid = (low+high)/2;
	if(amountToPay <= arrDenominations[mid])
	{
		return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
	}
	return countNotes(arrDenominations, counter, 0, high-1, amountToPay);
}
}
