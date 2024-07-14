package com.polovyi.ivan.tutorials;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class SortTest {

    @Test
    public void testSortByCashBack() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions, new Comparators().cashbackComparator);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_Direct_Impl() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions, (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack()));
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_Arrays_Sort() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        PurchaseTransaction[] transactions = {transaction1, transaction2, transaction3};
        System.out.println("Transactions BEFORE sort = " + Arrays.toString(transactions));
        Arrays.sort(transactions, new Comparators().cashbackComparator);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = Arrays.stream(transactions).toList().stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_Arrays_Sort_Direct_Impl() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        PurchaseTransaction[] transactions = {transaction1, transaction2, transaction3};
        System.out.println("Transactions BEFORE sort = " + Arrays.toString(transactions));
        Arrays.sort(transactions, (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack()));
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = Arrays.stream(transactions).toList().stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_Stream() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> sortedList = Stream.of(transaction1, transaction2, transaction3)
                .sorted(new Comparators().cashbackComparator)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Transactions AFTER sort = " + sortedList);
        List<String> idsList = sortedList.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_Stream_Direct_Impl() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> sortedList = Stream.of(transaction1, transaction2, transaction3)
                .sorted((object1, object2) ->
                        Integer.compare(object1.getCashBack(), object2.getCashBack()))
                .collect(Collectors.toUnmodifiableList());
        System.out.println("Transactions AFTER sort = " + sortedList);
        List<String> idsList = sortedList.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_TreeSet() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        Set<PurchaseTransaction> transactions = new TreeSet<>(new Comparators().cashbackComparator);
        transactions.addAll(Set.of(transaction1, transaction2, transaction3));
        System.out.println("Transactions = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    @Test
    public void testSortByCashBack_TreeSet_Direct_Impl() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        Set<PurchaseTransaction> transactions = new TreeSet<>((object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack()));
        Set<PurchaseTransaction> unsortedTransactions = Set.of(transaction1, transaction2, transaction3);
        System.out.println("Transactions BEFORE sort = " + unsortedTransactions);
        transactions.addAll(unsortedTransactions);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }

    // Default Methods
    @Test
    public void testSortByCashBack_Reversed_Method() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> cashbackComparator = (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack());
        Collections.sort(transactions, cashbackComparator.reversed());

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#2", "#1", "#3"), idsList);
    }

    @Test
    public void testSortByCashBack_ThenComparing_Method() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> cashbackComparator = (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack());
        Comparator<PurchaseTransaction> purchaseTransactionComparator = cashbackComparator.thenComparing((object1, object2) ->
                object1.getCreatedAt().compareTo(object2.getCreatedAt()));
        Collections.sort(transactions, purchaseTransactionComparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#2", "#3", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_ThenComparing_Method_2() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "visa", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> cashbackComparator = (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack());
        Comparator<PurchaseTransaction> purchaseTransactionComparator = cashbackComparator
                .thenComparing(s -> s.getCreatedAt().get(ChronoField.DAY_OF_WEEK), (createdAt1, createdAt2) ->
                        createdAt1.compareTo(createdAt2));

        Collections.sort(transactions, purchaseTransactionComparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_ThenComparing_Method_3() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "visa", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> cashbackComparator = (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack());
        Comparator<PurchaseTransaction> purchaseTransactionComparator = cashbackComparator
                .thenComparing(s -> s.getCreatedAt().get(ChronoField.DAY_OF_WEEK));

        Collections.sort(transactions, purchaseTransactionComparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_ThenComparing_Primitive() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "visa", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> cashbackComparator = (object1, object2) ->
                Integer.compare(object1.getCashBack(), object2.getCashBack());
        Comparator<PurchaseTransaction> purchaseTransactionComparator = cashbackComparator
                .thenComparingInt(s -> s.getCreatedAt().get(ChronoField.DAY_OF_WEEK));

        Collections.sort(transactions, purchaseTransactionComparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    // Static Methods

    @Test
    public void testSortByCashBack_Comparing_Method() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "visa", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 3);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 2);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> comparator = Comparator.comparing(s -> s.getCreatedAt().get(ChronoField.DAY_OF_WEEK),
                (createdAt1, createdAt2) ->
                        createdAt1.compareTo(createdAt2));
        Collections.sort(transactions, comparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_Comparing_Method_2() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "visa", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 3);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "Master", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 2);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> comparator = Comparator.comparing(s -> s.getCreatedAt().get(ChronoField.DAY_OF_WEEK));
        Collections.sort(transactions, comparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_ReverseOrder_Method() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> comparator = Comparator.comparing(PurchaseTransaction::getCashBack,
                Comparator.reverseOrder());
        Collections.sort(transactions, comparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#2", "#1", "#3"), idsList);
    }

    @Test
    public void testSortByCashBack_NullLast_Method() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", null, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);

        Comparator<PurchaseTransaction> comparator = Comparator.comparing(PurchaseTransaction::getAmount,
                Comparator.nullsLast(Comparator.naturalOrder()));
        Collections.sort(transactions, comparator);

        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSortByCashBack_ComparingInt() {
        PurchaseTransaction transaction1 = new PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 2);
        PurchaseTransaction transaction2 = new PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 3);
        PurchaseTransaction transaction3 = new PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions, Comparator.comparingInt(PurchaseTransaction::getCashBack));
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#1", "#2"), idsList);
    }
    
    // Comparable implementation

    @Test
    public void testSort_cashback() {
        A_PurchaseTransaction transaction1 = new A_PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now().minus(1,
                ChronoUnit.DAYS), 1);
        A_PurchaseTransaction transaction2 = new A_PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now().minus(10,
                ChronoUnit.DAYS), 1);
        A_PurchaseTransaction transaction3 = new A_PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now().minus(5,
                ChronoUnit.DAYS), 1);
        List<A_PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(A_PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#2", "#3", "#1"), idsList);
    }

    @Test
    public void testSort_equal_cashback_and_created_at() {
        A_PurchaseTransaction transaction1 = new A_PurchaseTransaction("#1", "VISA", BigDecimal.TEN, LocalDate.now(), 1);
        A_PurchaseTransaction transaction2 = new A_PurchaseTransaction("#2", "MASTER", BigDecimal.TWO, LocalDate.now(), 1);
        A_PurchaseTransaction transaction3 = new A_PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<A_PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(A_PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

    @Test
    public void testSort_cashback_and_created_at_and_amount() {
        A_PurchaseTransaction transaction1 = new A_PurchaseTransaction("#1", "VISA", BigDecimal.ONE, LocalDate.now(), 1);
        A_PurchaseTransaction transaction2 = new A_PurchaseTransaction("#2", "MASTER", BigDecimal.ONE, LocalDate.now(), 1);
        A_PurchaseTransaction transaction3 = new A_PurchaseTransaction("#3", "AMEX", BigDecimal.ONE, LocalDate.now(), 1);
        List<A_PurchaseTransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        System.out.println("Transactions BEFORE sort = " + transactions);
        Collections.sort(transactions);
        System.out.println("Transactions AFTER sort = " + transactions);
        List<String> idsList = transactions.stream()
                .map(A_PurchaseTransaction::getId)
                .collect(Collectors.toUnmodifiableList());
        assertEquals(List.of("#3", "#2", "#1"), idsList);
    }

}
