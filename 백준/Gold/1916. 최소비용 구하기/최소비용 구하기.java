import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] list=new ArrayList[N];
		
		int[][] price=new int[N][N];
		for(int i=0;i<N;i++)
		{
			Arrays.fill(price[i],100000001);
			list[i]=new ArrayList<int[]>();
			price[i][i]=0;
		}
		
		for(int i=0;i<M;i++)
		{
			String[] arr=br.readLine().split(" ");
			
			int A=Integer.parseInt(arr[0])-1;
			int B=Integer.parseInt(arr[1])-1;
			int V=Integer.parseInt(arr[2]);
			
			list[A].add(new int[] {B,V});
		}
		
		String[] arr=br.readLine().split(" ");
		int S=Integer.parseInt(arr[0])-1;
		int D=Integer.parseInt(arr[1])-1;
		
		boolean[] visited=new boolean[N];
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a,Integer b)
			{
				return price[S][a]-price[S][b];
			}
		});
		pq.add(S);
		
		while(!pq.isEmpty())
		{
			int cur=pq.poll();
//			System.out.println(cur);
			
			if(visited[cur])
			{
				continue;
			}
			visited[cur]=true;
			
			for(int[] route:list[cur])
			{
				int ds=route[0];
				int v=route[1];
				if(price[S][cur]+v<price[S][ds])
				{
					price[S][ds]=price[S][cur]+v;
					pq.add(ds);
				}
			}
		}
		
		System.out.println(price[S][D]);
		
	}
}