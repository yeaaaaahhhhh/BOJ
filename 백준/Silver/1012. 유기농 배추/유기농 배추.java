import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		for (int t = 0; t < T; t++) {
			String[] tmp = br.readLine().split(" ");

			int N = Integer.parseInt(tmp[1]);
			int M = Integer.parseInt(tmp[0]);
			int K = Integer.parseInt(tmp[2]);

			int[][] map = new int[N][M];
			Queue<int[]> plants = new LinkedList<>();
			for (int k = 0; k < K; k++) {
				tmp = br.readLine().split(" ");
				int x = Integer.parseInt(tmp[0]);
				int y = Integer.parseInt(tmp[1]);

				plants.add(new int[] { y, x });
				map[y][x] = 1;
			}
			int cnt = 0;
			while (!plants.isEmpty()) {
				int[] plant = plants.poll();

				if (map[plant[0]][plant[1]] != 1) {
					continue;
				}
				cnt++;

				Queue<int[]> q = new LinkedList<>();
				q.add(plant);
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					map[cur[0]][cur[1]] = 2;
					for (int d = 0; d < 4; d++) {
						int ty = cur[0] + dy[d];
						int tx = cur[1] + dx[d];

						if (ty < 0 || ty >= N || tx < 0 || tx >= M || map[ty][tx] != 1) {
							continue;
						}

						q.add(new int[] { ty, tx });
						map[ty][tx] = 2;

					}
				}

			}
			System.out.println(cnt);

		}

	}

}