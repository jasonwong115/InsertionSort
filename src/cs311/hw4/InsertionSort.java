package cs311.hw4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class to take in generic array and sorts it using the insertion sort algorithm
 * Sort is in "decreasing" to "increasing" order as defined by the comparator
 * @author Jason Wong
 * 
 *
 * @param <T>
 */
public class InsertionSort<T> implements ISort<T> {

	@Override
	public void sort(T[] arr, int start, int end, Comparator<T> comp) {

		//Invalid arguments passed:
		//Null elements given, invalid start and end numbers, array is empty (which means start and end are invalid)
		if(arr == null || comp == null || end < start || start < 0 || end > arr.length - 1 || arr.length == 0){
			throw new IllegalArgumentException();
		}
		
		//No sorting needed if index is the same
		if(end == start){
			return;
		}
		
		int n = arr.length;
		
		//Traverse starting index + 1 to end and insert each index
        for (int j = start + 1; j <= end ; j++) {
            T key = arr[j];
            
            //Array contains null element
            if(key == null){
            	throw new IllegalArgumentException();
            }
            
            int i = j-1;
            
            //Traverse backwards to find the "sorted" position for key
            while ( (i >= start) && (  comp.compare(arr[i], key) >=1 ) ) {
            	arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
        }
        
	}
}
