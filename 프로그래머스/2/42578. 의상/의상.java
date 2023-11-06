import java.util.*;
class Solution {
    public int solution(String[][] clothes) {

        ArrayList<String> strs=new ArrayList();
        int[] cnt=new int[31];
        int bodypart=0;
        for(int i=0;i<clothes.length;i++)
        {
            
            if(strs.contains(clothes[i][1]))
            {
                cnt[strs.indexOf(clothes[i][1])]++;
            }
            else
            {
                strs.add(clothes[i][1]);
                cnt[bodypart++]=1;
            }
        }
        int answer = cnt[0]+1;
        for(int i=1;i<bodypart;i++)
        {
            answer*=cnt[i]+1;
        }
        return answer-1;
    }
}