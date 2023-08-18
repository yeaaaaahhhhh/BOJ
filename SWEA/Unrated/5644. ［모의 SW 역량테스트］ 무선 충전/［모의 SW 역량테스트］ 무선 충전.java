import java.io.*;
import java.util.*;

class Solution {
	static BC[] bcs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int[] pA = new int[] { 1, 1 };
			int[] pB = new int[] { 10, 10 };

			String[] tmp = br.readLine().split(" ");

			int M = Integer.parseInt(tmp[0]);
			int A = Integer.parseInt(tmp[1]);

			tmp = br.readLine().split(" ");
			int[] mA = new int[M];
			for (int i = 0; i < M; i++) {
				mA[i] = Integer.parseInt(tmp[i]);
			}

			tmp = br.readLine().split(" ");
			int[] mB = new int[M];
			for (int i = 0; i < M; i++) {
				mB[i] = Integer.parseInt(tmp[i]);
			}
			bcs = new BC[A];
			for (int j = 0; j < A; j++) {
				tmp = br.readLine().split(" ");
				bcs[j] = new BC(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[0]), Integer.parseInt(tmp[2]),
						Integer.parseInt(tmp[3]));
			}

			int res = 0;
			for (int time = 0; time <= M; time++) {
				res += getBattery(pA, pB);
				if (time != M) {
					move(pA, mA[time]);
					move(pB, mB[time]);
				}
				//System.out.println("time: " + time + " " + res);
			}
			System.out.println("#"+t+" "+res);
		}
	}

	static int getBattery(int[] pA, int[] pB) {
		boolean[] batA = new boolean[bcs.length];
		boolean[] batB = new boolean[bcs.length];

		for (int i = 0; i < bcs.length; i++) {
			int distA = Math.abs(bcs[i].x - pA[0]) + Math.abs(bcs[i].y - pA[1]);
			int distB = Math.abs(bcs[i].x - pB[0]) + Math.abs(bcs[i].y - pB[1]);

			if (distA <= bcs[i].cover) {
				batA[i] = true;
			}
			if (distB <= bcs[i].cover) {
				batB[i] = true;
			}
		}
		int max = 0;
		for (int i = 0; i < bcs.length; i++) {
			for (int j = 0; j < bcs.length; j++) {
				int sum = 0;
				if (i == j) {
					if (batA[i] && batB[j]) {
						sum += bcs[i].perf;
						if (sum > max) {
							max = sum;
						}
						continue;
					}
				}

				if (batA[i]) {
					sum += bcs[i].perf;
				}
				if (batB[j]) {
					sum += bcs[j].perf;
				}
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	static void move(int[] person, int op) {
		switch (op) {
		case 0:
			break;
		case 1:
			person[0]--;
			break;
		case 2:
			person[1]++;
			break;
		case 3:
			person[0]++;
			break;
		case 4:
			person[1]--;
			break;
		}
	}
}

class BC {
	int x, y;
	int cover;
	int perf;

	public BC(int x, int y, int cover, int perf) {
		this.x = x;
		this.y = y;
		this.cover = cover;
		this.perf = perf;
	}
}