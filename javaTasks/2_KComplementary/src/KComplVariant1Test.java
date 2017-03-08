import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrey on 08.03.2017.
 */
public class KComplVariant1Test extends TestCase {
    @Test
    public void testFindCompl () {
        List<ComplementaryPair> list = KComplVariant1.findCompl(array, k);
        boolean b = false;
        for (ComplementaryPair c : list) {
            if (c.getFirst() == 2 && c.getSecond() == 3) b = true;
        }
        if (!b) Assert.fail();

    }

    int[] array = new int[] { 7, -1, -1, -7, 0, 4, 3, 2, -5, -6, 8 };
    int k = 5;
    ComplementaryPair complementaryPair2 = new ComplementaryPair(2, 3);
    ArrayList<ComplementaryPair> lst = new ArrayList<ComplementaryPair>();

}