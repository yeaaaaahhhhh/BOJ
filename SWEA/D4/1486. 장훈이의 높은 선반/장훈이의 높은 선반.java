import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N,B;
	static int[] arr;
	static int res;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			String[] tmp=br.readLine().split(" ");
			
			N=Integer.parseInt(tmp[0]);
			B=Integer.parseInt(tmp[1]);
			res=Integer.MAX_VALUE;
			arr=new int[N];
			tmp=br.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(tmp[i]);
			}
			
			dfs(0,0);
			System.out.println("#"+t+" "+(res-B));
		}
	}
	static void dfs(int idx,int sum)
	{
		//System.out.println(idx+" "+sum);
		if(idx==N)
		{
			if(sum>=B&&res>sum)
			{
				res=sum;
			}
			return;
		}
		
		dfs(idx+1,sum+arr[idx]);
		dfs(idx+1,sum);
	}
}
