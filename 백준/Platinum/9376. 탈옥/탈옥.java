import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int h, w;
	static char[][] map;
	static int[][] prsn;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] tmp = br.readLine().split(" ");

			h = Integer.parseInt(tmp[0]) + 2;
			w = Integer.parseInt(tmp[1]) + 2;

			map = new char[h][w];
			prsn = new int[2][2];

			for (int i = 0; i < h; i++)
				Arrays.fill(map[i], '.');

			for (int i = 1; i < h - 1; i++) {
				String str = br.readLine();
				for (int j = 1; j < w - 1; j++) {
					map[i][j] = str.charAt(j - 1);
					if (map[i][j] == '$') {
						if (prsn[0][0] == 0) {
							prsn[0][0] = i;
							prsn[0][1] = j;
						} else {
							prsn[1][0] = i;
							prsn[1][1] = j;
						}
					}
				}
			}

//			for(char[] ma:map)
//			{
//			 	System.out.println(Arrays.toString(ma));
//		 	}
//			
			int[][] helper = getPrice(new int[] { 0, 0 });
			int[][] p1 = getPrice(prsn[0]);
			int[][] p2 = getPrice(prsn[1]);

			int[][] res = new int[h][w];

			int min = Integer.MAX_VALUE;

			// get map sum
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					res[i][j] = helper[i][j] + p1[i][j] + p2[i][j];
					if (map[i][j] == '#') {
						res[i][j] -= 2;
					}
					if (min > res[i][j])
						min = res[i][j];
				}
			}

//			for(int i=0;i<h;i++)
//				System.out.println(Arrays.toString(res[i]));

			System.out.println(min);
		}

	}

	static int[][] getPrice(int[] loc) {
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int[][] res = new int[h][w];
		for (int i = 0; i < h; i++) {
			Arrays.fill(res[i], 100000);
		}
		boolean[][] visited = new boolean[h][w];

		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1,o2)->{
			return o1[2]-o2[2];
		});
		

		res[loc[0]][loc[1]] = 0;
		q.add(new int[] { loc[0], loc[1], 0 });
		visited[loc[0]][loc[1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty < 0 || tx < 0 || ty >= h || tx >= w || visited[ty][tx] || map[ty][tx] == '*') {
					continue;
				}

				visited[ty][tx] = true;
				if (map[ty][tx] == '$' || map[ty][tx] == '.') {
					res[ty][tx] = cur[2];
					q.add(new int[] { ty, tx, cur[2] });
				} else if (map[ty][tx] == '#') {
					res[ty][tx] = cur[2] + 1;
					q.add(new int[] { ty, tx, cur[2] + 1 });
				}
			}
		}

		return res;
	}
}