import java.io.*;
import java.util.*;

public class Main {
	static int[][] pr;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		pr=new int[N][N];
		visited=new boolean[N];
		min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
			String[] tmp=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				pr[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		dfs(0,0,0,-1);
		System.out.println(min);
	}

	static void dfs(int bf, int price, int cnt, int st) {
		if (st == -1) {
			for (int i = 0; i < pr.length; i++) {
				visited[i] = true;
				dfs(i, 0, cnt + 1, i);
				visited[i] = false;
			}
			return;
		}
		if (cnt >= pr.length) {
			if (min > price) {
				min = price;
			}
			return;
		}

		for (int i = 0; i < pr.length; i++) {
			if (pr[bf][i] != 0 && !visited[i]) {
				if (cnt+1 == pr.length) {
					if(pr[i][st]!=0) {
						dfs(i,price+pr[bf][i]+pr[i][st],cnt+2,st);
					}
				} else {
					visited[i] = true;
					dfs(i, price + pr[bf][i], cnt + 1, st);
					visited[i] = false;
				}
			}
		}
	}
}