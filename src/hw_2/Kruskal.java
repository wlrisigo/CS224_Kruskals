package hw_2;
import java.util.*;
import java.lang.*; 
import java.io.*;

public class Kruskal {
	

	
	class Edge implements Comparable<Edge>{
		 int src, dest, weight; 
		@Override
		public int compareTo(Edge otherEdge) {
			return this.weight-otherEdge.weight;
		}
		
	};
	
	
	private int V;
	Edge edge[]; 
	private int parentorHeight[];
	private int count;
	
	public Kruskal(int v, int e) {
		count = v; 
		parentorHeight = new int[v];
		for(int node = 0; node < v; node++) {
			parentorHeight[node] = -1;		
		}	
	}
	
public int getCount() {
	return(count);
}
	
	
	public int find(int node){ 
	        // find root and make root as parent of i (path compression) 
		
		 //when it holds a parent 
	        if (parentorHeight[node] > 0) {
	        	// recursively call
	        	parentorHeight[node] = find(parentorHeight[node]);  
	        	//Every time I am at the root and while recursive stack is not empty I will subtract one
		        parentorHeight[node] += 1; // i don't want to take away from height 
		        								//  if what I am looking for is the root
	    }
	        //return index when height
	        return(node);
}
	 
	 //when making a union if x and y within same set then 
	public boolean isConnected(int x, int y){
		 return find(x) == find(y);
	 }
	
	public void unionHeight(int X, int Y) {
		int x = find(X);
		int y = find(Y);
		if(isConnected(X,Y)) {
			// fix above should be here cause that case will never happen check Kruskal
			if(X<Y) {
				parentorHeight[x] -=parentorHeight[y]; 
				//have root of y point to x
				parentorHeight[y] = x;
				return;
			}else{
				parentorHeight[y] -=parentorHeight[x]; 
				//have root of x point to y
				parentorHeight[x] = y;
				return;
			}
		}
		if(x < y) {
			//Add together the heights
			parentorHeight[x] -=parentorHeight[y]; 
			//have root of y point to x
			parentorHeight[y] = x;
		}else {
			parentorHeight[y] -=parentorHeight[x]; 
			//have root of y point to x
			parentorHeight[x] = y;
		}
		count--;
	}	 
	
	
	void KruskalMST(){
		Edge result[] = new Edge[V];
		int e = 0;
		int i = 0;
		for(i=0; i < V; i++) {
			result[i] = new Edge();
		}
		Arrays.sort(edge);
		i=0;
		while(e< V-1){
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			int x = next_edge.src; 
			int y = next_edge.dest;
			if(!isConnected(x,y)) {
				result[e++] = next_edge;
				unionHeight(x,y);
			}
		}
		 for (i = 0; i < e; ++i) 
	            System.out.println(result[i].src+" -- " +  
	                   result[i].dest+" == " + result[i].weight); 
	}
	
	
	
	public static void main (String[] args) 
    { 
  
        /* Let us create following weighted graph 
                 10 
            0--------1 
            |  \     | 
           6|   5\   |15 
            |      \ | 
            2--------3 
                4       */
        int V = 4;  // Number of vertices in graph 
        int E = 5;  // Number of edges in graph 
        Kruskal graph = new Kruskal(V, E); 
  
        // add edge 0-1 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = 10; 
  
        // add edge 0-2 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 6; 
  
        // add edge 0-3 
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 3; 
        graph.edge[2].weight = 5; 
  
        // add edge 1-3 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 15; 
  
        // add edge 2-3 
        graph.edge[4].src = 2; 
        graph.edge[4].dest = 3; 
        graph.edge[4].weight = 4; 
  
        graph.KruskalMST(); 
    } 
	
}
