import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int[] loc = null;
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					loc = new int[] { i, j };
					map[i][j]='.';
				}
			}
		}

		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		int res = 0;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { loc[0], loc[1], 0, 0 });

		boolean[][][] visited = new boolean[N][M][64];

		
		visited[loc[0]][loc[1]][0] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
		
			for (int d = 0; d < 4; d++) {
				int ty = cur[0] + dy[d];
				int tx = cur[1] + dx[d];
				if(ty<0||tx<0||ty>=N||tx>=M)
				{
					continue;
				}
				//System.out.println(ty+" "+tx);
				char type = map[ty][tx];

				if(visited[ty][tx][cur[3]])
				{
					continue;
				}

				if (type >= 'A' && type <= 'F') {
					if ((cur[3] & (1 << (type - 'A'))) > 0) {	
						//System.out.println("go "+cur[3]+" "+(1 << (type - 'A')));
						q.add(new int[] { ty, tx, cur[2] + 1, cur[3]});
						visited[ty][tx][cur[3]]=true;
					}
				}
				else if(type>='a'&&type<='f')
				{
					//System.out.println("get"+type);
					int keyV=cur[3]|(1<<(type-'a'));
					q.add(new int[] { ty, tx, cur[2] + 1,keyV});
					visited[ty][tx][keyV]=true;

				}
				else if(type=='1') {
					System.out.println(cur[2]+1);
					return;
				}
				else if(type=='.'){
					q.add(new int[] { ty, tx, cur[2] + 1,cur[3]});
					visited[ty][tx][cur[3]]=true;
				}
			}
//			System.out.println(Arrays.toString(cur));
//			for(int k=0;k<64;k++)
//			{
//				for(int i=0;i<N;i++)
//				{
//					for(int j=0;j<M;j++)
//					{
//						System.out.print(visited[i][j][k]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println("---------------");
//			}
//			System.out.println();
//			for(char[] ma:map)
//			{
//				System.out.println(Arrays.toString(ma));
//			}
		}
		System.out.println(-1);

	}
}
