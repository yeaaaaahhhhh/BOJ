import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] tmp = br.readLine().split(" ");
			if (tmp.length == 1) {
				break;
			}
			long res = 0;
			int[] v = new int[tmp.length];
			
			
			for (int i = 1; i < tmp.length; i++) {
				v[i-1] = Integer.parseInt(tmp[i]);
			}

			Stack<Integer> st = new Stack();
			
			
			for (int i = 0; i < v.length; i++) {
				if (st.isEmpty()) {
					st.add(i);
					continue;
				}

				while (!st.isEmpty() && v[st.peek()] >= v[i]) {
					int pop = st.pop();
					long size= (st.isEmpty())? (long)v[pop]*i:(long)v[pop]*(i-st.peek()-1);
					if(size>res)
					{
						res=size;
					}
				}

				st.push(i);
			}

			while (!st.isEmpty()) {
				int pop = st.pop();
				
				long size=(st.isEmpty())?(long)v[pop]*v.length:(long)v[pop]*(v.length-st.peek()-1);
				
				if (size > res) {
					res = size;
				}
			}
			System.out.println(res);
		}
	}
}