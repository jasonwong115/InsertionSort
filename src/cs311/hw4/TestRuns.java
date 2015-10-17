package cs311.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class TestRuns {

	public static void main(String[] args) {
		int maxArraySize = 40000;
		int increment = 1000;
		int timeDataSize = (maxArraySize/increment)*100 + 1;
		double[] timeData = new double[timeDataSize];
		long totalTime = 0;
		int index = 0;
		for(int i = 20000; i <= maxArraySize; i=i+increment){
			for(int j = 0; j < 100 ; j++){
				//Uncomment code below to create runtimes
				//totalTime = totalTime + sortTime(generateSortedArray(i));
				//totalTime = totalTime + sortTime(generateReverseSortedArray(i));
				//totalTime = totalTime + sortTime(generateAverageArray(i));
			}
			double avgTime = totalTime/(double)100;
			timeData[index] = avgTime;
			index++;
			System.out.println(avgTime);
			totalTime = 0;
		}
		System.out.println("Complete!");
		
	}
	
	/**
	 * Generate array of size n which is already sorted
	 * @param n
	 * 	Size of array to generate
	 */
	public static Integer[] generateSortedArray(int n){
		List<Integer> data = new ArrayList<>(n);
		Random random = new Random();

	    for (int i = 0; i < n; i++) {
	        int rndNum = random.nextInt();
	        int insertionPoint = Collections.binarySearch(data, rndNum);
	        data.add(insertionPoint > -1 ? insertionPoint : - insertionPoint - 1, rndNum);
	    }
	    Integer[] array = data.toArray(new Integer[data.size()]);
	    //System.out.println("Final array result: " + Arrays.deepToString(array));
	    return array;
	}
	
	/**
	 * Generate array of size n which is sorted in reverse order
	 * @param n
	 * 	Size of array to generate
	 */
	public static Integer[] generateReverseSortedArray(int n){
		List<Integer> data = new ArrayList<>(n);
		Random random = new Random();

	    for (int i = 0; i < n; i++) {
	        int rndNum = random.nextInt();
	        int insertionPoint = Collections.binarySearch(data, rndNum);
	        data.add(insertionPoint > -1 ? insertionPoint : - insertionPoint - 1, rndNum);
	    }
	    Collections.reverse(data);
	    Integer[] array = data.toArray(new Integer[data.size()]);
	    //System.out.println("Final array result: " + Arrays.deepToString(array));
	    return array;
	}
	
	/**
	 * Generate array of size n which is n "average running time" array
	 * @param n
	 * 	Size of array to generate
	 */
	public static Integer[] generateAverageArray(int n){
		Integer[] array = new Integer[n];
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = (int) random.nextInt();
		}
		//System.out.println("Final array result: " + Arrays.deepToString(array));
		return array;
	}
	
	/**
	 * Sort array using insertion sort algoritm and return time
	 * @return
	 */
	public static long sortTime(Integer[] array){
		InsertionSort<Integer> is = new InsertionSort<Integer>();
		IntComparator ic = new IntComparator();
		
		long startingTime = System.currentTimeMillis();
		is.sort(array, 0, array.length - 1, ic);
		long endingTime = System.currentTimeMillis();
		
		long result = endingTime - startingTime;
		return endingTime - startingTime;
	}
	

}
