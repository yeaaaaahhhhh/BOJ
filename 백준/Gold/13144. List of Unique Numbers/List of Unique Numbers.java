import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); 
		arr = new int[N]; 
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashSet<Integer> set = new HashSet<Integer>(); 
		
		int head = 0; 
//		int tail = 0; 
		long ans = 0; 
//		set.add(arr[head]);
		
		for(int tail=0; tail<N; tail++) {
//			System.out.printf("head : %d, tail : %d, ans : %d\n", head, tail, ans);
			
			
			if(set.contains(arr[tail])) { // 중복된 값을 만나면
//				System.out.println("중복");
//				ans += (tail - head); // 이전에 해당 값을 만났을 때까지 연속된 모든 경우 구함
				
				while(true) { // 중복되지 않을 만큼 head 당기기
					set.remove(arr[head]);
					ans += (tail - head); // 이전에 해당 값을 만났을 때까지 연속된 모든 경우 구함
//					System.out.println(ans);
					if(arr[head] == arr[tail]) {
						head++;
						break; 
					}
					head++; 
				}
			}
			set.add(arr[tail]); 
			
		}
		
		for(int i=head; i<N; i++) {
			ans += N- i ; 
//			System.out.println(N-i); 
		}

		System.out.println(ans); 
		}

}