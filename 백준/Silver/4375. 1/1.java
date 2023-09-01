import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		while (true) {
			int[] rem = new int[100000];

			int digit = 0;
			int sum = 0;
			while (true) {
				if (digit == 0) {
					rem[digit] = 1 % N;
				} else if (digit == 1) {
					rem[digit] = 10 % N;
				} else {
					rem[digit] = (rem[digit - 1] * 10) % N;
				}
				sum += rem[digit];
				//System.out.println(Arrays.toString(rem));
				if (sum % N == 0) {
					System.out.println(digit + 1);
					break;
				}
				digit++;
			}
			String str=br.readLine();
			if(str==null)
				return;
			else
				N=Integer.parseInt(str);
		}
	}
}
