import java.util.*;
import java.io.*;

public class Main {

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] dp;
		String[] stg;
		dp=new int[N+1];
		stg=new String[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		stg[1]="1";
		dp[1]=0;
		
		for(int i=2;i<=N;i++)
		{
			int num=0;
			int res=Integer.MAX_VALUE;
			
			if(res>dp[i-1]+1)
			{
				res=dp[i-1]+1;
				num=i-1;
			}
			if(i%2==0&&res>dp[i/2]+1)
			{
				res=dp[i/2]+1;
				num=i/2;
			}
			if(i%3==0&&res>dp[i/3]+1)
			{
				res=dp[i/3]+1;
				num=i/3;
			}
			
			stg[i]=i+" "+stg[num];
			dp[i]=res;
		}
		
		
		
		System.out.println(dp[N]);
		System.out.println(stg[N]);
		
	}
}