import java.util.*;
class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        // for(int[] bor:game_board)
        // {
        //     System.out.println(Arrays.toString(bor));
        // }
        // System.out.println("-------");
        ArrayList<Block> holes=findBlocks(game_board,0);
        // for(int[] tab:table)
        // {
        //     System.out.println(Arrays.toString(tab));
        // }
        ArrayList<Block> pcs=findBlocks(table,1);
        
        for(int i=0;i<holes.size();i++)
        {
            boolean found=false;
            Block hole=holes.get(i);
            for(int j=0;j<pcs.size();j++)
            {
                Block pc=pcs.get(j);
                
                if(hole.cnt==pc.cnt&&(hole.width==pc.width
                  ||hole.width==pc.height)&&(hole.width+hole.height==pc.width+pc.height))
                {
                    found=matches(hole,pc,game_board,table);
                    if(found)
                    {
                        pcs.remove(pc);
                         answer+=hole.cnt;
                        break;
                    }
                        
                }
            }
        }
        
        return answer;
    }
    static boolean matches(Block A,Block B,int[][] mapA,int[][] mapB)
    {
        int[][] blockA=new int[A.height][A.width];
        for(int i=0;i<A.height;i++)
        {
            for(int j=0;j<A.width;j++)
            {
                blockA[i][j]=mapA[A.stY+i][A.stX+j];
            }
        }
        // for(int[] blA:blockA)
        // {
        //     System.out.println("\t"+Arrays.toString(blA));
        // }
        // System.out.println("A-----B");
        for(int t=0;t<4;t++)
        {
            int[][] blockB=null;
            //turn
            if(t%2==1&&(A.height!=B.width||A.width!=B.height))
            {
                continue;
            }
            else if(t%2==0&&(A.height!=B.height||A.width!=B.width))
            {
                continue;
            }
            switch(t)
            {
                case 0:                    
                    blockB=new int[B.height][B.width];
                    for(int i=0;i<B.height;i++)
                    {
                        for(int j=0;j<B.width;j++)
                        {
                            blockB[i][j]=mapB[B.stY+i][B.stX+j];
                        }
                    }
                    break;
                case 1:
                    blockB=new int[B.width][B.height];
                    for(int i=0;i<B.height;i++)
                    {
                        for(int j=0;j<B.width;j++)
                        {
                            blockB[j][B.height-i-1]=mapB[B.stY+i][B.stX+j];
                        }
                    }
                    break;
                case 2:
                    blockB=new int[B.height][B.width];
                    for(int i=0;i<B.height;i++)
                    {
                        for(int j=0;j<B.width;j++)
                        {
                            blockB[B.height-i-1][B.width-j-1]=mapB[B.stY+i][B.stX+j];
                        }
                    }
                    break;
                case 3:
                    blockB=new int[B.width][B.height];
                    for(int i=0;i<B.height;i++)
                    {
                        for(int j=0;j<B.width;j++)
                        {
                            blockB[B.width-j-1][i]=mapB[B.stY+i][B.stX+j];
                        }
                    }
                    break;
            }
            // for(int[] blB:blockB)
            // {
            //     System.out.println("\t"+Arrays.toString(blB));
            // }
            //match
            boolean match=true;
            outer:for(int i=0;i<A.height;i++)
            {
                for(int j=0;j<A.width;j++)
                {
                    if(blockA[i][j]==blockB[i][j])
                    {
                        match=false;
                        break outer;
                    }
                }
            }
            if(match)
                return true;
        }
        return false;
    }
    static ArrayList<Block> findBlocks(int[][] board,int flag)
    {
        ArrayList<Block> res=new ArrayList<Block>();
        boolean[][] visited=new boolean[board.length][board[0].length];
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
                if(board[i][j]==flag&&!visited[i][j])
                {
                    int cnt=1;
                    int[] min={i,j};
                    int[] max={i,j};
                    
                    Queue<int[]> q=new LinkedList();
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                    while(!q.isEmpty())
                    {
                        int[] cur=q.poll();
                        for(int d=0;d<4;d++)
                        {
                            int ty=cur[0]+dy[d];
                            int tx=cur[1]+dx[d];
                               
                            if(ty<0||tx<0||ty>=board.length||tx>=board[0].length)
                            {  
                                continue;
                            }
                            
                            if(!visited[ty][tx]&&board[ty][tx]==flag)
                            {
                                q.add(new int[]{ty,tx});
                                visited[ty][tx]=true;
                                cnt++;
                                if(min[0]>ty||min[1]>tx)
                                {
                                    if((min[0]-ty)*(min[1]-tx)<0)
                                    {
                                        min[0]=Math.min(min[0],ty);
                                        min[1]=Math.min(min[1],tx);
                                    }
                                    else
                                    {
                                        if(min[0]>ty)
                                        {
                                            min[0]=ty;
                                        }
                                        else
                                        {
                                            min[1]=tx;
                                        }
                                    }
                                }
                                if(max[0]<ty||max[1]<tx)
                                {
                                    if((max[0]-ty)*(max[1]-tx)<0)
                                    {
                                        max[0]=Math.max(max[0],ty);
                                        max[1]=Math.max(max[1],tx);
                                    }
                                    else
                                    {
                                        if(max[0]<ty)
                                        {
                                            max[0]=ty;
                                        }
                                        else
                                        {
                                            max[1]=tx;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    res.add(new Block(max[1]-min[1]+1,max[0]-min[0]+1,min[1],min[0],cnt));
                    // System.out.println((max[1]-min[1]+1)+" "+(max[0]-min[0]+1)+" "+(min[1])+" "+min[0]+" "+cnt);
                }
            }
        }
        return res;
    }
}
class Block
{
    int width;
    int height;
    int stX;
    int stY;
    int cnt;
    Block(int width,int height,int stX,int stY,int cnt)
    {
        this.width=width;
        this.height=height;
        this.stX=stX;
        this.stY=stY;
        this.cnt=cnt;
    }
}