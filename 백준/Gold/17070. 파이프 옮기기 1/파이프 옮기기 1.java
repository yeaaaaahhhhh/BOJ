import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<int[]> q;
	static int[][][] map;
	static int N;
	static boolean[][] isWall;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		isWall = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(tmp[j]);
				if (cur == 1) {
					isWall[i][j] = true;
				}
			}
		}
		
		map=new int[N][N][3];
		
		q=new LinkedList<int[]>();
		if(isWall[N-1][N-1])
		{
			System.out.println(0);
			return;
		}
		q.add(new int[] {0,1,0});
		map[0][1][0]=1;
		while(!q.isEmpty())
		{
			int[] cur=q.poll();
			
			int y=cur[0];
			int x=cur[1];
			int dir=cur[2];
			
			if(dir==0)//가로
			{
				goRight(y,x);
				goDiag(y,x);
			}
			else if(dir==1)//대각선
			{
				goRight(y,x);
				goDiag(y,x);
				goDown(y, x);
			}
			else
			{
				goDiag(y,x);
				goDown(y, x);
			}
		}
		
		System.out.println(map[N-1][N-1][0]+map[N-1][N-1][1]+map[N-1][N-1][2]);
	}
	static void goRight(int y,int x)
	{
		if(x+1<N&&!isWall[y][x+1])
		{
			map[y][x+1][0]++;
			q.add(new int[] {y,x+1,0});
		}
	}
	static void goDiag(int y,int x)
	{
		if(x+1<N&&y+1<N&&!isWall[y+1][x+1]&&!isWall[y+1][x]&&!isWall[y][x+1])
		{
			map[y+1][x+1][1]++;
			q.add(new int[] {y+1,x+1,1});
		}
	}
	static void goDown(int y,int x)
	{
		if(y+1<N&&!isWall[y+1][x])
		{
			map[y+1][x][2]++;
			q.add(new int[] {y+1,x,2});
		}
	}
}
