import java.util.*;
import java.io.*;
import java.math.BigDecimal;


public class Main {
	static long[] org;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		int K=Integer.parseInt(tmp[2]);
		org=new long[N];
		tree=new long[N*4];
		for(int i=0;i<N;i++)
		{	
			org[i]=Long.parseLong(br.readLine());
		}
		init(0,N-1,1);
		//System.out.println(Arrays.toString(tree));
		for(int i=0;i<M+K;i++)
		{
			tmp=br.readLine().split(" ");
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1])-1;
			long c=Long.parseLong(tmp[2]);
			
			if(a==1)
			{
				change(0,N-1,1,b,c-org[b]);
				//System.out.println(Arrays.toString(tree));
			}
			else
			{
				System.out.println(getSum(0,N-1,1,b,(int)c-1));
			}
		}
	}
	static long getSum(int start,int end,int idx,int b,int c)
	{
		if(end<b||start>c)
		{
			return 0;
		}
		else if(b<=start&&c>=end)
		{
			return tree[idx];
		}
		int mid=(start+end)/2;
		return getSum(start,mid,idx*2,b,c)+getSum(mid+1,end,idx*2+1,b,c);
	}
	static long init(int start,int end,int idx)
	{
		if(start==end)
		{
			return tree[idx]=org[start];
		}
		int mid=(start+end)/2;
		return tree[idx]=init(start,mid,idx*2)+init(mid+1,end,idx*2+1);
	}
	static void change(int start,int end,int idx,int node,long diff)
	{
		if(start<=node&&node<=end)
		{
			tree[idx]+=diff;
			if(start==end)
			{
				org[node]=tree[idx];
				return;
			}
			int mid=(start+end)/2;
			change(start,mid,idx*2,node,diff);
			change(mid+1,end,idx*2+1,node,diff);
		}
		else
			return;
	}
}