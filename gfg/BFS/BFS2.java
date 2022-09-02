import java.util.*;


/* we dont know source and the graph is disconnected*/
class BFS2
{
	public static void BFS(ArrayList<ArrayList<Integer>> adj, int v, int s, boolean visited[])
	{
		Queue<Integer> q=new LinkedList<Integer>();
		
		visited[s]=true;
		queue.add(s);
		
		while(q.isEmpty() == false)
		{
			int u=q.poll();
			System.out.print(u+" ");
			for(int v : adj.get(u))
			{
				if(visited[v]==false)
				{
					visited[v]=true;
					queue.add(v);
				}
			}
		}
	}

	public static void BFSDis(ArrayList<ArrayList<Integer>> adj, int v)
	{
		boolean visited[]=new boolean visited[v+1];
		for(int i=0;i<v;i++)
		{
			if(visited[i]==false)
			{
				BFS(adj,i,visited);
			}
		}
	}
