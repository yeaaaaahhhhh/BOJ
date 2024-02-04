import java.io.*;
import java.util.*;

public class Main {
	static int[][] cap=new int[52][52];
	static int[][] flow=new int[52][52];
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		

		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			
			int a=charToInt(tmp[0].charAt(0));
			int b=charToInt(tmp[1].charAt(0));
			int c=Integer.parseInt(tmp[2]);
			
			cap[a][b]+=c;
			cap[b][a]+=c;
		}
		System.out.println(countFlow(0,25));
	}
	static int countFlow(int src,int sink)
	{
		int res=0;
		int[] par=new int[52];
		
		while(true)
		{
			Arrays.fill(par, -1);
			Queue<Integer> q=new LinkedList<>();
			q.add(src);
			par[src]=src;
			
			while(!q.isEmpty()&&par[sink]==-1)
			{
				int cur=q.poll();
				//System.out.println("cur : "+cur);
				for(int i=0;i<52;i++)
				{
					if(cap[cur][i]-flow[cur][i]>0&&par[i]==-1)
					{
						//System.out.println("go : "+i);
						q.add(i);
						par[i]=cur;
					}
				}
			}
			
			if(par[sink]==-1)
			{
				break;
			}
			
			int maxFlow=Integer.MAX_VALUE;
			
			for(int i=sink;i!=src;i=par[i])
			{
				maxFlow=Math.min(maxFlow, cap[par[i]][i]-flow[par[i]][i]);
			}
			
			for(int i=sink;i!=src;i=par[i])
			{
				flow[par[i]][i]+=maxFlow;
				flow[i][par[i]]-=maxFlow;
			}
			//System.out.println(maxFlow);
			res+=maxFlow;
		}
		
		return res;
	}
	static int charToInt(char a)
	{
		if(a>='A'&&a<='Z')
		{
			return a-'A';
		}
		else if(a>='a'&&a<='z')
		{
			return a-'a'+26;
		}
		else
			return -1;
	}
}