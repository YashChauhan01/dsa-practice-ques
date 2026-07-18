class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0,h=0;
        for(int w: nums)
        {
            l=Math.max(l,w);
            h+=w;
        }
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(canSplit(nums,m,k))
            h=m-1;
            else
            l=m+1;
        }
        return l;
    }
    private boolean canSplit(int[] arr, int cap, int k)
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
            if(cnt>k)
            return false;
        }
        return true;
    }
}