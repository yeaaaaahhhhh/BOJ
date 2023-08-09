import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[][] map=new boolean[100][100];
		int cnt=0;
		for (int t = 1; t <= T; t++) {
			String[] tmp=br.readLine().split(" ");
			
			int x=Integer.parseInt(tmp[0]);
			int y=Integer.parseInt(tmp[1]);
			
			for(int i=0;i<10;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(!map[y+i][x+j])
					{
						map[y+i][x+j]=true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
