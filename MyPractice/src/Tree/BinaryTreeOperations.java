package Tree;

public class BinaryTreeOperations {
	/*
	 * Check is a tree is sum tree i.e. value of a node should be equal to sum of it's child.
	 */
	public static boolean IsSumTree(BinaryTreeNode root) {
		if(root == null) {
			return false;
		} else if(root.Left == null && root.Right == null) {
			return true;
		}
		
		int sum = 0;
		boolean left = false;
		if(root.Left != null) {
			sum += Integer.parseInt(root.Left.Data);
			left = IsSumTree(root.Left);
		}
		
		boolean right = false;
		if(root.Right != null) {
			sum += Integer.parseInt(root.Right.Data);
			right = IsSumTree(root.Right);
		}
		
		if(sum != Integer.parseInt(root.Data) || !left || !right) {
			return false;
		}
		
		return true;
	}
}
