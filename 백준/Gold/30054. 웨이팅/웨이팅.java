import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		final int MAX_TIME = 300002;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Customer> pq = new PriorityQueue<>();

		Customer[] cust = new Customer[MAX_TIME];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			int reserved = Integer.parseInt(tmp[0]);
			int arrived = Integer.parseInt(tmp[1]);
			Customer cur = new Customer(reserved, arrived);

			cust[reserved] = cur;

			pq.add(cur);

		}

		int res = 0;
		for (int t = 1; t < MAX_TIME; t++) {
			if (pq.isEmpty()) {
				break;
			}

			if (cust[t] != null && cust[t].arrived <= t) {
				if (res < t - cust[t].arrived) {
					res = t - cust[t].arrived;
				}
				pq.remove(cust[t]);
				cust[t] = null;
			} else if (pq.peek().arrived <= t) {

				Customer cur = pq.peek();
				if (res < t - cur.arrived) {
					res = t - cur.arrived;
				}
				cust[cur.reserved] = null;
				pq.remove(cur);
				//System.out.println(cur);
			}
		}
		System.out.println(res);
	}
}

class Customer implements Comparable<Customer> {
	int reserved;
	int arrived;

	public Customer(int reserved, int arrived) {
		super();
		this.reserved = reserved;
		this.arrived = arrived;
	}

	@Override
	public String toString() {
		return "Customer [reserved=" + reserved + ", arrived=" + arrived + "]";
	}

	@Override
	public int compareTo(Customer o) {
		if (this.arrived == o.arrived) {
			return this.reserved - o.reserved;
		}
		return this.arrived - o.arrived;
	}
}