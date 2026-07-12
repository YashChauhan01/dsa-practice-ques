class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n<=1)
        return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int i=0,j=1;
        List<int[]> ans=new ArrayList<>();
        while(j<n)
        {
            int first[]=intervals[i];
            int second[]=intervals[j];
            if(first[1]>=second[0])
            {
                second[0]=Math.min(second[0],first[0]);
                second[1]=Math.max(first[1],second[1]);
                i++;
                j++;
            }
            else
            {
                ans.add(first);
                i++;
                j++;
            }
        }
        ans.add(intervals[i]);
        return ans.toArray(new int[ans.size()][]);
    }
}
