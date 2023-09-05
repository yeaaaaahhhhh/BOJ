import java.io.*;
import java.util.*;

public class Main {

	static int N,M;

	static int[][] arr;

	static int[] dy= {0,0,1,-1};
	static int[] dx= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp=br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		
		arr=new int[N][M];
		int cheese=0;
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(tmp[j]);
				if(arr[i][j]==1)
				{
					cheese++;
				}
			}
		}
		
		Queue<int[]> q=new LinkedList();
		
		q.add(new int[] {0,0});
		arr[0][0]=2;
		int t=0;
		while(!q.isEmpty())
		{
			Queue<int[]> tq=new LinkedList();
			int melted=0;
			while(!q.isEmpty())
			{
				int[] cur=q.poll();
				
				for(int d=0;d<4;d++)
				{
					int ty=cur[0]+dy[d];
					int tx=cur[1]+dx[d];
					
					if(ty>=0&&tx>=0&&ty<N&&tx<M&&arr[ty][tx]!=2)
					{
						if(arr[ty][tx]==1)
						{
							melted++;
							tq.add(new int[] {ty,tx});
						}
						else
						{
							q.add(new int[] {ty,tx});
						}
						arr[ty][tx]=2;
					}
				}
			}
			cheese-=melted;
			if(cheese==0)
			{
				System.out.println(++t+"\n"+melted);
				return;
			}
//			for(int[] ar:arr)
//			{
//				System.out.println(Arrays.toString(ar));
//			}
//			
			++t;
			q=tq;
		}
	}
		
}