import java.io.*;
import java.util.*;


public class Main {
	static boolean[][] occupied=new boolean[3][];
	static int N;
	static int res=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());

		occupied[0]=new boolean[N];
		occupied[1]=new boolean[N*2];
		occupied[2]=new boolean[N*2];
		dfs(0);
		System.out.println(res);
	}
	static void dfs(int idx)
	{
		if(idx==N)
		{
			res++;
			return;
		}
		for(int i=0;i<N;i++)
		{
			if(isAvailable(idx, i))
			{
				occupied[0][i]=true;
				occupied[1][idx-i+N-1]=true;
				occupied[2][idx+i]=true;
				dfs(idx+1);
				occupied[0][i]=false;
				occupied[1][idx-i+N-1]=false;
				occupied[2][idx+i]=false;
			}
		}
	}
	static boolean isAvailable(int hang,int yeol)
	{
		if(occupied[0][yeol])
		{
			return false;
		}
		if(occupied[1][hang-yeol+N-1])
		{
			return false;
		}
		if(occupied[2][hang+yeol])
		{
			return false;
		}
		return true;
	}
}

