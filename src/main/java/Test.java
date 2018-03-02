import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    private static List<List<Integer>> range(int[] a) {
        List<List<Integer>> ranges = new ArrayList<>();
        int j;
        for (int i=0; i< a.length-1; i++) {
            j = i + 1;
           if (a[j] - a[i] == 1) {

           }
        }
        return ranges;
    }

    public static void main(String[] args) {
        int[] a = {0,2,3,4,6,8,9};
        System.out.println(range(a));
    }
}
