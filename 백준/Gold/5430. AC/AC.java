import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());

		pr:for(int t=0;t<T;t++)
		{
			String func=br.readLine();
			
			int N=Integer.parseInt(br.readLine());

			
			String str=br.readLine();
			
			str=str.substring(1,str.length()-1);
			String[] tmp=str.split(",");
//			System.out.println(tmp.length);
			
			Deque<String> ll=new ArrayDeque();
			for(int i=0;i<N;i++)
			{
				ll.add(tmp[i]);
			}
//			System.out.println(ll.isEmpty());
//			System.out.println("ll:"+ll);
			boolean reverse = false;
			
			for(int k=0;k<func.length();k++)
			{
				char op=func.charAt(k);
				//System.out.println(op);
				if(op=='R')
				{
					reverse=!reverse;
				}
				else if(op=='D')
				{
					if(ll.isEmpty())
					{
						System.out.println("error");
						continue pr;
					}
					else if(reverse)
					{
						ll.pollLast();
					}
					else
					{
						ll.pollFirst();
					}
				}
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append("[");
			int len=ll.size();
			if(!reverse) {
				for(int i=0;i<len;i++)
				{
					sb.append(ll.pollFirst());
					if(i!=len-1)
					{
						sb.append(",");
					}
				}
			}
			else
			{
				for(int i=0;i<len;i++)
				{
					sb.append(ll.pollLast());
					if(i!=len-1)
					{
						sb.append(",");
					}
				}
			}
			sb.append("]");
			
			System.out.println(sb.toString());
		}
	}
}