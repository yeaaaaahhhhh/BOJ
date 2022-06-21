import java.util.List;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static int A,B;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp=br.readLine().split(" ");
		A=Integer.parseInt(tmp[0]);
		B=Integer.parseInt(tmp[1]);
		arr=new boolean[A];
		bw.write(GCF()+"\n");
		bw.write(LCM()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int GCF()
	{
		for(int i=1;i<A+1;i++)
		{
			if(A%i==0)
			{
				arr[i-1]=true;
			}
		}
		for(int i=B;i>0;i--)
		{
			if(B%i==0&&i<=A)
			{
				if(arr[i-1]==true)
					return i;
			}
		}
		return 1;
	}
	static int LCM()
	{
		int ans=A;
		while(true)
		{
			if(ans%B==0)
			{
				return ans;
			}
			ans+=A;
		}
	}

}