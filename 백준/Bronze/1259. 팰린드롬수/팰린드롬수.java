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
		
		String input=br.readLine();
		while(!input.equals("0")){
			boolean check=true;
			for(int i=0;i<input.length()/2;i++)
			{
				if (input.charAt(i)!=input.charAt(input.length()-1-i))
				{
					check=false;
					bw.write("no\n");
					break;
				}
			}
			if(check)
			{
				bw.write("yes\n");
			}
			input=br.readLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}