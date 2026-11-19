class Solution {
    int[][] directions=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    public int orangesRotting(int[][] grid) {
        int freshOrangesCount=0;
        int minutes=0;
        Queue<int[]> rottenOranges=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshOrangesCount++;
                }
                else if(grid[i][j]==2){
                    rottenOranges.add(new int[]{i,j});
                }
            }
        }
        if(freshOrangesCount==0){
            return 0;
        }
        if(rottenOranges.isEmpty()){
            return -1;
        }
        
        while(!rottenOranges.isEmpty()&&freshOrangesCount>0){
            int size=rottenOranges.size();
            minutes++;
            for(int i=0;i<size;i++){
                int[] adj=rottenOranges.poll();
                
                for(int[] dir:directions){
                    int r=adj[0]+dir[0];
                    int c=adj[1]+dir[1];
                    if(r>=0&&c>=0&&r<grid.length&&c<grid[0].length&&grid[r][c]==1){
                        freshOrangesCount--;
                        grid[r][c]=2;
                        rottenOranges.add(new int[]{r,c});
                    }
                }
            }
        
        }
        if(freshOrangesCount>0){
            return -1;
        }
        return minutes;
    }
}
