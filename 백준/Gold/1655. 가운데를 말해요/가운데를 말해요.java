import java.io.*;
import java.util.*;

class Main
{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minHeap=new PriorityQueue<>((o1,o2)->o2-o1);
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1,o2)->o1-o2);
		
		for(int i=0;i<N;i++)
		{
			int v=Integer.parseInt(br.readLine());
			if(minHeap.isEmpty())
			{
				minHeap.add(v);
			}
			else if(minHeap.size()<=maxHeap.size())
			{
				if(v>maxHeap.peek())
				{
					minHeap.add(maxHeap.poll());
					maxHeap.add(v);
				}
				else
				{
					minHeap.add(v);
				}
			}
			else
			{
				if(v<minHeap.peek())
				{
					maxHeap.add(minHeap.poll());
					minHeap.add(v);
				}
				else
					maxHeap.add(v);
			}
//			for(int a:minHeap)
//			{
//				System.out.print(a+" ");
//			}
//			System.out.println("=>min");
//			for(int b:maxHeap)
//			{
//				System.out.print(b+" ");
//			}
//			System.out.println("=>max");
			bw.write(minHeap.peek()+"\n");
		}
		bw.flush();
	}
}