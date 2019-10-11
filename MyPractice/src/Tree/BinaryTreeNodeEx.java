package Tree;

public class BinaryTreeNodeEx {
	public String Data;
	public BinaryTreeNodeEx Parent;
	public BinaryTreeNodeEx LeftChild;
	public BinaryTreeNodeEx RightChild;
	
	public BinaryTreeNodeEx(String data) {
		this.Data = data;
		this.Parent = null;
		this.LeftChild = null;
		this.RightChild = null;
	}
	
	public BinaryTreeNodeEx(String data, BinaryTreeNodeEx leftChild, BinaryTreeNodeEx rightChild) {
		this.Data = data;
		this.LeftChild = leftChild;
		if(leftChild != null) {
			leftChild.Parent = this;
		}
		this.RightChild = rightChild;
		if(rightChild != null) {
			rightChild.Parent = this;
		}
	}
	
	public void AddLeftChild(BinaryTreeNodeEx child) {
		this.LeftChild = child;
		child.Parent = this;
	}
	
	public void AddRightChild(BinaryTreeNodeEx child) {
		this.RightChild = child;
		child.Parent = this;
	}
	
	public void Print() {
		System.out.println(this.Data);
	}
}
