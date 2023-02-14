import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> arr=new PriorityQueue();
		
		for(int i=0;i<N;i++)
		{
			int input=Integer.parseInt(br.readLine());
			if(input==0)
			{
				if(arr.isEmpty())
					bw.write(0+"\n");
				else
					bw.write(arr.poll()+"\n");
			}
			else
			{
				arr.add(input);
			}
		}
		bw.flush();
		bw.close();
		
	}
}