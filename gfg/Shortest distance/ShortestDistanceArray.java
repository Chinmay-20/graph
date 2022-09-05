import java.util.*;


//BFS approach
class ShortestDistanceArray
{
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u, int v)
	{
		adj.get(u).add(v);
		adj.get(v).add(u);	
	}
	
	public static void shortestdistance(ArrayList<ArrayList<Integer>> adj, int vertices,int source)
	{
		boolean visited[]=new boolean[vertices];
		int[] distance=new int[5];
		for(int index=0;index<distance.length;index++)
		{
			distance[index]=Integer.MAX_VALUE;
		}
		
		distance[source]=0;
		
		Queue<Integer> queue=new LinkedList<Integer>();
		
		queue.add(source);
		
		while(queue.isEmpty()==false)
		{
			int ref=queue.poll();
			
			for(int index : adj.get(ref))
			{
				if(visited[index]==false)
				{
					visited[index]=true;
					queue.add(index);
					distance[index]=distance[ref]+1;
				}
			}
		}
		for(int index=0;index<distance.length;index++)
		{
			System.out.println(distance[index]+" ");
		}		
				
	}
	public static void main(String arr[])
	{
		int vertices=5;
		
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		
		for(int index=0;index<vertices;index++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj,0,1);
		addEdge(adj,0,2);
		addEdge(adj,1,2);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
	
		shortestdistance(adj,vertices,0);
	}
}
