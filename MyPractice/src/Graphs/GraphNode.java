package Graphs;

import java.util.*;

public class GraphNode {
	public String Data;
	public List<GraphNode> AdjacentNodes;
	
	private GraphNode() {
		this.Data = null;
		this.AdjacentNodes = new ArrayList<GraphNode>();
	}
	
	public GraphNode(String data){
		this();
		this.Data = data;
	}
	
	public void AddAdjacentNode(GraphNode node) {
		boolean alreadyExists = false;
		Iterator<GraphNode> iterator = this.AdjacentNodes.iterator();
		while(iterator.hasNext()) {
			GraphNode adjacentNode = iterator.next();
			if(adjacentNode.Data == node.Data) {
				alreadyExists = true;
				break;
			}
		}
		
		if(!alreadyExists) {
			this.AdjacentNodes.add(node);
		}
	}
}
