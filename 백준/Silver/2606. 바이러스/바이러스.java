import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int comN;
	static boolean[][] arr;
	static boolean[] visited;
	static int res=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		comN=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		arr=new boolean[comN][comN];
		visited=new boolean[comN];
		for(int i=0;i<m;i++)
		{
			String[] tmp=br.readLine().split(" ");
			int a=Integer.parseInt(tmp[0]);
			int b=Integer.parseInt(tmp[1]);
			arr[a-1][b-1]=true;
			arr[b-1][a-1]=true;
		}
		visited[0]=true;
		func(0);
		bw.write(res+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int n)
	{
		for(int i=0;i<comN;i++)
		{
			if(arr[n][i])
			{
				if(!visited[i])
				{
					res++;
					visited[i]=true;
					func(i);
				}
			}
		}
	}
}