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

    @Override
    public void remove(T item) {
        tree.delete_item(item);

    }

    @Override
    public boolean contains(T item) {
        return tree.contains(item);
    }

    @Override
    public boolean is_empty() {
        return tree.is_empty();
    }

    @Override
    public int count(T item) {
        return (int) tree.count(item);
    }

    @Override
    public int size() {
        return tree.size();
    }
}
