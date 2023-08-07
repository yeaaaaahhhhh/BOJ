import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		for(int t=1;t<=10;t++)
		{
			int N=Integer.parseInt(br.readLine());
			LinkedList<String> list=new LinkedList<>();
			String[] tmp=br.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				list.add(tmp[i]);
			}
			int M=Integer.parseInt(br.readLine());
			
			String[] orders=br.readLine().split("I");
			//System.out.println(Arrays.toString(orders));
			for(int i=1;i<M+1;i++)
			{
				tmp=orders[i].split(" ");
				int idx=Integer.parseInt(tmp[1]);
				int len=Integer.parseInt(tmp[2]);
				for(int j=0;j<len;j++)
				{
					list.add(idx+j, tmp[3+j]);
				}
				//System.out.println(list.toString());
			}
			bw.write("#"+t);
			for(int i=0;i<10;i++)
			{
				bw.write(" "+list.get(i));
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
