import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
	static int[] plan;
	static int[] price;
	static int min = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] tmp = br.readLine().split(" ");
			price = new int[4];
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(tmp[i]);
			}
			plan = new int[12];
			tmp = br.readLine().split(" ");
			min = price[3];
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(tmp[i]);
			}

			dfs(0, 0);
			
			System.out.println("#"+t+" "+min);
		}
	}

	static void dfs(int mon, int sum) {
		if (mon >= 12) {
			if (sum < min) {
				min = sum;
			}
			return;
		}
		dfs(mon + 1, sum + plan[mon] * price[0]);
		dfs(mon + 1, sum + price[1]);
		dfs(mon + 3, sum + price[2]);
	}
}
