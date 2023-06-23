import java.util.*;
class Solution {
    static HashMap <String,Integer> hm;
    public String[] solution(String[] orders, int[] course) {
        for(int i=0;i<orders.length;i++)
        {
            String str=orders[i];
            String[] tmp=str.split("");
            Arrays.sort(tmp);
            String nstr="";
            for(String t:tmp)
            {
                nstr+=t;
            }
            //System.out.println(nstr);
            orders[i]=nstr;
        }
        ArrayList<String> answer = new ArrayList<>();
        hm=new HashMap();
        for(int c=0;c<course.length;c++)
        {
            findCourse(orders,course[c]);

            int max=2;
            ArrayList<String> res=new ArrayList();
            //System.out.println();
            for(Map.Entry<String,Integer> entry:hm.entrySet())
            {
                //System.out.print(entry.getKey()+" "+entry.getValue()+"\t");
                if(entry.getValue()>max)
                {
                    max=entry.getValue();
                    if(!res.isEmpty())
                    {
                        res.clear();
                    }
                    res.add(entry.getKey());
                }
                else if(entry.getValue()==max)
                {
                    res.add(entry.getKey());
                }
            }
            answer.addAll(res);
            hm.clear();
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    static void findCourse(String[] orders,int len)
    {
        for(int o=0;o<orders.length;o++)
        {
            String str=orders[o];
            ArrayList<String> arr=new ArrayList<>();
            for(int i=0;i<str.length();i++)
            {
                char crt=str.charAt(i);
                int sz=arr.size();
                //System.out.print("*"+arr.size());
                for(int j=0;j<sz;j++)
                {
                    if(arr.get(j).length()>=len)
                    {
                        continue;
                    }
                    arr.add(arr.get(j)+crt);
                }
                arr.add(crt+"");
            }
//            System.out.println(str+" "+len);
//            for(String r:arr)
//                System.out.print(r+"\t");
            for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i).length()==len) {
                    hm.put(arr.get(i),hm.getOrDefault(arr.get(i), 0)+1);
                }
            }
        }
    }

}