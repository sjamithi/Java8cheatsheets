import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        String[][] data = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}};

        Stream<String[]> temp = Arrays.stream(data);

//        Stream<String[]> stream = temp.filter(s -> "a".equalsIgnoreCase(s.toString()));
//
//        stream.forEach(System.out::println);

        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        stringStream.forEach(s -> System.out.print(s + " "));
    }
}
