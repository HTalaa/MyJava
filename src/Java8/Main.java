package Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList=new ArrayList<>();
        myList.add(5);
        myList.add(3);
        myList.add(1);
        myList.add(4);
        myList.add(2);
        //myList.forEach((a)-> System.out.println(a));
        //Collections.sort(myList,(a,b)->compare(a,b));
        Collections.sort(myList,Main::compare);
        myList.forEach((a)-> System.out.println(a));
        System.out.println(Stream.of(1,2,3,4,5).reduce(0,(e1,e2)->e1+e2));

        List<Person> myList1=new ArrayList<>();
        myList1.add(new Person(10,"Abdullah"));
        myList1.add(new Person(32,"Hamid"));
        myList1.add(new Person(25,"Karim"));
        System.out.println(
        myList1.stream().map(p ->p.getName()).collect(Collectors.joining(","))
        );
        System.out.println(
                myList1.stream().collect(Collectors.maxBy(Comparator.comparing(Person::getAge))).get().getName()
        );
        System.out.println(myList1.stream().collect(Collectors.averagingInt(Person::getAge)).intValue());
        System.out.println(myList1.stream().collect(Collectors.partitioningBy(p -> p.getAge() < 30)));
    }
    static int compare(int firstArg,int secondArg){
        return  firstArg-secondArg;
    }
}
