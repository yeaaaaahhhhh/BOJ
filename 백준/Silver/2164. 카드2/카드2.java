import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> q=new LinkedList<>();
		
		int N=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++)
		{
			q.add(i);
		}
		
		
		while(q.size()>1)
		{
			q.poll();
			q.add(q.poll());
			//System.out.println(q.toString());
		}
		System.out.println(q.poll());
	}
}
