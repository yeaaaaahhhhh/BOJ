import java.util.*;
import java.io.*;

class Solution {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println("#"+t);
			int[][] arr = new int[N][N];
			int x = 0, y = -1;
			int idx = 1;
			int dir = 0;
			boolean flag = false;
			while (true) {
				int tx = x + dx[dir % 4];
				int ty = y + dy[dir % 4];
				if (tx >= 0 && ty >= 0 && tx < N && ty < N && arr[tx][ty] == 0) {
					x = tx;
					y = ty;
					flag = false;
					arr[x][y] = idx++;
				} else {
					if (!flag) {
						dir++;
						flag = true;
					} else {
						break;
					}
				}

			}
			for (int[] ar : arr) {
				for (int a : ar) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
		}
	}
}
