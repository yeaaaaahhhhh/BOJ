import java.io.*;
import java.util.*;

public class Main {

	static Long res=Long.MAX_VALUE;

	static long A;
	static long B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		A= Long.parseLong(tmp[0]);
		
		B=Long.parseLong(tmp[1]);
		
		dfs(A,1);
		
		if(res!=Long.MAX_VALUE)
			System.out.println(res);
		else
			System.out.println(-1);
				
	}
	static void dfs(long n,long cnt)
	{
		if(n>B)
		{
			return;
		}
		if(n==B)
		{
			//System.out.println(n+" "+cnt);
			if(res>cnt)
			{
				res=cnt;
			}
			return;
		}
		
		dfs(n*2,cnt+1);
		dfs(n*10+1,cnt+1);
	}
}