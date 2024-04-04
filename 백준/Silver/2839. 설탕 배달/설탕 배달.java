import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[2][N + 1];
		
		Arrays.fill(arr[0],10000);
		Arrays.fill(arr[1],10000);
		for (int i = 0; i * 3 < N + 1; i++) {
			arr[0][i * 3] = i;
		}
		arr[1] = arr[0].clone();

		for (int i = 0; i < N + 1; i++) {
			if (i % 5 == 0) {
				arr[1][i] = i / 5;
			} else {
				if(i<5)
					continue;
				arr[1][i] = Math.min(arr[1][i], arr[1][i - 5] + 1);
			}
		}

//		for (int i = 0; i < 2; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		if(arr[1][N]==10000)
		{
			System.out.println(-1);
			return;
		}
		System.out.println(arr[1][N]);
	}
}