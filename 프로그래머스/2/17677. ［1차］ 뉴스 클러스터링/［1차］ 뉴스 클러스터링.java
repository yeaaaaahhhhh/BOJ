import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList list1=getGroup(str1);
        ArrayList list2=getGroup(str2);
        
        int gyo=0;
        for(int i=0;i<list1.size();i++)
        {
            int found;
            if((found=list2.indexOf(list1.get(i)))!=-1)
            {
                list1.remove(i--);
                list2.remove(found);
                gyo++;
            }
        }
        double hap=list1.size()+list2.size()+gyo;
        int res;
        if(hap==0)
        {
            res=65536;
        }
        else
        {
            res=(int)(gyo/hap*65536.0);
        }

        return res;
    }
    static ArrayList<String> getGroup(String str)
    {
        str=str.toUpperCase();
        ArrayList<String> list= new ArrayList();
        for(int i=0;i<str.length()-1;i++)
        {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'
              &&str.charAt(i+1)>='A'&&str.charAt(i+1)<='Z')
            {
                list.add(str.charAt(i)+""+str.charAt(i+1));
            }
        }
        // System.out.println(list.toString());
        return list;
    }
}