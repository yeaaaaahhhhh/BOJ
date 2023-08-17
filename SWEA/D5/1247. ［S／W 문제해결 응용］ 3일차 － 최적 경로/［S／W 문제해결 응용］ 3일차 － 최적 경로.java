import java.io.*;
import java.util.*;

class Solution {
	static int min;
	static boolean[] visited;
	static Loc[] clients;
	static Loc home;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++)
		{
			int N=Integer.parseInt(br.readLine());
			min=Integer.MAX_VALUE;
			String[] tmp=br.readLine().split(" ");
			
			Loc work=new Loc(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
			home=new Loc(Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]));
			
			clients=new Loc[N];
			for(int i=0;i<N;i++)
			{
				clients[i]=new Loc(Integer.parseInt(tmp[4+i*2]),Integer.parseInt(tmp[4+i*2+1]));
			}
			visited=new boolean[N];
			
			dfs(work.y,work.x,0,0);
			
			System.out.println("#"+t+" "+min);
		}
	}
	static void dfs(int y,int x,int dist,int idx)
	{
		if(idx==clients.length)
		{
			min=Math.min(min, dist+Math.abs(y-home.y)+Math.abs(x-home.x));
			return;
		}
		int i=0;
		for(;i<clients.length;i++)
		{
			if(!visited[i])
			{
				Loc t= clients[i];
				visited[i]=true;
				dfs(t.y,t.x,dist+Math.abs(y-t.y)+Math.abs(x-t.x),idx+1);
				visited[i]=false;
			}
		}
		
	}
}
class Loc
{
	int y,x;
	Loc(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
