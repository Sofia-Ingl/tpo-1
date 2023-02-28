import task1.ArcCos;
import task2.BucketSortCollection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        double a = ArcCos.arccos(-1);
//        double b = ArcCos.arccos(1);
//        double c = ArcCos.arccos(0);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        Integer[] arr = new Integer[]{436, -900, 876, 866, 876, 640, 756, 625, 337, 815, 649, 235};
        BucketSortCollection<Integer> sortingCol = new BucketSortCollection<Integer>();
        sortingCol.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
