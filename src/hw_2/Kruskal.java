package hw_2;
import java.util.*;
import java.lang.*; 
import java.io.*;

public class Kruskal {
	
	
	  
	  
	
	public class Edge{
		
		public Edge(int src, int dst, int weight) {
			this.src = src;
			this.dst =dst;
			this.weight = weight;
		}
		public Edge() {
			
		}
		int src, dst, weight;
		
		int getSrc() {
			return src;
		}
		int getDst() {
			return dst;
		}
		int getWeight() {
			return weight;			
		}
		void setSrc(int Src) {
			src = Src;
		}
		void setDst(int Dst) {
			dst = Dst;
		}
		void setWeight(int Weight) {
			weight = Weight;
		}
		
	}

	private int V; 
	private int Z; 
	//THE NODE'S ACTUAL Random Variable IS 1 - ARRAY INDEX
	//SO IF LOOKIN FOR ACTUAL NODE GO TO ONE LESS INDEX
	private int parentorHeight[];
	private int count; 
	
	
	public Kruskal(int v, int e) {
		count = v; 
		V=v;
		Z=e;
		parentorHeight = new int[v];
		for(int node = 0; node < v; node++) {
			parentorHeight[node] = -1;		
		}	
//		for(int edg = 0; edg < e; e++) {
//			edge[edg] = new Edge();
//		}
	}
	
	public int getCount() {
		return(count);
	}

	public int find(int x){ 
		int node = x;
		int a = parentorHeight[x];
	        // find root and make root as parent of i (path compression) 
		boolean isValueIndexPos = false;
		//first check to see if it holds a positive number
	        if (parentorHeight[node] > 0) {
	        	//if holds a positive value and  its parent is a positive value mark x true
	        	if(parentorHeight[parentorHeight[node]] > 0) {
	        		isValueIndexPos = true;	
	        	}
	        	// go to the index value of what array is holding
	        	//and whatever that index value is holding make it parent node
	        	//do this until parent[node] is a negative value
	        	parentorHeight[node] = find(parentorHeight[node]);        	
	    }
	        //if the index of the value was not negative add one to root(which should be negative
	      //  System.out.println(x);
	        if(isValueIndexPos) {
	        	System.out.println(parentorHeight[node]);
        		parentorHeight[node] += 1;
        		} // Should only add if index is negative
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
		
		//which root has a larger negative value;
		int a = parentorHeight[x];
		int b = parentorHeight[y];
		
		if(parentorHeight[x] < parentorHeight[y]) {
			//have root of y point to x
			parentorHeight[y] = x;
		}
		else if(parentorHeight[x] > parentorHeight[y]) {
			parentorHeight[x] = y;
		}
		else if(X<Y) {
			if(parentorHeight[y]<0)
				parentorHeight[x]= parentorHeight[x] - 1*(1); 
			//have root of y point to x
			parentorHeight[y] = x;
		}else{
			parentorHeight[y]= parentorHeight[y] - 1*(1); 
			//have root of x point to y
			parentorHeight[x] = y;
		}
		count--;
	}
	
	//Merge sort from Robert Sedgewick and Kevin Wayne. 
	 private Edge[] merge(Edge[] a, Edge[] b) {
	        Edge[] c = new Edge[a.length + b.length];
	        int i = 0, j = 0;
	        for (int k = 0; k < c.length; k++) {
	            if(i >= a.length) 
	            	c[k] = b[j++];
	            else if (j >= b.length)
	            	c[k] = a[i++];
	            else if(a[i].getWeight() <= b[j].getWeight()) 
	            	c[k] = a[i++];
	            else    
	            	c[k] = b[j++];
	        }
	        return c;
	    }

	    public Edge[] mergesort(Edge[] input) {
	        int N = input.length;
	        if (N <= 1) 
	        	return input;
	        Edge[] a = new Edge[N/2];
	        Edge[] b = new Edge[N - N/2];
	        for (int i = 0; i < a.length; i++)
	            a[i] = input[i];
	        for (int i = 0; i < b.length; i++)
	            b[i] = input[i + N/2];
	        return merge(mergesort(a), mergesort(b));
	    }
	    Edge graph[] = new Edge[15];
	    public Edge[] makeGraph() {
	       	for (int i = 0; i < Z; i++) {
	       		graph[i]= new Edge();
			}
	    	 
	    	graph[0].setWeight(9);
	    	graph[0].setSrc(1-1);
	    	graph[0].setDst(2-1);
	    	
	    	graph[1].setWeight(24);
	    	graph[1].setSrc(2-1);
	    	graph[1].setDst(3-1);
	    	
	    	graph[2].setWeight(15);
	    	graph[2].setSrc(1-1);
	    	graph[2].setDst(7-1);
	    	
	    	graph[3].setWeight(5);
	    	graph[3].setSrc(6-1);
	    	graph[3].setDst(7-1);
	    	
	    	graph[4].setWeight(14);
	    	graph[4].setSrc(1-1);
	    	graph[4].setDst(6-1);
	    	
	    	graph[5].setWeight(30);
	    	graph[5].setSrc(5-1);
	    	graph[5].setDst(6-1);
	    	
	    	graph[6].setWeight(18);
	    	graph[6].setSrc(6-1);
	    	graph[6].setDst(3-1);
	    	
	    	graph[7].setWeight(2);
	    	graph[7].setSrc(5-1);
	    	graph[7].setDst(3-1);
	    	
	    	graph[8].setWeight(11);
	    	graph[8].setSrc(5-1);
	    	graph[8].setDst(4-1);
	    	
	    	graph[9].setWeight(7);
	    	graph[9].setSrc(4-1);
	    	graph[9].setDst(8-1);
	    	
	    	graph[10].setWeight(44);
	    	graph[10].setSrc(7-1);
	    	graph[10].setDst(8-1);
	    	
	    	graph[11].setWeight(16);
	    	graph[11].setSrc(5-1);
	    	graph[11].setDst(8-1);
	    	
	    	graph[12].setWeight(6);
	    	graph[12].setSrc(4-1);
	    	graph[12].setDst(3-1);
	    	
	    	graph[13].setWeight(19);
	    	graph[13].setSrc(3-1);
	    	graph[13].setDst(8-1);
	    	
	    	graph[14].setWeight(20);
	    	graph[14].setSrc(7-1);
	    	graph[14].setDst(5-1);
	    	
	    	
	    	for (int i = 0; i < graph.length; i++) {
				System.out.print(graph[i].getWeight() + ", ");
			}
	    	return graph;
	    }
	    
	    public void mst() {
	    	int e= 0;
	    	int v = 0;
	    	Edge finished[]= makeGraph();
	    	System.out.println();
	    	finished = mergesort(finished);
	    	System.out.println();
	    	for (int i = 0; i < finished.length; i++) {
				System.out.print(finished[i].getWeight() + ", ");
			}
	    	System.out.println();
	    	while(e< V-1) {
	    		Edge next_edge = new Edge();
	    		next_edge = finished[v++];
	    		
	    		int w = next_edge.getWeight();
	    		int x = find(next_edge.getSrc());
	    		int y = find(next_edge.getDst()); 
	    		//check this logic
	    		int a = parentorHeight[x];
	    		int b = parentorHeight[y];
	    		
	    		if(parentorHeight[x] < 0 &&  parentorHeight[y] == parentorHeight[x]) {
	    			unionHeight(x,y); 
	    			e++;
	    			System.out.println(x + " - " + y);			
	    		}
	    		else if(parentorHeight[x] != parentorHeight[y]) {
	    			unionHeight(x,y); 
	    			e++;
	    			System.out.println(x + " - " + y);
	    		}
	    		
	    	}
	    	System.out.println();
	    	for (int i = 0; i < parentorHeight.length; i++) {
	    		System.out.print(parentorHeight[i] + ", ");
			}
	    }
	    	
	    
	    
	    public static void main(String[] args) {
	    	Kruskal e = new Kruskal(8,15);
	    	e.mst();
 	
	    }
	    
	   
	
}
