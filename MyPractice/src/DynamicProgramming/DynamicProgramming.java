package DynamicProgramming;

import java.util.*;

public class DynamicProgramming {
	/*
	 * You can perform the following operations on the string, a:
	 *	Capitalize zero or more of a's lowercase letters.
	 *	Delete all of the remaining lowercase letters in a.
	 * Given two strings, a and b, determine if it's possible to make a equal to b as described.
	 * */
	public static boolean IsAbbrevation1(String a, String b) {
		return IsAbbrevation1Util(a, b, 0);
	}
	
	private static boolean IsAbbrevation1Util(String a, String b, int index) {
		if(a.equals(b))
			return true;
		
		if(index >= a.length())
			return false;
		
		if(index < b.length() && a.charAt(index) == b.charAt(index))
			return IsAbbrevation1Util(a, b, index+1);
		
		if(Character.isLowerCase(a.charAt(index))) {
			String leftPartA = a.substring(0, index);
			String rightPartA = a.substring(index+1, a.length());
			
			boolean afterDeleting = false;
			String deletedCharacterA = leftPartA + rightPartA;
			afterDeleting = IsAbbrevation1Util(deletedCharacterA, b, index);
			
			boolean afterChangingCase = false;
			Character ch = Character.toUpperCase(a.charAt(index));
			if(index < b.length() && ch == b.charAt(index)) {
				String upperCaseCharacterA = leftPartA + ch + rightPartA;
				afterChangingCase = IsAbbrevation1Util(upperCaseCharacterA, b, index+1);
			}
			
			return afterDeleting || afterChangingCase;
		}
		
		return false;
	}
	
	public static boolean IsAbbrevation(String a, String b) {
        if(a.length() < b.length())
            return false;
        String onlyUpperA = a.replaceAll("[a-z]", "");
        int[][] lcs1 = longestCommonSubSequence(onlyUpperA, b);
        int i1 = onlyUpperA.length();
        int j1 = b.length();
        
        String upperA = a.toUpperCase();
        int[][] lcs = longestCommonSubSequence(upperA, b);
        int i = a.length();
        int j = b.length();
        if(lcs1[i1][j1] == onlyUpperA.length() && lcs[i][j] == b.length()) {
        	/*while(i!=0 && j!=0) {
        		if(upperA.charAt(i-1) == b.charAt(j-1)) {
        			i--;
        			j--;
        		} else {
        			if(Character.isUpperCase(a.charAt(i-1)))
        				return false;
        			
        			if(lcs[i-1][j] < lcs[i][j-1])
        				j--;
        			else
        				i--;
        		}
        	}*/
        	
        	return true;
        }

        return false;
	}
	
	
    private static int[][] longestCommonSubSequence(String a, String b) {
        int[][] lcs = new int[a.length()+1][b.length()+1];

        for(int i=0; i<=a.length(); i++) {
            for(int j=0; j<=b.length(); j++) {
                if(i==0 || j==0)
                    lcs[i][j] = 0;
                else if(a.charAt(i-1) == b.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        return lcs;
    }
	
	
	/*
	 * A child can take 1, 2 or 3 steps. In how many possible ways can he cover N steps.
	 * f(1)= 1, f(2)=2, f(3)=4, ... f(N)=f(N-1)+f(N-2)+f(N-3)
	 * 
	 * This gets stuck for N close to 50
	 */
	public static int CountTotalWaysForStepsRecursive(int N) {
		if(N <= 0) {
			return 0;
		} else if(N == 1) {
			return 1;
		} else if(N == 2) {
			return 2;
		} else if(N == 3) {
			return 4;
		} 
		
		return CountTotalWaysForStepsRecursive(N-1) + CountTotalWaysForStepsRecursive(N-2) + CountTotalWaysForStepsRecursive(N-3);
	}
	
	public static long CountTotalWaysForSteps(int N) {
		long[] stepsRecord = new long[N+1];
		
		for(int i=0; i<=N; i++) {
			stepsRecord[i] = -1;
		}
		
		return CountTotalWaysForSteps(N, stepsRecord);
	}
	
	private static long CountTotalWaysForSteps(int N, long stepsRecord[]) {
		if(N <= 0) {
			return 0;
		} else if(N == 1) {
			return 1;
		} else if(N == 2) {
			return 2;
		} else if(N == 3) {
			return 4;
		} else if(stepsRecord[N] != -1) {
			return stepsRecord[N];
		}
		
		return stepsRecord[N] = CountTotalWaysForSteps((N-1), stepsRecord) + CountTotalWaysForSteps((N-2), stepsRecord) + CountTotalWaysForSteps((N-3), stepsRecord);
	}
	
	
	
	/*
	 * Print all possible valid combinations of braces for a given N.
	 */
	public static void PrintAllNBraces(int N) {
		HashSet<String> possibleCombinations = GetPossibleCombinationOfBraces(N);
		System.out.println("Possible combinations with " + N + " are " + possibleCombinations.size());
		
		for(String combination : possibleCombinations) {
			System.out.println(combination);
		}
		
//		ArrayList<String> allCombinations = new ArrayList<String>();
//		char[] combination = new char[2*N];
//		AddBraces(allCombinations, N, N, combination, 0);
//		
//		System.out.println("Possible combinations with " + N + " are " + allCombinations.size());
//		for(String combinations: allCombinations) {
//			System.out.println(combinations);
//		}
	}
	
	private static void AddBraces(ArrayList<String> list, int leftParenCount, int rightParenCount, char[] string, int index) {
		if(leftParenCount > rightParenCount || leftParenCount < 0) {
			return;
		}
		
		if(leftParenCount == 0 && rightParenCount == 0) {
			String str = String.copyValueOf(string);
			list.add(str);
		}
		
		if(leftParenCount > 0) {
			string[index] = '(';
			AddBraces(list, leftParenCount-1, rightParenCount, string, index+1);
		}
		
		if(rightParenCount > 0) {
			string[index] = ')';
			AddBraces(list, leftParenCount, rightParenCount-1, string, index+1);
		}
	}
	
	private static HashSet<String> GetPossibleCombinationOfBraces(int N) {
		HashSet<String> possibleCombinations = new HashSet<String>();
		
		if(N == 1) {
			possibleCombinations.add("()");
		} else if(N > 1) {
			HashSet<String> allN_1Braces = GetPossibleCombinationOfBraces(N-1);
			Iterator<String> itr = allN_1Braces.iterator();
			while(itr.hasNext()) {
				String str = itr.next();
				
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i) == '(') {
						String left = str.substring(0, i+1);
						String right = str.substring(i+1, str.length());
						possibleCombinations.add(String.format("%s%s%s", left, "()", right));
					}
				}
				
				possibleCombinations.add(String.format("%s%s", "()", str));
			}
		}
		
		return possibleCombinations;
	}
	
	
	
	/*
	 * Return all subsets of set.
	 */
	public static void PrintAllSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = GetAllSubsets(set, 0);
		
		System.out.println("All subsets are " + allSubsets.size());
		for(ArrayList<Integer> subset : allSubsets) {
			System.out.print("{");
			for(Integer item : subset) {
				System.out.print(item + " ");
			}
			System.out.println("}");
		}
	}
	
	private static ArrayList<ArrayList<Integer>> GetAllSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();

		if(set.size() == index) {
			allSubsets.add(new ArrayList<Integer>());
		} else {
			Integer item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = GetAllSubsets(set, index + 1);
			for(ArrayList<Integer> subset : moreSubsets) {
				ArrayList<Integer> fewMoreSubset = new ArrayList<Integer>();
				fewMoreSubset.addAll(subset);
				fewMoreSubset.add(item);
				allSubsets.add(subset);
				allSubsets.add(fewMoreSubset);
			}
		}
		
		return allSubsets;
	}
	
	
	
	/*
	 * Arrange 8 queens on a 8x8 chess board such that none of them share same row, column or diagonals.
	 */
	public static void Print8Queens() {
		Integer[] columns = new Integer[8];
		ArrayList<Integer[]> output = new ArrayList<Integer[]>();
		ArrangeQueens(0, columns, output);
		
		System.out.println("All possible combinations of placing 8 queens on 8X8 chessboard");
		for(Integer[] column : output) {
			for(int row=0; row<8; row++) {
				System.out.print("[" + row + "," + column[row] + "]");
			}
			System.out.println();
		}
	}
	
	private static void ArrangeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if(row == 8) {
			results.add(columns.clone());
		} else {
			for(int column=0; column < 8; column++) {
				if(IsValidMove(columns, row, column)) {
					columns[row] = column;
					ArrangeQueens(row+1, columns, results);
				}
			}
		}
	}
	
	private static boolean IsValidMove(Integer[] columns, int x, int y) {
		for(int row=0; row<x; row++) {
			int column = columns[row];
			
			if(column == y) {
				return false;
			}
			
			int columnDiff = Math.abs(column - y);
			int rowDiff = Math.abs(row - x);
			if(columnDiff == rowDiff) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	/*
	 * Calculate number of ways to represent N cents using 25, 10, 5, 1 cent coins.
	 */
	public static void PrintMakeChange(int[] denominations, int N) {
//		System.out.println("Total number of ways to make change of " + N + " is " + MakeChange(denominations, N, 0));
		
		int[][] possibleWays = new int[N+1][denominations.length];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<denominations.length; j++) {
				possibleWays[i][j] = -1;
			}
		}
		System.out.println("Total number of ways to make change of " + N + " is " + MakeChange(denominations, N, 0, possibleWays));
	}
	
	private static int MakeChange(int[] denominations, int N, int index) {
		if(index >= denominations.length-1) {
			return 1;
		}
		
		int possibleWays = 0;
		int denomination = denominations[index];
		
		for(int i=0; i*denomination<=N; i++) {
			int amountRemaining = N - (i*denomination);
			possibleWays += MakeChange(denominations, amountRemaining, index+1);
		}
		
		return possibleWays;
	}
	
	private static int MakeChange(int[] denominations, int N, int index, int[][] possibleWays) {
		if(possibleWays[N][index] != -1) {
			return possibleWays[N][index];
		}
		
		int possibleWayCount = 0;
		int denomination = denominations[index];
		
		for(int i=0; i*denomination<=N; i++) {
			int amountRemaining = N - (i*denomination);
			possibleWayCount += MakeChange(denominations, amountRemaining, index+1);
		}
		
		possibleWays[N][index] = possibleWayCount;
		return possibleWayCount;
	}
}
