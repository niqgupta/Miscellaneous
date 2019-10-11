package Tree;

import java.util.*;

public class BinaryTree {
	private BinaryTreeNode root;
	
	public BinaryTree(BinaryTreeNode node) {
		this.root = node;
	}
	
	public int HeightOfTree() {
		if(root == null) {
			return 0;
		}
		
		return HeightOfTree(root);
		/*
		int heightOfTree = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if(temp == null) {
				heightOfTree++;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			
			if(temp.Left != null) {
				queue.add(temp.Left);
			}
			if(temp.Right != null) {
				queue.add(temp.Right);
			}
		}
		
		return heightOfTree;*/
	}
	
	private int HeightOfTree(BinaryTreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return Math.max(HeightOfTree(root.Left), HeightOfTree(root.Right)) + 1;
	}
	
	public int WidthOfTree() {
		if(root == null) {
			return 0;
		}
		
		int widthLeftSide = 0;
		int widthRightSide = 0;
		
		BinaryTreeNode leftSide = root.Left;
		while(leftSide != null) {
			widthLeftSide++;
			leftSide = leftSide.Left;
		}
		
		BinaryTreeNode rightSide = root.Right;
		while(rightSide != null) {
			widthRightSide++;
			rightSide = rightSide.Right;
		}
		
		return (widthLeftSide + 1 + widthRightSide);
	}
	
	public int NumberOfLeaves() {
		if(root == null) {
			return 0;
		}
		
		int numberOfLeaves = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if(temp.Left == null && temp.Right == null) {
				numberOfLeaves++;
				continue;
			}
			
			if(temp.Left != null) {
				queue.add(temp.Left);
			}
			
			if(temp.Right != null) {
				queue.add(temp.Right);
			}
		}
		
		return numberOfLeaves;
	}
	
	public void PreOrderTraversal() {
		System.out.println("Pre order traversal");
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		BinaryTreeNode temp = root;
		while(true) {
			while(temp != null) {
				System.out.print(temp.Data + " ");
				stack.push(temp);
				temp = temp.Left;
			}
			
			if(stack.isEmpty())
				break;
			
			temp = stack.pop();
			temp = temp.Right;
		}
	}
	
	public void PostOrderTraversal() {
		System.out.println("Post order traversal");
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		HashSet<BinaryTreeNode> visited = new HashSet<BinaryTreeNode>();
		
		BinaryTreeNode temp = root;
		while(true) {
            while(temp != null) {
                stack.push(temp);
                temp = temp.Left;
            }

            if(stack.isEmpty())
                break;
            
            if(stack.peek().Right == null) {
            	BinaryTreeNode pop = stack.pop();
            	visited.add(pop);
                System.out.print(pop.Data + " ");
            } else {
            	if(!visited.contains(stack.peek().Right))
            		temp = stack.peek().Right;
            	else {
            		BinaryTreeNode pop = stack.pop();
                	visited.add(pop);
                    System.out.print(pop.Data + " ");
            	}
            }
			/*
			while(temp != null) {
				stack.push(temp);
				temp = temp.Left;
			}
			
			if(stack.isEmpty())
				break;
			
			if(stack.peek().Right == null) {
				BinaryTreeNode popped = stack.pop();
				System.out.print(popped.Data + " ");
				
				while(!stack.isEmpty() && popped == stack.peek().Right) {
					popped = stack.pop();
					System.out.print(popped.Data + " ");
				}
			} else
				temp = stack.peek().Right;
			*/
		}
	}
	
	public void InOrderTraversal() {
		System.out.println("In order traversal");
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode temp = root;
		
		while(true) {
			while(temp != null) {
				stack.push(temp);
				temp = temp.Left;
			}
			
			if(stack.isEmpty())
				break;
			
			BinaryTreeNode pop = stack.pop();
			System.out.print(pop.Data + " ");
			temp = pop.Right;				
		}
	}
	
	public void LevelOrderTraversalReverse() {
		System.out.println("Reverse level order traversal");
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if(temp == null) {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			
			System.out.print(temp.Data + " ");
			
			if(temp.Right != null) {
				queue.add(temp.Right);
			}
			
			if(temp.Left != null) {
				queue.add(temp.Left);
			}
		}
	}
	
	public void LevelOrderTraversal() {
		if(root == null) {
			return;
		}
		
		System.out.print("Level order traversal ");
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			System.out.print(temp.Data + " ");
			
			if(temp.Left != null) {
				queue.add(temp.Left);
			}
			
			if(temp.Right != null) {
				queue.add(temp.Right);
			}
		}
		
		System.out.println();
	}
	
	public void ZigZagTraversal() {
		if(root == null) {
			return;
		}
		
		System.out.println("Zig zag traversal");
		boolean isReverseSwitch = false;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty() || !stack.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			
			if(temp == null) {
				if(queue.isEmpty() && !stack.isEmpty()) {
					while(!stack.isEmpty()) {
						queue.add(stack.pop());
					}
					queue.add(null);
					isReverseSwitch = !isReverseSwitch;
				}
				
				System.out.println();
				continue;
			}
			
			System.out.print(temp.Data + " ");
			
			if(isReverseSwitch) {
				if(temp.Right != null) {
					stack.add(temp.Right);
				}
				
				if(temp.Left != null) {
					stack.add(temp.Left);
				}
			} else {
				if(temp.Left != null) {
					stack.add(temp.Left);
				}
				
				if(temp.Right != null) {
					stack.add(temp.Right);
				}
			}
		}
	}
	
	public int LevelWithMaxSum() {
		if(root == null) {
			return 0;
		}
		
		int levelWithMaxSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int currentLevel = 1;
		int currentLevelSum = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if(temp == null) {
				if(currentLevelSum > maxSum) {
					maxSum = currentLevelSum;
					levelWithMaxSum = currentLevel;
				}
				
				currentLevel++;
				currentLevelSum = 0;
				if(!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			
			currentLevelSum += Integer.parseInt(temp.Data);
			if(temp.Left != null) {
				queue.add(temp.Left);
			}
			if(temp.Right != null) {
				queue.add(temp.Right);
			}
		}
		
		return levelWithMaxSum;
	}
	
	public void FindPathWithSum(int sum) {
		int pathIndex = -1;
		String[] path = new String[this.HeightOfTree()];
		
		System.out.println("Paths with sum " + sum);
		FindPathWithSum(root, sum, pathIndex, path);
	}
	
	private void FindPathWithSum(BinaryTreeNode root, int sum, int pathIndex, String[] path) {
		if(root == null) {
			return;
		}
		
		path[pathIndex + 1] = root.Data;
		if(Integer.parseInt(root.Data) == sum ) {
			for(int i=0; i<=pathIndex+1; i++ ) {
				System.out.print(path[i] + " ");
			}
			path[pathIndex + 1] = "";
			return;
		}
		
		
		if(root.Left != null) {
			FindPathWithSum(root.Left, sum - Integer.parseInt(root.Data), pathIndex+1, path);
		}
		
		if(root.Right != null) {
			FindPathWithSum(root.Right, sum - Integer.parseInt(root.Data), pathIndex+1, path);
		}
		path[pathIndex + 1] = "";
	}
	
	public void PrintRootToLeafPaths() {
		int pathIndex = -1;
		String[] path = new String[this.HeightOfTree()];
		
		System.out.println("All root to leaf paths");
		PrintRootToLeafPaths(root, pathIndex, path);
	}
	
	private void PrintRootToLeafPaths(BinaryTreeNode root, int pathIndex, String[] path) {
		if(root == null) {
			return;
		}
		
		if(root.Left == null && root.Right == null) {
			path[pathIndex+1] = root.Data;
			for(int i=0; i<=pathIndex+1; i++) {
				System.out.print(path[i] + " ");
			}
			System.out.println();
			path[pathIndex+1] = "";
			
			return;
		}
		
		path[pathIndex+1] = root.Data;
		PrintRootToLeafPaths(root.Left, pathIndex+1, path);
		PrintRootToLeafPaths(root.Right, pathIndex+1, path);
		path[pathIndex+1] = null;
	}
	
	public void PrintAllAncestors(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.println("All ancestors of " + node.Data);
		int pathIndex = -1;
		String path[] = new String[this.HeightOfTree()];
		PrintAllAncestors(root, node, pathIndex, path);
	}
	
	private void PrintAllAncestors(BinaryTreeNode root, BinaryTreeNode node, int pathIndex, String[] path) {
		if(root == null || node == null) {
			return;
		}
		
		if(root == node) {
			for(int i=0; i<=pathIndex; i++) {
				System.out.print(path[i] + ", ");
			}
		}
		
		path[pathIndex+1] = root.Data;
		
		if(root.Left != null) {
			PrintAllAncestors(root.Left, node, pathIndex + 1, path);
		}
		
		if(root.Right != null) {
			PrintAllAncestors(root.Right, node, pathIndex + 1, path);
		}
		
		path[pathIndex+1] = "";
		
	}
	
	public void Print() {
		if(root == null) {
			return;
		}
		
		int heightOfTree = this.HeightOfTree();
		BinaryTreeNode emptyTreeNode = new BinaryTreeNode("");
		for(int i=0; i<=(Math.pow(2, --heightOfTree)-1); i++) {
			System.out.print(" ");
		}
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.remove();
			if(temp == null) {
				if(!queue.isEmpty()) {
					queue.add(null);
					System.out.println();
				}
				
				heightOfTree--;
				for(int i=0; i<=(Math.pow(2, heightOfTree)-1); i++) {
					System.out.print(" ");
				}
				continue;
			} else if(temp == emptyTreeNode) {
				queue.add(emptyTreeNode);
				queue.add(emptyTreeNode);
				System.out.print(" ");
				continue;
			}
			
			System.out.print(temp.Data);
			if(temp.Left != null) {
				queue.add(temp.Left);
			} else {
				queue.add(emptyTreeNode);
			}
			if(temp.Right != null) {
				queue.add(temp.Right);
			} else {
				queue.add(emptyTreeNode);
			}
		}
	}
	
}
