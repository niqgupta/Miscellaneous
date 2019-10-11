package LinkedList;

import java.util.*;

public class LinkedListOperations extends LinkedList {
	
	public LinkedListOperations() {
		super();
	}
	
	public LinkedListNode FindNthNode(int n) {
		LinkedListNode nthNode = head;
		int index = 1;
		
		while(index < n) {
			if(nthNode == null) {
				break;
			}
			
			nthNode = nthNode.Next;
			index++;
		}

		return nthNode;
	}
	
	public void Reverse() {
		LinkedListNode reversedList = null;
		
		while(head != null) {
			LinkedListNode temp = head;
			head = head.Next;
			temp.Next = reversedList;
			reversedList = temp;
		}
		
		head = reversedList;
	}
	
	public void ReverseInPairs() {
		LinkedListNode pairElement1 = null;
		LinkedListNode pairElement2 = null;
		LinkedListNode temp = head;
		LinkedListNode previousNode = null;
		
		while(temp != null && temp.Next != null) {
			pairElement1 = temp;
			pairElement2 = temp.Next;
			temp = temp.Next.Next;
			
			pairElement1.Next = pairElement2.Next;
			pairElement2.Next = pairElement1;
			
			if(previousNode == null) {
				head = pairElement2;
			} else {
				previousNode.Next = pairElement2;
			}
			previousNode = pairElement1;
		}
	}
	
	public LinkedListNode FindMiddleNode() {
		LinkedListNode middleNode = head;
		LinkedListNode lastNode = head.Next;
		
		while(lastNode != null && lastNode.Next != null) {
			middleNode = middleNode.Next;
			lastNode = lastNode.Next.Next;
		}
		
		return middleNode;
	}
	
	public void PrintFromEnd() {
		PrintFromEnd(head);
	}
	
	private void PrintFromEnd(LinkedListNode node) {
		if(node == null) {
			return;
		}
		
		PrintFromEnd(node.Next);
		if(node.Next != null) {
			System.out.print(" -> ");
		}
		
		System.out.print(node.Data);
	}
	
	public static int Length(LinkedListNode head) {
		LinkedListNode temp = head;
		int lengthOfList = 0;
		
		while(temp != null) {
			lengthOfList++;
			temp = temp.Next;
		}
		
		return lengthOfList;
	}
	
	public static LinkedListNode FindIntersectingPoint(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode intersectingNode = null;
		
		LinkedListNode list1 = head1;
		LinkedListNode list2 = head2;
		int length1 = LinkedListOperations.Length(head1);
		int length2 = LinkedListOperations.Length(head2);
		
		int diff = length1 - length2;
		if(length1 < length2) {
			diff = length2 - length1;
			list1 = head2;
			list2 = head1;
		}
		
		while(diff != 0) {
			list1 = list1.Next;
			diff--;
		}
		
		while(list1 != null && list2 != null) {
			if(list1 == list2) {
				intersectingNode = list1;
				break;
			}
			
			list1 = list1.Next;
			list2 = list2.Next;
		}
		
		return intersectingNode;
	}
	
	
	public static boolean IsPalindrome(LinkedListNode head) {
		Stack<String> stack = new Stack<String>();
		LinkedListNode slowNode = head;
		LinkedListNode fastNode = head;
		
		while(fastNode != null && fastNode.Next != null) {
			stack.add(slowNode.Data);
			slowNode = slowNode.Next;
			fastNode = fastNode.Next.Next;
		}
		
		if(fastNode != null) {
			slowNode = slowNode.Next;
		}
		
		while(!stack.isEmpty()) {
			if(stack.pop() != slowNode.Data) {
				return false;
			}
			
			slowNode = slowNode.Next;
		}
		
		return true;
	}
	
	
	/*
	 * Print linked list
	 */
	public static void Print(LinkedListNode head) {
		LinkedListNode current = head;
		
		while(current != null) {
			System.out.print(current.Data);
			current = current.Next;
			
			if(current != null) {
				System.out.print("->");
			}
		}
	}
	
	/*
	 * Reverse linked list K nodes
	 */
	public static LinkedListNode ReverseKNodes(LinkedListNode head, int K) {
		LinkedListNode reversedList = head;
		LinkedListNode prevKNode = null;
		LinkedListNode startK = head;
		LinkedListNode endK = head;
		
		while(endK.Next != null) {
			int count = 0;
			while(count<K && endK.Next != null) {
				endK = endK.Next;
				count++;
			}
			
			if(count < K) {
				break;
			}
			count = 0;

			LinkedListNode reverse = endK;
			LinkedListNode current = startK;
			do {
				LinkedListNode temp = current.Next;
				current.Next = reverse;
				reverse = current;
				current = temp;
			} while(current != endK);
			
			if(prevKNode == null) {
				reversedList = reverse;
			} else {
				prevKNode.Next = reverse;
			}
			prevKNode = startK;
			startK = startK.Next;
		}
		
		return reversedList;
	}
}
