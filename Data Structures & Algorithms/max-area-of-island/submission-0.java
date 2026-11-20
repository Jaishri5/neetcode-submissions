class Solution {
    int[][] directions=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    int area=0;
    int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    area=0;
                    markVistedAndCountCells(grid,i,j,visited);
                    maxArea=Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
    public void markVistedAndCountCells(int[][] grid,int i,int j,boolean[][] visited){
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&!visited[i][j]&&grid[i][j]==1){

            area++;
            visited[i][j]=true;
            for(int[] dir:directions){
                 markVistedAndCountCells(grid,i+dir[0],j+dir[1],visited);
            }
            
        }
    }
}
