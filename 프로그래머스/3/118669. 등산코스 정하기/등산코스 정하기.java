import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        //ArrayList<Integer> gate=new ArrayList<Integer>(Arrays.asList(gates));
        //이건 int값을 Integer에 넣으려는 거라서 안됨
        //자동형변환 안됨 킹받는다.
        ArrayList<Integer> gate=new ArrayList<Integer>();
        for(int g:gates)
        {
            gate.add(g);
        }
        
        ArrayList<Integer> summit=new ArrayList<Integer>();
        for(int s:summits)
        {
            summit.add(s);
        }
        // Collections.sort(summit);
        
        // for(int ga:gate)
        //     System.out.print(ga+" ");

        // System.out.print(gate.size());
        ArrayList<int[]>[] list=new ArrayList[n+1];
        
        for(int i=0;i<n+1;i++)
        {
            list[i]=new ArrayList();
        }
        
        for(int i=0;i<paths.length;i++)
        {
            boolean spot=false;
            
            //봉우리=도착만 가능
            if(summit.contains(paths[i][0])||summit.contains(paths[i][1]))
            {
                spot=true;
                if(summit.contains(paths[i][0]))
                {
                    list[paths[i][1]].add(new int[]{paths[i][0],paths[i][2]}); 
                }
                else{
                     list[paths[i][0]].add(new int[]{paths[i][1],paths[i][2]});
                }
            }
                          
            //gate=출발만 가능
            if(gate.contains(paths[i][0])||gate.contains(paths[i][1]))
            {
                spot=true;
                if(gate.contains(paths[i][0]))
                {
                    list[paths[i][0]].add(new int[]{paths[i][1],paths[i][2]}); 
                }
                else{
                     list[paths[i][1]].add(new int[]{paths[i][0],paths[i][2]});
                }
            }
            
            if(!spot)
            {
                list[paths[i][1]].add(new int[]{paths[i][0],paths[i][2]});
                list[paths[i][0]].add(new int[]{paths[i][1],paths[i][2]});
            }
        }
        
        // for(int i=1;i<n+1;i++)
        // {
        //     for(int[] arr:list[i])
        //     {
        //         System.out.print(Arrays.toString(arr)+" ");
        //     }
        //     System.out.println();           
        // }
        
        int min=Integer.MAX_VALUE;
        int node=-1;

        int[] v=new int[n+1];
        boolean[] visited=new boolean[n+1];
        Arrays.fill(v,10000001);
        
        
        PriorityQueue<int[]> q= new PriorityQueue<>((o1,o2)->{
            if(o1[1]==o2[1])
            {
                boolean f1=summit.contains(o1[0]);
                boolean f2=summit.contains(o2[0]);
                if(f1&&f2)
                {
                    return o1[0]-o2[0];
                }
                else if(f1||f2)
                {
                    return f1?1:-1;
                }
                
            }
            return o1[1]-o2[1];
        });
        
        for(int g:gate)
        {
            v[g]=0;    
            q.add(new int[]{g,0});
        }
        
        while(!q.isEmpty())
        {
            int[] cur=q.poll();
            int st=cur[0];
            int pr=cur[1];
            visited[st]=true;
            if(summit.contains(st)&&min>v[st])
            {
                node=st;
                min=v[st];
            }
            if(pr>min)
            {
                return new int[]{node,min};
            }
            for(int[] info:list[st])
            {
                if(!visited[info[0]]&&v[info[0]]>Math.max(v[st],info[1]))
                {
                    v[info[0]]=Math.max(v[st],info[1]);
                    q.add(new int[]{info[0],v[info[0]]});
                }
            }
        }
        // System.out.println(g+"res : "+Arrays.toString(v));
        
        return new int[]{node,min};
    }
}