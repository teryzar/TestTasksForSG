package tests;

import junit.framework.TestCase;
import org.junit.Assert;

import static myjava.Palindroms.checkPalindroms;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 08.03.2017.
 */
public class PalindromsTest extends TestCase {
    @org.junit.Test
    public void testCheckPalindroms() throws Exception {
        String s = "assa";
        if (!checkPalindroms(s)) Assert.fail("fail");
    }

}