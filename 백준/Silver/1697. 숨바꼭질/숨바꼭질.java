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
	static int X;
	static int Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] tmp = br.readLine().split(" ");
		X = Integer.parseInt(tmp[0]);
		Y = Integer.parseInt(tmp[1]);

		bw.write(func() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int func() {
		if (Y < X) {
			return X - Y;
		} else {
			int[] grd = new int[Y+1];
			for(int i=0;i<X;i++)
			{
				grd[i]=Math.abs(X-i);
			}
			for (int i = X+1; i <= Y; i++) {
				if(i%2==0)
				{
					grd[i]=Math.min(grd[i/2]+1, grd[i-1]+1);
				}
				else
					grd[i]=Math.min(grd[i-1]+1,grd[i/2+1]+2);
			}
			return grd[Y];
		}

	}
}