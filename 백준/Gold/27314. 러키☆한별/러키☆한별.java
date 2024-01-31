import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] star = new int[2];
	static ArrayList<int[]> ppl = new ArrayList<int[]>();
	static ArrayList<Door> doors = new ArrayList<Door>();
	static int max=0;
	
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'H') {
					star[0] = i;
					star[1] = j;
				} else if (map[i][j] == '#') {
					doors.add(new Door(i, j));
				} else if (map[i][j] == 'P') {
					ppl.add(new int[] { i, j });
				}
			}
		}

		// door에 사람들 거리 넣어주기
		for (int[] p : ppl) {
			countDist(p,false);
		}

//		for (Door d : doors) {
//			System.out.println(d.toString());
//		}

		countDist(star,true);
		
		System.out.println(max);
	}

	static void countDist(int[] p, boolean isStar) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { p[0], p[1], 0 });
		visited[p[0]][p[1]] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];

				if (ty < 0 || tx < 0 || ty >= N || tx >= M || visited[ty][tx] || map[ty][tx] == 'X') {
					continue;
				}

				if (map[ty][tx] == '#') {
					for (Door door : doors) {
						if (door.x == tx && door.y == ty) {
							if (isStar) {
								int cnt=0;
								for(int pd:door.dist)
								{
									if(pd<=cur[2]+1)
									{
										cnt++;
									}
								}
								if(cnt>max)
								{
									max=cnt;
								}
							} else {
								door.dist.add(cur[2] + 1);
							}
						}

					}
				}

				visited[ty][tx] = true;
				q.add(new int[] { ty, tx, cur[2] + 1 });
			}
		}
	}
}

class Door {
	int x;
	int y;
	ArrayList<Integer> dist;

	Door(int y, int x) {
		this.x = x;
		this.y = y;
		dist = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "Door [x=" + x + ", y=" + y + ", dist=" + dist + "]";
	}

}