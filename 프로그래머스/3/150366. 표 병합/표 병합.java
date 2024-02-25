import java.util.*;

class Solution {
	static HashMap<Integer, String> tbl = new HashMap<>();
	static int[] par = new int[50 * 50];

	public String[] solution(String[] commands) {
		ArrayList<String> answer = new ArrayList();
		for (int i = 0; i < 50 * 50; i++) {
			par[i] = i;
		}
		for (String command : commands) {
			String[] com = command.split(" ");
			if (com[0].equals("UPDATE")) {
				if (com.length == 4) {
					int r = Integer.parseInt(com[1]);
					int c = Integer.parseInt(com[2]);
					String v = com[3];

					tbl.put(getParent(getLoc(r, c)), v);
				} else {
					String oldV = com[1];
					String newV = com[2];
					for (Map.Entry<Integer, String> entry : tbl.entrySet()) {
						tbl.replace(entry.getKey(), oldV, newV);
					}
				}
			}
			if (com[0].equals("MERGE")) {
				int l1 = getLoc(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
				int l2 = getLoc(Integer.parseInt(com[3]), Integer.parseInt(com[4]));
				l1 = getParent(l1);
				l2 = getParent(l2);

				if (l1 == l2) {
					continue;
				}

				if (tbl.containsKey(l1) && tbl.containsKey(l2)) {
					tbl.remove(l2);
				}

				if (tbl.containsKey(l2)) {
					par[l1] = l2;
				} else {
					par[l2] = l1;
				}
			}
            
			if (com[0].equals("UNMERGE")) {

				int loc = getLoc(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
				int locpar = getParent(loc);

				for (int i = 0; i < 50 * 50; i++) {
					par[i] = getParent(i);
				}

				for (int i = 0; i < 50 * 50; i++) {
					if (par[i] == locpar) {
						par[i] = i;
					}
				}

				if (tbl.containsKey(locpar)) {
					String value = tbl.get(locpar);
					tbl.remove(locpar);
					tbl.put(loc, value);
				}
			}
			if (com[0].equals("PRINT")) {

				int loc = getLoc(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
				loc = getParent(loc);
				if (tbl.containsKey(loc)) {
					answer.add(tbl.get(loc));
				} else {
					answer.add("EMPTY");
				}
			}

			// System.out.println(tbl);
		}
		return answer.toArray(new String[0]);

	}

	static int getLoc(int r, int c) {
		return (r - 1) * 50 + (c - 1);
	}

	static int getParent(int loc) {
		if (loc == par[loc]) {
			return loc;
		}
		return par[loc] = getParent(par[loc]);
	}
}