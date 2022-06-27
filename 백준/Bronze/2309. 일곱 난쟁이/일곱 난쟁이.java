import java.io.*;
import java.util.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int[] H=new int[9];
		int sum=0;
		for(int i=0;i<9;i++)
		{
			H[i]=Integer.parseInt(br.readLine());
			sum+=H[i];
		}
		Arrays.sort(H);
		int faker1=0,faker2=0;
		for(int i=0;i<8;i++)
		{
			for(int j=i+1;j<9;j++)
			{
				if(H[i]+H[j]==sum-100)
				{
					faker1=i;
					faker2=j;
				}
			}
		}
		for(int i=0;i<9;i++)
		{
			if(i==faker1||i==faker2)
			{
				continue;
			}
			bw.write(H[i]+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}