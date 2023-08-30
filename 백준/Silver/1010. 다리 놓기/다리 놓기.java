import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[31][31];

		for (int i = 1; i < 31; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				}
			}
		}

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");

			int A = Integer.parseInt(tmp[0]);
			int B = Integer.parseInt(tmp[1]);
			
			System.out.println(dp[Math.max(A, B)][Math.min(A, B)]);
		}

	}
	// nCr= n-1Cr+n-1Cr-1
}
