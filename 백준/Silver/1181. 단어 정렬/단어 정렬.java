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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ArrayList<String>[] str = new ArrayList[50];
		for(int i=0;i<50;i++)
		{
			str[i]=new ArrayList<String>();
		}
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(!str[tmp.length()-1].contains(tmp))
				str[tmp.length() - 1].add(tmp);
		}
		for (int i = 0; i < 50; i++) {
			if (!str[i].isEmpty()) {
				Collections.sort(str[i]);
				for(String a:str[i])
				{
					bw.write(a+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}