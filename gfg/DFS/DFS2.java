import java.util.*;

class DFS2
{
	public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited)
	{
		visited[s]=true;
		System.out.print(s+" ");
		
		for(int index : adj.get(s))
		{
			if(visited[index]==false)
			{
				DFSRec(adj,index,visited);
			}
		}
	}
	
	public static void DFS(ArrayList<ArrayList<Integer>> adj,int v,int source)
	{
		boolean visited[]=new boolean[v];
		
		DFSRec(adj,source,visited);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void main(String args[])
	{
		int vertices=5;
		
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(vertices);
		
		for(int i=0;i<vertices;i++)
		{
			adj.add(new ArrayList<Integer>()); //we are adding empty cell to arraylist
		}
		addEdge(adj,0,1);
		addEdge(adj,1,3);
		addEdge(adj,0,2);
		addEdge(adj,2,3);
		addEdge(adj,1,4);
		addEdge(adj,3,4);
		
		DFS(adj,vertices,0);
	}
}
