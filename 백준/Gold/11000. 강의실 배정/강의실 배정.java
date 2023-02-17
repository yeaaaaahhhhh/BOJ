import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		LinkedList<Node> list=new LinkedList<>();
		PriorityQueue<Integer> q=new PriorityQueue<>();
				
		for(int i=0;i<N;i++)
		{
			String[] strs=br.readLine().split(" ");
			int S=Integer.parseInt(strs[0]);
			int T=Integer.parseInt(strs[1]);
			
			list.add(new Node(S,T));
		}
		Collections.sort(list);
		
		while(!list.isEmpty())
		{
			Node tn=list.poll();
			if(q.isEmpty())
			{
				q.add(tn.end);
			}
			else if(q.peek()>tn.start)
			{
				q.add(tn.end);
			}
			else
			{
				q.poll();
				q.add(tn.end);
			}
		}
		System.out.println(q.size());
	}
}
class Node implements Comparable<Node>
{
	int start;
	int end;
	Node(int start,int end)
	{
		this.start=start;
		this.end=end;
	}
	@Override
	public int compareTo(Node o) {
		if(o.start==this.start)
			return this.end-o.end;//종료시각이 빠른게 먼저
		else
			return this.start-o.start;
	}
}
