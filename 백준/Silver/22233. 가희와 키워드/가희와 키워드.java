import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp=br.readLine().split(" ");
		
		int N=Integer.parseInt(tmp[0]);
		int M=Integer.parseInt(tmp[1]);
		
		Set<String> set=new HashSet();
		
		for(int i=0;i<N;i++)
		{
			set.add(br.readLine());
		}
		
		for(int i=0;i<M;i++)
		{
			tmp=br.readLine().split(",");
			
			for(int j=0;j<tmp.length;j++)
			{
				set.remove(tmp[j]);
			}
			System.out.println(set.size());
		}
	}
}