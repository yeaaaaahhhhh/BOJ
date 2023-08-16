import java.io.*;

public class Main {
	static int N;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N=Integer.parseInt(br.readLine());
		
		arr=new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		dfs(0,0,N);

	}

	static void dfs(int y,int x,int size) {
		char color=arr[y][x];
		boolean flag=false;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(arr[y+i][x+j]!=color)
				{
					flag=true;
					break;
				}
			}
		}
		if(flag)
		{
			System.out.print("(");
			dfs(y,x,size/2);
			dfs(y,x+size/2,size/2);
			dfs(y+size/2,x,size/2);
			dfs(y+size/2,x+size/2,size/2);
			System.out.print(")");
		}
		else
		{
			System.out.print(color);
		}
	}

}
