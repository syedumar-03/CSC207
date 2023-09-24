public class TreeMultiSet extends MultiSet {
    // hamsters guinea
    // pigs shrews
    // small rats
    // mice chincillas
    // sugar gliders
    // dwarf hamsters
    // russian hamsters
    // skinny pigs
    // moles mole
    // rats star
    // nosed moles
    // squirrels muscrats

    Tree tree;

    public TreeMultiSet() {
        tree = Tree(null);
    }

    public boolean add(T item) {
        tree.insert(item);
    }

    public void remove(T item) {
        tree.delete_item(item);

    }

    public boolean contains(T item) {
        return tree.contains(item);
    }

    public boolean is_empty() {
        tree.is_empty();
    }

    public int count(T item) {
        return tree.count(item);

    }

    public int size() {
        return tree.size();
    }

}
