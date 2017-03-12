import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//так как с помощью хешмап найти результат не получилось - то придется сортировать массив
public class KComplVariant1 {
    public static List<ComplementaryPair> findCompl (int[] array, int k) {
        List<ComplementaryPair> compList = new ArrayList<ComplementaryPair>();
        //сортируем массив
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        while (true) { //идем по массиву с двух сторон
            int s = array[first] + array[last];
            if (s == k) { //если сумма элементов равна К вот оно решение, добавляем в список, берем следующее число с начала и с конца
                System.out.println(array[first] + " " + +array[last]);
                compList.add(new ComplementaryPair(array[first], array[last]));
                first++;
                last--;
            } else {
                if (s < k) first++; //если сумма меньше - иддем по взрастанию массива
                else last--; //если больше - по убыванию
            }
            if (first >= last) break;
        }
        return compList;
    }

}
