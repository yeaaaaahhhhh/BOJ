import java.io.*;
import java.util.*;

public class Main {
	static int[][] check = new int[4][18];
	static int[][] score = new int[6][3];
	static int[] res = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			String[] tmp = br.readLine().split(" ");

			for (int j = 0; j < 18; j++) {
				check[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		dfs(0, 1);

		for (int r : res) {
			bw.write(r + " ");
		}
		bw.flush();
		bw.close();
	}

	static void dfs(int home, int other) {
		//System.out.println(home + " " + other);
		if (home == 5) {
			for(int i=0;i<4;i++)
			{
				checkDiff(i);
			}
			return;
		}

		int nHome = home;
		int nOther = other + 1;
		if (nOther >= 6) {
			nHome++;
			nOther = nHome + 1;
		}
		boolean flag = false;
		// home 이김
		score[home][0]++;
		score[other][2]++;
		dfs(nHome, nOther);
		score[home][0]--;
		score[other][2]--;

		score[home][1]++;
		score[other][1]++;
		dfs(nHome, nOther);
		score[home][1]--;
		score[other][1]--;

		score[home][2]++;
		score[other][0]++;
		dfs(nHome, nOther);
		score[home][2]--;
		score[other][0]--;
	}

	static boolean checkDiff(int i) {
		if (res[i] == 0) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					if (score[j][k] != check[i][j * 3 + k]) {
						
						return false;
					}
				}
			}
			res[i]=1;
		}
		return true;
	}
}
