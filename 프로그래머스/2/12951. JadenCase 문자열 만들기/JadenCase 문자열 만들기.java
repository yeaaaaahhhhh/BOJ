class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        
        s=s.toLowerCase();
        
        boolean space=true;
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(space&&ch>='a'&&ch<='z')
            {
                sb.append((char)(ch-'a'+'A'));
            }
            else
            {
                sb.append(ch);
            }
             
            if(ch==' ')
            {
                space=true;
            }
            else
            {
                space=false;
            }
        }
        return sb.toString();
    }
}