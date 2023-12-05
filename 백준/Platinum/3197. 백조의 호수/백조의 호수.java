import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dSw = { -1, -1 };// destination Swan
	static int[] sSw = { -1, -1 };// starting point Swan
	static Queue<int[]> sq = new LinkedList<int[]>();// swan queue
	static Queue<int[]> wq = new LinkedList<int[]>();// melting water queue

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		R = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					if (sSw[0] == -1) {
						sSw[0] = i;
						sSw[1] = j;
					} else {
						dSw[0] = i;
						dSw[1] = j;
					}
					map[i][j] = '.';
				}
				if (map[i][j] == '.') {
					wq.add(new int[] { i, j });
				}
			}
		}

		int day = 0;
		sq.add(sSw);
		visited[sSw[0]][sSw[1]]=true;
		
		while (true) {
//			System.out.println("day : "+day);
//			printMap();
			if (moveSwan()) {
				break;
			}
			melt();
			
			day++;
		}
		System.out.println(day);
	}

	static void printMap() {
		System.out.println("--- map ---");
		for (char[] ma : map) {
			System.out.println(Arrays.toString(ma));
		}
		
		System.out.println("--- visited ---");
		for (boolean[] visit : visited) {
			System.out.println(Arrays.toString(visit));
		}
	}

	static void melt() {
		Queue<int[]> q = new LinkedList<int[]>();

		while (!wq.isEmpty()) {
			int[] cur = wq.poll();
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty < 0 || tx < 0 || ty >= R || tx >= C || map[ty][tx] == '.') {
					continue;
				}

				if (map[ty][tx] == 'X') {
					map[ty][tx] = '.';
					q.add(new int[] { ty, tx });
				}
			}
		}
		wq = q;
	}

	static boolean moveSwan() {
		Queue<int[]> q = new LinkedList<int[]>();

		while (!sq.isEmpty()) {
			int[] cur = sq.poll();
			
			if (cur[0] == dSw[0] && cur[1] == dSw[1]) {
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];
				if (ty < 0 || tx < 0 || ty >= R || tx >= C || visited[ty][tx]) {
					continue;
				}
				
				visited[ty][tx] = true;
				
				if (map[ty][tx] == '.') {
					sq.add(new int[] { ty, tx });
				} else// X (얼음) 일때
				{
					q.add(new int[] { ty, tx });
				}
			}
		}
		sq = q;
		return false;
	}
}