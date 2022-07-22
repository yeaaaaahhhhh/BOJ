import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] x=new int[3];
		int[] y=new int[3];
		for(int i=0;i<3;i++)
		{
			String[] tmp=br.readLine().split(" ");
			x[i]=Integer.parseInt(tmp[0]);
			y[i]=Integer.parseInt(tmp[1]);
		}
		
		int resX=(x[0]==x[1])? x[2]:((x[1]==x[2])? x[0]: x[1]);
		int resY=(y[0]==y[1])? y[2]:((y[1]==y[2])? y[0]: y[1]);
		
		bw.write(resX+" "+resY);
		
		bw.flush();
		bw.close();
		br.close();
	}
}