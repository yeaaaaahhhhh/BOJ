import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		arr=new int[N];
		tmp=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int func()
	{
		int max=0;
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				for(int k=j+1;k<N;k++)
				{
					int sum=arr[i]+arr[j]+arr[k];
					if(sum<=M)
					{
						if(max<sum)
							max=sum;
					}
				}
			}
		}
		return max;
	}

}