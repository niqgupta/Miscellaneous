package Random;

import java.util.*;

public class Random {
	/*
	 * Using 32 bits, reverse all bits of an integer
	 * */
	public static long InverseBits(long n) {
		return GetIntegerFrom32Bits(Get32BitArray(n));
	}
	
    public static long[] Get32BitArray(long n) {
        long[] bitsArray = new long[32];
        int bitIndex = 0;
        long integer = n;

        while(bitIndex < bitsArray.length && integer != 0) {
            bitsArray[bitIndex] = integer % 2;
            integer /= 2;
            bitIndex++;
        }

        return bitsArray;
    }

    public static long GetIntegerFrom32Bits(long[] arr) {
        long integer = 0;

        for(int i=0; i<arr.length; i++) {
            int value = 1;
            if(arr[i] == 1)
                value = 0;
            
            integer += value * Math.pow(2, i);
        }

        return integer;
    }
	
	
	/*
	 * Given a tree, count all pairs i, j such that XOR of all nodes between i and j is K
	 * */
	public static int CountPairsXOR(int[] A, int[] P, int K) {
		int pairs = 0;
		
		for(int i=A.length-1; i>0; i--) {
			int value = A[i];
			int parent = P[i-1]-1;
			while(parent >= 0) {
				value = value ^ A[parent];
				if(value==K)
					pairs++;
				
				if(parent > 0)
					parent = P[parent-1]-1;
				else
					parent--;
			}
		}
		
		return pairs;
	}
	
	
	/*
	 * Find Nth root of a number given to a decimal precision
	 */
	public static double FindNthRoot(int N, int num, int decimalPlaces) {
		double nthRoot = 0;
		long start = (long) (1 * Math.pow(10, decimalPlaces));
		long end = (long)(num * Math.pow(10, decimalPlaces));
		long number = (long)(num * Math.pow(10, decimalPlaces*N));
		long previousValue = 0;
		
		while(start < end) {
			long mid = (start + end)/2;
			long midPowerN = (long)(Math.pow(mid, N));

			if(midPowerN == number || previousValue == mid) {
				nthRoot = mid;
				break;
			} else if(midPowerN < number) {
				start = mid;
			} else {
				end = mid;
			}
			previousValue = mid;
		}
		
		nthRoot /= Math.pow(10, decimalPlaces);
		return nthRoot;
	}
	
	
	/*
	 * Input a number like 123456
	 * Output should be number in INR format i.e. 1,23,456
	 */
	public static String FormatToINR(int value) {
		int numberOfDigits =  NumberOfDigits(value);
		int separatorCount = 0;
		
		if(numberOfDigits > 3) {
			separatorCount = (numberOfDigits/2) - 1;
		}
		
		int index = numberOfDigits + separatorCount;
		char[] numArr = new char[index];
		int num = value;
		int separatorIndex = -1;
		while(num != 0) {
			if(separatorIndex == 2) {
				numArr[--index] = ',';
				separatorIndex = 0;
			} else {
				int rem = num % 10;
				num /= 10;
				numArr[--index] = Character.forDigit(rem, 10);
				separatorIndex++;
			}
		}
		
		return new String(numArr);
	}
	
	private static int NumberOfDigits(int value) {
		int numberOfDigits = 0;
		
		int num = value;
		while(num != 0) {
			numberOfDigits++;
			num /= 10;
		}
		
		return numberOfDigits;
	}
	
	
	/*
	 * Merge Sort by dividing problem into 3 sub arrays
	 * 
	 * Yet to be tested
	 */
	public static int[] MergeSortBy3(int[] unSortedArray) {
		int sortedArray[];
		
		if(unSortedArray.length <= 1) {
			return unSortedArray;
		}
		
		int subArrayLength = unSortedArray.length/3;
		int A[] = MergeSortBy3(Arrays.copyOfRange(unSortedArray, 0, subArrayLength));
		int B[] = MergeSortBy3(Arrays.copyOfRange(unSortedArray, subArrayLength+1, (2*subArrayLength)+1));
		int C[] = MergeSortBy3(Arrays.copyOfRange(unSortedArray, (2*subArrayLength)+2, unSortedArray.length));
		
		sortedArray = MergeSortedArrays(A, B, C);
		
		return sortedArray;
	}
	
	public static int[] MergeSortedArrays(int[] A, int[] B, int[] C) {
		int mergedArray[] = new int[A.length + B.length + C.length];
		int mergeIndex = 0;
		int a=0, b=0, c=0;
		
		while(a < A.length || b < B.length || c < C.length) {
			if(a < A.length && (b >= B.length || A[a] <= B[b]) && (c >= C.length || A[a] <= C[c])) {
				mergedArray[mergeIndex] = A[a];
				a++;
			} else if(b < B.length && (a >= A.length || B[b] <= A[a]) && (c >= C.length || B[b] <= C[c])) {
				mergedArray[mergeIndex] = B[b];
				b++;
			} else if(c < C.length && (a >= A.length || C[c] <= A[a]) && (b >= B.length || C[c] <= B[b])) {
				mergedArray[mergeIndex] = C[c];
				c++;
			} else {
				break;
			}
			
			mergeIndex++;
		}
		
		return mergedArray;
	}
	
	
	/*
	 * Find next palindrome number higher than a given number.
	 */
	public static int GetNextHighestPalindrome(int num) {
		int n = num + 1;
		int noOfDigits = NumberOfDigits(n);
		boolean isEvenLength = noOfDigits%2 == 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<noOfDigits/2; i++) {
			int digit = n%10;
			stack.push(digit);
			n /= 10;
		}
		
		int leftHalfOfPalindrome = n;
		if(!isEvenLength) {
			n /= 10;
		}
		
		while(!stack.isEmpty()) {
			int leftDigit = n%10;
			int rightDigit = stack.pop();
			
			if(leftDigit < rightDigit) {
				leftHalfOfPalindrome++;
				break;
			} else if(leftDigit > rightDigit) {
				break;
			}
			
			n /= 10;
		}
		
		return CreatePalindrome(leftHalfOfPalindrome, isEvenLength);
	}
	
	
	private static int CreatePalindrome(int firstHalf, boolean isEvenLength) {
		int palindrome;
		
		palindrome = firstHalf;
		if(!isEvenLength) {
			firstHalf /= 10;
		}
		
		while(firstHalf != 0) {
			int digit = firstHalf % 10;
			
			palindrome = (palindrome*10) + digit;
			
			firstHalf /= 10;
		}
		
		return palindrome;
	}
	
	
	
	/*
	 * Find maximum product of three consecutive digits in a string of integer
	 * 
	 * Input : 123456
	 * Output : 120 i.e. 4*5*6
	 */
	public static int MaxProductOfThreeConsecutiveDigits(String str) {
		int maxProduct = 0;
		int product = 1;
		int k = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0') {
				k = 0;
				product = 1;
				continue;
			}
			
			if(k == 3) {
				product /= Character.getNumericValue(str.charAt(i-3));
				k--;
			}
			
			product *= Character.getNumericValue(str.charAt(i));
			k++;
			
			if(maxProduct < product) {
				maxProduct = product;
			}
		}
		
		return maxProduct;
	}
	
	
	/*
	 * Get excel column representation for an integer.
	 * like 1 > A; 2 > B; 27 > AA; ...
	 */
	public static String GetExcelColumnRepresentation(int num) {
		String excelColumn = "";
		
		while(num != 0) {
			int rem = num % 26;
			char charToAdd = ' ';
			
			switch(rem) {
				case 0:
					charToAdd = 'Z';
					break;
				case 1:
					charToAdd = 'A';
					break;
				case 2:
					charToAdd = 'B';
					break;
				case 3:
					charToAdd = 'C';
					break;
				case 4:
					charToAdd = 'D';
					break;
				case 5:
					charToAdd = 'E';
					break;
				case 6:
					charToAdd = 'F';
					break;
				case 7:
					charToAdd = 'G';
					break;
				case 8:
					charToAdd = 'H';
					break;
				case 9:
					charToAdd = 'I';
					break;
				case 10:
					charToAdd = 'J';
					break;
				case 11:
					charToAdd = 'K';
					break;
				case 12:
					charToAdd = 'L';
					break;
				case 13:
					charToAdd = 'M';
					break;
				case 14:
					charToAdd = 'N';
					break;
				case 15:
					charToAdd = 'O';
					break;
				case 16:
					charToAdd = 'P';
					break;
				case 17:
					charToAdd = 'Q';
					break;
				case 18:
					charToAdd = 'R';
					break;
				case 19:
					charToAdd = 'S';
					break;
				case 20:
					charToAdd = 'T';
					break;
				case 21:
					charToAdd = 'U';
					break;
				case 22:
					charToAdd = 'V';
					break;
				case 23:
					charToAdd = 'W';
					break;
				case 24:
					charToAdd = 'X';
					break;
				case 25:
					charToAdd = 'Y';
					break;
			}
			
			excelColumn = String.format("%c%s", charToAdd, excelColumn);
			num /= 26;
			
			if(rem == 0) {
				num--;
			}
		}
		
		return excelColumn;
	}
	
	
	
	/*
	 * Find min number in a sorted array that is rotated.
	 * 
	 * i.e. 5 4 1 2 3
	 */
	public static int FindMinElementInRotatedSortedArray(int[] arr) {
		int min = arr[0];
		int startIndex = 0;
		int endIndex = arr.length-1;
		
		while(startIndex < endIndex) {
			int mid = (startIndex + endIndex)/2;
			
			if(mid == startIndex || mid == endIndex) {
				min = arr[startIndex];
				if(arr[startIndex] > arr[endIndex]) {
					min = arr[endIndex];
				}
				
				break;
			}
			
			if((arr[startIndex] > arr[mid] && arr[startIndex] > arr[endIndex])
					|| (arr[startIndex] < arr[mid] && arr[startIndex] < arr[endIndex])) {
				endIndex = mid;
			} else if((arr[endIndex] > arr[mid] && arr[endIndex] > arr[startIndex])
					|| (arr[endIndex] < arr[mid] && arr[endIndex] < arr[startIndex])) {
				startIndex = mid;
			} else {
				startIndex++;
			}
			
			min = arr[mid];
		}

		return min;
	}
	
	
	/*
	 * Find second largest element in array.
	 */
	public static int FindSecondHighestNumber(int[] arr) {
		int highest, secondHighest;
		
		if(arr.length < 2) {
			return -1;
		}
		
		highest = arr[0];
		secondHighest = arr[1];
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			} else if(arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
		}
		
		return secondHighest;
	}
	
	
	/*
	 * Find location of an element in array which sorted row and column wise.
	 */
	public static void FindInArraySortedRowNColumn(int[][] arr, int number) {
		int N = arr[0].length;
		int i = 0, j = N-1;
		
		while(i<N && j>=0) {
			if(number == arr[i][j]) {
				System.out.println("Found at i,j > " + i + "," + j);
				break;
			}
			
			if(number < arr[i][j]) {
				j--;
			} else {
				i++;
			}
		}
	}
}
