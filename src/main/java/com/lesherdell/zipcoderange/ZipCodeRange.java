package com.lesherdell.zipcoderange;

public class ZipCodeRange implements Comparable<ZipCodeRange> {

    int start = 0;
    int end = 0;
    
    public ZipCodeRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
    public int compareTo(ZipCodeRange otherRange) {
        return this.start - otherRange.getStart();
    }
    
    @Override
    public boolean equals(Object other) {
        if ( !(other instanceof ZipCodeRange) )
            return false;
        ZipCodeRange otherRange = (ZipCodeRange) other;
        return (start == otherRange.start && end == otherRange.end) ? true : false;
    }
    
    @Override
    public int hashCode() {
        int hashValue = 51;
        hashValue = 31 * hashValue + start;
        hashValue = 31 * hashValue + end;
        return hashValue;
    }
    
}
