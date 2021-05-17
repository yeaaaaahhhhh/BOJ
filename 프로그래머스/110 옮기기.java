//처음 풀었던거
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String[] s = {"1110","100111100","0111111010"};
		String[] a=solution(s);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}

  static String[] solution(String[] s) {
    String[] answer = new String[s.length];
		for (int z = 0; z < s.length; z++) {
			String line = s[z];
			int cnt = 0;
			int tmpidx=line.indexOf("110");
			while (tmpidx!=-1) {
				cnt++;
				line = line.substring(0, tmpidx) + line.substring(tmpidx + 3);
				tmpidx = line.indexOf("110");
			}
			//System.out.println(line);
			while (cnt > 0) {
				if (line.contains("111")) {
					int idx = line.indexOf("111");
					//System.out.println(z+" "+line.substring(0, idx) + "	" + line.substring(idx));
					line = line.substring(0, idx) + "110" + line.substring(idx);
				}
				else
				{
					int idx=line.lastIndexOf('0');
					if(idx==-1)
					{
						line="110"+line;
					}
					else
					{
						line=line.substring(0,idx+1)+"110"+line.substring(idx+1);
					}
				}
				//System.out.println("---"+line);
				cnt--;
			}
			
			answer[z]=line;
		}
		return answer;
    }
}
