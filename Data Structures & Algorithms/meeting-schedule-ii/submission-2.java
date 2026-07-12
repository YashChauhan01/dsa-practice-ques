/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        int start[]=new int[n];
        int end[]=new int[n];
        int i=0;
        for(Interval it: intervals)
        {
            start[i]=it.start;
            end[i]=it.end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        i=0;
        int j=0,cnt=0,maxCnt=0;
        while(i<n)
        {
            if(start[i]<end[j])
            {
                cnt++;
                i++;
            }
            else
            {
                cnt--;
                j++;
            }
            maxCnt=Math.max(cnt,maxCnt);

        }
        return maxCnt;
    }
}
