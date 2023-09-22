import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiSet<T> extends MultiSet<T> {
    private List<T> list;

    public ArrayListMultiSet(){
        list = new ArrayList<>();
    }

    @Override
    public boolean add(T item) {
        list.add(item);
        return true;
    }

    @Override
    public void remove(T item) {
        if (list.contains(item)){
            list.remove(item);
        }

    }

    @Override
    public boolean contains(T item) {
        return list.contains(item);
    }

    @Override
    public boolean is_empty() {
        return list.isEmpty();
    }

    @Override
    public int count(T item) {
        int count = 0;
        for (T x : list){
            if (x.equals(item)){
                count += 1;
            }
        }
        return count;
    }

    @Override
    public int size() {
        return list.size();
    }
}