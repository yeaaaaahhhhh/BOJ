import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<int[]> q;
	static long[][][] map;
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

		map = new long[N][N][3];
		map[0][1][0] = 1;
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {
				if (!isWall[i][j]) {

					if (j - 1 >= 0) {
						map[i][j][0] += map[i][j-1][0] + map[i][j-1][1];
					}
					if (i - 1 >= 0) {
						map[i][j][2] += map[i-1][j][1] + map[i-1][j][2];
					}
					if (i - 1 >= 0 && j - 1 >= 0 && !(isWall[i - 1][j] || isWall[i][j - 1])) {
						map[i][j][1] += map[i-1][j-1][0] + map[i-1][j-1][1]+map[i-1][j-1][2];
					}

				}
			}
		}
//		for (int k = 0; k < 3; k++) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		System.out.println(map[N - 1][N - 1][0] + map[N - 1][N - 1][1] + map[N - 1][N - 1][2]);
	}
}
