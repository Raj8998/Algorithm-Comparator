package com.project.algocomparator.algorithms.sorting;

//SRC: https://www.geeksforgeeks.org/bucket-sort-2/
public class BubbleSort {
	
	public static void sort(int arr[], int n)
    {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
	
	public static void sort(float arr[], int n)
    {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
	
//	public static void sort(float arr[], int n)
//    {
//        if (n <= 0)
//            return;
//  
//        // 1) Create n empty buckets
//        @SuppressWarnings("unchecked")
//        Vector<Float>[] buckets = new Vector[n];
//  
//        for (int i = 0; i < n; i++) {
//            buckets[i] = new Vector<Float>();
//        }
//  
//        // 2) Put array elements in different buckets
//        for (int i = 0; i < n; i++) {
//            float idx = arr[i] * n;
//            buckets[(int)idx].add(arr[i]);
//        }
//  
//        // 3) Sort individual buckets
//        for (int i = 0; i < n; i++) {
//            Collections.sort(buckets[i]);
//        }
//  
//        // 4) Concatenate all buckets into arr[]
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < buckets[i].size(); j++) {
//                arr[index++] = buckets[i].get(j);
//            }
//        }
//    }
//	
//	public static void sort(int arr[], int n)
//    {
//        if (n <= 0)
//            return;
//  
//        // 1) Create n empty buckets
//        @SuppressWarnings("unchecked")
//        Vector<Integer>[] buckets = new Vector[n];
//  
//        for (int i = 0; i < n; i++) {
//            buckets[i] = new Vector<Integer>();
//        }
//  
//        // 2) Put array elements in different buckets
//        for (int i = 0; i < n; i++) {
//            int idx = arr[i] * n;
//            buckets[(int)(idx -1)].add(arr[i]);
//        }
//  
//        // 3) Sort individual buckets
//        for (int i = 0; i < n; i++) {
//            Collections.sort(buckets[i]);
//        }
//  
//        // 4) Concatenate all buckets into arr[]
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < buckets[i].size(); j++) {
//                arr[index++] = buckets[i].get(j);
//            }
//        }
//    }

}
