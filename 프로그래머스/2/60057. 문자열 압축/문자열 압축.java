class Solution {
    static int savedMax=0;
    public int solution(String s) {
        int answer = 0;
        
        for(int i=1;i<s.length()-1;i++)
        {
            int res=getLen(i,s);
            // System.out.println(res);
            if(res>savedMax)
            {
                savedMax=res;
            }
        }
        return s.length()-savedMax;
    }
    static int getLen(int size,String s)
    {
        int len=0;
        //setting
        String gizun=s.substring(0,size);
        int cnt=1;
        //compare
        for(int i=size;i+size<=s.length();i+=size)
        {
            String cur=s.substring(i,i+size);
            if(gizun.equals(cur))
            {
                // System.out.println("equal : "+cur);
                cnt++;
            }
            else
            {
                if(cnt!=1)
                {
                    len+=size*(cnt-1)-Integer.toString(cnt).length();
                    // System.out.println("not equal : "+cur+" "+len);
                }
                gizun=cur;
                cnt=1;
            }
        }
        if(cnt!=1)
        {
            len+=size*(cnt-1)-Integer.toString(cnt).length();
        }
        return len;
    }
}
//len + s.length-(i+size)