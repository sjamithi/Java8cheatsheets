import java.util.*;
import java.util.stream.Collectors;

public class FlatMapObjectToString {
    public static class Student {
        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private String name;

        private Set<String> books;

        private void addBook(String book) {
            if(this.books == null) {
                this.books = new HashSet<>();
            }
            this.books.add(book);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("sandeep");
        s1.addBook("Java 8 in action");
        s1.addBook("Spring microservices");
        s1.addBook("Elastic search in action");

        Student s2 = new Student();
        s2.setName("Jamithi");
        s2.addBook("zillap");
        s2.addBook("Spring microservices");
        s2.addBook("Learning python, 5th edition");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        List<String> books = students.stream().map(x -> x.books).flatMap(Collection::stream).distinct().collect(Collectors.toList());

        books.forEach(System.out::println);
    }
}
