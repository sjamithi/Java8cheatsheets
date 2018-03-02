import java.util.Optional;

public class Java8 {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("Sandeep");
        String a1 = "Yo";
        String a2 = null;


        System.out.println(gender);
        System.out.println(gender.get());
        System.out.println(Optional.empty());

        System.out.println(Optional.ofNullable(a1));
        System.out.println(Optional.ofNullable(a2));
        System.out.println(Optional.of(a2));
    }

}
