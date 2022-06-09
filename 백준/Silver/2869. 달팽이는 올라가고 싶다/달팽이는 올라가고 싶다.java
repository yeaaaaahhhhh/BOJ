import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int A,B,V;
		String[] str=br.readLine().split(" ");
		A=Integer.parseInt(str[0]);
		B=Integer.parseInt(str[1]);
		V=Integer.parseInt(str[2]);
		System.out.print(func(A,B,V));
	}
	static int func(int A,int B,int V)
	{
		double a=(V-A)/(double)(A-B);
		return (int)Math.ceil(a)+1;
	}
}
