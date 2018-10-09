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
//param is the index number
//return is index of root	
	public int find(int x){ 
		int node = x;
		int a = parentorHeight[x];
		int b = parentorHeight[x];
	        // find root and make root as parent of i (path compression) 
		int isValueIndexPos = 0;
		//first check to see if it holds a positive number
	        while(a > 0) {
	        	//if holds a positive value and  its parent is a positive value mark x true
	        	if(parentorHeight[a] > 0) {
	        		isValueIndexPos++;
	        		}    
	        	b=a;
	        	
	        	a = parentorHeight[a];
	        }
	        //The issue was that when I was doing recurrsive it was not returning root
	        //Now the is issue that I am returning -2 when I want the index of 
	        a +=isValueIndexPos;
	        //
	        parentorHeight[x] = b;
	        
	        
	        
	       // System.out.println("this is the the value: " +  parentorHeight[x] + "==" + a);
	        return(x);
}
	
	
	 
	 //when making a union if x and y within same set then 
	public boolean isConnected(int x, int y){
		 return find(x) == find(y);
	 }
	
	public void unionHeight(int c, int d) {
		int root_X =c;
		int root_Y = d;
		//which root has a larger negative value;
		int height_X = parentorHeight[root_X];
			if(height_X>=0) {
				height_X =parentorHeight[height_X];
			}
		int height_Y = parentorHeight[root_Y];
			if(height_Y>=0) {
				height_Y =parentorHeight[height_Y];
			}
		
		if(height_X < height_Y) {
			//have root of root_Y point to root_X
			parentorHeight[root_Y] = root_X;
		}
		else if(height_X > height_Y) {
			parentorHeight[root_X] = root_Y;
		}
		else if(root_X<root_Y) {
			if(parentorHeight[root_Y]<0) {
				//its pointing to root so root does not change
				parentorHeight[root_X]= parentorHeight[root_X] - 1*(1); 
			}
			//have root of root_Y point to root root_X
			parentorHeight[root_Y] = root_X;
		}else{
			if(parentorHeight[root_X]<0) {
				//its pointing to root so root does not change
				parentorHeight[root_Y]= parentorHeight[root_Y] - 1*(1); 
			}
			//have root of root_X point to root_Y
			parentorHeight[root_X] = root_Y;
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
	    	
	    	
	    
	    	return graph;
	    }
	    
	    public void mst() {
	    	int e= 0;
	    	int v = 0;
	    	Edge finished[]= makeGraph();
	    	System.out.println();
	    	finished = mergesort(finished);
	    	while(e< V-1) {
	    		Edge next_edge = new Edge();
	    		next_edge = finished[v++];
	    		
	    		int w = next_edge.getWeight();
	    		int x = find(next_edge.getSrc());
	    		int y = find(next_edge.getDst()); 
	    		//check this logic
	    		
	    		
	    		//could be a direct parent
	    		
	    		int a = parentorHeight[x];
	    		if(parentorHeight[x] <0) {

	    			a = x;

	    		}
	    		else if(parentorHeight[a]>= 0 ) {
	    			a = parentorHeight[a];
	    		}

	    		
	   
	    		int b = parentorHeight[y];
	    		if(parentorHeight[y] <0) {

	    			b = y;

	    		}
	    		else if(parentorHeight[b]>= 0 ) {
	    			b = parentorHeight[b];
	    		}

	    		

	    		if(a >= 0 && b >= 0 && b!=a) {
	    			unionHeight(x,y); 
	    			e++;
	    			System.out.println(x + " - " + y + " ----" + next_edge.getWeight());			
	    		}	    		
	    	}
	    	
	    	
	    	for (int i = 0; i < parentorHeight.length; i++) {
	    	
	    		System.out.print(parentorHeight[i]  + ", ");
	    		}
	    }
	    	
	    	
	    
	    
	    public static void main(String[] args) {
	    	Kruskal e = new Kruskal(8,15);
	    	e.mst();
 	
	    }
	    
	   
	
}
