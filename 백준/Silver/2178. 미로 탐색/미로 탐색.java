import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		boolean[][] canGo=new boolean[N][M];
		
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<M;j++)
			{
				if(str.charAt(j)=='1')
				{					
					canGo[i][j]=true;
				}
			}
		}
		
		int[][] arr=new int[N][M];
		
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {0,0,1});
		canGo[0][0]=false;
		int[] dy= {-1,0,1,0};
		int[] dx= {0,-1,0,1};
		
		while(!q.isEmpty())
		{
			int[] cur=q.poll();
			arr[cur[0]][cur[1]]=cur[2];
			for(int d=0;d<4;d++)
			{
				int ty=cur[0]+dy[d];
				int tx=cur[1]+dx[d];
				
				if(tx>=0&&ty>=0&&ty<N&&tx<M&&canGo[ty][tx])
				{
					q.add(new int[] {ty,tx,cur[2]+1});
					canGo[ty][tx]=false;
				}
			}
		}
//		for(int[] ar:arr)
//			System.out.println(Arrays.toString(ar));
		System.out.println(arr[N-1][M-1]);
	
	}
}