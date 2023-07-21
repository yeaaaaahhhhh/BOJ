
import java.io.*;
import java.util.*;
public class Solution {

	//창용 마을 무리의 수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=T;test++)
		{
			String[] tmp=br.readLine().split(" ");
			
			int N=Integer.parseInt(tmp[0]);
			int M=Integer.parseInt(tmp[1]);
			
			boolean[][] rel=new boolean[N][N];
			
			for(int i=0;i<M;i++)
			{
				tmp=br.readLine().split(" ");
				int p1=Integer.parseInt(tmp[0])-1;
				int p2=Integer.parseInt(tmp[1])-1;
				
				rel[p1][p2]=true;
				rel[p2][p1]=true;
				
			}
			System.out.println("#"+test+" "+getRes(N,rel));
			
		}
	}
	static int getRes(int N,boolean[][] rel)
	{
		boolean[] visited=new boolean[N];
		int res=1;
		Queue<Integer> q=new LinkedList();
		int idx=0;
		q.add(0);
		visited[0]=true;
		while(idx<N)
		{
			if(q.isEmpty())
			{
				for(;idx<N;idx++)
				{
					if(!visited[idx])
					{
						q.add(idx);
						visited[idx]=true;
						res++;
						break;
					}
				}
			}
			else
			{
				int cur=q.poll();
				for(int i=0;i<N;i++)
				{
					if(rel[cur][i]&&!visited[i])
					{
						q.add(i);
						visited[i]=true;
					}
				}
			}
		}
		return res;
	}

}
