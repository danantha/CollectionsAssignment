package com.collections.dedupmain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Static Util class to remove the duplicate from the integer array
 * @author Anantha Kannan D
 *
 */

public class DeDup {

	public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
		20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
		13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	public static void main(String [] args) {

		int[] originalrandomIntegers = cloneRandInt();
		System.out.println("originalrandomIntegers--10th value::"+originalrandomIntegers[10]);
		System.out.println("originalrandomIntegers--size::"+originalrandomIntegers.length);
		
		ArrayList<Integer> deDupedIntegers_Meth1 = deDupMethBinSort();
		System.out.println("deDupedIntegers_Meth1--5th value::"+deDupedIntegers_Meth1.get(10));
		System.out.println("deDupedIntegers_Meth1--size::"+deDupedIntegers_Meth1.size());
		System.out.println("deDupedIntegers_Meth1::"+deDupedIntegers_Meth1.toString());

		ArrayList<Integer> deDupedIntegers_Meth2 = deDupMethodHashSet();
		System.out.println("deDupedIntegers_Meth2--5th value::"+deDupedIntegers_Meth2.get(10));
		System.out.println("deDupedIntegers_Meth2--size::"+deDupedIntegers_Meth2.size());
		System.out.println("deDupedIntegers_Meth2::"+deDupedIntegers_Meth2.toString());
		
		ArrayList<Integer> deDupedIntegers_Meth3 = deDupMethodHashMap();
		System.out.println("deDupedIntegers_Meth3--5th value::"+deDupedIntegers_Meth3.get(10));
		System.out.println("deDupedIntegers_Meth3--size::"+deDupedIntegers_Meth3.size());
		System.out.println("deDupedIntegers_Meth3::"+deDupedIntegers_Meth3.toString());
		
		ArrayList<Integer> deDupedIntegers_Meth4 = deDupMethod4();
		System.out.println("deDupedIntegers_Meth4--5th value::"+deDupedIntegers_Meth4.get(10));
		System.out.println("deDupedIntegers_Meth4--size::"+deDupedIntegers_Meth4.size());
		System.out.println("deDupedIntegers_Meth4::"+deDupedIntegers_Meth4.toString());
	}

	/**
	 * The approach utilise binary sort logic.
	 * Array will be stored in collection object and sorted
	 * Then binary comparison will be done with the collection object (ArrayList)
	 * Trade off, the order will not be retained, which is addressed in the below approaches
	 * @return ArrayList
	 */
	private static ArrayList<Integer> deDupMethBinSort() {
		int[] randCloneInt1 = cloneRandInt();
		Arrays.sort(randCloneInt1);
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		int prevVal = 0;
		int count = 0;
		for(int counterVal: randCloneInt1) {
			if(count==0) {
				tempList.add(counterVal);
				prevVal=counterVal;
			} else if(prevVal!=counterVal) {
				tempList.add(counterVal);
				prevVal=counterVal;
			}
			count++;
		}
		return tempList;
	}
	
	/**
	 * We will store the result of the 'duplicate comparison' in a binary array
	 * Later in another loop, same will be used to add the specific item in the collection object
	 * @return ArrayList
	 */
	
	private static ArrayList<Integer> deDupMethod4() {
		boolean[] isMatch = new boolean[randomIntegers.length];

	    for(int i = 0; i < randomIntegers.length; i++) {
	        for(int j = i+1; j < randomIntegers.length; j++) {
	            if(randomIntegers[j] == randomIntegers[i]) {
	            	isMatch[j] = true;
	            }
	        }
	    }

	    ArrayList<Integer> tempList = new ArrayList<Integer>();
	    for (int i = 0; i < randomIntegers.length; i++) {
	        if(isMatch[i]) {
	            continue;
	        }
	        else {
	            tempList.add(randomIntegers[i]);
	        }
	    }

	    return tempList;
	}
	
	/**
	 * The approach utilise HashSet inherent feature of not storing the duplicate values
	 * Since, order needs to be maintained, we will use LinkedHashSet
	 * LinkedHashSet maintains the order of insertion
	 * @return ArrayList
	 */

	private static ArrayList<Integer> deDupMethodHashSet() {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		Set<Integer> tempSet = new LinkedHashSet<Integer>();
		for(int counterVal: randomIntegers) {
			tempSet.add(counterVal);
		}
		tempList = new ArrayList<Integer>(tempSet);
		
		return tempList;
	}
	
	/**
	 * The approach uses HashMap and compares the current counter value with the earlier inserted
	 * values in the HashMap.
	 * Since, order needs to be maintained, we will use count as key
	 * @return ArrayList
	 */
	
	private static ArrayList<Integer> deDupMethodHashMap() {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		int count = 1;
		for(int counterVal: randomIntegers) {
				if(!hMap.containsValue(counterVal)) {
					hMap.put(count, counterVal);
					count++;
				}
		}
		tempList = new ArrayList<Integer>(hMap.values());
		
		return tempList;
	}
	
	/**
	 * Util method to clone the Integer array
	 * @return int[]
	 */
	
	
	private static int[] cloneRandInt() {
		int[] randCloneInt = new int[randomIntegers.length];
		System.arraycopy(randomIntegers, 0, randCloneInt, 0, randomIntegers.length);
		return randCloneInt;
	}

}
