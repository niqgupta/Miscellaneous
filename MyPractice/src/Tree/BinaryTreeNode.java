package Tree;

public class BinaryTreeNode {
	public String Data;
	public BinaryTreeNode Left;
	public BinaryTreeNode Right;
	
	public BinaryTreeNode(String data) {
		this.Data = data;
		this.Left = null;
		this.Right = null;
	}
	
	public BinaryTreeNode(String data, BinaryTreeNode left, BinaryTreeNode right) {
		this.Data = data;
		this.Left = left;
		this.Right = right;
	}
	
	public void AddLeftChild(BinaryTreeNode child) {
		this.Left = child;
	}
	
	public void AddRightChild(BinaryTreeNode child) {
		this.Right = child;
	}
	
	public void Print() {
		System.out.println(Data);
	}
}
