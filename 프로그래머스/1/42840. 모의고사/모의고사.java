import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] sol={{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        
        int[] idx={0,0,0};
        int[] scr={0,0,0};
        for(int i=0;i<answers.length;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(sol[j][idx[j]++]==answers[i])
                {
                    scr[j]++;
                }
                if(idx[j]==sol[j].length)
                {
                    idx[j]=0;
                }
            }
        }
        System.out.println(Arrays.toString(scr));
        int max=0;
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<3;i++)
        {
            if(max==scr[i])
            {
                list.add(i+1);
            }
            else if(max<scr[i])
            {
                list.clear();
                list.add(i+1);
                max=scr[i];
            }
        }
        int[] answer=list.stream().mapToInt(i->i)
            .toArray();
        return answer;
    }
}