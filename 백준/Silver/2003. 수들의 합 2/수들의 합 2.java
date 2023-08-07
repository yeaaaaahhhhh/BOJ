import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		
		int[] arr=new int[N];
		tmp=br.readLine().split(" ");
	
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		
		int res=0;
		int l=0;
		int r=1;
		int sum=arr[0];
		while(l<N&&r<=N)
		{
			if(r<N&&sum<M)
			{
				sum+=arr[r++];
			}
			else
			{				
				if(sum==M)
				{
					res++;
				}
				sum-=arr[l++];
			}
			//System.out.println(l+" "+r+" "+sum);
		}
		System.out.println(res);
	}
}
