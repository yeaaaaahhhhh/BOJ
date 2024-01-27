import java.io.*;
import java.util.*;

class Main {

	static int R, C;
	static char[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Queue<int[]> water = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);

		map = new char[R][C];

		int sy = 0, sx = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
					map[i][j] = '.';
				} else if (map[i][j] == '*') {
					water.add(new int[] { i, j });
				}

			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[R][C];
		q.add(new int[] { sy, sx });
		visited[sy][sx] = true;
		int time = 0;
		while (!q.isEmpty()) {
			flood();
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			time++;
			Queue<int[]> nq = new LinkedList<int[]>();
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ty = cur[0] + dy[d];
					int tx = cur[1] + dx[d];

					if (ty < 0 || tx < 0 || ty >= R || tx >= C || visited[ty][tx]) {
						continue;
					}

					if (map[ty][tx] == '.') {
						visited[ty][tx] = true;
						nq.add(new int[] { ty, tx });
					} else if (map[ty][tx] == 'D') {
						System.out.println(time);
						return;
					}
				}
			}
			q=nq;
		}

		System.out.println("KAKTUS");
	}

	static void flood() {
		Queue<int[]> nq = new LinkedList<int[]>();
		while (!water.isEmpty()) {
			int[] cur = water.poll();
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];
				if (ty < 0 || tx < 0 || ty >= R || tx >= C || map[ty][tx] != '.') {
					continue;
				}
				map[ty][tx] = '*';
				nq.add(new int[] { ty, tx });
			}
		}
		water = nq;
	}
}