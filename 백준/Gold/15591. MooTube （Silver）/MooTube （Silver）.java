import java.io.*;
import java.util.*;

class Main{
	static int N,Q;
	static ArrayList<int[]>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		Q=Integer.parseInt(tmp[1]);
		
		arr = new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=new ArrayList();
		}
		//할당할 때에는 for each 문을 사용하면 안된다.
		
		for(int i=0;i<N-1;i++)
		{
			tmp=br.readLine().split(" ");
			int a=Integer.parseInt(tmp[0])-1;
			int b= Integer.parseInt(tmp[1])-1;
			int v=Integer.parseInt(tmp[2]);
			
			arr[a].add(new int[] {b,v});
			arr[b].add(new int[] {a,v});
		}
		for(int i=0;i<Q;i++)
		{
			visited=new boolean[N];
			
			tmp=br.readLine().split(" ");
			int k=Integer.parseInt(tmp[0]);
			int v=Integer.parseInt(tmp[1]);
			
			visited[v-1]=true;
			
			Queue<Integer> que=new LinkedList<Integer>();
			que.add(v-1);
			
			int res=0;
			while(!que.isEmpty())
			{
				int cur=que.poll();
				for(int[] a: arr[cur])
				{
					if(a[1]>=k&&visited[a[0]]==false)
					{
						que.add(a[0]);
						visited[a[0]]=true;
						res++;
					}
				}
			}
			System.out.println(res);
		}
		//문제를 처음에 안읽어서 변수명들이 엉망이 됐다.
	}
}