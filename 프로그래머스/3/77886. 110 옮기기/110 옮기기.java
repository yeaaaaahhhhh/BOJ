import java.util.*;
class Solution {
    public String[] solution(String[] s) {
       	String[] answer = new String[s.length];
		for (int z = 0; z < s.length; z++) {
			String line = s[z];
			StringBuilder sb=new StringBuilder();
			int cnt = 0;
            
            
            for(int i=0;i<line.length();i++)
            {
                char cur=line.charAt(i);
                int len=sb.length();
                if(len>1)
                {
                    if(cur=='0'&&sb.charAt(len-1)=='1'&&sb.charAt(len-2)=='1')
                    {
                        sb.delete(len-2,len);
                        cnt++;
                        continue;
                    }
                }
                sb.append(line.charAt(i));
            }
            
            int dst=sb.lastIndexOf("0");
            
            if(dst==-1)
            {
                sb.insert(0,"110".repeat(cnt));
            }
            else
            {
                sb.insert(dst+1,"110".repeat(cnt));
            }
            answer[z]=sb.toString();
		}
		return answer;
    }
}