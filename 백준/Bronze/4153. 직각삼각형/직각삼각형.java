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
		int[] input=new int[3];
		boolean check=false;
		do {
			String[] tmp=br.readLine().split(" ");
			
			input[0]=Integer.parseInt(tmp[0]);
			input[1]=Integer.parseInt(tmp[1]);
			input[2]=Integer.parseInt(tmp[2]);
			
			if(input[0]==0)
			{
				check=true;
			}
			else {
				Arrays.sort(input);
				boolean res=input[0]*input[0]+input[1]*input[1]==input[2]*input[2];
				if(res)
					bw.write("right\n");
				else
					bw.write("wrong\n");
			}
		}while(!check);

		bw.flush();
		bw.close();
		br.close();
	}
}