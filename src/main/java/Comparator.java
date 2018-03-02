import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Comparator {

    public static class Developer {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private String name;
        private int salary;
        private int age;


        public Developer(String name, int salary, int age) {
            this.name = name;
            this.salary = salary;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        List<Developer> devs = new ArrayList<>();
        devs.add(new Developer("Jam", 70000, 29));
        devs.add(new Developer("San", 30000, 25));
        devs.add(new Developer("San", 90000, 25));
        devs.add(new Developer("Deep", 100000, 27));
        devs.add(new Developer("thee", 170000, 53));
        devs.add(new Developer("thee", 100000, 50));

        System.out.println("Before sort");
        System.out.println();
        for (Developer dev: devs) {
            System.out.println(dev.getAge() + " " + dev.getName() + " "+ dev.getSalary());
        }

        System.out.println("sort by age");
        System.out.println();
        devs.sort((Developer d1, Developer d2) -> d1.getAge()-d2.getAge()) ;
        devs.forEach(d -> System.out.println(d.getAge() + " " + d.getName() + " "+ d.getSalary()));
        System.out.println();

        System.out.println("sort by name");
        System.out.println();
//        devs.sort((Developer d1, Developer d2) -> d1.getName().compareTo(d2.getName()));
        devs.sort(comparing(Developer::getName));
        devs.forEach(d -> System.out.println(d.getAge() + " " + d.getName() + " "+ d.getSalary()));
        System.out.println();

        System.out.println("sort by salary");
        System.out.println();
        devs.sort(comparing(Developer::getSalary));
        devs.forEach(d -> System.out.println(d.getAge() + " " + d.getName() + " "+ d.getSalary()));


        System.out.println("Counting example");
        Map<String, Long> counting = devs.stream().collect(
                Collectors.groupingBy(Developer::getName, Collectors.counting())
        );

        System.out.println(counting);

        System.out.println("summing int example");
        Map<String, Integer> sum = devs.stream().collect(
                Collectors.groupingBy(Developer::getName, Collectors.summingInt(Developer::getSalary))
        );

        System.out.println(sum);

        System.out.println();
        System.out.println("group  by salary list of devs");
        Map<Integer, Set<Integer>> devsSalaries = devs.stream().collect(
                Collectors.groupingBy(Developer::getSalary, Collectors.mapping(Developer::getAge, Collectors.toSet()))
        );
        System.out.println(devsSalaries);


        System.out.println();
        System.out.println("group by salary");
        Map<Integer, Set<String>> groupBySalary =
                devs.stream().collect(
                        Collectors.groupingBy(Developer::getSalary,
                                Collectors.mapping(Developer::getName, Collectors.toSet()))
                );
        System.out.println(groupBySalary);
    }
}
