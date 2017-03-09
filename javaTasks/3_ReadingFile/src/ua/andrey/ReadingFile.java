package ua.andrey;


import java.io.*;
import java.util.*;

import static ua.andrey.SorterByValue.sortByValue;


public class ReadingFile {

    private static String filePath;
    private static String delimiter;
    private static Map<String, Integer> frqMap = new HashMap<String, Integer>();

    public static List<String> readThisFile(String fileName, String delimiter) {
        //TODO почистить цикл с токинайзером
        try{
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            //Построчно считываем файл
            while(line != null){
                //разбиваем строку на подстроки согласно разделителю(delimiter)
                StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
                //считываем каждую подстроку и формируем катру частотности
                if (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    while (true) {
                        //Если такая строка уже была в файле добавляем к частоте +1, если нет - присваиваем 1
                        if (!frqMap.containsKey(token)) {
                            frqMap.put(token, 1);
                        } else {
                            int freq = frqMap.get(token) + 1;
                            frqMap.put(token, freq);
                        }

                        if (tokenizer.hasMoreTokens()) token = tokenizer.nextToken();
                        else break;
                    }
                }
                //считывем следующую строку
                line = reader.readLine();
            }


        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }

        Map<String, Integer> sortedMap = sortByValue(frqMap);
        Set<String> keySet = sortedMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
//        ArrayList<String> resultList = reverseSort(listOfKeys);
        Collections.reverse(listOfKeys);
        return listOfKeys;


    }
}
