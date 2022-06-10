import java.io.*;
import java.util.*;

public class Main {

	static int M,N;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		int[] outp=new int[M];
		boolean[] visited= new boolean[N];
		func(outp,visited,0);
	}
	static void func(int[] outp,boolean[] visited,int crt)
	{
		if(crt==M)
		{
			for(int a:outp)
			{
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		for(int x=0;x<N;x++)
		{
			if(!visited[x])
			{
				boolean[] nvisited=visited.clone();
				int[] noutp=outp.clone();
				nvisited[x]=true;
				noutp[crt]=x+1;
				func(noutp,nvisited,crt+1);
			}
		}
	}
}
