import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		String s=br.readLine();
		String find="IO".repeat(N)+"I";
//		System.out.println(find);
		int idx=0;
		int res=0;
		
		while((idx=s.indexOf(find,idx))!=-1)
		{
//			System.out.println(idx);
			idx++;
			res++;
		}
		
		System.out.println(res);
	}

}