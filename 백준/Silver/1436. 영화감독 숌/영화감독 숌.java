import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		
		bw.write(func()+"\n");

		bw.flush();
		bw.close();
		br.close();
	}
	static int func()
	{
		int cnt=0;
		int n=665;
		while(true)
		{
			int sixcnt=0;
			if(String.valueOf(n).contains("666"))
				cnt++;
			if(cnt==N)
			{
				return n;
			}
			n++;
		}
	}
}