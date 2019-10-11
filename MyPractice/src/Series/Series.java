package Series;

public class Series {
	/*
	 * Generates top N prime numbers.
	 */
	public static void GeneratePrimeNumbers(int N) {
		System.out.println("Prime numbers");
		boolean[] isPrime = SetBooleanFlagForPrime(N+1);
		
		for(int i=0; i<=N; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}
	}
	
	private static boolean[] SetBooleanFlagForPrime(int N) {
		boolean[] isPrime = new boolean[N+1];
		
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		int prime = 2;
		while(prime <= N && prime != Integer.MIN_VALUE) {
			UpdateIsPrime(isPrime, prime);
			prime = GetNextPrime(isPrime, prime);
		}
		
		return isPrime;
	}
	
	private static void UpdateIsPrime(boolean[] isPrime, int prime) {
		int i = prime*prime;
		while(i<isPrime.length) {
			isPrime[i] = false;
			i += prime;
		}
	}
	
	private static int GetNextPrime(boolean[] isPrime, int prime) {
		int nextPrime = Integer.MIN_VALUE;
		
		for(int i=prime+1; i<isPrime.length; i++) {
			if(isPrime[i]) {
				nextPrime = i;
				break;
			}
		}
		
		return nextPrime;
	}
	
	
	
	/*
	 * Fibonacci series : generate N numbers
	 */
	public static void FibonacciSeries(int N) {
		System.out.println("Fibonacci series");
		FibonacciSeries(0, 1, N);
	}
	
	private static void FibonacciSeries(int a, int b, int count) {
		if(count <= 0) {
			return;
		}
		
		System.out.print(b + ", ");
		FibonacciSeries(b, a+b, count-1);
	}
}
