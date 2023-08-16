import java.io.*;

public class Main {
	static int N;
	static int[][] eggs;
	static int max=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N=Integer.parseInt(br.readLine());
		eggs=new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");

			for (int j = 0; j < 2; j++) {
				eggs[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		dfs(0,0);

		bw.write(max+" ");
		bw.flush();
		bw.close();
	}

	static void dfs(int idx,int sum) {
		if(idx==N)
		{
			max=Math.max(max,sum);
			return;
		}
		if(eggs[idx][0]<=0)
		{
			dfs(idx+1,sum);
			return;
		}
		boolean hasEgg=false;
		for(int i=0;i<N;i++)
		{
			int tsum=sum;
			if(i!=idx&&eggs[i][0]>0)
			{
				hasEgg=true;
				eggs[idx][0]-=eggs[i][1];
				eggs[i][0]-=eggs[idx][1];
				
				if(eggs[idx][0]<=0)
				{
					tsum++;
				}
				if(eggs[i][0]<=0)
				{
					tsum++;
				}
				//System.out.println(idx+" "+i+" "+tsum);
				dfs(idx+1,tsum);
				eggs[idx][0]+=eggs[i][1];
				eggs[i][0]+=eggs[idx][1];
			}
		}
		if(!hasEgg)
		{
			dfs(idx+1,sum);
		}
	}

}
