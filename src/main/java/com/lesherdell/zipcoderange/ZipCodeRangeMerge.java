package com.lesherdell.zipcoderange;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class ZipCodeRangeMerge {

    public List<ZipCodeRange> merge(List<ZipCodeRange> inputRanges) throws Exception {
        
        List<ZipCodeRange> returnList = new ArrayList<ZipCodeRange>();
        
        if (inputRanges == null)
            throw new Exception("Range list parameter is null");
        
        // deep copy
        List<ZipCodeRange> sortedRanges = new ArrayList<ZipCodeRange>();
        for (ZipCodeRange range : inputRanges) {
            if ( range.getEnd() < range.getStart() )
                throw new Exception("invalid range: " + range.toString());
            sortedRanges.add(new ZipCodeRange(range.start,range.end));
        }
        Collections.sort(sortedRanges);
        
        Deque<ZipCodeRange> mergedRanges = new ArrayDeque<ZipCodeRange>();
        mergedRanges.push(sortedRanges.get(0));
        ZipCodeRange prevRange = sortedRanges.get(0);
        sortedRanges.remove(0);
        
        for (ZipCodeRange range : sortedRanges) {
            // if this range isn't overlapping, contained in, or adjacent to the previous range,
            // put it on the merged range stack
            if (range.getStart() > (mergedRanges.peek()).getEnd() + 1) {
                mergedRanges.push(range);
            }
            // merge by updating the end of the previous range to the end of this range
            else {
                if (range.getEnd() > (mergedRanges.peek()).getEnd()) {
                    mergedRanges.pop();
                    prevRange.setEnd(range.getEnd());
                    mergedRanges.push(prevRange);
                }    
            }
            prevRange = range;
        }

        returnList =  new ArrayList<ZipCodeRange>(mergedRanges);
        Collections.sort(returnList);
        return returnList;
    }
}
