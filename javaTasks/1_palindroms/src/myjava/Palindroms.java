package myjava;


public class Palindroms {

    //Метод checkPalindroms принимает две строки, переворачивает с помощью StringBuilder, проверяет идентичны лм переданная и переввернутая строка.
    public static boolean checkPalindroms(String str1){
        StringBuffer sbf = new StringBuffer(str1).reverse();
        String str2 = String.valueOf(sbf);
        if (str1.equals(str2)) return true;
        else
            return false;
    }


}
