import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiSet<T> implements MultiSet<T> {
    private List<T> list;

    public ArrayListMultiSet() {
        list = new ArrayList<>();
    }

    public boolean add(T item) {
        list.add(item);
        return true;
    }

    public void remove(T item) {
        if (list.contains(item)) {
            list.remove(item);
        }

    }

    public boolean contains(T item) {
        return list.contains(item);
    }

    public boolean is_empty() {
        return list.isEmpty();
    }

    public int count(T item) {
        int count = 0;
        for (T x : list) {
            if (x.equals(item)) {
                count += 1;
            }
        }
        return count;
    }

    public int size() {
        return list.size();
    }
}