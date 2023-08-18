import java.io.*;
import java.util.*;

public class Main{
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());		//수빈이 위치
		int k = Integer.parseInt(st.nextToken());		//동생 위치
		answer = Integer.MAX_VALUE;
		
		dfs(n, k, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int n, int k, int count) {		//수빈이위치, 동생위치, 카운트
		if( n >= k ) {
			count += n - k;
			if( answer > count ) {
				answer = count;
			}
			return;
		}
		
		dfs(n, n, count + k - n);
		if( n == 0 ) {
			n = 1;
			count++;
		}
		
		if( k % 2 == 1 ) {
			dfs(n, k + 1, count + 1);
			dfs(n, k - 1, count + 1);
		}		
		else {
			dfs(n, k / 2, count + 1);
		}
	}
}