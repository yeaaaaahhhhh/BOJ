import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] board;
	static int res=0,N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		board=new boolean[N][N];
		
		dfs(0);
		System.out.println(res);
	}
	static void dfs(int idx)
	{
		if(idx==N)
		{
//			for(boolean[] bo:board)
//			{
//				System.out.println(Arrays.toString(bo));
//			}
//			System.out.println();
			res++;
			return;
		}

		for(int i=0;i<N;i++)
		{
			boolean flag = false;
			for(int j=0;j<idx;j++)
			{
				if(board[j][i])
				{
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				int ty=idx-1;
				int tx=i-1;
				while(tx>=0&&ty>=0&&tx<N&&ty<N)
				{
					if(board[ty][tx])
					{
						flag=true;
						break;
					}
					ty-=1;
					tx-=1;
				}
			}
			if(!flag)
			{
				int ty=idx-1;
				int tx=i+1;
				while(tx>=0&&ty>=0&&tx<N&&ty<N)
				{
					if(board[ty][tx])
					{
						flag=true;
						break;
					}
					ty-=1;
					tx+=1;
				}
			}
			if(!flag)
			{
				board[idx][i]=true;
				dfs(idx+1);
				board[idx][i]=false;
			}
		}
	}
}

