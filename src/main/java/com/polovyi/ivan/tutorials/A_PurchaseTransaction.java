package com.polovyi.ivan.tutorials;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class A_PurchaseTransaction implements Comparable<A_PurchaseTransaction> {

    private String id;
    private String paymentType;
    private BigDecimal amount;
    private LocalDate createdAt;
    private int cashBack;


    @Override
    public int compareTo(A_PurchaseTransaction pt) {
        return Comparator.comparingInt(A_PurchaseTransaction::getCashBack)
                .thenComparing(A_PurchaseTransaction::getCreatedAt)
                .thenComparing(A_PurchaseTransaction::getAmount)
                .thenComparing(A_PurchaseTransaction::getPaymentType)
                .compare(this, pt);
    }

//    @Override
//    public int compareTo(A_PurchaseTransaction object) {
//        if (this.getCashBack() != object.getCashBack())
//            return Integer.compare(this.getCashBack(), object.getCashBack());
//
//        if (!this.getCreatedAt().equals(object.getCreatedAt()))
//            return this.getCreatedAt().compareTo(object.getCreatedAt());
//
//        if (!this.getAmount().equals(object.getAmount()))
//            return this.getAmount().compareTo(object.getAmount());
//
//        return this.getPaymentType().compareTo(object.getPaymentType());
//    }

}
