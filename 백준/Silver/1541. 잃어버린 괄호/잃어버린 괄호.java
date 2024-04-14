import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line=br.readLine();
		
		String[] info=line.split("[-]");
		
		//System.out.println(Arrays.toString(info));
		
		int res=0;
	
		for(int i=0;i<info.length;i++)
		{
			int num=0;
			if(info[i].contains("+"))
			{
				String[] cur=info[i].split("\\+");
				for(String c:cur) {
					num+=Integer.parseInt(c);
				}
			}
			else
			{
				num=Integer.parseInt(info[i]);
			}
			if(i==0)
			{
				res+=num;
			}
			else
			{
				res-=num;
			}
		}
		System.out.print(res);
		
	}
}