package task2;

import java.util.*;

public class BucketSortCollection<T extends Number> implements BucketSort<T> {

    private final Integer maxVal = 1024;
    private final Vector<TreeMap<T, Integer>> collection;

    public BucketSortCollection() {
        this.collection = new Vector<TreeMap<T, Integer>>();
    }

    private Integer countHashVal(T value) {
        return  Math.abs((Integer) value) * collection.size() / maxVal;
    }

    public void sort(T[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                collection.add(new TreeMap<T, Integer>());
            }
            for (T t : array) {
                if ((maxVal <= (Integer) t) || ((Integer) t < 0)) {
                    System.err.println("Поддерживаются лишь числа в указанном диапазоне: от 0 до " + maxVal);
                    collection.clear();
                    return;
                }
                int index = countHashVal(t);
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
