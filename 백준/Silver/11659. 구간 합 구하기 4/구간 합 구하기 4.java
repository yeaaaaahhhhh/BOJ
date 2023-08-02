import java.util.*;
import java.io.*;


public class Main {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		
		tmp=br.readLine().split(" ");
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			if(i==0)
				arr[i]=Integer.parseInt(tmp[i]);
			else
				arr[i]=arr[i-1]+Integer.parseInt(tmp[i]);
		}
		//System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<M;i++)
		{
			tmp=br.readLine().split(" ");
			int st=Integer.parseInt(tmp[0]);
			int end=Integer.parseInt(tmp[1]);
			int sum=arr[end-1];
			if(st>1)
			{
				sum-=arr[st-2];
			}
			System.out.println(sum);
		}
		
	}
}