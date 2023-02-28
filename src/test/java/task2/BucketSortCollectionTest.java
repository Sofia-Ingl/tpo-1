package task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BucketSortCollectionTest {

    private static BucketSortCollection<Integer> sortingCollection;

    @BeforeAll
    static void initCollection() {
        sortingCollection = new BucketSortCollection<Integer>();
    }

    @Test
    void nullableArrayTest() {
        Integer[] arr = null;
        sortingCollection.sort(arr);
        assertArrayEquals(arr, null);
        assertEquals(sortingCollection.getCollection().size(), 0);
    }


    @Test
    void arrayStandardTest() {
        Integer[] arr = new Integer[]{477, 8, 876, 600, 919, 648, 93, 17};
        Integer[] resultArr = new Integer[]{8, 17, 93, 477, 600, 648, 876, 919};
        sortingCollection.sort(arr);
        assertArrayEquals(arr, resultArr);
        assertEquals(sortingCollection.getCollection().size(), 0);
    }

    @Test
    void arrayNegativesTest() {
        Integer[] arr = new Integer[]{477, 8, 876, -2, 600, 919, 648, 93, 17, -988, 1027, 0};
        Integer[] resultArr = new Integer[]{-988, -2, 0, 8, 17, 93, 477, 600, 648, 876, 919, 1027};
        sortingCollection.sort(arr);
        assertArrayEquals(arr, resultArr);
        assertEquals(sortingCollection.getCollection().size(), 0);
    }


    @Test
    void arrayRepetitionsTest() {
        Integer[] arr = new Integer[]{477, 8, 93, 876, 600, 919, -1, 8, 8, 648, 93, 17, -1};
        Integer[] resultArr = new Integer[]{-1, -1, 8, 8, 8, 17, 93, 93, 477, 600, 648, 876, 919};
        sortingCollection.sort(arr);
        assertArrayEquals(arr, resultArr);
        assertEquals(sortingCollection.getCollection().size(), 0);
    }

}
