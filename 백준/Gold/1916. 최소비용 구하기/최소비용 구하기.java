import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<int[]>[] list=new ArrayList[N];
		
		for(int i=0;i<N;i++)
		{
			list[i]=new ArrayList<int[]>();
		}
		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().split(" ");
			
			int A=Integer.parseInt(tmp[0])-1;
			int B=Integer.parseInt(tmp[1])-1;
			int V=Integer.parseInt(tmp[2]);
			
			list[A].add(new int[] {B,V});
		}
		
		String[] tmp=br.readLine().split(" ");
		
		int S=Integer.parseInt(tmp[0])-1;
		int E=Integer.parseInt(tmp[1])-1;
		
		int[] res=new int[N];
		Arrays.fill(res, 100000000);
		res[S]=0;
		
		boolean[] visited=new boolean[N];
		
		PriorityQueue<int[]> q=new PriorityQueue<int[]>((o1,o2)->{
			return o1[1]-o2[1];
		});
		q.add(new int[] {S,0});
		visited[S]=true;
		
		while(!q.isEmpty())
		{
			int[] cur=q.poll();
			//여기 방문체크가 들어가야 모든 노드 기준으로 맵의 최소값 계산을 한번씩 
			visited[cur[0]]=true;
			
			if(cur[0]==E)
			{
				break;
			}
			
			for(int[] info:list[cur[0]])
			{
				if(!visited[info[0]]&&res[info[0]]>res[cur[0]]+info[1])
				{
					//여기에 방문체크가 들어가면 시작점 기준으로만 최소값 계산
					res[info[0]]=res[cur[0]]+info[1];
					q.add(new int[] {info[0],res[info[0]]});
				}
			}
		}
		
//		System.out.println(Arrays.toString(res));
		System.out.println(res[E]);
		
	}

}