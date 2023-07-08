//11:30까지
//3*2*2*2=24
import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        
        List<String> comb=new ArrayList<String>(24);
        //리스트의 배열 만들기 헷갈림
        //리스트의 리스트를 만드는 것이 낫다
        List<List<Integer>> score=new ArrayList<List<Integer>>(24);
        for(int i=0;i<24;i++)
        {
            score.add(new ArrayList<Integer>());
        }

        String[] lang={"c","j","p"};
        String[] dep={"b","f"};
        String[] car={"j","s"};
        String[] food={"c","p"};

        for(String a:lang)
        {
            for(String b:dep)
            {
                for(String c:car)
                {
                    for(String d:food)
                    {
                        comb.add(a+b+c+d);
                    }
                }
            }
        }
        
        for(String appl:info)
        {
            String[] tInfo=appl.split(" ");
            String code=tInfo[0].charAt(0)+""+tInfo[1].charAt(0)+""+tInfo[2].charAt(0)+""+tInfo[3].charAt(0);
            score.get(comb.indexOf(code)).add(Integer.parseInt(tInfo[4]));
        }
        
        for(List sc: score)
        {
            Collections.sort(sc);
        }
        
        int[] res=new int[query.length];
        for(int q=0;q<query.length;q++)
        {
            String[] tq=query[q].split(" ");
            String cCheck=tq[0].charAt(0)+""+tq[2].charAt(0)+""+tq[4].charAt(0)+""+tq[6].charAt(0);
            char[] code={tq[0].charAt(0),tq[2].charAt(0),tq[4].charAt(0),tq[6].charAt(0)};
            int cut=Integer.parseInt(tq[7]);
            for(int i=0;i<24;i++)
            {
                String tcom=comb.get(i);
                boolean match=true;
                for(int j=0;j<4;j++)
                {
                    if(code[j]=='-')
                    {
                        continue;
                    }
                    else if(code[j]!=tcom.charAt(j))
                    {
                        match=false;
                        break;
                    }
                }
                if(match)
                {
                    //System.out.println(cCheck+" "+tcom+" "+score.get(i).size());
                    List<Integer> sc=score.get(i);
                    int st=0;
                    int end=sc.size()-1;
                    while(st<=end)
                    {
                        int mid=(st+end)/2;
                        if(sc.get(mid)>=cut)
                        {
                            end=mid-1;
                        }
                        else
                        {
                            st=mid+1;
                        }
                    }
                    //System.out.println(st+" "+end);
                    res[q]+=sc.size()-st;
                }
            }
            
        }
        return res;
    }
}