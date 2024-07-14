package com.polovyi.ivan.tutorials;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        var example1 = Stream.of(3, 2, 1)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("example1 = " + example1);

        var example2 = Stream.of(3, 2, 1)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("example2 = " + example2);

        var example3 = Stream.of("A", "B", "C")
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("example3 = " + example3);

        var example4 = Stream.of("A", "b", "C")
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList());
        System.out.println("example4 = " + example4);

        var example5 = Stream.of(new PurchaseTransaction("#1", "visa", BigDecimal.TEN, null, 3),
                        new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                                ChronoUnit.DAYS), 1),
                        new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                                ChronoUnit.DAYS), 2))
                .sorted(Comparator.comparing(PurchaseTransaction::getCreatedAt,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toList());
        System.out.println("example5 = " + example5);

        var example6 = Stream.of(new PurchaseTransaction("#1", "VISA", BigDecimal.ONE,
                                LocalDate.now(), 1),
                        new PurchaseTransaction("#2", "MASTER", BigDecimal.ONE, LocalDate.now(), 1),
                        new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1))
                .sorted((o1, o2) -> Comparator.comparingInt(PurchaseTransaction::getCashBack)
                        .thenComparing(PurchaseTransaction::getCreatedAt)
                        .thenComparing(PurchaseTransaction::getAmount)
                        .thenComparing(PurchaseTransaction::getPaymentType)
                        .compare(o1, o2))
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toList());
        System.out.println("example5 = " + example6);

    }
}
