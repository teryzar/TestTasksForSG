package ua.dubrovskiy.tests;

import junit.framework.TestCase;
import org.junit.Assert;

import static ua.dubrovskiy.java.Palindroms.checkPalindroms;

/**
 * Created by Andrey on 08.03.2017.
 */
public class PalindromsTest extends TestCase {
    @org.junit.Test
    public void testCheckPalindroms() throws Exception {
        String s = "asksa";
        if (!checkPalindroms(s)) Assert.fail("fail");
    }

}