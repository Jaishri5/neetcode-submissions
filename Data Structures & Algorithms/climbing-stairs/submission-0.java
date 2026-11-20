class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        int[] possibleSteps=new int[n];
        possibleSteps[0]=1;
        possibleSteps[1]=2;
        for(int i=3;i<=n;i++){
            possibleSteps[i-1]=possibleSteps[i-2]+possibleSteps[i-3];
        }
        return possibleSteps[n-1];
    }
}
