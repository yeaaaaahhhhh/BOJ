//냅색으로 생각했는데 이진탐색일듯!
class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int len=g.length;
        
        int minw=Integer.MAX_VALUE;
        int minWidx=-1;
        for(int i=0;i<len;i++)
        {
            if(w[i]<minw)
            {
                minw=w[i];
                minWidx=i;
            }
        }
        //최대시간
        long l=0;
        long r=((a+b)/minw+1)*((long)t[minWidx]*2);
        while(l<r)
        {
            long m=(l+r)/2;
            // System.out.println(l+" "+r+" "+m);
            //운반가능량 계산
            int gold=0,silver=0,any=0;
            for(int i=0;i<len;i++)
            {
                long cap=Math.min(g[i]+s[i],w[i]*((m/(t[i]*2))+((m%(t[i]*2)>=t[i])?1:0)));
                long curG=(cap-s[i]>0)?cap-s[i]:0;
                long curS=(cap-g[i]>0)?cap-g[i]:0;
                // System.out.println(i+": "+cap+" "+curG+" "+curS);
                gold+=curG;
                silver+=curS;
                any+=(cap-curG-curS);
            }
            
            //성공 판별
            long gLeft=Math.max(0,(a-gold));
            long sLeft=Math.max(0,(b-silver));
            // System.out.println(m+" "+gLeft+" "+sLeft+" "+any);
            // System.out.println();
            if(gLeft+sLeft<=any)
            {
                //운반가능
                r=m;
            }
            else
            {
                l=m+1;
            }
            
        }
        
        return l;
    }
}
