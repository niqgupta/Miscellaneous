package Sequence;

import java.util.*;

public class SequenceOperations {
	public static int LongestIncreasingSubArraySize(int[] arr) {
		int longestIncreasingSubArraySize = 0;
		int currentIncreasinSubArraysize = 1;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > arr[i-1]) {
				currentIncreasinSubArraysize++;
			} else {
				if(longestIncreasingSubArraySize < currentIncreasinSubArraysize) {
					longestIncreasingSubArraySize = currentIncreasinSubArraysize;
				}
				currentIncreasinSubArraysize = 1;
			}
		}
		
		if(longestIncreasingSubArraySize < currentIncreasinSubArraysize) {
			longestIncreasingSubArraySize = currentIncreasinSubArraysize;
		}
		
		return longestIncreasingSubArraySize;
	}
	
	public static int LongestIncreasingSubSequenceSize(int[] arr) {
		int longestIncreasingSubSequenceSize = 0;
		int[] longestIncreasingSubSequenceSizes = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			longestIncreasingSubSequenceSizes[i] = 1;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					longestIncreasingSubSequenceSizes[i] = Math.max(longestIncreasingSubSequenceSizes[i], (longestIncreasingSubSequenceSizes[j]+1));
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(longestIncreasingSubSequenceSize < longestIncreasingSubSequenceSizes[i]) {
				longestIncreasingSubSequenceSize = longestIncreasingSubSequenceSizes[i];
			}
		}
		
		return longestIncreasingSubSequenceSize;
	}
	
	
	public static char[] LongestCommonSubSequence(char[] arr1, char[] arr2) {
		int LCS[][] = new int[arr1.length+1][arr2.length+1];
		
		for(int i=0; i<=arr1.length; i++) {
			for(int j=0; j<=arr2.length; j++) {
				if(i==0 || j==0) {
					LCS[i][j] = 0;
				} else if(arr1[i-1] == arr2[j-1]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		int i=arr1.length, j=arr2.length;
		int index = LCS[i][j];
		char[] longestCommonSubSequence = new char[index];

		while(index != 0) {
			if(LCS[i][j] == LCS[i-1][j]) {
				i -= 1;
			} else if(LCS[i][j] == LCS[i][j-1]) {
				j -= 1;
			} else {
				longestCommonSubSequence[--index] = arr1[i-1];
				i -= 1;
				j -= 1;
			}
		}
		
		return longestCommonSubSequence;
	}
	
	
	public static char[] LongestCommonSubString(char[] arr1, char[] arr2) {
		int[][] LCS = new int[arr1.length+1][arr2.length+1];
		int maxI = 0, maxJ = 0, max = 0;
		
		for(int i=0; i<=arr1.length; i++) {
			for(int j=0; j<=arr2.length; j++) {
				if(i==0 || j==0) {
					LCS[i][j] = 0;
				} else if(arr1[i-1] == arr2[j-1]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
					if(max < LCS[i][j]) {
						max = LCS[i][j];
						maxI = i;
						maxJ = j;
					}
				} else {
					LCS[i][j] = 0;
				}
			}
		}
		
		int index = max, i= maxI, j=maxJ;
		char[] longestCommonSubString = new char[index];
		
		while(index != 0) {
			if(LCS[i][j] == LCS[i-1][j]) {
				i -= 1;
			} else if(LCS[i][j] == LCS[i][j-1]) {
				j -= 1;
			} else {
				longestCommonSubString[--index] = arr1[i-1];
				i -= 1;
				j -= 1;
			}
		}
		
		return longestCommonSubString;
	}
	
	
	
	/*
	 * Find length of longest continuous string with unique characters.
	 */
	public static int LongestStringWithUniqueChar(String string) {
		int longestStringWithUniqueChar = 0;
		
		char[] charArr = string.toCharArray();
		Queue<Character> queue = new LinkedList<Character>();
		
		for(int i=0; i<charArr.length; i++) {
			while(queue.contains(charArr[i])) {
				queue.poll();				
			}
			
			queue.add(charArr[i]);
			if(queue.size() > longestStringWithUniqueChar) {
				longestStringWithUniqueChar = queue.size();
			}
		}
		
		return longestStringWithUniqueChar;
	}
}
