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
	static int K,N;
	static int[] arr;
	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp=br.readLine().split(" ");
		K = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);
		arr=new int[K];
		for(int i=0;i<K;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
			if(max<arr[i])
				max=arr[i];
		}

		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static long func()
	{
		long start=1;
		long end=max;

		long res=0;
		while(end>=start)
		{
			long mid=(start+end)/2;
			int cnt=0;
			for(int i=0;i<K;i++)
			{
				cnt+=arr[i]/mid;
			}
			if(cnt>=N)
			{
				start=mid+1;
				if(res<mid) 
					res=mid; 
			}else {
				end=mid-1;
			}
		}
		
		return res;
	}

}