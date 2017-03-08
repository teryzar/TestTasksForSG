import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//так как с помощью хешмап найти результат не получилось - то придется сортировать массив
public class KComplVariant1 {
    public static List<ComplementaryPair> findCompl (int[] array, int k) {
        List<ComplementaryPair> compList = new ArrayList<ComplementaryPair>();
        Arrays.sort(array);

        int first = 0;
        int last = array.length - 1;
        while (true) {
            int s = array[first] + array[last];
            if (s == k) {
                System.out.println(array[first] + " " + +array[last]);
                compList.add(new ComplementaryPair(array[first], array[last]));
                first++;
                last--;
            } else {
                if (s < k) first++;
                else last--;
            }
            if (first >= last) break;
        }
        return compList;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {7, -1, -1, -7, 0, 4, 3, 2, -5, -6, -2};
        List<ComplementaryPair> lst = findCompl(arr, 5);
        for (ComplementaryPair c : lst) {
            System.out.println(c.getFirst() + " " + c.getSecond());
        }

    }
}
