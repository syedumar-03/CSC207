import java.util.ArrayList;

public class TreeMultiSet<T> extends MultiSet<T>{
    private Tree<T> tree;

    public TreeMultiSet() {
        tree = new Tree<>(null, new ArrayList<>());
    }

    @Override
    public boolean add(T item) {
        tree.insert(item);
        return true;
    }

    public void remove(T item) {
        tree.delete_item(item);

    }

    public boolean contains(T item) {
        return tree.contains(item);
    }

    public boolean is_empty() {
        return tree.is_empty();
    }

    public int count(T item) {
        return (int) tree.count(item);

    }

    public int size() {
        return tree.size();
    }


}
