package com.sei.problems.first;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class DeDup {

	public static void main(String[] args) {
		int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
	            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
	            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   	
		
	
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println( "Duplicate Array: ");
		printIntArray(randomIntegers);
		System.out.println("\n--------------------------------------------------------------------------------------------");
		
		System.out.println( "Unique Elements using HashSet: ");
		printIntArray(deDupWithHashSet(randomIntegers));
		System.out.println("\n--------------------------------------------------------------------------------------------");
		
		System.out.println( "Unique Elements using Quick sort: ");
		printIntArray(deDupBySorting(randomIntegers));
		System.out.println("\n--------------------------------------------------------------------------------------------");
		
		System.out.println( "Unique Elements and preserving the original array order using a string object: ");
		printIntArray(deDupAndPreserveOrgiOrderUsingStringObj(randomIntegers));
		System.out.println("\n--------------------------------------------------------------------------------------------");
		
		System.out.println( "Unique Elements and preserving the original array order: ");		
		printIntArray(deDupAndPreserveOrgiOrder(randomIntegers));
		System.out.println("\n--------------------------------------------------------------------------------------------");
	}

	//A method to print integer array
	private static void printIntArray(int[] uniqnum) {
		for (int i = 0; i < uniqnum.length; i++) 
			System.out.print(uniqnum[i] + " ");
	}

	//A method to remove duplicates from randomIntegers using HashSet
	public static int[] deDupWithHashSet(int[] randomIntegers){		
		int length = randomIntegers.length;
		Set<Integer> uniqnumSet = new HashSet<Integer>();

		for(int i = 0; i < length; i++){
			uniqnumSet.add(randomIntegers[i]);
		}
		
		Iterator<Integer> it = uniqnumSet.iterator();
		int [] uniqnum= new int[uniqnumSet.size()];
		int i=0;
		while(it.hasNext()) {
		  uniqnum[i++] = (Integer) it.next();
		}
		return uniqnum; 
	}

	//A method to remove duplicates from randomIntegers by using quick sort
	public static int[] deDupBySorting(int[] randomIntegers){
		if(randomIntegers.length==0)
			return randomIntegers;
		
		//Copy randomIntegers into another temp array 
		int [] sortedArray = new int[randomIntegers.length];
		System.arraycopy(randomIntegers,0,sortedArray, 0, randomIntegers.length);

		quickSort(sortedArray);
		int [] uniqnumTemp = new int[sortedArray.length];;
		int length=0;
		for(int i=0,j=1;j<sortedArray.length;i++,j++){
			if(sortedArray[i]!=sortedArray[j])
				uniqnumTemp[length++] = sortedArray[i];
		}		
		uniqnumTemp[length++] = sortedArray[sortedArray.length-1];

		int [] uniqnum = new int[length];
		System.arraycopy(uniqnumTemp, 0, uniqnum, 0, length);
		return uniqnum;
		
	}
	
	private static void quickSort(int[] array) {		
		quicksort(array, 0, array.length - 1);
	}
		
	private static void quicksort(final int[] partialArray, final int low, final int high) {
	    int i = low, j = high;
	    //find Pivot element 
	    int pivot = partialArray[low + (high - low) / 2];
	    int temp;
	    //Partitioning - Swap elements so that all the elements less than pivot stays left side 
	    //of it and greater and equals stays right 
	    while (i <= j) {
	    	//Compare from left
	        while (partialArray[i] < pivot) {
	            i++;
	        }
	        
	        //Compare from Right
	        while (partialArray[j] > pivot) {
	            j--;
	        }
	        
	        if (i <= j) {
	        	temp = partialArray[i];
	        	partialArray[i] = partialArray[j];
	        	partialArray[j] = temp;
	            i++;j--;
	        }
	    }
	    
	    //Recursion - Recursively sort left and right parts (with respect to pivot) of the array  
	    if (low < j) {
	        quicksort(partialArray, low, j);
	    }
	    if (i < high) {
	        quicksort(partialArray, i, high);
	    }
	}

	//A method to remove duplicates from randomIntegers by preserving the original Order.
	//This method uses a String object to store the unique numbers
	public static int[] deDupAndPreserveOrgiOrderUsingStringObj(int[] randomIntegers) {
		if(randomIntegers.length==0)
			return randomIntegers;
		
		String s="";
		for (int i = 0; i < randomIntegers.length; i++) {
			if(!s.contains( " " + String.valueOf(randomIntegers[i])+" ,"))
				s+=" " +randomIntegers[i]+" ,";
		}
		
		String stringArray[]=s.replaceAll(" ","").split(",");
		
		int [] uniqnum=new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) 
			uniqnum[i]=Integer.parseInt(stringArray[i]);
	
		return uniqnum; 
	}
	
	//A method to remove duplicates from randomIntegers by preserving the original Order
	public static int[] deDupAndPreserveOrgiOrder(int[] randomIntegers) {
		
		int [] uniqnumTemp = new int[randomIntegers.length];
		int k =0;
		
		for(int i=0;i<randomIntegers.length;i++){
			if(randomIntegers[i]!=-1) {
				uniqnumTemp[k++]=randomIntegers[i];
				for(int j=i+1;j<randomIntegers.length;j++){				
						if (randomIntegers[i]==randomIntegers[j])
							randomIntegers[j]=-1;      //This is the disadvantage of this approach. Assuming '-1'
													   //will never be part of randomIntegers. Hence, using '-1' to
													   //identify/override the duplicate elements
				}			
			}
		}

		int [] uniqnum = new int[k];
		System.arraycopy(uniqnumTemp, 0, uniqnum, 0, k);
		
		return uniqnum;				
	}	
}
