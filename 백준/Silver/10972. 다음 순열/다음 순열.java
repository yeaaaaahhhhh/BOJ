import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static int[] num;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(tmp[i]);
		}
		if(func()) {
		for(int i:num)
		{
			bw.write(i+" ");
		}}
		else
		{
			bw.write(-1+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean func() {
		int max=N-1;
		for(int k=N-2;k>=0;k--)
		{
			if(num[max]<num[k])
			{
				max=k;
			}
			else
			{
				boolean[] decided=new boolean[N];
				for(int x=0;x<k;x++)
				{
					decided[num[x]-1]=true;
				}
				int min=10001;
				for(int x=k+1;x<N;x++)
				{
					if(num[k]<num[x]&&min>num[x])
						min=num[x];
				}
				num[k]=min;
				decided[num[k]-1]=true;
				ArrayList tmp=new ArrayList<Integer>();
				for(int x=0;x<N;x++)
				{
					if(!decided[x])
					{
						tmp.add(x+1);
					}
				}
				Collections.sort(tmp);
				for(int x=0;x<tmp.size();x++)
				{
					num[k+1+x]=(int) tmp.get(x);
				}
				return true;
			}
		}
		return false;
	}

	static void swap(int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}