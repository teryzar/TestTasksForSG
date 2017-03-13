package ua.dubrovskiy.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//алгоритм более эффективный, чем первый, но не смог разобраться почему не рабоиает HashMap.contains
public class KComplVariant2 {
    public static List<ComplementaryPair> findCompl (int[] array, int k) {
        List<ComplementaryPair> result = new ArrayList<ComplementaryPair>();
        //Воспользуемся возпомагательной коллекцией с самім простім алгоритмом доступа
        Set<Integer> suppSet = new HashSet<Integer>();

        for (int i : array) {
            //вычисляем второе число из пары
            int temp = k - i;
            //если число содержится в сете - это решение
            if (suppSet.contains(temp)) result.add(new ComplementaryPair(i, temp));
                //если нет - добавляем в хешсет
            else suppSet.add(temp);
        }

        return result;
    }

}