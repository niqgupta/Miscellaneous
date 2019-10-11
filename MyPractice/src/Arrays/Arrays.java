package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class Arrays {
	/*
	 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
	 * */
	public static int MaxNonAdjacentSubsetSum(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		HashMap<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<A.length; i++) {
			int sum = MaxNonAdjacentSubsetSumLeft(A, i, leftMap) + MaxNonAdjacentSubsetSumRight(A, i, rightMap) - A[i];
			if(sum > maxSum)
				maxSum = sum;
		}
		
		return maxSum;
	}
	
	private static int MaxNonAdjacentSubsetSumRight(int[] A, int index, HashMap<Integer, Integer> map) {
		if(map.keySet().contains(index))
			return map.get(index);
		
		int maxSum = A[index];
		
		for(int i=index+2; i<A.length; i++) {
			int sum = A[index] + MaxNonAdjacentSubsetSumRight(A, i, map);
			if(sum > maxSum)
				maxSum = sum;
		}
		
		map.put(index, maxSum);
		return maxSum;
	}
	
	private static int MaxNonAdjacentSubsetSumLeft(int[] A, int index, HashMap<Integer, Integer> map) {
		if(map.keySet().contains(index))
			return map.get(index);
		
		int maxSum = A[index];
		
		for(int i=index-2; i>=0; i--) {
			int sum = A[index] + MaxNonAdjacentSubsetSumLeft(A, i, map);
			if(sum > maxSum)
				maxSum = sum;
		}
		
		map.put(index, maxSum);
		return maxSum;
	}
	
	
	/*
	 * Given a list of integers, sort them based on their frequency
	 * If frequency matches then by value
	 * */
	public static void SortByFrequecy(List<Integer> list) {
		int[] frequency = new int[1000000];		
		for(int i=0; i<frequency.length; i++) {
			frequency[i] = 0;
		}
		
		for(Integer i : list) {
			frequency[i]++;
		}
		
		List<Integer> sortedFreq = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> freqList = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0; i<frequency.length; i++) {
			if(frequency[i] != 0) {
				if(!sortedFreq.contains(frequency[i]))
					sortedFreq.add(frequency[i]);
					
				if(freqList.containsKey(frequency[i])) {
					ArrayList<Integer> valueList = freqList.get(frequency[i]);
					valueList.add(i);
				} else {
					ArrayList<Integer> valueList = new ArrayList<Integer>();
					valueList.add(i);
					freqList.put(frequency[i], valueList);
				}
			}
		}
		
		Collections.sort(sortedFreq);
		for(Integer freq : sortedFreq) {
			ArrayList<Integer> valueList = freqList.get(freq);
			Collections.sort(valueList);
			for(Integer value : valueList) {
				for(int i=0; i<freq; i++)
					System.out.println(value);
			}
		}
	}
	
	
	
	/*
		Array of 0s and 1s sorted row level
		Input matrix
		0 1 1 1
		0 0 1 1
		1 1 1 1  // this row has maximum 1s
		0 0 0 0
		
		Output: 2
	 */
	public static int RowWithMaxSum(int arr[][], int Rows, int Columns) {
		int rowWithMaxSum = 0;
		int indexOfFirst1 = -1;
		
		indexOfFirst1 = IndexOfFirst1(arr[rowWithMaxSum], 0, Columns-1);
		for(int row=1; row<Rows; row++) {
			if(indexOfFirst1 == 0) {
				break;
			}
			
			if(indexOfFirst1 != -1) {
				if(arr[row][indexOfFirst1-1] == 1 && indexOfFirst1 != 0) {
					indexOfFirst1 = IndexOfFirst1(arr[row], 0, indexOfFirst1-1);
					rowWithMaxSum = row;
				}
			} else {
				indexOfFirst1 = IndexOfFirst1(arr[row], 0, Columns-1);
				rowWithMaxSum = row;
			}
		}
		
		return rowWithMaxSum + 1;
	}
	
	/*
	 * Uses binary search to find occurrence of first 1 in arr between start and end indexes.
	 * Assuming arr contains only 0s and 1s in sorted order.
	 */
	private static int IndexOfFirst1(int arr[], int start, int end) {
		int indexOfFirst1 = -1;
		int low = start;
		int high = end;

		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid]==1 && (mid==0 || arr[mid-1]==0)) {
				return mid;
			} else {
				if(arr[mid]==0) {
					low = mid+1;
				} else {
					high = mid-1;
				}
			}
		}
		
		return indexOfFirst1;
	}
}
