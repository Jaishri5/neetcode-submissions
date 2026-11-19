class Solution {
    int[][] directions=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
   
    public int numIslands(char[][] grid) {
        int count =0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&& grid[i][j]=='1'){
                    markConnectedLand(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void markConnectedLand(char[][] grid,int i,int j,boolean[][] visited){
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&!visited[i][j]&& grid[i][j]=='1'){
            visited[i][j]=true;
            for(int[]dir:directions){
                markConnectedLand(grid,i+dir[0],j+dir[1],visited);
            }
        }
    }
}
