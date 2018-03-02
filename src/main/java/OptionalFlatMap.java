import java.util.Optional;

public class OptionalFlatMap {
    public static void main(String[] args) {
        Optional<String> nonEmptyString = Optional.of("sandeep");
        Optional<String> empty = Optional.empty();

        System.out.println("Non empty optional: " + nonEmptyString.map(String::toUpperCase));
        System.out.println("Empty optional: " + empty.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(nonEmptyString);
        System.out.println(nonEmptyOptionalGender);
        System.out.println(nonEmptyOptionalGender.map(g -> g.map(String::toUpperCase)));
        System.out.println("flat map --> " +nonEmptyOptionalGender.flatMap(g -> g.map(String::toUpperCase)));


        //Filter on Optional

        System.out.println("----- - - -- - - - - Filter on optional - - -- - - -- - -- ");
        System.out.println(nonEmptyString.filter(g -> g.equals("saNDeep")));
        System.out.println(nonEmptyString.filter(f -> f.equalsIgnoreCase("SANdeep")));
        System.out.println(empty.filter(d -> d.equalsIgnoreCase("SandEEp")));


        //isPresent
        System.out.println("-=-=-=     is present -=-=-=-=--------------");
        nonEmptyString.ifPresent(s -> System.out.println("There is a value"));


        //orElse

        System.out.println("---------------------------- or else ---------------------");
        System.out.println(nonEmptyString.orElseGet(() ->"N/a"));
        System.out.println(empty.orElseGet(() -> "N/a"));
    }
}
