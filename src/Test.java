
import java.util.*;

public class Test {
	
	public Test() {
		
	}
	
	
	public static void main(String[] args) {
		

		HashMap<Node, ArrayList<Node>> allMembers = new HashMap<>();
	
		
		LabelledDirectedGraph dGraph = new LabelledDirectedGraph(allMembers);
		
		Node n1 = new Node("Red",1);
		Node n2 = new Node("Green",2);
		Node n3 = new Node("Blue",3);
		Node n4 = new Node("White",4);
		
		ArrayList<Node> neighbour1 = new ArrayList<>();
		ArrayList<Node> neighbour4 = new ArrayList<>();
		
		neighbour1.add(n2);
		neighbour1.add(n3);
		neighbour1.add(n4);
		
		neighbour4.add(n1);
		neighbour4.add(n3);
		
		dGraph.addNode(n1);
		dGraph.addNode(n2);
		dGraph.addNode(n3);
		dGraph.addNode(n4);
		
		dGraph.addNeighbourList(n1,neighbour1);
		dGraph.addNeighbour(n2, n1);
		dGraph.addNeighbour(n3, n2);
		dGraph.addNeighbourList(n4, neighbour4);
		
		// test the whole graph
		System.out.println("Now display the whole graph:");
		dGraph.display();
		System.out.println();
		
		// test the delete function
		System.out.println("Now delete the Blue neighbour of White: ");
		dGraph.deleteNeighbour(n4, n1);
		dGraph.display();
		System.out.println();
		
		// test the get function
		System.out.println("Now get all the neighbours of Red:");
		dGraph.getNeiboursOfNode(n1);
		System.out.println();
		
		// test the add function
		System.out.println("Now add a new Node Pink as the neighbour of Green");
		dGraph.addNeighbour(n2, new Node("Pink",5));
		dGraph.display();
	}
}
