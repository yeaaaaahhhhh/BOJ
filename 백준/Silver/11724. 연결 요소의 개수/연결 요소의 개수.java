import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		
		ArrayList<Integer>[] list=new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++)
		{
			tmp=br.readLine().split(" ");
			
			int A=Integer.parseInt(tmp[0])-1;
			int B=Integer.parseInt(tmp[1])-1;
			
			list[A].add(B);
			list[B].add(A);
		}
		
		int cnt=0;
		
		boolean[] visited=new boolean[N];
		
		for(int idx=0;idx<N;idx++)
		{
			Queue<Integer> q=new LinkedList<>();
			if(!visited[idx])
			{
				q.add(idx);
			}
			else
			{
				continue;
			}
			
			while(!q.isEmpty())
			{
				int cur=q.poll();
				for(int i=0;i<list[cur].size();i++)
				{
					int con=list[cur].get(i);
					
					if(!visited[con])
					{
						visited[con]=true;
						q.add(con);
						//System.out.println(cur+" "+con);
					}
				}
			}
			cnt++;
		}
		
		bw.write(cnt+" ");
		bw.flush();
	}
}
