import java.util.*;
import java.util.stream.Stream;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);

		int[] st = new int[2];

		int[][] arr = new int[n][m];
		int[][] res = new int[n][m];

		for (int i = 0; i < n; i++) {
			Arrays.fill(res[i], -1);
		}
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
				if (arr[i][j] == 2) {
					st[0] = i;
					st[1] = j;
					res[i][j] = 0;
				} else if (arr[i][j] == 0) {
					res[i][j] = 0;
				}
			}
		}

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(st);

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int v = res[cur[0]][cur[1]];
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty < 0 || tx < 0 || ty >= n || tx >= m || arr[ty][tx] != 1) {
					continue;
				}

				q.add(new int[] { ty, tx });
				res[ty][tx] = v + 1;
				arr[ty][tx] = 2;
			}

		}

		for (int i = 0; i < n; i++) {
			for(int j=0;j<m;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}

	}

}