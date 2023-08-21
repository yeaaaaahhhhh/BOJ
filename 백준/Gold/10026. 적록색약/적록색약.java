import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				switch (str.charAt(j)) {
				case 'R':
					map[i][j] = 0;
					break;

				case 'B':
					map[i][j] = 1;
					break;

				case 'G':
					map[i][j] = 2;
					break;
				}
			}
		}

		boolean[][] visited = new boolean[N][N];

		int nonRes =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					nonRes++;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					visited[i][j]=true;
					
					while (!q.isEmpty()) {
						
						int[] cur=q.poll();
						
						for(int d=0;d<4;d++)
						{
							int ty=cur[0]+dy[d];
							int tx=cur[1]+dx[d];
							
							if(ty>=0&&tx>=0&&ty<N&&tx<N&&!visited[ty][tx]&&map[ty][tx]==map[i][j])
							{
								q.add(new int[] {ty,tx});
								visited[ty][tx]=true;
							}
						}
					}

				}
			}
		}
		visited = new boolean[N][N];
		int cbRes =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					cbRes++;
					Queue<int[]> q = new LinkedList<int[]>();
					q.add(new int[] { i, j });
					visited[i][j]=true;
					
					while (!q.isEmpty()) {
						
						int[] cur=q.poll();
						
						for(int d=0;d<4;d++)
						{
							int ty=cur[0]+dy[d];
							int tx=cur[1]+dx[d];
							
							if(ty>=0&&tx>=0&&ty<N&&tx<N&&!visited[ty][tx]&&map[ty][tx]%2==map[i][j]%2)
							{
								q.add(new int[] {ty,tx});
								visited[ty][tx]=true;
							}
						}
					}

				}
			}
		}
		System.out.println(nonRes+" "+cbRes);
	}
}
