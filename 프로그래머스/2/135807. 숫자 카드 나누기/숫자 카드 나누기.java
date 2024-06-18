class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcpA=arrayA[0];
        for(int i=1;i<arrayA.length;i++)
        {
            gcpA=gcp(gcpA,arrayA[i]);
        }
        
        boolean right=true;
        for(int num:arrayB)
        {
            if(num%gcpA==0)
            {
                right=false;
                break;
            }
        }
        if(right)
        {
            answer=gcpA;   
        }
        
        int gcpB=arrayB[0];
        for(int i=1;i<arrayB.length;i++)
        {
            gcpB=gcp(gcpB,arrayB[i]);
        }
        
        if(gcpB>gcpA)
        {
            right=true;
            for(int num:arrayA)
            {
                if(num%gcpB==0)
                {
                    right=false;
                    break;
                }
            }
            if(right)
            {
                answer=gcpB;   
            }
        }
        
        return answer;
    }
    
    public int gcp(int a, int b)
    {
        while(true)
        {
            int r=a%b;
            if(r==0)
            {
                return b;
            }
            a=b;
            b=r;
            // System.out.println("line");
        }
    }
}
//최대공약수
//하나도 나눌수 없다. = 영희%k==0
//=최소공배수를 나눌수 없다

