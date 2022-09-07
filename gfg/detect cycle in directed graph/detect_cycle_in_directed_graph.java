import java.util.*;

class detect_cycle_in_directed_graph
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
	{
		adj.get(u).add(v);
	}
	public static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean recst[])
	{
		visited[s]=true;
		recst[s]=true;
		
		for(int u : adj.get(s))
		{
			if(visited[u]==false && DFSRec(adj, u,visited, recst)) //we are making vertex true in recursion stack array
			{
				return true;
			}
			else if(recst[u]==true) //we are checking if cycle is present
			{
				return true;
			}
		}
		recst[s]=false;
		return false;
	}
	
	public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int vertices)
	{
		boolean visited[]=new boolean[vertices];
		boolean recst[]=new boolean[vertices];
		
		for(int i=0;i<vertices;i++)
		{
			if(visited[i]==false)
			{
				if(DFSRec(adj,i,visited,recst)==true)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		int vertices=6;
		
		for(int i=0;i<vertices;i++)
		{	
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj,0,1);
		addEdge(adj,2,1);
		addEdge(adj,2,3);
		addEdge(adj,3,4);
		addEdge(adj,4,5);
		addEdge(adj,5,3);
		//O(V+E)
		System.out.println(DFS(adj,vertices));	
	}
}
