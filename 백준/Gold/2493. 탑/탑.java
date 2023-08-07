import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		String[] tmp=br.readLine().split(" ");
		int[] res=new int[N];
		Stack <int[]> st=new Stack<>();
		for(int i=0;i<N;i++)
		{
			int[] cur= {i+1,Integer.parseInt(tmp[i])};
			while(!st.isEmpty())
			{
				int[] top=st.peek();
				if(top[1]>cur[1])
				{
					res[i]=top[0];
					break;
				}
				else
				{
					st.pop();
				}
			}
			st.add(cur);
		}
		for(int i: res)
		{
			bw.write(i+" ");
		}
		bw.flush();
	}
}
