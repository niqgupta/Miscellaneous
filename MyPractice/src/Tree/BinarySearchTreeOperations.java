package Tree;

public class BinarySearchTreeOperations {
	/*
	 * Given preorder traversal of binary search tree, generate huffman code for a node.
	 * If node is root then just print "#"
	 * For non-root node, print path from root to node, for every left take 0 and right take 1.
	 * Ex:          7
	 * 			4			9
	 *		2		5	8		10
	 *	1		3	6
	 *Huffman code for node 3 of above BST is 001
	 *	7->4 = 0
	 *	4->2 = 0
	 *	2->3 = 1
	 */
	public static String GenerateHuffmanCodeOfBST(int[] preOrder, int node) {
		return GenerateHuffmanCodeOfBST(preOrder, node, 0);
	}
	
	private static String GenerateHuffmanCodeOfBST(int[] preOrder, int node, int indexToProcess) {
		String huffmanCode = new String();
		
		if(preOrder[0] == node) {
			huffmanCode = "#";
		} else if(preOrder[indexToProcess] == node) {
			huffmanCode = "";
		} else if(preOrder[indexToProcess] > node) {
			huffmanCode = "0" + GenerateHuffmanCodeOfBST(preOrder, node, indexToProcess+1);
		} else {
			int rightSubTreeRootIndex = indexToProcess+1;
			for(; rightSubTreeRootIndex < preOrder.length; rightSubTreeRootIndex++) {
				if(preOrder[rightSubTreeRootIndex] > preOrder[indexToProcess]) {
					break;
				}
			}
			huffmanCode = "1" + GenerateHuffmanCodeOfBST(preOrder, node, rightSubTreeRootIndex);
		}
		
		return huffmanCode;
	}
}
