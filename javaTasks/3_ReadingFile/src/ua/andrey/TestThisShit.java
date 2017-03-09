package ua.andrey;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static ua.andrey.ReadingFile.readThisFile;
import static ua.andrey.SorterByValue.sortByValue;

public class TestThisShit {

    public static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
//        map.put("fjhbsdvjbd", 43);
//        map.put("fjhbsdv", 12);
//        map.put("fbsdvjbd", 3);
//        map.put("fjhbsdvrthrthjbd", 4);
//        map.put("fj111hbsdvjbd", 50);
//        map.put("fjhsdvj31bd", 35);
//        map.put("fjh11123bsdvjbd", 22);
//        map.put("fjhbqweqweqweqwesdvjbd", 18);

//        Map<String, Integer> sortedMap = sortByValue(map);
        List<String> top100= readThisFile("E:\\1.txt", " ");
        printMap(top100);


    }
    public static void printMap(List<String> mp) {
//        Iterator it = mp.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
//            it.remove(); // avoids a ConcurrentModificationException
        for (String s : mp) {
            System.out.println(s);
        }
    }
}
