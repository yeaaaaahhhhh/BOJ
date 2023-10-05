import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class Solution {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, M, K;
	static LinkedList<Group> groups;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			K = Integer.parseInt(tmp[2]);

			groups = new LinkedList<>();

			for (int i = 0; i < K; i++) {
				tmp = br.readLine().split(" ");
				int y = Integer.parseInt(tmp[0]);
				int x = Integer.parseInt(tmp[1]);
				int cnt = Integer.parseInt(tmp[2]);
				int dir = Integer.parseInt(tmp[3]) - 1;

				Group cur = new Group(y, x, cnt, dir);

				groups.add(cur);
			}

			for (int m = 0; m < M; m++) {

				for (int i = 0; i < groups.size(); i++) {
					Group cur = groups.get(i);
					int ty = cur.y + dy[cur.dir];
					int tx = cur.x + dx[cur.dir];
					if (ty == 0 || ty == N - 1 || tx == 0 || tx == N - 1) {
						cur.cnt /= 2;
						cur.dir = (cur.dir % 2 == 0) ? cur.dir + 1 : cur.dir - 1;
					}
//				System.out.println(cur.y+" "+cur.x+" "+ty+" "+tx);
					cur.y = ty;
					cur.x = tx;

					if (cur.cnt == 0) {
						groups.remove(i);
						i--;
						continue;
					}
				}

				Collections.sort(groups);

				int[][] map = new int[N][N];

				for (int i = 0; i < N; i++) {
					Arrays.fill(map[i], -1);
				}
				for (int i = 0; i < groups.size(); i++) {
					Group cur = groups.get(i);

					if (map[cur.y][cur.x] == -1) {
						map[cur.y][cur.x] = i;
					} else {
						int idx = map[cur.y][cur.x];

						Group bigger = groups.get(idx);
						bigger.cnt += cur.cnt;
						groups.remove(i);
						i--;
						continue;
					}
				}
			}

			int sum = 0;
			for (Group gr : groups) {
				sum += gr.cnt;
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}

class Group implements Comparable<Group> {
	int y, x;
	int cnt;
	int dir;

	public Group(int y, int x, int cnt, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.dir = dir;
	}

	@Override
	public int compareTo(Group o) {
		if (this.y == o.y && this.x == o.x) {
			return o.cnt - this.cnt;
		} else {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}

	@Override
	public String toString() {
		return "Group [y=" + y + ", x=" + x + ", cnt=" + cnt + ", dir=" + dir + "]";
	}

}
