import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N,M;
	static String[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		N=Integer.parseInt(tmp[0]);
		M=Integer.parseInt(tmp[1]);
		input=new String[N];
		for(int i=0;i<N;i++)
		{
			input[i]=br.readLine();
		}
		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int func() {
		boolean[][] match=new boolean[N][M];
		String str=input[0];
		int first=str.charAt(0);
		match[0][0]=true;
		for(int k=1;k<M;k++)
		{
			if(k%2==1)
			{
				match[0][k]=!(first==str.charAt(k));
			}
			else
			{
				match[0][k]=(first==str.charAt(k));
			}
		}
		for(int x=0;x<M;x++)
		{
			first=str.charAt(x);
			//first의 match 결과 : match[0][x]
			for(int y=1;y<N;y++)
			{
				if(y%2==1)
				{
					match[y][x]=((first==input[y].charAt(x))^match[0][x]);
				}
				else
				{
					match[y][x]=!((first==input[y].charAt(x))^match[0][x]);
				}
			}
		}
		int min=64;
		for(int i=0;i+7<N;i++)
		{
			for(int j=0;j+7<M;j++)
			{
				int n=0;
				for(int k=0;k<8;k++)
				{
					for(int l=0;l<8;l++)
					{
						if(match[k+i][l+j])
							n++;
					}
				}
				min=Math.min(Math.min(n, 64-n),min);
			}
		}
		return min;
	}
}