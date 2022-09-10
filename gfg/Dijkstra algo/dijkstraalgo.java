class dijkstraalgo
{
	int[] dijkstra(int graph[][], int src)
	{
		int v=graph.length;
		int[] dist=new int[v];
		
		Arrays.fill(dist, Integer.MAX_VALUE)
		dist[src]=0;
			
		boolean fin[]=new boolean[v];
			
		for(int count=0;count<v-1;count++)
		{
			int u=-1;
			for(int i=0;i<v;i++)
			{
				if(!fin[i] && (u==-1 || dist[i]<dist[u]))
					u=i;
					
			}
			fin[u]=true;
			for(int V=0;V<v;V++)
			{
				if(!fin[V] && graph[u][V]!=0)
				{
					dist[V]=min(dist[V],dist[u]+graph[u][V]);
				}
			}
			return dist;
		}
	}
} 
