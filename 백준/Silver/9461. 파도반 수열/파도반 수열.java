import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[] dp=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		dp[6]=3;
		dp[7]=4;

		for(int i=8;i<101;i++)
		{
			dp[i]=dp[i-2]+dp[i-3];
		}

		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++)
		{
			int N=Integer.parseInt(br.readLine());
			
			System.out.println(dp[N]);
		}

	}
}