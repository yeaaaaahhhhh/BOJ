import java.io.*;
import java.util.*;

class Main
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] stmp=br.readLine().split(" ");
		boolean[] arr=new boolean[20000001];
		for(int i=0;i<N;i++)
		{
			int v=Integer.parseInt(stmp[i]);
			arr[v+10000000]=true;
		}
		int M=Integer.parseInt(br.readLine());
		stmp=br.readLine().split(" ");
		for(int i=0;i<M;i++)
		{
			int v=Integer.parseInt(stmp[i]);
			if(arr[v+10000000])
			{
				System.out.print("1 ");
			}
			else
			{
				System.out.print("0 ");
			}
		}
		
	}
}