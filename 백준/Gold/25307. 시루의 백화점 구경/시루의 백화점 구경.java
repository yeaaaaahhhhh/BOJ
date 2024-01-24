import java.io.*;
import java.util.*;

class Main {
	static int N, M, K;
	static int[][] map;
	static int[] siru;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		K = Integer.parseInt(tmp[2]);

		map = new int[N][M];

		ArrayList<int[]> mnnq = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if (map[i][j] == 4) {
					siru = new int[] { i, j };
				} else if (map[i][j] == 3) {
					mnnq.add(new int[] { i, j });
				}
			}
		}

		setMnnq(mnnq);

//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(map[i]));
//		}

		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { siru[0], siru[1], 0 });
		visit[siru[0]][siru[1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			System.out.println("cur : "+cur[0]+" "+cur[1]);
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];
				if (ty < 0 || tx < 0 || ty >= N || tx >= M || visit[ty][tx]) {
					continue;
				}

				if (map[ty][tx] == 0) {
					visit[ty][tx] = true;
					q.add(new int[] { ty, tx, cur[2] + 1 });
				} else if (map[ty][tx] == 2) {
					System.out.println(cur[2] + 1);
					return;
				}
			}
		}
		System.out.println(-1);

	}

	static void setMnnq(ArrayList<int[]> mnnq) {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		
		for (int[] mnq : mnnq) {
			q.add(mnq);
		}
		
		for (int i = 0; i < K; i++) {
			Queue<int[]> nq = new LinkedList<int[]>();
			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (visit[cur[0]][cur[1]]) {
					continue;
				}

				visit[cur[0]][cur[1]] = true;

				for (int d = 0; d < 4; d++) {
					int ty = cur[0] + dy[d];
					int tx = cur[1] + dx[d];
					if (ty < 0 || tx < 0 || ty >= N || tx >= M) {
						continue;
					} else {
						nq.add(new int[] { ty, tx });
						if (map[ty][tx] == 0 || map[ty][tx] == 2) {
							map[ty][tx] = 1;
						}
					}
				}

			}
			q = nq;
		}
	}
}