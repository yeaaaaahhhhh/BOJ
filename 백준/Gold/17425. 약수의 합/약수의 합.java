import java.io.*;

class Main {
	static int[] fx = new int[1000001];
	static long[] gx = new long[1000001];
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for(int i=1;i<=1000000;i++)
		{
			for(int j=i;j<=1000000;j+=i)
			{
				fx[j]+=i;
			}
		}
		for(int i=1;i<=1000000;i++)
		{
			gx[i]=fx[i]+gx[i-1];
		}
		for (int n = 0; n < T; n++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(gx[N] + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}