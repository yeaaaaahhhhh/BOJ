import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int N;
	static int res=200;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		int color = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					colorIsland(i, j, color);
					color++;
				}
			}
		}

//		for (int[] ma : map) {
//			System.out.println(Arrays.toString(ma));
//		}

		for (int k = 2; k < color; k++) {
			inner:for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==k)
					{
						bridgeSimul(i, j, k);
						break inner; 
					}
				}
			}
		}
		
		System.out.println(res);

	}
	
	static void bridgeSimul(int y,int x,int color)
	{
		boolean[][] visited=new boolean[N][N];
		
		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		
		PriorityQueue<int[]> q = new PriorityQueue(new Comparator<int[]>() {
			public int compare(int[] a,int[] b)
			{
				return a[2]-b[2];
			}
		});
		
		q.add(new int[] { y, x,0 });
		visited[y][x]=true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			//System.out.println(cur[0] + " " + cur[1]);
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];
				//System.out.println(q.toString());
				if (ty >= 0 && tx >= 0 && ty < N && tx < N && !visited[ty][tx]) {
					if(map[ty][tx]==0)
					{
						q.add(new int[] { ty, tx,cur[2]+1 });
						visited[ty][tx] = true;	
					}
					else if(map[ty][tx]==color)
					{
						q.add(new int[] { ty, tx,0 });
						visited[ty][tx] = true;	
					}
					else
					{
						if(res>cur[2])
						{
							res=cur[2];
						}
						return;
					}
				}
			}
		}
	}
	
	static void colorIsland(int y, int x, int color) {

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { y, x });
		map[y][x] = color;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			//System.out.println(cur[0] + " " + cur[1]);
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty >= 0 && tx >= 0 && ty < N && tx < N && map[ty][tx] == 1) {
					q.add(new int[] { ty, tx });
					map[ty][tx] = color;
				}
			}
		}
	}
}
