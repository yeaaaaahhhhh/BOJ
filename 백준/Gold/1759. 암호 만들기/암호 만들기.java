import java.io.*;
import java.util.*;

public class Main {
	static boolean[] isVowel;
	static boolean[] visited;
	static String[] alphabet;
	static int L,C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		L=Integer.parseInt(tmp[0]);
		C=Integer.parseInt(tmp[1]);
		
		alphabet=br.readLine().split(" ");
		Arrays.sort(alphabet);
		isVowel=new boolean[C];
		visited=new boolean[C];
		
		for(int i=0;i<C;i++)
		{
			switch(alphabet[i])
			{
			case "a":
			case "e":
			case "i":
			case "o":
			case "u":
				isVowel[i]=true;
				break;
			}
		}
		dfs(0,0,0);
	}
	
	static void dfs(int idx,int vowelCnt,int len)
	{
		//System.out.println(idx+" "+vowelCnt+" "+len);
		if(len==L)
		{
			if(vowelCnt>=1&&L-vowelCnt>=2)
			{
				for(int i=0;i<C;i++)
				{
					if(visited[i])
					{
						System.out.print(alphabet[i]);
					}
				}
				System.out.println();
			}
			return;
		}
		for(int i=idx;i<C;i++)
		{
			if(!visited[i])
			{
				visited[i]=true;
				if(isVowel[i])
				{
					dfs(i+1,vowelCnt+1,len+1);
				}
				else
				{
					dfs(i+1,vowelCnt,len+1);
				}
				visited[i]=false;
			}
		}
	}
	
}
