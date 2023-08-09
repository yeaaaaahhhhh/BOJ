import java.io.*;
import java.util.*;

class Solution {
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			int max=0;
			int idx=-1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int res=dfs(i, j, N);
					if(res>max) {
						max=res;
						idx=arr[i][j];
					} else if(res==max&&arr[i][j]<idx)
					{
						idx=arr[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+idx+" "+max);
		}
	}

	static int dfs(int y, int x, int N) {
		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, 1, -1 };
		int cnt = 0;
		cnt++;
		for (int d = 0; d < 4; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];

			if (tx >= 0 && ty >= 0 && tx < N && ty < N) {
				if (arr[ty][tx] - arr[y][x] == 1) {
					cnt += dfs(ty, tx, N);
				}
			}
		}
		return cnt;
		
	}
}
