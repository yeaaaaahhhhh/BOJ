import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] w = new int[N];// 동전의 값 == 일반적인 배낭 문제의 무게
			String[] tmp = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				w[i] = Integer.parseInt(tmp[i]);
			}

			int M = Integer.parseInt(br.readLine());
			int[][] knapsack = new int[N + 1][M + 1];

			for (int i = 1; i < N + 1; i++) {
				for (int j = 0; j < M + 1; j++) {
					if (j >= w[i - 1]) {
						if (i == 1) {
							if (j % w[i - 1] == 0) {
								knapsack[i][j] = 1;
							}
						} else {
							if (j == w[i - 1]) {
								knapsack[i][j]=knapsack[i-1][j]+1;
							} else {
								knapsack[i][j] = knapsack[i - 1][j] + knapsack[i][j - w[i - 1]];
							}
						}
					} else {
						knapsack[i][j] = knapsack[i - 1][j];
					}
					
				}
			}

//			for (int[] kn : knapsack) {
//				System.out.println(Arrays.toString(kn));
//			}
			
			System.out.println(knapsack[N][M]);
		}
	}
}
