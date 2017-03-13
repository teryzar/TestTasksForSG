package ua.dubrovskiy.tests;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static ua.dubrovskiy.java.ReadingFile.findTop100K;

/**
 * Created by Andrey on 13.03.2017.
 */
class ReadingFileTest extends TestCase {
    @org.junit.Test
    public void testfindTop100K() throws Exception {
        List<String> top100 = findTop100K("1.txt", " ");
        int i = 5;
        for(String s : top100) {
            String template = "Фраза " + i;
            if (!s.equals(template)) Assert.fail();
        }
    }
}