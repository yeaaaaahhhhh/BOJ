import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		int[][] dp=new int[N][N];
		
		String[] tmp=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
			dp[i][i]=1;
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(i-j==1)
				{
					if(arr[i]==arr[j])
					{
						dp[i][j]=1;
					}
				}
				else
				{
					if(arr[i]==arr[j]&&dp[i-1][j+1]==1)
					{
						dp[i][j]=1;
					}
				}
			}
		}
		
//		for(int i=0;i<N;i++)
//			System.out.println(list[i]);
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(dp[i]));
//		}
		int M=Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++)
		{
			tmp=br.readLine().split(" ");
			int a=Integer.parseInt(tmp[0])-1;
			int b=Integer.parseInt(tmp[1])-1;
			bw.write(dp[b][a]+"\n");
		}
		bw.flush();
	}
}