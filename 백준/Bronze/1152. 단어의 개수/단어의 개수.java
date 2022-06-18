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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] tmp = br.readLine().split(" ");
		int cnt=0;
		for(int i=0;i<tmp.length;i++)
		{
			if(!tmp[i].isBlank()) {
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

}