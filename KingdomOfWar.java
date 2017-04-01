//============================================================================
// Name        : KingdomOfWar
// Author      : Anup Wadhekar
// Version     :
// Copyright   : Your copyright notice
/* Description : Two kingdoms are at war. Kingdom 1 has N soldiers (numbered as 1 to N) and the war goes on for K days. Each day only one soldier from each kingdom fights. 

Kingdom 1 can select one soldier from soldier number Ni to Nj. Ni and Nj are provided to you for each day.

Selection criteria: Each soldier has 2 parameters - A & B. A soldier is/are selected if A is max. If more than one soldier has A max then the soldier with min. B (of the shortlisted soldiers) is/are selected. If more than one soldier is still available, then the soldier with least index (of the shortlisted soldiers) is selected.
Print the soldier number selected for each day of the war.

Input: 
Line 1 contains number of soldiers of Kingdom1 => N
Line 2 contains N space-separated values of A
Line 3 contains N space-separated values of B
Line 4 contains number of days fight goes on => K
Next K lines contain space separated values of Ni and Nj

Output: 
K lines contain soldier number selected for each day of the war.

Sample Input:
10
2 5 3 7 9 2 9 8 7 15
5 2 1 8 3 1 2 9 0 5
3
1 5
3 8
4 10

Result:
5
7
10
============================================================================*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class KingdomOfWar {
 /* Function war() to select soldier number based on given input values*/
	Integer war(int numberOfSoldiers,int numberOfDays,ArrayList<Integer> valuesofA,ArrayList<Integer> valuesofB,ArrayList<Integer> range)
	{
		int j,ind=0; // Temporary variables
		ArrayList<Integer> indexarr1 = new ArrayList<Integer>();  // Temporary Arraylist for storing intermediate results
		ArrayList<Integer> indexarr2 = new ArrayList<Integer>();  // Temporary Arraylist for storing intermediate results
		int m=range.get(0)-1;
		Integer MAX = valuesofA.get(m);
		//System.out.println("Inside war() function -range.get(0)-1)="+m);
		/* To calculate maximum value amongs values of A(i.e valuesofA) */
		for(j=(range.get(0)-1);j<range.get(1);j++)
		{
			if(valuesofA.get(j)>MAX)
				MAX=valuesofA.get(j);
		}
		//System.out.println("Maximum value of A="+MAX);
		/* To check if A has more than one entry maximum values */
		for(j=(range.get(0)-1);j<range.get(1);j++)
		{
			//System.out.println("entered to check duplicate MAX values");
			if(valuesofA.get(j)==MAX)
				indexarr1.add(j);
				
		}
		//System.out.println("indexarr1="+indexarr1);
		/* If A has more than one entry for maximum value,checking minimum value in B */
		if(indexarr1.size()>1)
		{
			//System.out.println("entered if loop when more than 1 value have max value");
			Integer MIN=valuesofB.get(indexarr1.get(0));
			//System.out.println("valuesofB.get(indexarr1.get(0)):"+MIN);
			/*Checking minimum value in B (i.e valuesofB) */
			for(j=1;j<indexarr1.size();j++)
			{
				if(valuesofB.get(j)<MIN)
				{
					MIN=valuesofB.get(j);
					ind = indexarr1.get(j);
				}
			}
			//System.out.println("Minimum value of B:"+MIN+" and soldier number is ="+(ind+1));
			/* To check if B has more than one entry for minimum value*/
			for(j=0;j<indexarr1.size();j++)
			{
				//System.out.println("entered to check duplicate MIN values");
				if(valuesofB.get(indexarr1.get(j))==MIN)
					indexarr2.add(indexarr1.get(j));
					
			}
			//System.out.println("indexarr2:"+indexarr2);
			/* If B has more than one entry for minimum value,least index among them */
			if (indexarr2.size()>1)
			{
				//System.out.println("entered if loop when more than 1 value have min value");
				Collections.sort(indexarr2);
				//System.out.println("returning:"+indexarr2.get(0));
				return indexarr2.get(0);
				
			}
			else
			{
				//System.out.println("returning:"+indexarr2.get(0));
				return indexarr2.get(0);
			}
		}
		else
		{
			//System.out.println("final else");
			return valuesofA.indexOf(MAX);
		}
		 
	}
	/* Main function starts*/
	public static void main(String[] args) {
		int numberOfSoldiers,numberOfDays;
		KingdomOfWar kowObject;
		ArrayList<Integer> range,valuesofA,valuesofB;
		System.out.println("Enter the number of soldiers of the Kingdom:");
		Scanner sc= new Scanner(System.in);
	    numberOfSoldiers=sc.nextInt();
	    System.out.println("Enter the number of days of wars:");
	    numberOfDays=sc.nextInt();
	    System.out.println("Enter the values of A for "+ numberOfSoldiers+" soldiers:");
	    valuesofA = new ArrayList<Integer>();
	    for(int i=0;i<numberOfSoldiers;i++)
	    {
	    	valuesofA.add(sc.nextInt());
	    }
	    System.out.println("Enter the values of B for "+ numberOfSoldiers+" soldiers:");
	    valuesofB = new ArrayList<Integer>();
	    for(int i=0;i<numberOfSoldiers;i++)
	    {
	    	valuesofB.add(sc.nextInt());
	    }
	    for(int k=1;k<=numberOfDays;k++)
	    {
	    	System.out.println("Enter the range to select a soldier from: for day "+k);
	    	range = new ArrayList<Integer>();
	    	range.add(sc.nextInt());
	    	range.add(sc.nextInt());
	    	kowObject = new KingdomOfWar();
	    	Integer selectedSoldier=kowObject.war(numberOfSoldiers,numberOfDays,valuesofA,valuesofB,range);
	    	//System.out.println("recieved in main:"+selectedSoldier);
	    	selectedSoldier++;
	    	System.out.println("Soldier selected for day "+k+ " is "+selectedSoldier);
	    }
	}

}
