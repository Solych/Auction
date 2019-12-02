package com.auction.utils;

import com.auction.model.Lot;

import java.util.Comparator;

public class LotComparator implements Comparator<Lot> {
    @Override
    public int compare(Lot o1, Lot o2) {
        if (o1.getDateOfPut().getTime() > o2.getDateOfPut().getTime())
            return -1;
        else if(o1.getDateOfPut().getTime() < o2.getDateOfPut().getTime())
            return 1;
        else
            return 0;
    }
}
