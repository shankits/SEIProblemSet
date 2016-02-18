	/**						SEI Tech Lead Candidate Problem Set
Submitted by: Shankara Narayanan Tiruchirappalli Singaravadivelu
Consulting Firm: Liquid Hub
Contact Info: 860 944 5537

1.	Given the following class, write 3 methods that can be used to return an array that has no duplicates.
2.	You should define a method signature that you feel is appropriate to the problem.
3.	We would prefer to see three implementations (one that should take into consideration #4 below) and an explanation of what use-cases are suitable to each implementation 
Solution 1#: This is the best possible solution using LinkedHashset which can retain the orginal order and avoid duplicates within the collection.
Solution 2#: This is another possibility but here we will have to check the existence of the object explicitly.
Solution 3#: This takes more time and consumes more memory. 
4.	What if we need to retain the original order? – LinkedHashSet takes care of original order
5.	What are the positives and negatives of your solution?
a.	Can you implement it another way so as to avoid the negatives? – Solution2# is the secondary option without negatives.
6.	Your solution should be testable and “production ready.”
7.	Your solution should be posted to a public github repo that SEI can clone.
**//**
 * 
 */
package main.com;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author snarayanan
 *
 */
public class DeDup {
	
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] nonDuplicateArray = null;
		DeDup deDup = new DeDup();
		nonDuplicateArray = deDup.positiveSolution();
		System.out.println("Solution #1: ");
		deDup.printArray(nonDuplicateArray);
		
		System.out.println("Solution #2: ");
		nonDuplicateArray = deDup.anotherPositiveSolution();		
		deDup.printArray(nonDuplicateArray);
		
		System.out.println("Solution #3: ");
		nonDuplicateArray = deDup.negativeSolution();		
		deDup.printArray(nonDuplicateArray);
			
		
	}

	/**
	 * Linked HashSet internally avoids the duplicates to be added collection. Also it maintains the order of the value insertion (original order)
	 * @return
	 */
	public Integer[] positiveSolution(){
		LinkedHashSet<Integer> nonDuplicateSet = new LinkedHashSet<>();
		
		for (Integer value: randomIntegers) {
			nonDuplicateSet.add(value);
		}
		Integer[] nonDuplicateArray = nonDuplicateSet.toArray(new Integer[nonDuplicateSet.size()]);
	
		return nonDuplicateArray;
	}
	/**
	 * Another possibility if by adding the values to an Array list by checking the previous existence and then converting it to Array
	 * @return
	 */
	public Integer[] anotherPositiveSolution(){
		List<Integer> nonDuplicateList = new ArrayList<>();
		
		for (Integer value: randomIntegers){
			if(!nonDuplicateList.contains(value)){
				nonDuplicateList.add(value);
			}
		}
		Integer[] nonDuplicateArray = new Integer[nonDuplicateList.size()];
		nonDuplicateArray = nonDuplicateList.toArray(nonDuplicateArray);
	
		return nonDuplicateArray;
	}
	
	/**
	 * This is time consuming - We are checking every value before adding it to the list to avoid duplicates. Also we iterating the whole list 
	 * to be added to another array from list
	 * @return
	 */
	public Integer[]  negativeSolution(){
		Integer[] tempArray = new Integer[randomIntegers.length];
		int i=0;
		int j=0;
		String tempStr="";
		while(i<randomIntegers.length){
			if(j==0){
				tempArray[j] = randomIntegers[i];
				j++;
				tempStr = tempStr+ " "+randomIntegers[i]+",";
			} else if(!tempStr.contains(" "+randomIntegers[i]+",")) {
				tempArray[j] = randomIntegers[i];
				j++;
				tempStr = tempStr+ " "+randomIntegers[i]+",";				
			}
			i++;
		}
		Integer[] nonDuplicateArray = new Integer[j];
		for(int k =0; k<j;k++){
			if(tempArray[k]!=null)
				nonDuplicateArray[k]= tempArray[k];
		}
		return nonDuplicateArray;
	}
	
	public void printArray(Integer[] nonDuplicateArray){
		 for(int i = 0; i < nonDuplicateArray.length; i++){
             System.out.print(nonDuplicateArray[i]+", ");
          } 
		 
		 System.out.println("size: "+ nonDuplicateArray.length);
	}
}
