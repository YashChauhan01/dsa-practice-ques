class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0;
        for(int w: weights)
        {
            l=Math.max(l,w);
            h+=w;
        }
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(canShip(weights,m,days))
            h=m-1;
            else
            l=m+1;
        }
        return l;
    }
    private boolean canShip(int[] arr, int cap, int days)
    {
        int cnt=1,sum=0;
        for(int it: arr)
        {
            sum+=it;
            if(sum>cap)
            {
                cnt++;
                sum=it;
            }
            if(cnt>days)
            return false;
        }
        return true;
    }
}