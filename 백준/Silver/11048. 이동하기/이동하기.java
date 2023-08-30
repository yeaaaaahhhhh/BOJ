import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		
		int[][] map=new int[N][M];
		int[][] dp=new int[N][M];
		for(int i=0;i<N;i++)
		{
			tmp=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		dp[0][0]=map[0][0];
		int[] dy= {1,0};
		int[] dx= {0,1};
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				for(int d=0;d<dy.length;d++)
				{
					int ty=i+dy[d];
					int tx=j+dx[d];
					
					if(ty<N&&tx<M)
					{
						dp[ty][tx]=Math.max(dp[ty][tx], dp[i][j]+map[ty][tx]);
					}
				}
			}
		}
		
//		for(int[] d:dp)
//		{
//			System.out.println(Arrays.toString(d));
//		}
		
		System.out.println(dp[N-1][M-1]);
		
	}
}
