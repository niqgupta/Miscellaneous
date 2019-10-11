package Tree;

import java.util.*;

public class BinaryTreeNodeExOperations {
	/*
	 * Given a binary tree where each node has pointer to it's parent node.
	 * For two nodes N1 and N2 find their first common ancestors.
	 */
	public static BinaryTreeNodeEx FirstCommonAncestor(
			BinaryTreeNodeEx root,
			BinaryTreeNodeEx node1,
			BinaryTreeNodeEx node2) {
		BinaryTreeNodeEx firstCommonAncestor = node1;
		BinaryTreeNodeEx temp = node2;
		
		Set<BinaryTreeNodeEx> visitedNodes = new HashSet<BinaryTreeNodeEx>();
		do {
			visitedNodes.add(temp);
			temp = temp.Parent;
		} while(temp != root);
		
		do {
			if(visitedNodes.contains(firstCommonAncestor)) {
				break;
			}
			
			firstCommonAncestor = firstCommonAncestor.Parent;
		} while(firstCommonAncestor != root);
		
		return firstCommonAncestor;
	}
}
