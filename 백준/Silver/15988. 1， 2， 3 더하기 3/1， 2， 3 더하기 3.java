import java.util.*;
import java.io.*;

class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T;
		int[] arr;
		long[] dp=new long[1000001];

		T=Integer.parseInt(br.readLine());
		arr=new int[T];
		for(int i=0;i<T;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		br.close();
		
		dp[0]=1;
		dp[1]=2;
		dp[2]=4;
		for(int i=3;i<1000001;i++)
		{
			dp[i]=(dp[i-3]+dp[i-2]+dp[i-1])%1000000009;
		}
		
		for(int i=0;i<T;i++)
		{
			bw.write(dp[arr[i]-1]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}