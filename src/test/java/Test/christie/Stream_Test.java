package Test.christie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_Test {

    public static void main(String[] args) {

        // Integer stream

        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();
        // printing 30 to 40
      //  IntStream.range(30,40).forEach(System.out::print);

        System.out.println();


// skip the number

        IntStream.range(1,10).skip(5).forEach(x -> System.out.print(x));
       // System.out.println();
      //  IntStream.range(30,40).skip(35).forEach(System.out::print);
        System.out.println();

// finding the sum of numbers
        System.out.println(

                IntStream.range(1,10).sum()

        );


        // sorting the string

        Stream.of("Ahmat", "Alim", "Lachin", "Ghulam", "Abbas")
                .sorted().findFirst().ifPresent(s -> System.out.print(s));

        System.out.println();

        // String Array

        String [] people = {"Ahmat", "Alim", "Lachin", "Ghulam", "Abbas", "Roshal","Hamit" };

        Arrays.stream(people).filter(s ->s.startsWith("H")).forEach(System.out::print);
        System.out.println("Thisis  aline breaker");
Arrays.stream(people).filter(f -> f.contains("m")).forEach(System.out::print);

        System.out.println();
// Averages of square in int array

        Arrays.stream(new int [] {1,2,3,4,6,8,7,9,10})
                .map(s -> s*s).average().ifPresent(m ->System.out.print(m));


ArrayList<Integer> myNUm = new ArrayList<Integer>();
myNUm.add(20);
myNUm.add(30);
myNUm.add(40);
 myNUm.stream().forEach(System.out::println);

        Consumer<Integer> me = (k)->{System.out.print(k);};
        myNUm.forEach(me);


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach( method );

        System.out.println();
        // sorting the array and print out the results

        List<String > workers = new ArrayList<>(Arrays.asList("Ahmat", "Alim", "Lachin", "Ghulam", "Abbas", "Roshal","Hamit"));

workers.stream()
        .map(String::toLowerCase)
        .filter(k ->k.contains("s")).forEach(System.out::println);







    }

}
