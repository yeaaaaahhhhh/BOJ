import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] arr=new int[N];
		
		String[] tmp=br.readLine().split(" ");
		
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		
		int[] lis=new int[N];
		int maxidx=1;
		lis[0]=arr[0];
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(lis[j]==0&&arr[i]<lis[j-1])
				{
					lis[j]=arr[i];
					maxidx++;
					break;
				}
				if(arr[i]>lis[j])
				{
					lis[j]=arr[i];
					break;
				}
			}
		}
		System.out.println(N-maxidx);
	}
}
