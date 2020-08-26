package MJIA;

import java.util.*;
import java.util.stream.Collectors;

public class Run1 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> transaction2011=
                transactions.stream().filter(transaction -> transaction.getYear()==2011)
                        .sorted(Comparator.comparing(Transaction::getValue))
                        .collect(Collectors.toList());
        System.out.println(transaction2011);
        List<String> cities=transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(cities);
        Set<String> citiesSet=transactions.stream().map(transaction -> transaction.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(citiesSet);
        List<Trader> traders=transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().compareTo("Cambridge")==0)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(traders);
        String allTraders=transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName).distinct()
                .sorted().collect(Collectors.joining(" "));
        System.out.println(allTraders);
        Boolean isMilan=transactions.stream().map(Transaction::getTrader).anyMatch(trader -> trader.getCity().compareTo("Milan")==0);
        System.out.println(isMilan);
        transactions.stream().takeWhile(transaction -> transaction.getTrader().getCity().compareTo("Cambridge")==0).forEach(System.out::println);
        Optional<Integer> high=transactions.stream().map(Transaction::getValue).reduce((t1, t2) -> t1 > t2 ? t1 : t2);
        System.out.println(high);
        Optional<Integer> highiestValue=transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(highiestValue);
        Transaction smallest=transactions.stream().reduce((t1,t2)->t1.getValue()<t2.getValue()?t1:t2).get();
        System.out.println(smallest);

    }
}
