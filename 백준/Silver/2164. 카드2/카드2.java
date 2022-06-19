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
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		bw.write(func()+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int func()
	{
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			q.add(i);
		}
		boolean swtch=true;
		while(q.size()>1)
		{
			if(swtch)
			{
				q.poll();
				swtch=false;
			}
			else
			{
				q.add(q.poll());
				swtch=true;
			}
		}
		return q.poll();
	}

}