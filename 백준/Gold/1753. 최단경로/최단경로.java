import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int V=Integer.parseInt(tmp[0]);
		int E=Integer.parseInt(tmp[1]);
		
		int K=Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] routes=new ArrayList[V+1];
		for(int i=0;i<V+1;i++)
		{
			routes[i]=new ArrayList<int[]>();
		}
		boolean[] visited=new boolean[V+1];
		int[] dist=new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0;i<E;i++)
		{
			tmp=br.readLine().split(" ");
			int u=Integer.parseInt(tmp[0]);
			int v=Integer.parseInt(tmp[1]);
			int w=Integer.parseInt(tmp[2]);
			routes[u].add(new int[] {v,w});
			
		}
		
//		for(ArrayList<int[]> list:routes)
//		{
//			for(int[] li:list)
//			{
//				System.out.println(Arrays.toString(li));
//			}
//		}
		
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			
			public int compare(int[] o1,int[] o2)
			{
				return o1[1]-o2[1];
			}
		});
		
		
		int cnt=0;
		visited[0]=true;
		dist[K]=0;
		pq.add(new int[] {K,0});
		while(!pq.isEmpty())
		{
			int[] cur=pq.poll();
			
			if(visited[cur[0]])
			{
				continue;
			}
			if(++cnt>=V)
			{
				break;
			}
			visited[cur[0]]=true;
			
			for(int i=0;i<routes[cur[0]].size();i++)
			{
				int[] adj= routes[cur[0]].get(i);
				int tDist=adj[1]+dist[cur[0]];
				if(!visited[adj[0]])
				{
					pq.add(new int[] {adj[0],tDist});
					if(tDist<dist[adj[0]])
					{
						dist[adj[0]]=tDist;
					}
				}
			}
			//System.out.println(Arrays.toString(dist));
			
		}
		
		for(int i=1;i<V+1;i++)
		{
			if(dist[i]!=Integer.MAX_VALUE)
			{
				System.out.println(dist[i]);
			}
			else
			{
				System.out.println("INF");
			}
		}
		
	}

}
