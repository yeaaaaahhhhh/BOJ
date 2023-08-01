import java.io.*;
import java.util.*;

class Main {
	static boolean[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr=new boolean[N][N];
		
		func(0,0,N);
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j])
				{
					bw.write(" ");
				}
				else
				{
					bw.write("*");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void func(int x,int y,int n)
	{
		if(n==3)
		{
			arr[x+1][y+1]=true;
		}
		else
		{
			int part=n/3;
			for(int a=0;a<3;a++)
			{
				for(int b=0;b<3;b++)
				{
					if(a!=1||b!=1)
					{
						func(x+a*part,y+b*part,part);
					}
					else
					{
						for(int i=0;i<part;i++)
						{
							for(int j=0;j<part;j++)
							{
								arr[x+part+i][y+part+j]=true;
							}
						}
					}
				}
			}
		}
		
	}
}