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
    void arrayValuesOutOfBoundsTest() {
        Integer[] arr = new Integer[]{477, 8, 876, 600, 919, 648, 93, 10000, 17};
        Integer[] resultArr = new Integer[]{477, 8, 876, 600, 919, 648, 93, 10000, 17};
        sortingCollection.sort(arr);
        assertArrayEquals(arr, resultArr);
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
    void arrayRepetitionsTest() {
        Integer[] arr = new Integer[]{477, 8, 93, 876, 600, 919, 8, 8, 648, 93, 17};
        Integer[] resultArr = new Integer[]{8, 8, 8, 17, 93, 93, 477, 600, 648, 876, 919};
        sortingCollection.sort(arr);
        assertArrayEquals(arr, resultArr);
        assertEquals(sortingCollection.getCollection().size(), 0);
    }

}
