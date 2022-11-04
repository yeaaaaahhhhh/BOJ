import java.io.*;
import java.util.*;

class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int run=0;run<3;run++)
		{
			String[] tmp=br.readLine().split(" ");
			int res=0;
			for(int i=0;i<4;i++)
			{
				res+=Integer.parseInt(tmp[i]);
			}
			if(res==4)
			{
				bw.write("E\n");
			}
			else
			{
				bw.write('D'-res);
				bw.newLine();
			}
		}
		bw.flush();
		
		
		
	}
}