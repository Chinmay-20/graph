import java.util.*;


/* we dont know source and the graph is disconnected*/
class BFS2
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
	{
		adj.get(u).add(v); //1
		adj.get(v).add(u); //2 as it is undirected graph it adds edges from both side
		//working
		//1 we go to u's array list by calling get function on main array list and then we add v to this used array list
		//2 we go to v's array list and add u to this particular array list 
	}
	public static void BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean visited[])
	{
		Queue<Integer> queue=new LinkedList<Integer>();
		
		visited[s]=true;
		queue.add(s);
		
		while(queue.isEmpty() == false)
		{
			int u=queue.poll();
			System.out.print(u+" ");
			for(int index : adj.get(u))
			{
				if(visited[index]==false)
				{
					visited[index]=true;
					queue.add(index);
				}
			}
		}
		System.out.println();	
	}

	public static void BFSDis(ArrayList<ArrayList<Integer>> adj, int v)
	{
		boolean visited[]=new boolean[v+1]; //bydefault false
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				BFS(adj,i,visited);
			}
		}
	}
	
	public static void main(String args[])
	{
		int V=8; //5 vertices
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(V);
		
		for(int i=0;i<V;i++)
		{
			adj.add(new ArrayList<Integer>()); //we are adding empty cell to arraylist
		}
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
		addEdge(adj,2,4);
		addEdge(adj,3,4);
		addEdge(adj,5,6);
		addEdge(adj,5,7);
		addEdge(adj,6,7);
		//printGraph(adj);
		BFSDis(adj,V); //we removed source as we dont know the source
	}
}
