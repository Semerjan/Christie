package Test.christie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args) throws IOException {


        List<String> workers = new ArrayList<>(Arrays.asList("Ahmat", "Alim", "Lachin", "Ghulam", "Abbas", "Roshal", "Hamit"));

        workers.stream().map(String::toLowerCase).filter(s->s.contains("a")).forEach(System.out::println);


        //6 average of int array square

/*
        int num[] ={2,4,5,7,8,9,9};
        Arrays.stream(num).map(x->x*x).average().ifPresent(System.out::println);

        // reading from the external file
       // Stream <String> bands = Files
        Stream <String> bands = Files.lines(Paths.get("bands.txt"));

        bands.sorted().filter(s->s.length()>2).forEach(System.out::println);
        bands.close();

*/


        ArrayList<String> college = new ArrayList<String>();

        college.add("University of Toronto");
        college.add("University of London");
        college.add("University of West");
        college.add("University of Ottawa");
        college.add("University of Calgary");
        college.add("University of Vancouver");
        college.add("University of Winnipeg");
        college.add("University of Montreal");

        for (String each:college
             ) {

            System.out.println("Universty names as fallow:" + each);

        }

        college.stream().map(String::toUpperCase).filter(s->s.contains("L")).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::println);


        Consumer<String > colleges = s -> {System.out.println(s);};
           college.forEach(colleges);



    }
}
