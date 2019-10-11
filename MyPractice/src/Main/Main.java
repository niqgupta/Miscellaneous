package Main;

import LinkedList.*;
import Random.*;
import Random.Random;
import Sequence.SequenceOperations;
import Tree.*;

import java.util.*;

import Arrays.*;
import Arrays.Arrays;
import DynamicProgramming.*;
import Series.*;
import Strings.*;
import Graphs.*;

public class Main {

	public static void main(String[] args) {
//		LinkedListOperations list = new LinkedListOperations();
//		list.AddToHead("L");
//		list.AddToHead("I");
//		list.AddToHead("H");
//		list.AddToHead("K");
//		list.AddToHead("I");
//		list.AddToHead("N");
//		list.Print();
//		list.FindNthNode(1).Print();
//		list.Reverse();
//		list.ReverseInPairs();
//		list.Print();
//		list.FindMiddleNode().Print();
//		list.PrintFromEnd();
//		LinkedListNode list1 = new LinkedListNode("G", new LinkedListNode("U", new LinkedListNode("P", new LinkedListNode("T", new LinkedListNode("A")))));
//		LinkedListNode list2 = new LinkedListNode("K", new LinkedListNode("U", new LinkedListNode("M", new LinkedListNode("A", new LinkedListNode("R", list1)))));
//		LinkedListNode list3 = new LinkedListNode("N", new LinkedListNode("I", new LinkedListNode("K", new LinkedListNode("H", new LinkedListNode("I", new LinkedListNode("L", list1))))));
//		System.out.println("Intersecting node is " + LinkedListOperations.FindIntersectingPoint(list2, list3).Data);
//		System.out.println("Is list palindrome " + LinkedListOperations.IsPalindrome(new LinkedListNode("N", new LinkedListNode("I", new LinkedListNode("N")))));
//		LinkedListNode list = new LinkedListNode("G", new LinkedListNode("U", new LinkedListNode("P", new LinkedListNode("T", new LinkedListNode("A")))));
//		LinkedListOperations.Print(LinkedListOperations.ReverseKNodes(list, 3));

//		BinaryTreeNode node1 = new BinaryTreeNode("1");
//		BinaryTreeNode node2 = new BinaryTreeNode("2");
//		BinaryTreeNode node3 = new BinaryTreeNode("3");
//		BinaryTreeNode node4 = new BinaryTreeNode("4");
//		BinaryTreeNode node5 = new BinaryTreeNode("5");
//		BinaryTreeNode node6 = new BinaryTreeNode("6");
//		
//		node1.Left = node2; node1.Right = node3;
//		node2.Left = node4;
//		node3.Left = node6; node3.Right = node5;
//		
//		BinaryTree tree = new BinaryTree(node1);
//		tree.PreOrderTraversal();
//		tree.PostOrderTraversal();
//		tree.InOrderTraversal();
//		System.out.println("Height of tree " + tree.HeightOfTree());
//		System.out.println("Width of tree " + tree.WidthOfTree());
//		System.out.println("Number of leaves " + tree.NumberOfLeaves());
//		tree.LevelOrderTraversal();
//		System.out.println("Level with max sum " + tree.LevelWithMaxSum());
//		tree.PrintRootToLeafPaths();
//		tree.FindPathWithSum(4);
//		tree.LevelOrderTraversalReverse();
//		tree.ZigZagTraversal();
//		tree.PrintAllAncestors(node4);
//		tree.Print();
		
//		BinaryTreeNodeEx node1 = new BinaryTreeNodeEx("X");
//		BinaryTreeNodeEx node2 = new BinaryTreeNodeEx("Y");
//		BinaryTreeNodeEx root = new BinaryTreeNodeEx("1", new BinaryTreeNodeEx("2", node1, null), new BinaryTreeNodeEx("3", node2, null));
//
//		System.out.println("First common ancestor for " + node1.Data + " and " + node2.Data + " is " + BinaryTreeNodeExOperations.FirstCommonAncestor(root, node1, node2).Data);
//		int[] preOrderBST = {7, 4, 2, 1, 3, 5, 6, 9, 8, 10};
//		System.out.println(BinarySearchTreeOperations.GenerateHuffmanCodeOfBST(preOrderBST, 6));
	
		
//		int[] arr = {1, 2, 5, 3, 4};
//		System.out.println("Size of longest increasing subsequence " + SequenceOperations.LongestIncreasingSubSequenceSize(arr));
//		System.out.println("Size of longest increasing subarray " + SequenceOperations.LongestIncreasingSubArraySize(arr));
//		char[] arr1 = "GeeksForGeeks".toCharArray();
//		char[] arr2 = "Geek".toCharArray();
//		char[] lcs = SequenceOperations.LongestCommonSubSequence(arr1, arr2);
//		char[] lcs = SequenceOperations.LongestCommonSubString(arr1, arr2);
//		System.out.print("Longest common substring is ");
//		for(int i=0; i<lcs.length; i++) {
//			System.out.print(lcs[i]);
//			if(i != lcs.length-1) {
//				System.out.print(", ");
//			}
//		}
		
//		String str = "abccbcdef";
//		System.out.println("Length of longest substring with unique character " + SequenceOperations.LongestStringWithUniqueChar(str));
		
		
//		int[][] arr = {
//				{0, 0, 0, 1},
//				{0, 0, 0, 1},
//				{0, 0, 0, 1},
//				{0, 0, 0, 0}
//		};
//		System.out.println("Row with max sum " + Arrays.RowWithMaxSum(arr, 4, 4));
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(3);
//		list.add(1);
//		Arrays.SortByFrequecy(list);
		
//		int[] A = new int[] {3, 5, -7, 8, 10};
//		System.out.println("Maximum sum of non-adjaent elements : " + Arrays.MaxNonAdjacentSubsetSum(A));
		
		String a = "abcdefghijklmnopqrstuvwxyzababababAbAbaBabAbababababAbababaBabaBabAbaBababababababababaBababaBababababaBabaBabababABabababAbabababaBAbababababababababababAbababaBabababAbabababababababaBaBabAbabaBababababababababaBAbabaBAbabAbababababaBababAbababababababaBabababababaBaBaBababababAbabaBababaBaBabababababababababababababababababababAbababababababababAbababaBababababababababAbabaBabababaBAbabababababababababababababababaBababAbabababaBAbababababaBabababababababaBaBabababababababAbababababababababAbabababaBabAbabaBabAbAbabAbaBabababababaBaBababABabababababAbaBababababababaBabababababababababababAbababababababababababababababababaBabababababababababababababababAbabaBababababababababababaBAbabababAbababababababababaBabababaBaBabababababababababaBababAbaBababAbababababaBAbababaBababababababAbABabababAbababaBababababababaBaBababababAbAbabababababababababaBababababababababababababababababaBabababAbabAbababababABabababAbabababababababababaBabABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String b = "ABCDEFGHIJKLMNOPQRSTUVWXYZAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBAABBABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//String a = "LaLaLA";
		//String b = "LALLA";
		//System.out.println("Is abbrevation > " + DynamicProgramming.IsAbbrevation1(a, b));
		
//		int steps = 50;
//		System.out.println("Number of ways to take " + steps + " steps is " + DynamicProgramming.CountTotalWaysForSteps(steps));
//		DynamicProgramming.PrintAllNBraces(4);
//		ArrayList<Integer> set = new ArrayList<Integer>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		DynamicProgramming.PrintAllSubsets(set);
//		DynamicProgramming.Print8Queens();
//		int[] denominations = {25, 10, 5, 1};
//		DynamicProgramming.PrintMakeChange(denominations, 10);
		
//		Series.GeneratePrimeNumbers(1000);
//		Series.FibonacciSeries(30);
		
//		int[] mappings = new int[3];
//		mappings[0] = 2;mappings[1] = 3;mappings[2] = 5;
//		System.out.println("String representation would be > " + Strings.FindSmallestStringRepresentation(mappings, 25));
		
//		boolean[][] swaps = {
//				{true, true, true, false, false, false},
//				{true, true, false, false, false, false},
//				{true, false, true, false, false, false},
//				{false, false, false, true, false, true},
//				{false, false, false, false, true, false},
//				{false, false, false, true, false, true}
//		};
//		System.out.println("Lexicographically smallest string > " + Strings.FindSmallestString("cdafbe", swaps));
		
//		boolean[][] lessThan = {
//				{false, false, false, false},
//				{false, false, true, false},
//				{true, false, false, false},
//				{false, true, false, false}
//		};
//		GraphOperations.SortElephantsByHeight(lessThan);
		
//		GraphNode node1 = new GraphNode("1");
//		GraphNode node2 = new GraphNode("2");
//		GraphNode node3 = new GraphNode("3");
//		GraphNode node4 = new GraphNode("4");
//		GraphNode node5 = new GraphNode("5");
//		Graph graph = new Graph();
//		graph.AddEdge(node1, node2);
//		graph.AddEdge(node2, node4);
//		graph.AddEdge(node1, node3);
//		graph.AddEdge(node2, node3);
//		graph.AddEdge(node3, node4);
//		graph.AddEdge(node5, node5);
//		GraphOperations.BreadthFirstTraversal(graph);
//		GraphOperations.DepthFirstTraversal(graph);
//		GraphOperations.TopologicalSort(graph);
		
//		String a = "a";
//		String b = "b";
//		String c = "c";
//		String d = "d";
//		String e = "e";
//		Graph graph = new Graph(new String[] {a, b, c, d, e});
//		graph.AddEdge(a, b);
//		graph.AddEdge(b, c);
//		graph.AddEdge(a, d);
//		graph.AddEdge(b, d);
//		graph.AddEdge(d, c);
//		graph.AddEdge(d, e);
//		GraphOperations.BreadthFirstTraversal(graph);
//		GraphOperations.DepthFirstTraversal(graph);
//		GraphOperations.TopologicalSortBFS(graph);
//		GraphOperations.TopologicalSortDFS(graph);
		
//		int N = 2;
//		int num = 17;
//		int precision = 6;
//		System.out.println(N + "th root of " + num + " with precision " + precision + " is " + Random.FindNthRoot(N, num, precision));
//		System.out.println(Random.FormatToINR(1000000000));
		
		long n = 4294967295L;
		System.out.println("32-bit inverse > " + Random.InverseBits(n));
		
//		int[] A = new int[] {1, 2, 4, 4, 2, 4};
//		int[] P = new int[] {1, 2, 2, 1, 5};
//		System.out.println("Count of pairs > " + Random.CountPairsXOR(A, P, 7));

//		int A[] = {1, 3, 3};
//		int B[] = {2, 4, 4, 18};
//		int C[] = {5, 7, 10, 15, 16};
//		for(int output : Random.MergeSortedArrays(A, B, C)) {
//			System.out.println(output);
//		}
		
//		int num = 1234678;
//		System.out.println("Next palindrome of " + num + " > " + Random.GetNextHighestPalindrome(num));
		
//		String str = "12340187";
//		System.out.print("Max product of 3 > " + Random.MaxProductOfThreeConsecutiveDigits(str));
		
//		int num = 781;
//		System.out.println("Excel representation of " + num + " > " + Random.GetExcelColumnRepresentation(num));

//		int arr[] = {10, 20, 30, 1, 2};
//		System.out.println("Min element in array is " + Random.FindMinElementInRotatedSortedArray(arr));
		
//		int arr[] = {10, 20, 3, 5, 2, 1, 30, 4, 50};
//		System.out.println("Second highest number is " + Random.FindSecondHighestNumber(arr));
		
		/*
		int arr[][] = {
				{1, 10, 20, 30},
				{2, 11, 21, 31},
				{3, 12, 22, 32},
				{4, 13, 23, 33}
		};
		int num = 1;
		Random.FindInArraySortedRowNColumn(arr, num);
		*/
		
		/*
		String s1 = "abcdabcab";
		String s2 = "abcababcd";
		System.out.println(Strings.IsRotation(s1, s2) ? "Yes" : "No");
		*/
	}
}
