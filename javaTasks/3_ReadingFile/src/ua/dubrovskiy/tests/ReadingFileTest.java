package ua.dubrovskiy.tests;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static ua.dubrovskiy.java.ReadingFile.findTop100K;

/**
 * Created by Andrey on 13.03.2017.
 */
public class ReadingFileTest extends TestCase {
    @Test
    public void testFindTop100K() throws Exception {
        List<String> top = findTop100K("1.txt", " ");
        int i = 5;
        for (String s : top) {
            String template = "Фраза " + String.valueOf(i);
            if (!s.equals(template)) Assert.fail();
        }
    }
}

