import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> dq=new ArrayDeque();
		for(int t=1;t<=10;t++)
		{
			int T=Integer.parseInt(br.readLine());
			String[] tmp=br.readLine().split(" ");
			for(int i=0;i<8;i++)
			{
				dq.addLast(Integer.parseInt(tmp[i]));
			}

			while(dq.peekLast()!=0) {
				int n=1;
				for(int i=0;i<5;i++)
				{
					int nNum=dq.pollFirst()-(n++);
					if(nNum<=0)
					{
						nNum=0;
						dq.addLast(nNum);
						break;
					}
					dq.addLast(nNum);
					
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<8;i++)
			{
				System.out.print(dq.pollFirst()+" ");
			}
			System.out.println();
		}
	}
}
