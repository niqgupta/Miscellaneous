package LinkedList;

public class LinkedList {
	protected LinkedListNode head;
	
	public LinkedList() {
		head = null;
	}
	
	public void AddToHead(String data) {
		LinkedListNode newNode = new LinkedListNode(data, head);
		head = newNode;
	}
	
	public void AddToTail(String data) {
		LinkedListNode newNode = new LinkedListNode(data);
		
		LinkedListNode lastNode = head;
		while(lastNode.Next != null) {
			lastNode = lastNode.Next;
		}
		
		lastNode.Next = newNode;
	}
	
	public void AddToPosition(String data, int position) {
		LinkedListNode newNode = new LinkedListNode(data);
		
		if(position == 1) {
			newNode.Next = head;
			head = newNode;
		}
		else if (position > 1) {
			LinkedListNode previousNode = head;
			int currentLocation = 2;
			while(currentLocation < position && previousNode.Next != null) {
				previousNode = previousNode.Next;
				currentLocation++;
			}
			
			newNode.Next = previousNode.Next;
			previousNode.Next = newNode;
		}
	}
	
	public void RemoveHead() {
		//LinkedListNode nodeToRemove = head;
		head = head.Next;
	}
	
	public void RemoveTail() {
		LinkedListNode previousNode = head;
		LinkedListNode tailNode = head.Next;
		while(tailNode != null && tailNode.Next != null ) {
			previousNode = tailNode;
			tailNode = tailNode.Next;
		}
		
		previousNode.Next = null;
	}
	
	public void RemoveAtPosition(int position) {
		if(position == 1) {
			head = head.Next;
		} else if(position > 1) {
			LinkedListNode previousNode = head;
			LinkedListNode currentNode = head.Next;
			int currentPosition = 2;
			while(currentPosition < position && currentNode.Next != null) {
				currentPosition++;
				previousNode = currentNode;
				currentNode = currentNode.Next;
			}
			
			if(currentPosition == position) {
				previousNode.Next = currentNode.Next;
			}
		}
	}
	
	public void Print() {
		LinkedListNode temp = head;
		while(temp != null) {
			System.out.print(temp.Data);
			temp = temp.Next;
			if(temp != null) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}
}
