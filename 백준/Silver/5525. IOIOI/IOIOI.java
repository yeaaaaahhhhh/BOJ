import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();

		StringBuilder sb = new StringBuilder();

		int len = N * 2 + 1;

		int mat = 0;
		int idx = 0;
		int res = 0;
		while (idx < S.length()) {
			if ((mat % 2 == 0 && S.charAt(idx) == 'I') || (mat % 2 == 1 && S.charAt(idx) == 'O')) {
				mat++;
			} else {
				if (mat != 0) {
					if (mat == 1) {
						mat--;
					} else {
						mat -= 2;
					}
					continue;
				}
			}
//			System.out.println(S.charAt(idx) + " " + idx + " " + mat);
			if (mat == len) {
				mat -= 2;
				res++;
//				System.out.println("found");
			}
			idx++;
		}
		System.out.println(res);
	}
}