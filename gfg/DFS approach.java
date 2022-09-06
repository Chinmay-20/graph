//DFS approach


class detect_cycle_in_graph
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s, int[] visited, int parent)
	{
		visited[s]=true;
		
		for(int u : adj.get(s))
		{
			if(visited[u]==false)//the source node is not visited enter the is else enter the else part
			{
				if(DFSRec(adj,u,visited,s)==true)
				{
					return true;
				}
			else if(u!=parent)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int vertices)
	{
		boolean visited[]=new boolean[vertices];
		
		for(int i=0;i<visited.length;i++)
		{
			if(visited[i]==false)
			{
				if(DFSRec(adj,i,visited,-1)==true)
					return true;
			}
		}
		return false;
	}
	public static void main(String  args[])
	{
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		int vertices=5;
		
		for(int i=0;i<index;i++)
		{	
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj,0,1);
		addEdge(adj,1,3);
		addEdge(adj,0,2);
		addEdge(adj,2,3);
		addEdge(adj,1,4);
		addEdge(adj,3,4);
		
		System.out.println(DFS(adj,v));	
	}
