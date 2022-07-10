import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		short[] wheel = new short[T]; // byte=8bit short=16bit

		for (int i = 0; i < T; i++) {
			wheel[i] = Short.parseShort(br.readLine(), 2);
		}

		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]) - 1;

			boolean dir;
			
			if (tmp[1].equals("-1")) {
				dir = false;// 반시계
			} else
				dir = true;// 시계

			int left = n;
			int right = n;

			while (left > 0) {
				int lp = wheel[left-1] >> 5 & 1; // 왼쪽 톱니바퀴의 3시방향
				int rp = wheel[left] >> 1 & 1; // 오른쪽 톱니바퀴의 9시방향

				if (lp == rp)
					break;
				else {
					// ldir방향으로 돌리기
					left--;
				}
			}

			while (right < T - 1) {
				int lp = wheel[right] >> 5 & 1; // 왼쪽 톱니바퀴의 3시방향
				int rp = wheel[right + 1] >> 1 & 1; // 오른쪽 톱니바퀴의 9시방향

				if (lp == rp)
					break;
				else {
					right++;
				}
			}
			boolean tdir = !dir;
			for (int i = n-1; i >= left; i--) {
				if (tdir) {
					// 시계
					int end = wheel[i] & 1;
					
					wheel[i] = (short) ((wheel[i] >> 1) | (end << 7));
				} else {
					// 반시계
					int end = (wheel[i] >> 7) & 1;
					
					wheel[i] = (short) ((wheel[i] << 1) & 255 | end);
				}
				tdir=!tdir;
			}
			if (dir) {
				// 시계
				int end = wheel[n] & 1;
				
				wheel[n] = (short) ((wheel[n] >> 1) | (end << 7));
			} else {
				// 반시계
				int end = (wheel[n] >> 7) & 1;
				
				wheel[n] = (short) ((wheel[n] << 1) & 255 | end);
			}
			tdir=!dir;
			for (int i = n+1; i <= right; i++) {
				if (tdir) {
					// 시계
					int end = wheel[i] & 1;
					wheel[i] = (short) ((wheel[i] >> 1) | (end << 7));
				} else {
					// 반시계
					int end = (wheel[i] >> 7) & 1;
					wheel[i] = (short) ((wheel[i] << 1) & 255 | end);
				}
				tdir=!tdir;
			}
		}
		int res = 0;
		for (int i = 0; i < T; i++) {
		
			if (wheel[i] >> 7 == 1) {
				res++;
			}
		}
		bw.write(res + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}