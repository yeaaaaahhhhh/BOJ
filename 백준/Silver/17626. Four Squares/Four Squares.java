import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[50000];

		for (int i = 0; i < n; i++) {
			int sqrt = (int) Math.sqrt(i + 1);
			if (sqrt * sqrt == i + 1) {
				a[i] = 1;
			} else {
				int min=4;
				for (int j = 1; j*j <i+1; j++) {
					int tmp=1+a[i-j*j];
					if(min>tmp)
						min=tmp;
				}
				a[i]=min;
			}
			//System.out.print(i+1+" "+a[i]+"\n");
		}
		bw.write(a[n-1] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}