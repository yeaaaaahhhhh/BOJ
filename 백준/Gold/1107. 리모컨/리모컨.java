import java.io.*;
import java.util.*;

public class Main {
	static int chanel;
	static int N;
	static int cnt;
	static ArrayList<Integer> broken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		chanel = 100;
		int len = Integer.parseInt(br.readLine());

		broken = new ArrayList<>();
		if (len > 0) {
			String[] tmp = br.readLine().split(" ");
			for (int i = 0; i < len; i++) {
				broken.add(Integer.parseInt(tmp[i]));
			}
		}

		dfs(5, 0);

		//System.out.println(chanel);
		System.out.println( cnt + Math.abs(N - chanel));

	}

	static void dfs(int idx, int num) {
		if (idx < 0) {
			//System.out.println("dfs: " + idx + " " + num + " " );
			int tcnt=String.valueOf(num).length();
			if (Math.abs(chanel - N)+cnt > Math.abs(num - N)+tcnt) {
				chanel = num;
				cnt=tcnt;
			}
			return;
		}

		int curDigit = (int) Math.pow(10, idx);

		//System.out.println(curDigit);
			
		for (int i = 0; i <= 9; i++) {
			if(i==0&&num==0&&idx!=0)
			{
				dfs(idx - 1, num);
			}
			else if (!broken.contains(i)) {
				dfs(idx - 1, num + i * curDigit);
			}
		}
	}
}