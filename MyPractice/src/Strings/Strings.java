package Strings;

import java.util.*;

public class Strings {
	/*
	 * Given that each alphabet corresponds to a number in increasing order
	 * For a number N, find string with minimum number of characters required to represent N.
	 * A=1, B=3, C=5, D=10, E=50...... Z=1000
	 * Number 29, can be represented as DDCBA
	 * It can also be represented as AAA..29 times, but we need minimum characters for output.
	 * */
	public static String FindSmallestStringRepresentation(int[] mappings, int N) {
		if(N < mappings[0])
			return new String();
		
		for(int i=mappings.length-1	; i>=0; i--) {
			if(mappings[i] == N) {
				return Character.toString((char)(i+65));
			} else if(mappings[i] < N) {
				int remaining = N%mappings[i];
				String remainingString = new String();
				if(remaining != 0)
					remainingString = FindSmallestStringRepresentation(mappings, N%mappings[i]);
				
				if(remaining == 0 || !remainingString.isEmpty()) {
					String stringSoFar = new String();
					int repeat = N/mappings[i];
					for(int j=0; j<repeat; j++) {
						stringSoFar = stringSoFar + Character.toString((char)(i+65));
					}
					
					return stringSoFar + remainingString;
				}
			}
		}
		
		return new String();
	}
	
	
	
	/*
	 * You are given a string, S, of 'N' characters.
	 * You also have some pairs of numbers, (i,j) 0 <= i,j < N, which indicates the string positions you are allowed to swap.
	 * what is the lexicographically smallest string you can form.
	 * String : cdafbe
	 * swaps : 
	 * 0-1					
	 * 0-2					
	 * 3-5
	 * Output : acdebf
	 */
	public static String FindSmallestString(String string, boolean[][] swaps) {
		char[] chars = string.toCharArray();
		boolean[] visited = new boolean[chars.length];
		
		for(int i=0; i<visited.length; i++) {
			visited[i] = false;
		}
		
		for(int i=0; i<visited.length; i++) {
			if(!visited[i]) {
				SortConnectedNodes(chars, swaps, visited, i);
			}
		}
		
		return new String(chars);
	}
	
	private static void SortConnectedNodes(char[] chars, boolean[][] swaps, boolean[] visited, int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		ArrayList<Integer> indexesToBeSorted = new ArrayList<Integer>();
		
		while(!queue.isEmpty()) {
			Integer temp = queue.remove();
			visited[temp] = true;
			indexesToBeSorted.add(temp);
			for(int i=0; i<visited.length; i++) {
				if(temp != i && swaps[temp][i] && !visited[i]) {
					queue.add(i);
				}
			}
		}
		
		SortIndexes(chars, indexesToBeSorted);
	}
	
	private static void SortIndexes(char[] chars, ArrayList<Integer> indexesToBeSorted) {
		indexesToBeSorted.sort(null);
		for(int i=0; i<indexesToBeSorted.size(); i++) {
			for(int j=i+1; j<indexesToBeSorted.size(); j++) {
				if(chars[indexesToBeSorted.get(i)] > chars[indexesToBeSorted.get(j)]) {
					char temp = chars[indexesToBeSorted.get(i)];
					chars[indexesToBeSorted.get(i)] = chars[indexesToBeSorted.get(j)];
					chars[indexesToBeSorted.get(j)] = temp;
				}
			}
		}
	}
	
	
	/*
	 * Find if a string is rotation of other.
	 */
	public static boolean IsRotation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		// Using KMP algorithm finding the best match.
		int lps[] = new int[s1.length()];
		int i = 0;
		int j = 0;
		while(i < s1.length()) {
			if(s1.charAt(i) == s2.charAt(j)) {
				lps[i] = ++j;
				i++;
			} else {
				if(j == 0) {
					lps[i] = 0;
					i++;
				} else {
					j = lps[j-1]-1;
					if(j < 0)
						j = 0;
				}
			}
		}
		
		// Now match the rest part
		i = 0;
		for(int k=lps[s1.length()-1]; k < s2.length(); k++, i++) {
			if(s1.charAt(i) != s2.charAt(k)) {
				return false;
			}
		}
		
		return true;
	}
}
