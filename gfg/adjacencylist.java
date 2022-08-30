//we have used arraylist of arraylist for storing adjacency list of graph
//we can also use arraylisy of linked list
//creating array of arraylist causes warning in java

import java.util.*;
class adjacencylist
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
	{
		adj.get(u).add(v); //1
		adj.get(v).add(u); //2 as it is undirected graph it adds edges from both side
		//working
		//1 we go to u's array list by calling get function on main array list and then we add v to this used array list
		//2 we go to v's array list and add u to this particular array list 
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adj)
	{
		//it traverses through main arraylist and for every array list it traverses through particular array list.
		for(int i=0;i<adj.size();i++)
		{
			for(int j=0;j<adj.get(i).size();j++)
			{
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}	
	}
	
	public static void main(String args[])
	{
		int V=5; //5 vertices
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
		{
			adj.add(new ArrayList<Integer>()); //we are adding empty cell to arraylist
		}
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		printGraph(adj);
	}
}
		
