
import java.io.*;
import java.util.Arrays;


public class Main {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp=br.readLine().split(" ");
		
		int S=Integer.parseInt(tmp[0]);
		int P=Integer.parseInt(tmp[1]);
		
		String str=br.readLine();
		
		int[] limit=new int[4];
		
		tmp=br.readLine().split(" ");
		for(int i=0;i<4;i++)
		{
			limit[i]=Integer.parseInt(tmp[i]);
		}
		
		int[] state=new int[4];
		
		for(int i=0;i<P;i++)
		{
			switch(str.charAt(i))
			{
			case 'A':
				state[0]++;
				break;
			case 'C':
				state[1]++;
				break;
			case 'G':
				state[2]++;
				break;
			case 'T':
				state[3]++;
				break;
			}
		}

		int res=0;
		if(checkState(limit,state))
			res++;
		for(int i=0;i<S-P;i++)
		{
			switch(str.charAt(i))
			{
			case 'A':
				state[0]--;
				break;
			case 'C':
				state[1]--;
				break;
			case 'G':
				state[2]--;
				break;
			case 'T':
				state[3]--;
				break;
			}
			switch(str.charAt(P+i))
			{
			case 'A':
				state[0]++;
				break;
			case 'C':
				state[1]++;
				break;
			case 'G':
				state[2]++;
				break;
			case 'T':
				state[3]++;
				break;
			}
			if(checkState(limit,state))
				res++;
		}
		System.out.println(res);
		
	}
	static boolean checkState(int[] limit,int[] state)
	{
		for(int i=0;i<4;i++)
		{
			if(limit[i]>state[i])
			{
				return false;
			}
		}
		return true;
	}
}