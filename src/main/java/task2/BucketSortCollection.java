package task2;

import java.util.*;

public class BucketSortCollection<T extends Number> implements BucketSort<T> {

    private final Vector<TreeMap<T, Integer>> collection;

    public BucketSortCollection() {
        this.collection = new Vector<TreeMap<T, Integer>>();
    }

    private Integer countHashVal(T value, int maxVal, int minVal) {
        return  ((Integer) value - minVal) * collection.size() / (maxVal + 1 - minVal);
    }

    public void sort(T[] array) {
        if (array != null) {
            int maxVal = Integer.MIN_VALUE;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                collection.add(new TreeMap<T, Integer>());
                if ((Integer) array[i] > maxVal) {
                    maxVal = (Integer) array[i];
                }
                if ((Integer) array[i] < minVal) {
                    minVal = (Integer) array[i];
                }
            }
            if (minVal == maxVal) {
                return;
            }
            for (T t : array) {
                int index = countHashVal(t, maxVal, minVal);
                TreeMap<T, Integer> map = collection.get(index);
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 1);
                }

            }
            int idx = 0;
            for (TreeMap<T, Integer> ts : collection) {
                for (T t: ts.keySet()) {
                    Integer iterNum = ts.get(t);
                    for (int i = 0; i < iterNum; i++) {
                        array[idx] = t;
                        idx++;
                    }

                }
            }
            collection.clear();
        }
    }

    public Vector<TreeMap<T, Integer>> getCollection() {
        return collection;
    }
}
