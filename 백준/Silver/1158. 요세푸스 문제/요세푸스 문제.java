import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		Queue<Integer> list = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		System.out.print("<");
		while (!list.isEmpty()) {
			for (int i = 0; i < M; i++) {
				if (i == M - 1) {
					if (list.size() == 1) {
						System.out.print(list.poll());
					} else {
						System.out.print(list.poll() + ", ");
					}
					break;
				}
				list.add(list.poll());
			}
		}
		System.out.print(">");
	}
}
