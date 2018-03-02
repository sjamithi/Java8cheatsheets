import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("z", 26);
        unsortedMap.put("b", 2);
        unsortedMap.put("j", 10);
        unsortedMap.put("a", 1);
        unsortedMap.put("y", 25);

        System.out.println("unsorted ... ");
        System.out.println(unsortedMap);

        Map<String, Integer> sortedByKeys = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sorted by keys");
        System.out.println(sortedByKeys);

        Map<String, Integer> sortByValues = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("sort by values");
        System.out.println(sortByValues);
        sortByValues.forEach((k, v) -> System.out.println(k + " "));
    }
}
