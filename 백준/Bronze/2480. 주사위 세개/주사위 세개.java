import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] a=new int[3];
		
		String[] tmp=br.readLine().split(" ");
		int cnt=0;
		int sameN=0;
		int max=0;
		for(int i=0;i<3;i++)
		{
			a[i]=Integer.parseInt(tmp[i]);
			if(a[i]>max)
				max=a[i];
			for(int j=i-1;j>=0;j--)
			{
				if(a[i]==a[j])
				{
					cnt++;
					sameN=a[i];
					break;
				}
			}
		}
		
		int res=0;
		if(cnt==0)
		{
			res=max*100;
		}
		else if(cnt==1)
		{
			res=1000+sameN*100;
		}
		else
			res=10000+sameN*1000;
		
		bw.write(res+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}