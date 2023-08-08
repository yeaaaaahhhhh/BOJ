import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
	static int[] op;
	static int[] num;
	static int N;
	static int min;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			N=Integer.parseInt(br.readLine());
			op=new int[4];
			num=new int[N];
			
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			
			String[] tmp=br.readLine().split(" ");
			for(int i=0;i<4;i++)
			{
				op[i]=Integer.parseInt(tmp[i]);
			}
			
			tmp=br.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				num[i]=Integer.parseInt(tmp[i]);
			}
			
			dfs(1,num[0]);
			System.out.println("#"+t+" "+Math.abs(max-min));
		}
	}
	static void dfs(int idx,int sum)
	{
		if(idx==N)
		{
			if(max<sum)
			{
				max=sum;
			}
			if(min>sum)
			{
				min=sum;
			}
			return;
		}
		if(op[0]>0)
		{
			op[0]--;
			dfs(idx+1,sum+num[idx]);
			op[0]++;
		}
		if(op[1]>0)
		{
			op[1]--;
			dfs(idx+1,sum-num[idx]);
			op[1]++;
		}
		if(op[2]>0)
		{
			op[2]--;
			dfs(idx+1,sum*num[idx]);
			op[2]++;
		}
		if(op[3]>0)
		{
			op[3]--;
			dfs(idx+1,sum/num[idx]);
			op[3]++;
		}
	}
}
