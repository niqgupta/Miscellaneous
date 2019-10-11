package LinkedList;

public class LinkedListNode {
	public String Data;
	public LinkedListNode Next;
	
	public LinkedListNode(String data) {
		this.Data = data;
		this.Next = null;
	}
	
	public LinkedListNode(String data, LinkedListNode next) {
		this.Data = data;
		this.Next = next;
	}
	
	public void Print() {
		System.out.println(Data);
	}
}
