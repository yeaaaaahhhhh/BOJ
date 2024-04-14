import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<String> bef=new Stack();
		Stack<String> aft=new Stack();
		
		String str=br.readLine();
		
		for(String ch: str.split(""))
		{
			bef.push(ch);
		}
		
		int N=Integer.parseInt(br.readLine());
		

		for(int i=0;i<N;i++)
		{
			String input=br.readLine();
			
			switch(input.charAt(0)) {
			case 'L':
				if(bef.isEmpty())
					break;
				aft.push(bef.pop());
				break;
			case 'D':
				if(aft.isEmpty())
					break;
				bef.push(aft.pop());
				break;
			case 'B':
				if(bef.isEmpty())
					break;
				bef.pop();
				break;
			case 'P':
				bef.push(String.valueOf(input.charAt(2)));
				break;
			}
		}
		
		while(!bef.isEmpty())
		{
			aft.push(bef.pop());
		}
		while(!aft.isEmpty())
		{
			bw.write(aft.pop());
		}
		bw.flush();
		bw.close();
	}
}