import java.util.*;
import java.io.*;

public class Main {
	static int[] pop;
	static boolean[] visited;
	static ArrayList<Integer>[] edge;
	static int totalSum=0;
	static int res=Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		
		pop=new int[N];
		visited=new boolean[N];
		edge=new ArrayList[N];
		
		for(int i=0;i<N;i++)
		{
			edge[i]=new ArrayList<Integer>();
		}
		
		String[] tmp=br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
		{
			pop[i]=Integer.parseInt(tmp[i]);
			totalSum+=pop[i];
		}
		
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<Integer.parseInt(tmp[0]);j++)
			{
				edge[i].add(Integer.parseInt(tmp[1+j])-1);
			}
		}
		
		dfs(1,0);
		
		if(res==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
	}
	static void dfs(int idx,int sum)
	{
		if(idx==N)
		{
			if(sum==0||sum==totalSum)
			{
				return;
			}
			ArrayList<Integer> listA=new ArrayList<>();
			ArrayList<Integer> listB=new ArrayList<>();
			for(int i=0;i<N;i++)
			{
				if(visited[i])
				{
					listA.add(i);
				}
				else
				{
					listB.add(i);
				}
			}

//			System.out.println("A"+listA.toString());
//			System.out.println("B"+listB.toString());
			if(isRight(listA)&&isRight(listB))
			{
//				System.out.println(totalSum-sum*2);
//				System.out.println();
				res=Math.min(res, Math.abs(totalSum-sum*2));
			}
			return;
		}
		
		for(int i=idx;i<N;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				dfs(i+1,sum+pop[i]);
				visited[i]=false;
			}
			dfs(i+1,sum);
		}
		
	}
	
	static boolean isRight(ArrayList<Integer> list)
	{
		int cnt=0;
		if(list.size()==1)
			return true;
		boolean[] visit=new boolean[list.size()];
		Queue<Integer> q=new LinkedList<Integer>();
		

		q.add(list.get(0));
		visit[0]=true;
		cnt++;
		while(!q.isEmpty())
		{
			int cur=q.poll();
			for(int i=0;i<edge[cur].size();i++)
			{
				for(int j=0;j<list.size();j++)
				{
					if(!visit[j]&&edge[cur].get(i)==list.get(j))
					{
						visit[j]=true;
						q.add(list.get(j));
						if(++cnt>=list.size())
						{
							return true;
						}
						break;
					}
				}
			}
		}
		return false;
	}
}