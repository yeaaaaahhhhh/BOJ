import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String[] str=input.split(" ");
		System.out.println(func(str));
	}
	static int func(String[] str)
	{
		if(str[1].length()==str[0].length())
		{
			int res=0;
			for(int j=0;j<str[0].length();j++)
			{
				if(str[0].charAt(j)!=str[1].charAt(j))
				{
					res++;
				}
			}
			return res;
		}
		int[] arr=new int[str[1].length()-str[0].length()+1];
		for(int i=0;i<=str[1].length()-str[0].length();i++)
		{
			for(int j=0;j<str[0].length();j++)
			{
				if(str[0].charAt(j)!=str[1].charAt(j+i))
				{
					arr[i]++;
				}
			}
			//System.out.println("*"+arr[i]);
		}
		int min=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			min=Math.min(min, arr[i]);
		}
		return min;
	}
}
