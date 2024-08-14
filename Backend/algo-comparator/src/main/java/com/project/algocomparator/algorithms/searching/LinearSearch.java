package com.project.algocomparator.algorithms.searching;

public class LinearSearch {
	public static int search(int arr[], int n, int x)
    {
        for (int i = 0; i < n; i++) {
            // Return the index of the element if the element
            // is found
            if (arr[i] == x)
                return i;
        }
 
        // return -1 if the element is not found
        return -1;
    }
	
	public static int search(float arr[], int n, float x)
    {
        for (int i = 0; i < n; i++) {
            // Return the index of the element if the element
            // is found
            if (arr[i] == x)
                return i;
        }
 
        // return -1 if the element is not found
        return -1;
    }
}
