import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//다익스트라 특징 : 음수 가중치에서는 사용 불가 

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N,M,K,X;
		int[] v;
		
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		K=Integer.parseInt(tmp[2]);
		X=Integer.parseInt(tmp[3])-1;
		
		ArrayList<Integer>[] list=new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			list[i]=new ArrayList<Integer>();
		}
		v=new int[N];
		
		Arrays.fill(v, Integer.MAX_VALUE);
		v[X]=0;
		for(int i=0;i<M;i++)
		{
			int A,B;
			tmp=br.readLine().split(" ");
			A=Integer.parseInt(tmp[0])-1;
			B=Integer.parseInt(tmp[1])-1;
			
			list[A].add(B);
		}
		
		//pq 사용할까 했으나 가중치가 항상 1이므로 항상 가장 가까운 곳이 큐의 앞에 있다.
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited=new boolean[N];
		q.add(X);
		visited[X]=true;
		
		while(!q.isEmpty())
		{
			int cur=q.poll();
			
			//연결된 곳 방문
			for(int i: list[cur])
			{
				if(!visited[i]&&v[i]>v[cur]+1)
				{
					visited[i]=true;
					v[i]=v[cur]+1;
					q.add(i);
				}
			}
		}
		
		boolean flag=false;
		for(int i=0;i<N;i++)
		{
			if(v[i]==K)
			{
				System.out.println(i+1);
				flag=true;
			}
		}
		if(!flag)
		{
			System.out.println(-1);
		}

	}


}