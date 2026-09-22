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
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq=new PriorityQueue<>();  // Stores end time
        for(Interval it: intervals)
        {
            if(!pq.isEmpty() && pq.peek()<=it.start)
            pq.poll();
            pq.add(it.end);
        }
        return pq.size();
    }
}
