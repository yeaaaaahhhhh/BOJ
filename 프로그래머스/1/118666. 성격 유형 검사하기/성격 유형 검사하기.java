import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> map=new HashMap();
        
        for(int i=0;i<survey.length;i++)
        {
            int idx=-1;
            int cho=choices[i]-4;
            if(cho<0)//앞
            {
                idx=0;
            }
            else if(cho>0)//양수 -> 뒤
            {
                idx=1;
            }
            
            if(idx!=-1)
            {
                char ch=survey[i].charAt(idx);
                map.put(ch,map.getOrDefault(ch,0)+Math.abs(cho));
                // System.out.println(map.get(ch));
            }
        }
        
        char[][] jipyo={{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        String answer = "";
        
        for(int i=0;i<4;i++)
        {
            int v1=map.getOrDefault(jipyo[i][0],0);
            int v2=map.getOrDefault(jipyo[i][1],0);
            
            if(v1<v2)
            {
                answer+=jipyo[i][1];
            }
            else if(v1>v2)
            {
                answer+=jipyo[i][0];
            }
            else
            {
                answer+=(char)Math.min(jipyo[i][0],jipyo[i][1]);
                //System.out.println((char)Math.min(jipyo[i][0],jipyo[i][1]));
            }
        }
        
        
        return answer;
    }
}
/*
n 1
C 1
M 2
T 3
A 1
TCMA
*/