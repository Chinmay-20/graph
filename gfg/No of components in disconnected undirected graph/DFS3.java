import java.util.*;

class DFS3
{

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int source,boolean[] visited)
	{
		visited[source]=true;
		System.out.print(source+" ");
		
		for(int index : adj.get(source))
		{
			if(visited[index]==false)
			{
				DFSRec(adj,index,visited);
			}
		}
	}
	
	public static int DFS(ArrayList<ArrayList<Integer>> adj, int vertices)
	{
		boolean []visited=new boolean[vertices];
		int cnt=0;
		for(int index=0;index<vertices;index++)
		{
			if(visited[index]==false)
			{
				DFSRec(adj, index, visited);
				cnt++;
			}
			
		}
		return cnt;
	}

	public static void main(String args[])
	{
		int vertices=7;
		
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<vertices;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj,0,1);
		
		addEdge(adj,2,3);
		addEdge(adj,2,4);
		addEdge(adj,3,4);
		
		addEdge(adj,5,6);
		System.out.println();
		int cnt=DFS(adj,vertices);
		System.out.println(cnt+" no of components");
	}
}
