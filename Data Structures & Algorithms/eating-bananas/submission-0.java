class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,hi=0;
        for(int it:piles)
            hi=Math.max(hi,it);
        while(l<=hi)
        {
            int m=l+(hi-l)/2;
            if(canEat(piles,m,h))
            hi=m-1;
            
            else
            l=m+1;
        }
        return l;
    }
    private boolean canEat(int[] arr, int speed, int h)
    {
        int cnt=0;
        for(int it: arr)
        {
            cnt+=(it+speed-1)/speed;
            if(cnt>h)
            return false;
        }
        return true;
    }

}
