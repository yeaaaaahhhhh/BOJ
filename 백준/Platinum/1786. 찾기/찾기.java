import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String pattern = br.readLine();

		int[][] dfa = new int[pattern.length()][56];

		int X = 0;
		dfa[0][getChar(pattern.charAt(0))] = 1;
		for (int i = 1; i < dfa.length; i++) {
			int cur=getChar(pattern.charAt(i));

//			System.out.println(pattern.charAt(i)+" "+cur);
			dfa[i] = dfa[X].clone();

			dfa[i][cur] = i + 1;

			X = dfa[X][cur];
//			System.out.println(X);
		}
//		for (int[] df : dfa)
//			System.out.println(Arrays.toString(df));
		
		ArrayList<Integer> list=new ArrayList<>() ;
		int idx=0;
		for(int i=0;i<str.length();i++)
		{
			
			int cur=getChar(str.charAt(i));
			
			
			idx=dfa[idx][cur];
			//System.out.println(i+" "+str.charAt(i)+" "+idx);
			
			if(idx>=pattern.length())
			{

				list.add(i-pattern.length()+2);
				idx=X;
			}
		}

		System.out.println(list.size());
		
		for(Integer n:list)
		{
			System.out.print(n+" ");
		}

	}
	
	static int getChar(char cur)
	{
		if(cur==' ')
		{
			return 55;
		}
		else if(cur>='a')
		{
			return 26+(cur-'a');
		}
		else
		{
			return cur-'A';
		}
	}

}
