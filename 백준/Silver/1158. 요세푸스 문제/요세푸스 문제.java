import java.io.*;
import java.util.*;

public class Main
{
	static int N;
	static int M;
	static Queue<Integer> q=new LinkedList();
	public static void main(String[] args)
	{
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[] tmp=br.readLine().split(" ");
			N=Integer.parseInt(tmp[0]);
			M=Integer.parseInt(tmp[1]);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		init();
		func();
	}
	static void init()
	{
		for(int i=0;i<N;i++)
		{
			q.add(i+1);
		}
	}
	static void func()
	{
		System.out.print("<");
		while(q.size()!=1)
		{
			for(int i=0;i<M;i++)
			{
				if(i==M-1)
				{
					System.out.print(q.peek()+", ");
					q.poll();
				}
				else
				{
					q.add(q.peek());
					q.poll();
				}
			}
		}
		System.out.print(q.peek()+">");
	}
}
