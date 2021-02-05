package Test.christie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream3 {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("kamal", 20000));
        people.add(new Person("Jacob", 100000));
        people.add(new Person("Adam",45000));
        people.add(new Person("Helen", 35000));
        people.add(new Person("Patric", 135000));


        List<Person> hundredClub = new ArrayList<>();

      /*  for (Person each:people
             ) {
             if(each.deposit>100000){
                 hundredClub.add(each);
             }
        }

        hundredClub.forEach(s -> {System.out.println(s.name);});*/

        List<Person> millonair = people.stream().filter(p->p.deposit>=100000).collect(Collectors.toList());

millonair.forEach(s->System.out.println(s.name));

        System.out.println("=================================================");
List<Person> sorted = people.stream()
        .sorted(Comparator.comparing(s->s.name)).collect(Collectors.toList());

sorted.forEach(s ->{System.out.println(s.name);});


        System.out.println(" ----------------------------------------------------------------");

        List<Person> SedFilter = people.stream().sorted(Comparator.comparing(k->k.name)).filter(p->p.deposit<100000)
               .collect(Collectors.toList());

        SedFilter.forEach(k ->{System.out.println(k.name);});

    }



   static class Person{

       String name;
       int deposit;

       public Person(String name, int deposit){

           this.name=name;
           this.deposit=deposit;
       }

    }



}
