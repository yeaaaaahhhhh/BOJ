import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int d = Integer.parseInt(tmp[1]);
		int k = Integer.parseInt(tmp[2]);
		int c = Integer.parseInt(tmp[3]);

		ArrayList<Integer> sushi=new ArrayList();

		for (int i = 0; i < N; i++) {
			sushi.add(Integer.parseInt(br.readLine()));
		}

		int[] ate=new int[d+1];
		int max=0;

		//init set
		int cnt=0;
		for(int i=0;i<k;i++)
		{
			int cur=sushi.get(i);
			if(ate[cur]==0)
			{
				cnt++;
			}
			ate[cur]++;
		}
		if(ate[c]==0)
		{
			max=cnt+1;
		}
		else {
			max=cnt;
		}
		
		if(max==k+1)
		{
			System.out.println(max);
			return;
		}
		//q 조회
		for(int i=0;i<N;i++)
		{
			int minus=sushi.get(i);
			int plus=sushi.get((k+i)%N);
			//System.out.println(minus+"빼고 "+plus+"넣음 ");
			ate[minus]--;
			if(ate[minus]==0)
			{
				cnt--;
			}
			if(ate[plus]==0)
			{
				cnt++;
			}
			ate[plus]++;
			
			int res=cnt;
			if(ate[c]==0)
			{
				res=cnt+1;
			}
			//결과 확인
			if(max<res)
			{
				max=res;
				if(max==k+1)
				{
					break;
				}
			}
//			System.out.println(i+"번째 "+cnt );
		}
		
		System.out.println(max);
		return;

	}
}