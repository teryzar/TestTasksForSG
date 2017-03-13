package ua.dubrovskiy.java;

/**
 * An object that sorts Map by value
 * <p>Found in Google so i do not really understand what do it do<p/>
 * */

import java.util.*;

public class SorterByValue {
    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );

        map.clear(); //очищаем оперативноую память
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        list.clear(); //очищаем оперативную память
        return result;
    }

}