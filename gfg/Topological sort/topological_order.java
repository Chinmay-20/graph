import java.util.*;

//Time complexity O(V+E)
class topological_order
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v, int[] indegree)
	{
		adj.get(u).add(v);
		indegree[v]++; //we can increase indegree here or in sort we can traverse through adjacency list and increment there
	}
	public static void toposort(ArrayList<ArrayList<Integer>> adj, int[] indegree)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=0;i<indegree.length;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}
		System.out.println("before while");
		while(q.isEmpty()==false)
		{
			int u=q.poll();
			System.out.print(u+" ");
			for(int index:adj.get(u))
			{
				indegree[index]--;
				if(indegree[index]==0)
				{
					q.add(index);
				}
			}
		}
	}
	public static void main(String args[])
	{
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		int vertices=5;
		
		int indegree[]=new int[vertices];
		
		for(int i=0;i<vertices;i++)
		{	
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj,0,2,indegree);
		addEdge(adj,0,3,indegree);
		addEdge(adj,2,3,indegree);
		addEdge(adj,1,3,indegree);
		addEdge(adj,1,4,indegree);
		
		toposort(adj,indegree);
		
		//System.out.println(indegree[0]+" "+indegree[1]+" "+indegree[2]+" "+indegree[3]+" "+indegree[4]);
	}
}
