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
	static int N,M;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		String[] tmp=br.readLine().split(" ");
		list=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			list.add(Integer.parseInt(tmp[i]));
		}
		Collections.sort(list);
		
		M=Integer.parseInt(br.readLine());
		tmp=br.readLine().split(" ");
		
		for(int i=0;i<M;i++)
		{
			if(func(Integer.parseInt(tmp[i])))
				bw.write("1\n");
			else
				bw.write("0\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
	static boolean func(int num)
	{
		int mid=list.size()/2;
		int low=0;
		int high=list.size();
		int tmp=list.get(mid);
		while(mid>low&&mid<high)
		{
			if(tmp==num)
			{
				return true;
			}
			else if(tmp<num)
			{
				low=mid;
				mid=(low+high)/2;
			}
			else
			{
				high=mid;
				mid=(low+high)/2;
			}
			tmp=list.get(mid);
		}
		if(tmp==num)
			return true;
		return false;
	}
}