import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		double[] minEdge = new double[N];
		PriorityQueue<double[]> pq=new PriorityQueue<>(new Comparator<double[]>() {
			public int compare(double[] a,double[] b)
			{
				return (int)(a[1]-b[1]);
			}
		});
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[0] = 0;

		double[][] stars = new double[N][2];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				stars[i][j] = Double.parseDouble(tmp[j]);
			}
		}

		boolean[] visited = new boolean[N];

		int node = 0;
		while (node != -1) {
			visited[node] = true;
			for (int i = 0; i < N; i++) {
				if (node == i) {
					continue;
				}
				//double L = Math.abs(stars[node][0] - stars[i][0]) + Math.abs(stars[node][1] - stars[i][1]);
				double L=Math.sqrt(Math.pow(stars[node][0]-stars[i][0],2)+Math.pow(stars[node][1]-stars[i][1],2));
				if (!visited[i] && minEdge[i] > L) {
					minEdge[i] = L;
					pq.add(new double[] {i,L});
				}
			}
			//System.out.println(Arrays.toString(minEdge));
			node=-1;
			while(!pq.isEmpty())
			{
				double[] cur=pq.poll();

				if(!visited[(int)cur[0]])
				{
					node=(int)cur[0];
					break;
				}
			}
		}

		double res = 0;

		for (int i = 1; i < N; i++) {
			res += minEdge[i] ;
		}

		System.out.println(Math.round(res*100)/100.0);
	}

}
