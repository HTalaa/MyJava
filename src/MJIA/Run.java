package MJIA;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Run {
    enum CaloricLevel {DIET, FAT, NORMAL}
    public static void main(String... args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        List<String> threeHighCaloricDishNames =
                menu.stream()
                        .filter(dish -> dish.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<Integer> num= Arrays.asList(1,2,1,3,3,2,4);
        num.stream().filter(i -> i%2 ==0 ).distinct().forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        List<Dish> filteredMenu=
                specialMenu.stream().filter(i->i.getCalories()<320).collect(toList());
        List<Dish> slicedMenu1=
                specialMenu.stream().takeWhile(i->i.getCalories()<320).collect(toList());
        List<Dish> slicedMenu2=
                specialMenu.stream().dropWhile(i->i.getCalories()<320).collect(toList());
        List<Dish> slicedMenuMeat=
                specialMenu.stream().filter(i->i.getType()== Dish.Type.MEAT).limit(2).collect(toList());
        slicedMenuMeat.stream().forEach(System.out::println);

        List<Integer> ints=menu.stream().map(Dish::getName).map(String::length).collect(toList());
        List<Integer> intSq=Arrays.asList(1,3,2,4,8);
        List<Integer> ints1=Arrays.asList(1,2,3);
        List<Integer> ints2=Arrays.asList(1,2,3);

        List<int[]> pairs=ints1.stream().flatMap(i -> ints2.stream().map(j->new int[]{i,j})).collect(toList());
        List<int[]> pairs1=ints1.stream().flatMap(i -> ints2.stream()
                .filter(j->(i+j)%3==0)
                .map(j->new int[]{i,j})).collect(toList());
        pairs.stream().filter(i-> Arrays.stream(i).sum()%3==0).collect(toList());
        intSq.stream().map(integer -> integer*integer).forEach(System.out::println);
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));
        System.out.println(num.stream().reduce(0, (a, b) -> a + b));
        System.out.println(num.stream().reduce(1, (a, b) -> a * b));
        System.out.println(num.stream().reduce((a, b) -> a * b));
        System.out.println(num.stream().reduce(Integer::max));
        System.out.println(num.stream().reduce((a,b)->a>b?a:b));
        System.out.println(menu.stream().map(dish -> 1).reduce(0,(a,b)->a+b));
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);
        System.out.println(max);
        System.out.println(maxCalories);
        IntStream evenNumbers=IntStream.rangeClosed(1,100).filter(n->n%2==0);
        System.out.println(evenNumbers.count());
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        Stream.iterate(new int[]{0, 1}, t->new int[]{t[1],t[0]+t[1]}).limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
        long howManydishes=menu.stream().collect(Collectors.counting());
        System.out.println(howManydishes);
        System.out.println(menu.stream().count());
        Comparator<Dish> dishCaloriesComparator=
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);
        System.out.println("total calories :"+ menu.stream().collect(summingInt(Dish::getCalories)));
        System.out.println("avg claories"+ menu.stream().collect(averagingDouble(Dish::getCalories)));
        IntSummaryStatistics menuStatistics=
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(" "));
        System.out.println(shortMenu);
        System.out.println(menu.stream().collect(reducing(0,Dish::getCalories,(i,j)->i+j)));
        Map<Dish.Type,List<Dish>> dishesByType=
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel=
                menu.stream().collect(groupingBy(
                   dish->{
                       if(dish.getCalories()<=400) return CaloricLevel.DIET;
                       else if(dish.getCalories()<=700) return CaloricLevel.NORMAL;
                       else return CaloricLevel.FAT;
                   }

                ));
        System.out.println(dishesByCaloricLevel);
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,filtering(dish -> dish.getCalories()>500,toList())));
        System.out.println(caloricDishesByType);
        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                mapping(Dish::getName, toList())));
        System.out.println(dishNamesByType);
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );
        System.out.println(dishesByTypeCaloricLevel);
        Map<Dish.Type,Long> typesCount=
                menu.stream().collect(groupingBy(Dish::getType,counting()));
        System.out.println(typesCount);
        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                .collect(groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
        Map<Dish.Type, Dish> mostCaloricByType1 =
                menu.stream().collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println(mostCaloricByType1);
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
        System.out.println(partitionedMenu.get(true));
        Map<Boolean,Map<Dish.Type,List<Dish>>> vegetarianDishesByType=
                menu.stream().collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(
                                Dish::isVegetarian,
                                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)
                        ));
        System.out.println(mostCaloricPartitionedByVegetarian);
        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500))));
        System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting())));
        LocalDate date=LocalDate.of(2017,9,21);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(LocalDate.now());
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        LocalTime time=LocalTime.of(13,45,20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        LocalDate date1=LocalDate.parse("2017-09-21");
        LocalTime time1=LocalTime.parse("13:45:20");
        System.out.println(date1.getYear());
        LocalDateTime dt1=LocalDateTime.of(2017, Month.SEPTEMBER,21,13,45,20);
        LocalDateTime dt2=LocalDateTime.of(date,time);
        LocalDateTime dt3=date.atTime(13,45,20);
        LocalDateTime dt4=date.atTime(time);
        LocalDateTime dt5=time.atDate(date);
        //System.out.println(Instant.now().get(ChronoField.DAY_OF_MONTH));
        Period tenDays = Period.between(LocalDate.of(2017, 9, 11),
                LocalDate.of(2017, 9, 21));
        System.out.println(tenDays);
        System.out.println(LocalDate.now().isAfter(date1));

        LocalDate date2=LocalDate.of(2017,9,21);
        LocalDate date3=date2.withYear(2011);
        LocalDate date4=date3.withDayOfMonth(25);
        LocalDate date5=date4.with(ChronoField.MONTH_OF_YEAR,2);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        LocalDate date6=date5.plusWeeks(1);
        LocalDate date7=date6.minusYears(7);
        LocalDate date8=date7.plus(6, ChronoUnit.MONTHS);
        System.out.println(date6);
        System.out.println(date7);
        System.out.println(date8);

        LocalDate date9 = LocalDate.of(2014, 3, 18);
        date9 = date9.with(ChronoField.MONTH_OF_YEAR, 9);
        date9 = date9.plusYears(2).minusDays(10);
        System.out.println(date9.withYear(2011));
        System.out.println(date9);
        System.out.println(stringToInt("55").get());
        System.out.println(stringToInt("AG4"));

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");


    }
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

/*

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalUtility::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

*/




}
