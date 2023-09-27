import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			int N=Integer.parseInt(br.readLine());
			

			int[][] loc=new int[N+2][2];
			for(int i=0;i<N+2;i++)
			{
				String[] tmp=br.readLine().split(" ");
				
				int x=Integer.parseInt(tmp[0]);
				int y=Integer.parseInt(tmp[1]);
				
				loc[i][0]=x;
				loc[i][1]=y;
			}
			
			int[][] dist=new int[N+2][N+2];
			
			for(int i=0;i<N+2;i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE/4);
			
			for(int i=0;i<N+2;i++)
			{
				for(int j=0;j<N+2;j++)
				{
					int dis=getDist(loc[i], loc[j]);
					if(dis<=1000)
					{
						dist[i][j]=1;
					}
					else
					{
						dist[i][j]=dis;
					}
				}
			}
			//printTwoLvl(dist);
			
			for(int k=1;k<N+1;k++)
			{
				for(int i=0;i<N+2;i++)
				{
					for(int j=0;j<N+2;j++)
					{
						dist[i][j]=Math.min(dist[i][k]+dist[k][j],dist[i][j]);	
					}
				}
			}
			//printTwoLvl(dist);
			if(dist[0][N+1]<=1000)
			{
				System.out.println("happy");
			}
			else
			{
				System.out.println("sad");
			}
		}
	}

	static int getDist(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	static void printTwoLvl(int[][] arr) {
		for (int[] ar : arr) {
			System.out.println(Arrays.toString(ar));
		}
	}
}
