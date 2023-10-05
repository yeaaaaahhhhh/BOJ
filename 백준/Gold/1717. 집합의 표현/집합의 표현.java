import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	static int[] root; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[]  tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		root=new int[N+1];
		for(int i=0;i<N+1;i++)
		{
			root[i]=i;
		}
		for(int i=0;i<M;i++)
		{
			tmp=br.readLine().split(" ");
			int op=Integer.parseInt(tmp[0]);
			int a=Integer.parseInt(tmp[1]);
			int b=Integer.parseInt(tmp[2]);
			
			if(op==0)//합집합
			{
				root[find(b)]=find(a);
			}
			else//출력
			{
				if(find(a)==find(b))
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
		
	}
	
	static int find(int node)
	{
		if(root[node]==node)
		{
			return node;
		}
		else
		{
			return root[node]=find(root[node]);
		}
	}

}
