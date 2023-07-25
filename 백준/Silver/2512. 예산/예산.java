import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		String[] tmp=br.readLine().split(" ");
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(tmp[i]);
		}
		Arrays.sort(arr);
		int budget=Integer.parseInt(br.readLine());
		
		int min=0;
		int max=arr[arr.length-1];
		int mid=(min+max)/2;
		
		while(min<=max)
		{
			int sum=0;
			for(int i=0;i<N;i++)
			{
				if(mid>arr[i])
				{
					sum+=arr[i];
				}
				else
				{
					sum+=mid;
				}
			}
			if(sum<budget)
			{
				min=mid+1;
			}
			else if(sum>budget)
			{
				max=mid-1;
			}
			else
			{
				break;
			}
			mid=(min+max)/2;
		}
		System.out.println(mid);
	}

}
