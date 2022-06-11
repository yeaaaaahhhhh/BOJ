import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(0, N - 1);
		for (int i : num) {
			bw.append(i+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void mergeSort(int left, int right) {
		int m = (left + right) / 2;
		if (right - left >= 2) {
			mergeSort(left, m);
			mergeSort(m + 1, right);
		}
		merge(left, m + 1, right);
	}

	static void merge(int x, int y, int z) {
		int i, j;
		i = x;
		j = y;
		int[] tmp = new int[z - x + 1];
		int idx = 0;
		while (i < y && j <= z) {
			if (num[i] > num[j]) {
				tmp[idx++] = num[j++];
			} else {
				tmp[idx++] = num[i++];
			}
		}
		if (i >= y) {
			while (j <= z) {
				tmp[idx++] = num[j++];
			}
		}
		if (j > z) {
			while (i < y) {
				tmp[idx++] = num[i++];
			}
		}
		for (int a = 0; a < tmp.length; a++) {
			num[x + a] = tmp[a];
		}
	}

}