
import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");

			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			int K = Integer.parseInt(tmp[2]);
			boolean[][] map = new boolean[N + 650][M + 650];
			ArrayList<Node>[] list = new ArrayList[K + 11];
			int[] dieWhen = new int[K + 20];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				tmp = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(tmp[j]);
					if (life != 0) {
						map[300 + i][300 + j] = true;
						list[life + 1].add(new Node(300 + i, 300 + j, life));
						dieWhen[life * 2]++;
					}
				}
			}

			for (int i = 1; i < K + 1; i++) {
				LinkedList<Node> q = new LinkedList<>();
				for (int j = 0; j < list[i].size(); j++) {
					Node cur = list[i].get(j);
					for (int d = 0; d < 4; d++) {
						int ty = cur.y + dy[d];
						int tx = cur.x + dx[d];
						if (!map[ty][tx]) {
							Node nNode = new Node(ty, tx, cur.life);
							int qIdx;
							if ((qIdx = q.indexOf(nNode)) == -1) {
								q.add(nNode);
							} else {
								if (q.get(qIdx).life < nNode.life) {
									q.get(qIdx).life = nNode.life;
								}
							}
						}
					}
				}
				//System.out.println(i + " " + q.size());
				while (!q.isEmpty()) {
					Node cur = q.poll();
					if (!map[cur.y][cur.x]) {
						list[cur.life + i + 1].add(cur);
						dieWhen[cur.life * 2 + i]++;
						map[cur.y][cur.x] = true;
					}
				}
			}
			int sum = 0;
			for (int i = K+1; i < dieWhen.length; i++) {
				sum += dieWhen[i];
				//System.out.print(dieWhen[i] + " ");
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}

class Node {
	int y, x, life;

	public Node(int y, int x, int life) {
		super();
		this.y = y;
		this.x = x;
		this.life = life;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}