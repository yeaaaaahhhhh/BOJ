
import java.util.*;
import java.io.*;

public class Solution {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++)
		{
			String[] tmp=br.readLine().split(" ");
			
			int V=Integer.parseInt(tmp[0]);
			int E=Integer.parseInt(tmp[1]);
			parents=new int[E];
			
			for(int i=0;i<E;i++)
			{
				parents[i]=i;
			}
			
			Edge[] arr=new Edge[E];
			
			for(int i=0;i<E;i++)
			{
				tmp=br.readLine().split(" ");
				int a=Integer.parseInt(tmp[0])-1;
				int b=Integer.parseInt(tmp[1])-1;
				int v=Integer.parseInt(tmp[2]);
				
				arr[i]=new Edge(a, b, v);
			}
			
			Arrays.sort(arr);
			
			long res=0;
			int cnt=0;
			for(int i=0;i<E;i++)
			{
				if(union(arr[i].a,arr[i].b))
				{
					//System.out.println(Arrays.toString(parents));
					res+=arr[i].val;
					if(++cnt>=V-1)
					{
						break;
					}
				}
			
			}
			System.out.println("#"+t+" "+res);
		}
	}
	static int find(int n)
	{
		if(n==parents[n])
		{
			return  n;
		}
		return parents[n]=find(parents[n]);
	}
	static boolean union(int a,int b)
	{
		int aPar=find(a);
		int bPar=find(b);
		//System.out.println(a+" "+aPar+" "+b+" "+bPar);
		if(aPar==bPar)
		{
			return false;
		}
		parents[bPar]=parents[aPar];
		return true;
	}
	static class Edge implements Comparable<Edge>
	{
		int a,b,val;

		public Edge(int a, int b, int val) {
			super();
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.val-o.val;
		}

	}
}