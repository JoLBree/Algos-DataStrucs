import java.util.ArrayList;


//
// SHORTESTPATHS.JAVA
// Compute shortest paths in a graph.
//
// Your constructor should compute the actual shortest paths and
// maintain all the information needed to reconstruct them.  The
// returnPath() function should use this information to return the
// appropriate path of edge ID's from the start to the given end.
//
// Note that the start and end ID's should be mapped to vertices using
// the graph's get() function.
//
// You can ignore the input and startTime arguments to the constructor
// unless you are doing the extra credit.
//
class ShortestPaths {

	int[] dists;
	Edge[] fromEdge;
	Handle[] handles;
	PriorityQueue<Vertex> pq;
	int start; // start Id
	int mew = 45; // min layover time
	
	//
	// constructor
	//
	public ShortestPaths(Multigraph G, int startId, 
			Input input, int startTime) 
	{
		if (startTime == 0){
			start = startId;
			pq = new PriorityQueue<Vertex>();
			dists = new int[G.nVertices()];
			fromEdge = new Edge[G.nVertices()];
			handles = new Handle[G.nVertices()];
			for (int i = 0; i < G.nVertices(); i++){
				if (i == startId){
					dists[i] = 0;
					handles[i] = pq.insert(0, G.get(i));
				} else{
					dists[i] = Integer.MAX_VALUE;
					handles[i] = pq.insert(Integer.MAX_VALUE, G.get(i));
				}
			}
			while (!pq.isEmpty()){
				Vertex u = pq.extractMin();
				if (dists[u.id()] == Integer.MAX_VALUE) return;
				Vertex.EdgeIterator t = u.adj();
				while(t.hasNext()){
					Edge e = t.next();
					if (u.id() == e.from().id()){
						Vertex v = e.to();
						Handle h = handles[v.id()];
						if(pq.decreaseKey(h, dists[u.id()]+e.weight())){
							dists[v.id()] = dists[u.id()]+e.weight();
							fromEdge[v.id()] = e;
						}
					}
				}    		
			}
		} else{ // Extra credit version here
			start = startId;
			pq = new PriorityQueue<Vertex>();
			dists = new int[G.nVertices()];
			fromEdge = new Edge[G.nVertices()];
			handles = new Handle[G.nVertices()];
			for (int i = 0; i < G.nVertices(); i++){
				if (i == startId){
					dists[i] = 0;
					handles[i] = pq.insert(0, G.get(i));
				} else{
					dists[i] = Integer.MAX_VALUE;
					handles[i] = pq.insert(Integer.MAX_VALUE, G.get(i));
				}
			}
			while (!pq.isEmpty()){
				Vertex u = pq.extractMin();
				if (dists[u.id()] == Integer.MAX_VALUE) return;
				Vertex.EdgeIterator t = u.adj();
				while(t.hasNext()){
					Edge e = t.next();
					if (u.id() == e.from().id()){
						Vertex v = e.to();
						Handle h = handles[v.id()]; // we are currently checking path u to v
						int uArrival;
						if (u.id() == start) {
							uArrival = startTime;
						} else{
							uArrival = input.flights[fromEdge[u.id()].id()].endTime;
						}						
						int eTovDeparture = input.flights[e.id()].startTime;
						int layoverTime = mew + (eTovDeparture - uArrival - mew + 2880)%1440;
						if(pq.decreaseKey(h, dists[u.id()]+e.weight()+layoverTime)){
							dists[v.id()] = dists[u.id()]+e.weight()+layoverTime;
							fromEdge[v.id()] = e;
						}
					}
				}    		
			}
		}
		

	}

	//
	// returnPath()
	// Return an array containing a list of edge ID's forming
	// a shortest path from the start vertex to the specified
	// end vertex.
	//
		
	public int [] returnPath(int endId) 
	{ 
		ArrayList<Integer> bkwrds = new ArrayList<Integer>();
		int i = endId;
		while (i != start){
			bkwrds.add(fromEdge[i].id());
			i = fromEdge[i].from().id();
		}
		int[] path = new int[bkwrds.size()];
		i = 0;
		for (int j = bkwrds.size()-1; j >= 0; j--){
			path[i] = bkwrds.get(j);
			i++;
		}
		return path;		
	}
}
