package Graphs;

import java.util.*;

public class Graph {
	private String[] vertices;
	private int verticesCount;
	private int[][] edges;
	private int[] indegree;
	
	private void initialize() {
		for(int i=0; i<this.verticesCount; i++) {
			for(int j=0; j<this.verticesCount; j++) {
				edges[i][j] = 0;
			}
		}
		
		for(int i=0; i<indegree.length; i++) {
			indegree[i] = 0;
		}
	}
	
	private Graph(int numberOfVertices) {
		this.verticesCount = numberOfVertices;
		this.edges = new int[this.verticesCount][this.verticesCount];
		this.indegree = new int[this.verticesCount];
		
		this.initialize();
	}
	
	public Graph(String[] vertices) {
		this(vertices.length);
		this.vertices = vertices;
	}
	
	public int VerticesCount() {
		return this.verticesCount;
	}
	
	public String Vertex(int index) {
		return this.vertices[index];
	}
	
	public int[] Indegree() {
		return this.indegree;
	}
	
	public void AddEdge(String startVertex, String endVertex, int edgeWeight) {
		int startIndex = Integer.MIN_VALUE;
		int endIndex = Integer.MIN_VALUE;
		
		for(int i=0; i<this.vertices.length; i++) {
			if(startIndex == Integer.MIN_VALUE && this.vertices[i] == startVertex) {
				startIndex = i;
			} else if(endIndex == Integer.MIN_VALUE && this.vertices[i] == endVertex) {
				endIndex = i;
			}
			
			if(startIndex != Integer.MIN_VALUE && endIndex != Integer.MIN_VALUE) {
				break;
			}
		}
		
		if(startIndex != Integer.MIN_VALUE && endIndex != Integer.MIN_VALUE) {
			this.edges[startIndex][endIndex] = edgeWeight;
		}
		
		this.indegree[endIndex]++;
	}
	
	
	public void AddEdge(String startVertex, String endVertex) {
		this.AddEdge(startVertex, endVertex, 1);
	}
	
	
	public List<Integer> AdjacentVerticesIndex(int index) {
		List<Integer> adjacentIndexes = new ArrayList<Integer>();
		
		for(int i=0; i<this.verticesCount; i++) {
			if(index != i && this.edges[index][i] == 1) {
				adjacentIndexes.add(i);
			}
		}
		
		return adjacentIndexes;
	}
	
//	public List<GraphNode> Nodes;
//	public HashMap<GraphNode, Integer> Indegree;
//	
//	public Graph() {
//		this.Nodes = new ArrayList<GraphNode>();
//		this.Indegree = new HashMap<GraphNode, Integer>();
//	}
//	
//	public void AddEdge(GraphNode from, GraphNode to) {
//		boolean fromAlreadyExists = false;
//		boolean toAlreadyExists = false;
//		GraphNode fromNode = new GraphNode("");
//		GraphNode toNode = new GraphNode("");
//
//		Iterator<GraphNode> iterator = this.Nodes.iterator();
//		while(iterator.hasNext()) {
//			GraphNode node = iterator.next();
//			if(!fromAlreadyExists && node.Data == from.Data) {
//				fromAlreadyExists = true;
//				fromNode = node;
//			} else if(!toAlreadyExists && node.Data == to.Data) {
//				toAlreadyExists = true;
//				toNode = node;
//			}
//			
//			if(fromAlreadyExists && toAlreadyExists) {
//				break;
//			}
//		}
//		
//		if(fromAlreadyExists) {
//			fromNode.AddAdjacentNode(to);
//		} else {
//			from.AddAdjacentNode(to);
//			this.Nodes.add(from);
//		}
//		
//		if(!toAlreadyExists) {
//			this.Nodes.add(to);
//		}
//		
//		if(this.Indegree.containsKey(to)) {
//			this.Indegree.put(to, this.Indegree.remove(to)+1);
//		} else {
//			this.Indegree.put(to, 1);
//		}
//	}
//	
//	public int[] GetIndegrees() {
//		int[] indegree = new int[this.Nodes.size()];
//		
//		for(int i=0; i<indegree.length; i++) {
//			indegree[i] = 0;
//		}
//		
//		for(GraphNode node : this.Nodes) {
//			for(GraphNode adjacentNode : node.AdjacentNodes) {
//				indegree[this.Nodes.indexOf(adjacentNode)]++;
//			}
//		}
//		
//		return indegree;
//	}
}
