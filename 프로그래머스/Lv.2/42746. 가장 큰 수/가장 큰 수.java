import java.util.*;
import java.io.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strs=new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++)
        {
            strs[i]=Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String strA,String strB)
            {
                int resA=Integer.parseInt(strA+strB);
                int resB=Integer.parseInt(strB+strA);
                return resB-resA;
            }    
        });
        

        StringBuilder sb=new StringBuilder();
        for(String str:strs)
        {
            if(sb.length()==0&&str.equals("0"))
            {
                continue;
            }
            sb.append(str);
        }
        if(sb.length()==0)
        {
            sb.append("0");
        }
        return sb.toString();
    }
}