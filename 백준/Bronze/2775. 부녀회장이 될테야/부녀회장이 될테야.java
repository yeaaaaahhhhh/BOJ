import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		int[][] dp=new int[15][15];
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				if(i==0)
				{
					dp[i][j]=j;
					continue;
				}
				if(j==0)
				{
					dp[i][j]=dp[i-1][j];
					continue;
				}
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
			}
		}
		
		for(int t=0;t<T;t++)
		{
			int k=Integer.parseInt(br.readLine());
			int n=Integer.parseInt(br.readLine());
			
			System.out.println(dp[k][n]);
		}
		
	}
}