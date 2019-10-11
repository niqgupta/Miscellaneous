
public class Main {

	public static void main(String[] args) {
		int[] arr = {8, 9, 10, 10, 11, 12}; // Assuming there is a duplicate value and numbers are in sequence
		System.out.println("Duplicate value " + FindDuplicateNumber(arr));
	}
	
	public static int FindDuplicateNumber(int[] arr) {
		int actualSum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			actualSum += arr[i];
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		
		int n = arr.length - 1;
		int naturalSum = (n*(n+1))/2;
		int expectedSum = naturalSum + (min-1) * n;
		
		return actualSum - expectedSum;
	}

}
