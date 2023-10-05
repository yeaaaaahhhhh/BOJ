import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Solution {
	static int N, W, H;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");

			N = Integer.parseInt(tmp[0]);
			W = Integer.parseInt(tmp[1]);
			H = Integer.parseInt(tmp[2]);

			res = Integer.MAX_VALUE;

			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			dfs(0, map);
			System.out.println("#"+t+" "+res);
		}
	}

	static void dfs(int stg, int[][] map) {

		if (stg == N) {
			int cnt=0;
			for(int i=0;i<H;i++)
			{
				for(int j=0;j<W;j++)
				{
					if(map[i][j]!=0)
					{
						cnt++;
					}
				}
			}
			
			//System.out.println(cnt+" : cnt");
			if (cnt < res) {
				res = cnt;
			}
			return;
		}
		boolean inFlag=false;
		for (int line = 0; line < W; line++) {
			int loc = -1;
			int pow = 0;
			for (int i = 0; i < H; i++) {
				if (map[i][line] != 0) {
					loc = i;
					pow = map[i][line];
					break;
				}
			}

			if (loc == -1) {
				continue;
			}
			inFlag=true;
			int[][] nmap = new int[H][];
			for (int i = 0; i < H; i++) {
				nmap[i] = map[i].clone();
			}

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { loc, line, pow });
			while (!q.isEmpty()) {
				int[] cur = q.poll();
//				System.out.println(Arrays.toString(cur));
				for (int i = 1 - cur[2]; i < cur[2]; i++) {
					// 세로로 갈기
					int ty = cur[0] + i;
					if (ty < 0 || ty >= H)
						continue;
					if (nmap[ty][cur[1]] > 1) {
						q.add(new int[] { ty, cur[1], nmap[ty][cur[1]] });
					}
					nmap[ty][cur[1]] = 0;
//					System.out.println("세로 갈기:"+ty+" "+cur[1]);
				}
				for (int i = 1 - cur[2]; i < cur[2]; i++) {
					// 세로로 갈기
					int tx = cur[1] + i;
					if (tx < 0 || tx >= W)
						continue;
					if (nmap[cur[0]][tx] > 1) {
						q.add(new int[] { cur[0], tx, nmap[cur[0]][tx] });
					}
					nmap[cur[0]][tx] = 0;
					//System.out.println("가로 갈기:"+cur[0]+" "+tx);
				}
			}
			setMap(nmap);
//			System.out.println("stg : "+stg+"line : "+line);
//			for (int[] nm : nmap) {
//				System.out.println(Arrays.toString(nm));
//			}
			dfs(stg+1,nmap);
		}
		if(!inFlag)
		{
			res=0;
			return;
		}
	}

	static void setMap(int[][] map)
	{
		for(int w=0;w<W;w++)
		{
			int loc=-1;
			LinkedList<Integer> list=new LinkedList();
			for(int h=H-1;h>=0;h--)
			{
				if(map[h][w]==0)
				{
					loc=h;
					break;
				}
			}
			//0이 없음
			if(loc==-1)
			{
				continue;
			}
			for(int i=loc-1;i>=0;i--)
			{
				if(map[i][w]!=0)
				{
					list.add(map[i][w]);
				}
			}
			if(list.isEmpty())
			{
				continue;
			}
			for(int i=loc;i>=0;i--)
			{
				if(list.isEmpty())
				{
					if(map[i][w]!=0)
					{
						map[i][w]=0;
					}
				}
				else
				{
					map[i][w]=list.pollFirst();
				}
			}
		}
	}
}