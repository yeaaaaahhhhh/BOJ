import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //에라 어쩌구 체
        boolean[] primeN=new boolean[1000000]; //0~1000000
        Arrays.fill(primeN,true);
        primeN[0]=false;
        primeN[1]=false;
        for (int i=2;i<1000;i++)
        {
            if(primeN[i])
            {
                for(int j=2;j*i<1000000;j++)
                {
                    primeN[j*i]=false;
                }
            }
        }
        
        //k진수로 바꾸기
        //11-> 3진수 -> 102
        
        int digit=1;
        while(true)
        {
            
            int tmp=(int)(n/Math.pow(k,digit));
            if(tmp>0)
            {
                digit++;
            }
            else
            {
                digit--;
                break;
            }
        }
        
        
        String kNstring="";
        
        for(int i=digit;i>=0;i--)
        {
            int div=(int)Math.pow(k,i);
            kNstring=kNstring+Integer.toString((int)n/div);
            n=n%div;
        }
        //System.out.println(kNstring);
        
        String[] strArr=kNstring.split("0");
        
        for(String str:strArr)
        {
            if(str.isBlank()||str.equals("1"))
            {
                continue;
            }
            long number=Long.parseLong(str);
            boolean breaked= false;
            for(int i=2;i<1000000;i++)
            {
                if(i>=number)
                {
                    break;
                }
                if(primeN[i])
                {
                    if(number%i==0)
                    {
                        System.out.println(number+" "+i);
                        breaked=true;
                        break;      
                    }
                }
            }
            if(!breaked)
                answer++;
        }
        
        return answer;
    }
}
//3진수 11111111