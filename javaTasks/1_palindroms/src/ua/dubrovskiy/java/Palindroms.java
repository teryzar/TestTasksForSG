package ua.dubrovskiy.java;

/**
 * Class that checks if the string is palindrom
 *        
 */

public class Palindroms {
    /**
     * checks if the string is palindrom
     * @param str1 - string to be checked
     * @return true if palindrom, false if is not
     */
    public static boolean checkPalindroms(String str1) {
        //прокатимся по строке с двух концов и сравним символы в начале и конце
        for (int i = 0; i < str1.length() / 2; ++i) {
            // Сравниваем символ с начала и конца
            if (str1.charAt(i) != str1.charAt(str1.length() - i - 1)) {
                return false; // символы не равны, не палиндром, возвращаем false
            }
        }
        return true; // проверка не выявила несовпадающих символов, возвращаем true
    }
}
