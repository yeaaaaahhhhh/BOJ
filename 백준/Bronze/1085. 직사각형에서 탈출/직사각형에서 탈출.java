import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int x,y,w,h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		x=Integer.parseInt(tmp[0]);
		y=Integer.parseInt(tmp[1]);
		w=Integer.parseInt(tmp[2]);
		h=Integer.parseInt(tmp[3]);
		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int func() {
		int a=Math.min(h-y, y);
		int b=Math.min(w-x, x);
		return Math.min(a, b);
	}
}