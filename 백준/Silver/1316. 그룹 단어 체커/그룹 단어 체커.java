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
			boolean[] spelled=new boolean[26];
			int i=1;
			boolean group=true;
			for(i=i;i<str[q].length();i++)
			{
				char now=str[q].charAt(i);
				if(now!=crnt)
				{
					if(spelled[now-'a']==true) 
					{
						group=false;
						break;
					}
					else
					{
						spelled[crnt-'a']=true;
						crnt=now;
					}
				}
			}
			if(group)
			{
				res++;
			}
		}
		return res;
	}
}
