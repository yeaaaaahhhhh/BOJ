import java.util.*;
import java.io.*;
public class Main {
	static int[] arr;
	static int[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp;
		while(!(tmp=br.readLine().split(" "))[0].equals("0"))
		{
			int n=Integer.parseInt(tmp[0]);
			arr=new int[n];

			tree=new int[n*4];
			
			for(int i=0;i<n;i++)
			{
				arr[i]=Integer.parseInt(tmp[i+1]);
			}
			
			init(0,n-1,1);
//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(tree));
			System.out.println(getRes(0,n-1));
		}
	}
	static int init(int start,int end,int node)
	{
		if(start==end)
		{
			return tree[node]=start;
		}
		int mid=(start+end)/2;
		int left =init(start,mid,node*2);
		int right=init(mid+1,end,node*2+1);
		if(arr[left]>arr[right])
		{
			return tree[node]=right;
		}
		else
		{
			return tree[node]=left;
		}
	}
	static int query(int start,int end,int node,int i,int j)
	{
		if(i>end||j<start)
		{
			return Integer.MAX_VALUE;
		}
		if(i<=start&&end<=j)
		{
			return tree[node];
		}
		
		int mid = (start + end) / 2;
        int lIdx = query(start, mid, node * 2, i, j);
        int rIdx = query(mid + 1, end, node * 2 + 1, i, j);
        if(lIdx==Integer.MAX_VALUE)
        {
        	return rIdx;
        }
        if(rIdx==Integer.MAX_VALUE)
        {
        	return lIdx;
        }
        return arr[lIdx]>arr[rIdx]?rIdx:lIdx;
 
	}
	static long getRes(int start,int end)
	{
		int min=query(0,arr.length-1,1,start,end);
		long v=(long)(end-start+1)*(long)arr[min];
		
		if(min>start)
		{
			v=Math.max(v,getRes(start,min-1));
		}
		
		if(min<end)
		{
			v=Math.max(v, getRes(min+1,end));
		}
		
		return v;
	}
}