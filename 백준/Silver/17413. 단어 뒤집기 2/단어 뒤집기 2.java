
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		Stack<Character> st=new Stack();
		
		boolean isWord=true;
		
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			
			if(ch=='<')
			{
				while(!st.isEmpty())
				{
					System.out.print(st.pop());
				}
				isWord=false;
				System.out.print(ch);
			}
			else if(ch=='>')
			{
				isWord=true;
				System.out.print(ch);
			}
			else
			{
				if(isWord)
				{
					if(ch==' ')
					{
						while(!st.isEmpty())
						{
							System.out.print(st.pop());
						}
						System.out.print(ch);
					}
					else {
						st.add(ch);
					}
				}
				else
				{
					System.out.print(ch);
				}
			}
		}
		while(!st.isEmpty())
		{
			System.out.print(st.pop());
		}
	}
}
