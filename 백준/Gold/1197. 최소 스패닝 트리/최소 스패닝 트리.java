import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		int V=Integer.parseInt(tmp[0]);
		int E=Integer.parseInt(tmp[1]);
		boolean[] visited=new boolean[V+1];
		
		ArrayList<int[]>[] routes=new ArrayList[V+1];
		for(int i=1;i<V+1;i++)
		{
			routes[i]=new ArrayList<int[]>();
		}
		
		for(int i=0;i<E;i++)
		{
			tmp=br.readLine().split(" ");
			int A=Integer.parseInt(tmp[0]);
			int B=Integer.parseInt(tmp[1]);
			int C=Integer.parseInt(tmp[2]);
			
			routes[B].add(new int[] {A,C});
			routes[A].add(new int[] {B,C});
		}
		
		int cnt=0;
		int sum=0;
		
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>((o1,o2)->{
			return o1[1]-o2[1];
		});
		
		pq.add(new int[] {1,0});
	
		while(!pq.isEmpty())
		{
			int[] cur=pq.poll();
			//System.out.println(Arrays.toString(cur));
			if(!visited[cur[0]]) {
				visited[cur[0]]=true;
				sum+=cur[1];
				cnt++;
				//System.out.println(" 0");
				for(int[] r:routes[cur[0]])
				{			
					pq.add(new int[] {r[0],r[1]});
				}
			}
			
			if(cnt==V)
			{
				break;
			}
		}
		System.out.println(sum);
	}
}