import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		//절대값이 가장 작은 수가 반환되도록 priority q 설정
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1,Integer o2)
			{
				int abo1=Math.abs(o1);
				int abo2=Math.abs(o2);

				if(abo1!=abo2)
					return abo1-abo2;
				if(o1>o2)
				{
					return 1;
				}
				else if(o1==o2)
				{
					return 0;
				}
				else
				{
					return -1;
				}
			}
		});
		for(int i=0;i<N;i++)
		{
			int input=Integer.parseInt(br.readLine());
			
			if(input==0)
			{
				if(pq.isEmpty())
				{
					System.out.println("0");
				}
				else
				{
					System.out.println(pq.poll());
				}
			}
			else
			{
				pq.add(input);
			}
		}
	}
}
