import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C;
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int N = Integer.parseInt(br.readLine());

		tmp = br.readLine().split(" ");

		boolean left = true;

		for (int i = 0; i < N; i++) {
			int y = R - Integer.parseInt(tmp[i]);
			if (left) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] == 'x') {
						breakCrst(y,x);
						break;
					}
				}
			} else {
				for (int x = C - 1; x >= 0; x--) {
					if (map[y][x] == 'x') {
						breakCrst(y, x);
						break;
					}
				}
			}
			left = !left;
		}
		
		for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void breakCrst(int y, int x) {
		map[y][x] = '.';
		for (int d = 0; d < 4; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];

			if (ty < 0 || tx < 0 || ty >= R || tx >= C || map[ty][tx] != 'x') {
				continue;
			}

			dropGroup(ty, tx);
//			break;

		}
	}
	
	static void dropGroup(int y, int x) {
		
		Queue<int[]> q = new LinkedList<int[]>();
		char[][] cmap = new char[R][];
		for (int i = 0; i < R; i++) {
			cmap[i] = map[i].clone();
		}
		int[] high = new int[C];// highest block in column that needs to be fallen;
		// 행 숫자가 높은 블록, 문제에서는 가장 낮은 블록
		Arrays.fill(high, -1);
		int[] low = new int[C];// highest block in column that needs to be fallen;
		Arrays.fill(low, 128);
		
		q.add(new int[] { y, x });
		cmap[y][x] = 'A';
		if (high[x] < y) {
			high[x] = y;
		}
		if(low[x]>y)
		{
			low[x]=y;
		}


//		for (char[] cma : cmap) {
//			System.out.println(Arrays.toString(cma));
//		}
		
//		System.out.println();

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty < 0 || tx < 0 || ty >= R || tx >= C || cmap[ty][tx] != 'x') {
					continue;
				}

				if (ty == R - 1) {

					return;
				} else {
					q.add(new int[] { ty, tx });
					cmap[ty][tx] = 'A';
					if (high[tx] < ty) {
						high[tx] = ty;
					}
					if(low[tx]>ty)
					{
						low[tx]=ty;
					}
				}
			}
		}
//		for (char[] cma : cmap) {
//			System.out.println(Arrays.toString(cma));
//		}
//		System.out.println();
		
		int mindiff = 100000007;
		for (int i = 0; i < C; i++) {
			if (high[i] == -1) {
				continue;

			}
			boolean noGround=true;
			for (int j = high[i] + 1; j < R; j++) {
				if (map[j][i] == 'x') {
					if (j - high[i] - 1 < mindiff) {
						mindiff = j - high[i] - 1;
						noGround=false;
						break;
					}
				}
			}
			if(noGround)
			{
				if(R-high[i]-1<mindiff)
				{
					mindiff=R-high[i]-1;
				}
			}
		}
//		System.out.println(mindiff);

		if(mindiff==100000007)
			return;
		for (int i = 0; i < C; i++) {
			if (high[i] == -1) {
				continue;
			}
			for (int j = high[i]; j >=low[i]; j--) {
				map[j+mindiff][i]=map[j][i];
				map[j][i]='.';
			}
		}
//		for (char[] ma : map) {
//			System.out.println(Arrays.toString(ma));
//		}
//		System.out.println();

	}
}