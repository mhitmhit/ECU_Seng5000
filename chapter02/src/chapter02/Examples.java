package chapter02;

import java.util.Random;

public class Examples {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Examples example = new Examples();
		
		// declarations
		int integerArray[] = {2, 1, 7, 6, 4, 2, 9};
		
		System.out.println(example.search(integerArray, 7));
		System.out.println(example.areDifferent(integerArray, integerArray));
		System.out.println(example.areUnique(integerArray));
		System.out.println(example.areUnique2(integerArray));
	}
	
/**
* Searches an array to find the first occurrence of a target.
*
* @param x Array to search
* @param target Target to search for
* @return The subscript of first occurrence if found; otherwise, 
return -1.
*/
/*<example chapter="2" number="1">*/
public static int search(int[] x, int target) {
	for (int i = 0; i < x.length; i++) {
	if (x[i] == target) {
	return i;
	}
	}
	// target not found
	return -1;
}
/*</example>*/
/*<example chapter="2" number="2">
/** Determine whether two arrays have no common elements.
@param x One array
@param y The other array
@return true if there are no common elements
*/
public static boolean areDifferent(int[] x, int[] y) {
	for (int i = 0; i < x.length; i++) {
	if (search(y, x[i]) != -1) {
	return false;
	}
	}
	return true;
}
/*</example>*/
/*<example chapter="2" number="3">*/
/**
* Determine whether the contents of an array are all unique.
*
* @param x The array
* @return true if all elements of x are unique
*/
public static boolean areUnique(int[] x) {
	for (int i = 0; i < x.length; i++) {
	for (int j = 0; j < x.length; j++) {
	if (i != j && x[i] == x[j]) {
	return false;
	}
	}
	}
	return true;
}
/*</example>*/
/*<example chapter="2" number="4">*/
/**
* Determine whether the contents of an array are all unique.
*
* @param x The array
* @return true if all elements of x are unique
*/
public static boolean areUnique2(int[] x) {
	for (int i = 0; i < x.length; i++) {
	for (int j = i + 1; j < x.length; j++) {
	if (x[i] == x[j]) {
	return false;
	}
	}
	}
	return true;
}

}// fin
