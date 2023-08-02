import java.util.*;
import java.io.*;

//청소년 상어 : 9시 30분
public class Main {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][][] arr = new int[4][4][2];
		HashMap<Integer, int[]> hm = new HashMap<>();

		for (int i = 0; i < 4; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(tmp[j * 2]);
				int dir = Integer.parseInt(tmp[j * 2 + 1]) - 1;

				arr[i][j][0] = num;
				arr[i][j][1] = dir;
				hm.put(num, new int[] { i, j });

			}
		}

		int[] shark = { 0, 0, arr[0][0][1] };// 상어의 x,y
		int sum = arr[0][0][0];
		hm.remove(arr[0][0][0]);
		arr[0][0] = new int[] { -1, -1 };
		// System.out.println(Arrays.toString(hm.get(16)));

		moveFish(arr, hm, shark);
		//printSpace(arr);
		dfs(arr, hm, shark, sum,0);

		System.out.println(max);

	}

	static void dfs(int[][][] arr, HashMap<Integer, int[]> hm, int[] shark, int sum,int depth) {
		int tx = shark[0];
		int ty = shark[1];
		int dir = shark[2];
		boolean flag = false;
		while (true) {
			tx += dx[dir];
			ty += dy[dir];
			//System.out.println(tx+" "+ty+" "+dir+" "+depth);
			if (tx >= 0 && ty >= 0 && tx < 4 && ty < 4) {
				if (arr[tx][ty][0] != 0) {
					flag = true;
					HashMap<Integer, int[]> nHm = (HashMap<Integer, int[]>) hm.clone();
					int[][][] narr = new int[4][4][2];
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							for(int k=0;k<2;k++)
								narr[i][j][k] = arr[i][j][k];
						}
					}
				
					// 이전 상어가 있던곳은 비움
					narr[shark[0]][shark[1]] = new int[] { 0, 0 };
					// 상어 새로운 곳으로 이동
					int[] nSh = { tx, ty, narr[tx][ty][1] };
					//System.out.println(Arrays.toString(nSh));
					int nSum = sum + narr[tx][ty][0];
					nHm.remove(narr[tx][ty][0]);
					narr[tx][ty] = new int[] { -1, -1 };

					
					moveFish(narr, nHm, nSh);
					//printSpace(narr);
		
					dfs(narr, nHm, nSh, nSum,depth+1);
				}
			} else {
				break;
			}
		}
		
		if (!flag && sum > max) {
			max = sum;
			return;
		}
	}

	static void printSpace(int[][][] arr) {
		for (int[][] ar : arr) {
			for (int[] f : ar) {
				System.out.print(f[0] + "-" + f[1] + " ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}

	static void moveFish(int[][][] arr, HashMap<Integer, int[]> hm, int[] shark) {
		for (int i = 1; i <= 16; i++) {
			int[] cur = hm.get(i);
			if (cur == null)
				continue;
			int x = cur[0];
			int y = cur[1];
			// System.out.println(i);
			for (int j = 0; j < 8; j++) {
				int tx = x + dx[arr[x][y][1]];
				int ty = y + dy[arr[x][y][1]];
				if (tx >= 0 && ty >= 0 && tx < 4 && ty < 4 && arr[tx][ty][0] != -1 && arr[tx][ty][1] != -1) {
					int tIdx = arr[tx][ty][0];
					hm.replace(i, new int[] { tx, ty });
					hm.replace(tIdx, new int[] { x, y });
					int[] arrTemp = arr[x][y].clone();
					arr[x][y] = arr[tx][ty].clone();
					arr[tx][ty] = arrTemp;
//					System.out.println(Arrays.toString(arr[x][y])+" "+Arrays.toString(arr[tx][ty]));
					break;
				} else
					arr[x][y][1] = (arr[x][y][1] + 1) % 8;
			}
			// printSpace(arr);
		}
	}
}
