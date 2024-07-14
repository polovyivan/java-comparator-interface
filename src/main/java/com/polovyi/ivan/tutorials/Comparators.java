package com.polovyi.ivan.tutorials;

import java.util.Comparator;

public class Comparators {

    public Comparator<PurchaseTransaction> cashbackComparator =
            (object1, object2) -> {
                int diff = object1.getCashBack() - object2.getCashBack();
                return diff == 0 ?
                        0 :
                        diff > 0 ?
                                1 :
                                -1;
            };
}
