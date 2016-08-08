# priyakarthik
import java.util.*;
 
public class Solution {
ublic static void main(String[] args){
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals.size() == 0)
            return intervals;
        if(intervals.size() == 1)
            return intervals;
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
            
        }
        
        result.add(new Interval(start, end));
        
        return result;
        
    }
}


class IntervalComparator implements Comparator{
        public int compare(Object o1, Object o2){
            Interval i1 = (Interval)o1;
            Interval i2 = (Interval)o2;
            return i1.start - i2.start;
        }
}
}
