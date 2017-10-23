import java.util.*;

public class LabelledDirectedGraph {

	protected HashMap<Node, ArrayList<Node>> allMembers = new HashMap<>();
	//private Map<Node, List<Edge>> in_edge;	// from another node to this node
	protected HashMap<Node, ArrayList<Edge>> out_edge = new HashMap<>();	//from this node to another node
	

	
	public LabelledDirectedGraph(HashMap<Node, ArrayList<Node>> allMembers) {
		
		this.allMembers = allMembers;

		
	}
	
	
	
	public void addNode(Node n) {
		
		if(!allMembers.containsKey(n)) {
			
			ArrayList<Node> none = new ArrayList<>();	// create an empty List to store neighbours of node
			ArrayList<Edge> nonee = new ArrayList<>();
			allMembers.put(n,none);
			out_edge.put(n, nonee);
			
		}
		
	}
	
	
	public void addEdge(Node n, Edge e) {
		
		/*if(in_or_out == true) {		// if the edge is in_edge
			List<Edge> en = in_edge.get(n);
			en.add(e);
		}
		*/
			
			ArrayList<Edge> en = new ArrayList<>();
			en = out_edge.get(n);
			en.add(e);
		
		
	}
	
	
	public void addNeighbour(Node p, Node n) {		// link from p to n
		
		if(allMembers.containsKey(p)) {
			
			ArrayList<Node> p1 = new ArrayList<>();
			p1 = allMembers.get(p);
			p1.add(n);
			
			Edge p_to_n = new Edge(n,p.key+"to"+n.key);	// create new edge of Node p
			addEdge(p,p_to_n);			// add edge to p
		}
		
	}
	
	
	
	public void addNeighbourList(Node p, ArrayList<Node> nList) {
		
		if(allMembers.containsKey(p)) {
			
			ArrayList<Node> p1 = allMembers.get(p);
			
			Iterator<Node> iter = nList.iterator();			// add link to p and all member of nList
			while(iter.hasNext()) {
				
				Node n = iter.next();
				
				if(!p1.contains(n)) {
					p1.add(n);
					Edge p_to_n = new Edge(n,p.key+"to"+n.key);
					addEdge(p,p_to_n);
				}
			}
			
		}
	}
	
	
	
	public void getNeiboursOfNode(Node n) {
		
		if(allMembers.containsKey(n)) {
			
			List<Node> n1 = allMembers.get(n);
			Iterator<Node> iter = n1.iterator();
			while(iter.hasNext()) {
				System.out.println("Neighbours:"+ iter.next().key);
			}
			
		}
		
		else {
			
			System.out.println("cannot find the neighbours of Node n");
			
			
		}
		
	}
	
	
	public void deleteEdge(Node p, Node n) {		// delete the link between p and n
		
		List<Edge> e = out_edge.get(p);
		
		Iterator<Edge> iter = e.iterator();
		while(iter.hasNext()) {
			
			Edge e1 = iter.next();
			if(e1.to_Node == n) {
				
				e.remove(e1);
	
			}
		}
	}
	
	public void deleteNeighbour(Node p, Node n) {
		
		if(allMembers.containsKey(p)) {
			
			List<Node> n1 = allMembers.get(p);
			
			if(n1.contains(n)) {
				n1.remove(n);
				deleteEdge(p,n);
			}
			
			else
				System.out.println("cannot find the deleted neighbour Node n");
		}
		
		else
			System.out.println("cannot find Node p in the graph");
	}
	
	
	public void display() {
		
		Iterator<Map.Entry<Node, ArrayList<Edge>>> iter = out_edge.entrySet().iterator();
		
		while(iter.hasNext()) {
			
			Map.Entry<Node, ArrayList<Edge>> mp = iter.next();
			
			Node n = mp.getKey();		// get node
			List<Edge> ne = mp.getValue();	// get edge
			
			System.out.println(n.key);     // show node
			
			Iterator<Edge> itern = ne.iterator();
			while(itern.hasNext()) {			// show neighbour list
				
				Edge a = itern.next();
				
				System.out.println("Connection:" + a.label + " NeighbourList:" + a.to_Node.key);
				
			}
			
		}
	}
	
}
