import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] input = new String[n];
		for(int i=0;i<n;i++)
		{
			input[i]=br.readLine();
		}
		System.out.print(func(input));
	}
	static int func(String[] str)
	{
		int res=0;
		for(int q=0;q<str.length;q++)
		{
			char crnt=str[q].charAt(0);
			String past=new String(); 
			int i=1;
			for(i=i;i<str[q].length();i++)
			{
				char now=str[q].charAt(i);
				if(now!=crnt)
				{
					if(past.contains(Character.toString(now))) 
					{
						break;
					}
					else
					{
						past=past+crnt;
						crnt=now;
					}
				}
				else
				{
					
				}
			}
			if(i==str[q].length())
				res++;
		}
		return res;
	}
}
