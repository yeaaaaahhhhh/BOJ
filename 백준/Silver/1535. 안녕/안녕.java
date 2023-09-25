import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] tired = new int[N];
		int[] happy = new int[N];

		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			tired[i] = Integer.parseInt(tmp[i]);
		}
		tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			happy[i] = Integer.parseInt(tmp[i]);
		}

		int[][] knapsack = new int[N + 1][100];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 100; j++) {
				// case 2 : 비교 필요
				if (j >= tired[i-1]) {
					knapsack[i][j] = Math.max(happy[i-1] + knapsack[i - 1][j - tired[i-1]], knapsack[i - 1][j]);
				}
				// case 1: 이전 최적해 가져오기
				else {
					knapsack[i][j]=knapsack[i-1][j];
				}
			}
		}
//		for(int[] kn:knapsack)
//		{
//			System.out.println(Arrays.toString(kn));
//		}
		
		System.out.println(knapsack[N][99]);
	}
}
