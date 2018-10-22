package com.lesherdell.zipcoderange;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ZipCodeRangeMergeTest {

    ZipCodeRangeMerge zipMerge = new ZipCodeRangeMerge();
    
    List<ZipCodeRange> inRangesTest1, outRangesTest1, inRangesTest2, outRangesTest2
                      ,inRangesTest3, outRangesTest3, inRangesTest4, outRangesTest4;
    
    @Before
    public void init() {

        // Test 1 data: Non-overlapping ranges
        // input = [94133,94133] [94200,94299] [94600,94699]
        // output = [94133,94133] [94200,94299] [94600,94699]
        
        inRangesTest1 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                             ,new ZipCodeRange(94600,94699)
                );
        outRangesTest1 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                             ,new ZipCodeRange(94600,94699)
                );
                
        // Test 2 data: Overlapping ranges
        // input = [94133,94133] [94200,94299] [94226,94399]
        // output = [94133,94133] [94200,94399]
        
        inRangesTest2 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                             ,new ZipCodeRange(94226,94399)
                );
        outRangesTest2 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94399)
                );
                
        // Test 3 data: range within another range
        // input = [94133,94133] [94200,94299] [94226,94399]
        // output = [94133,94133] [94200,94399]
        
        inRangesTest3 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                             ,new ZipCodeRange(94226,94227)
                );
        outRangesTest3 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                );
                
        // Test 4 data: adjacent ranges
        // input = [94133,94133] [94200,94299] [94226,94399]
        // output = [94133,94133] [94200,94399]
        
        inRangesTest4 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94299)
                             ,new ZipCodeRange(94300,94399)
                );
        outRangesTest4 = 
                Arrays.asList(new ZipCodeRange(94133,94133)
                             ,new ZipCodeRange(94200,94399)
                );
                
    }

    
    @Test
    public void mergeTest1() {
        // Test 1: Non-overlapping ranges
        List<ZipCodeRange> mergedRanges = null;
        try {
            mergedRanges = zipMerge.merge(inRangesTest1);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
        assertArrayEquals(mergedRanges.toArray(), outRangesTest1.toArray());
    }

    @Test
    public void mergeTest2() {
        // Test 2: Overlapping ranges
        List<ZipCodeRange> mergedRanges = null;
        try {
            mergedRanges = zipMerge.merge(inRangesTest2);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
        assertArrayEquals(mergedRanges.toArray(), outRangesTest2.toArray());
    }

    @Test
    public void mergeTest3() {
        // Test 3: range within another range
        List<ZipCodeRange> mergedRanges = null;
        try {
            mergedRanges = zipMerge.merge(inRangesTest3);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
        assertArrayEquals(mergedRanges.toArray(), outRangesTest3.toArray());
    }

    @Test
    public void mergeTest4() {
        // Test 4: adjacent ranges
        List<ZipCodeRange> mergedRanges = null;
        try {
            mergedRanges = zipMerge.merge(inRangesTest4);
        }
        catch(Exception e) {
            e.printStackTrace(System.out);
            fail();
        }
        assertArrayEquals(mergedRanges.toArray(), outRangesTest4.toArray());
    }

    @Test
    public void mergeExceptionTest() {
        List<ZipCodeRange> mergedRanges = null;
        try {
            // null list parameter
            mergedRanges = zipMerge.merge(null);
        }
        catch(Exception e) {
            // good
            return;
        }
        fail();  // should have gotten an exception
    }

}
