import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int K=Integer.parseInt(tmp[1]);
		
		int[] arr=new int[100001];
		Arrays.fill(arr, 100001);
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(N);
		arr[N]=0;
		while(!q.isEmpty())
		{
			int cur=q.poll();
			if(cur==K)
			{
				break;
			}
			
			if(cur+1<100001&&arr[cur+1]==100001)
			{
				arr[cur+1]=arr[cur]+1;
				q.add(cur+1);
			}
			if(cur-1>=0&&arr[cur-1]==100001)
			{
				arr[cur-1]=arr[cur]+1;
				q.add(cur-1);
			}
			if(cur*2<100001&&arr[cur*2]==100001)
			{
				arr[cur*2]=arr[cur]+1;
				q.add(cur*2);
			}
		}
		System.out.println(arr[K]);
	}

}