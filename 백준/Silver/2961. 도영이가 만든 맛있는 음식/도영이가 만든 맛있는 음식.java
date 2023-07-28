
import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int res = Integer.MAX_VALUE;
		ArrayList<Food> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			int s = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);

			arr.add(new Food(s, b));
			if (res > Math.abs(s - b)) {
				res = Math.abs(s - b);
			}

			if (i != 0) {
				int len = arr.size()-1;
				for (int j = 0; j < len; j++) {
					Food cur = arr.get(j);
					int ts = cur.sour * s;
					int tb = cur.bitter + b;
					arr.add(new Food(ts, tb));
					if (res > Math.abs(ts - tb)) {
						res = Math.abs(ts - tb);
					}
				}
			}
		}
		System.out.println(res);
	}

}

class Food {
	int sour;
	int bitter;

	public Food(int sour, int bitter) {
		super();
		this.sour = sour;
		this.bitter = bitter;
	}
}
