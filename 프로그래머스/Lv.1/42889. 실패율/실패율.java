import java.util.*;
class Solution {
    //[1,2,2,2,3,3,4,6]
    //1,2,5 이렇게 확뛰는 경우도 생각해야함
    public int[] solution(int N, int[] stages) {
        
        Arrays.sort(stages);
        // System.out.println(Arrays.toString(stages));
        
        float[] fail=new float[N];
        
        int idx=0;
        int cnt=0;
        int stt=0;
        for(int i=0;i<stages.length;i++)
        {
            if(idx>=N)
            {
                break;
            }
            
            if(stages[i]>idx+1)
            {
                while(stages[i]>idx+1)
                {
                    fail[idx]=cnt/((float)stages.length-stt);
                    System.out.println(idx+"-"+cnt+" "+(stages.length-stt)+"="+fail[idx]);
                    idx++;
                    stt=i;
                    cnt=0;
                }
                if(idx>=N)
                {
                    break;
                }
                
            }
            
            if(stages[i]==idx+1)
            {
                cnt++;
            }
 
        }
        if(idx<N)
        {
            fail[idx]=cnt/((float)stages.length-stt);
            System.out.println(idx+"-"+cnt+" "+(stages.length-stt)+"="+fail[idx]);
        }
        System.out.println(cnt+" "+idx+" "+stt);
        System.out.println(Arrays.toString(fail));
        
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            res.add(i+1);
        }
        
        Collections.sort(res,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2)
            {
                
                if(fail[o1-1]-fail[o2-1]>0)
                {
                    return -1;
                }
                else if(fail[o1-1]-fail[o2-1]<0)
                {
                    return 1;
                }
                else
                {
                    return o1-o2;
                }
            }
        });
        System.out.println(res);

        return res.stream().mapToInt(i->i).toArray();
    }
}