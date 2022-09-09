class primsandmst
{
	static int v=0;
	public static int prims(int graph[])
	{
		int key[]= new int[v];
		int res=0;
		
		Arrays.fill(key,Integer.MAX_VALUE);
		
		key[0]=0;
		
		boolean mset[]=new boolean[v];
		
		for(int count=0;count<v;count++)
		{
			int u=-1;
			for(int i=0;i<v,i++)
			{
				if(!mset[i] && (u==-1 || key[i]<key[u]))
					u=i;
					
			mset[u]=true;
			res=res+key[u];
			
			for(int x=0;x<v;x++)
			{
				if(!mset[x] && graph[u][x]!=0 && key[u][x]<key[x])
					key[x]=graph[u][x];
			}
		 
		}
		return res;
}
