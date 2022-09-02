import java.util.*;

class BFS1
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
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
	
	public static void BFS(ArrayList<ArrayList<Integer>> adj, int v, int source)
	{
		
		System.out.println();
		System.out.println();
		boolean visited[]=new boolean[v+1];
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		visited[source]=true;
		
		queue.add(source);
		
		while(queue.isEmpty()==false)
		{
			int vertex=queue.poll();
			
			System.out.print(vertex+" ");
			
			for(int index : adj.get(vertex))
			{
				if(visited[vertex]==false)
				{
					visited[vertex]=true;
					queue.add(vertex);
				}
			}
		}
		System.out.println();
	}

/* in traversing arraylist of arraylist we do adj.get(i).get(j) but here we do only adj.get(index) because in previous loop we are traversing index of outer arraylist and then arraylist connected to that node. But in this loop we are only traversing through outer arraylist and not traversing inner arraylist
*/

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
		addEdge(adj,2,3);
		addEdge(adj,2,4);
		addEdge(adj,3,4);
		printGraph(adj);
		BFS(adj,V, 0);
	}
}
