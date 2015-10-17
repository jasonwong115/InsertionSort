package cs311.hw4;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;

/**
 * @author mkyong
 *
 */
public class InsertionSortTests {

	//Data to sort
	Integer data[];
	Integer answer[];
			
	//Initialize all necessary classes
	static InsertionSort<Integer> is;
	static IntComparator ic;

    @BeforeClass
    public static void oneTimeSetUp() {
		is = new InsertionSort<Integer>();
		ic = new IntComparator();
    }

    @Test
    public void testWholeArray() {
        System.out.println("@Test - testWholeArray");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {0,1,1,7,8,9,9,23};
		is.sort(data, 0, data.length - 1, ic);
		System.out.println("Start: " + Arrays.deepToString(data));
		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test
    public void testPartialArray() {
        System.out.println("@Test - testPartialArray");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {0,1,1,8,9,9,23,7};
		is.sort(data, 0, data.length - 2, ic);
		System.out.println("Start: " + Arrays.deepToString(data));
		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test
    public void testPartialArray2() {
        System.out.println("@Test - testPartialArray2");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {8,0,1,1,9,9,23,7};
		is.sort(data, 3, data.length - 2, ic);
		System.out.println("Start: " + Arrays.deepToString(data));
		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testEmptyArray() {
    	System.out.println("@Test - testEmptyArray");
 		data = new Integer[] {};
 		answer = new Integer[] {};
 		is.sort(data, 0, 0, ic);
 		System.out.println("Start: " + Arrays.deepToString(data));
 		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test
    public void testOneElementArray() {
        System.out.println("@Test - testSameIndex");
		data = new Integer[] {8};
		answer = new Integer[] {8};
		is.sort(data, 0, 0, ic);
		System.out.println("Start: " + Arrays.deepToString(data));
		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test
    public void testSameIndex() {
        System.out.println("@Test - testSameIndex");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {8,0,1,23,9,9,1,7};
		is.sort(data, 0, 0, ic);
		System.out.println("Start: " + Arrays.deepToString(data));
		System.out.println("Final: " + Arrays.deepToString(answer));
        assertTrue(Arrays.equals(data,answer));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testStartGTEnd() {
    	System.out.println("@Test - testStartGTEnd");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {8,0,1,23,9,9,1,7};
		is.sort(data, data.length-1, 0, ic);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testEndGTLastIndex() {
    	System.out.println("@Test - testEndGTArrayLength");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {8,0,1,23,9,9,1,7};
		is.sort(data, 0, data.length, ic);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testStartLTZero() {
    	System.out.println("@Test - testStartLTZero");
		data = new Integer[] {8,0,1,23,9,9,1,7};
		answer = new Integer[] {8,0,1,23,9,9,1,7};
		is.sort(data, -1, data.length-1, ic);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNullArray() {
        System.out.println("@Test - testNullArray");
		is.sort(null, 0, 0, ic);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNullComparator() {
        System.out.println("@Test - testNullComparator");
        data = new Integer[] {8,0,1,23,9,9,1,7};
		is.sort(data, 0, data.length - 1, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNullElement() {
        System.out.println("@Test - testNullElement");
        data = new Integer[] {8,0,1,23,null,9,1,7};
		is.sort(data, 0, data.length - 1, null);
    }
}