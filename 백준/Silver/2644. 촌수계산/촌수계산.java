import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		String[] tmp = br.readLine().split(" ");

		int A = Integer.parseInt(tmp[0])-1;
		int B = Integer.parseInt(tmp[1])-1;

		ArrayList<Integer>[] list=new ArrayList[N];
		
		for(int i=0;i<N;i++)
		{
			list[i]=new ArrayList<Integer>();
		}
		
		int R=Integer.parseInt(br.readLine());
		for(int i=0;i<R;i++)
		{
			tmp = br.readLine().split(" ");

			int a = Integer.parseInt(tmp[0])-1;
			int b = Integer.parseInt(tmp[1])-1;
			
			list[a].add(b);
			list[b].add(a);
		}
		
		boolean[] visited=new boolean[N];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {A,0});
		visited[A]=true;
		
		while(!q.isEmpty())
		{
			int[] cur=q.poll();

			for(int i=0;i<list[cur[0]].size();i++)
			{
				int per=list[cur[0]].get(i);
				if(!visited[per])
				{
					if(per==B)
					{
						System.out.println(cur[1]+1);
						return;
					}
					else
					{
						q.add(new int[] {per,cur[1]+1});
						visited[per]=true;
					}
				}
			}
		}
		System.out.println(-1);
		
		
	}
}