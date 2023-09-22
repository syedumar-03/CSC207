import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    /*
     * A recursive tree data structure, which provides services required of the
     * MultiSet ADT. See TreeMultiSet, which is the next class defined.
     * 
     * This is a simplified version of the Tree data structure
     * adapted from CSC148.
     */
    // === Private Attributes ===
    // The item stored at this tree's root, or None if the tree is empty.
    // _root: Optional[Any]
    // The list of all subtrees of this tree.
    // _subtrees: list[Tree]

    // === Representation Invariants ===
    // - If self._root is None then self._subtrees is an empty list.
    // This setting of attributes represents an empty tree.
    //
    // Note: self._subtrees may be empty when self._root is not None.
    // This setting of attributes represents a tree consisting of just one
    // node.
    private T _root;
    private List<Tree<T>> _subtrees;

    public Tree(T _root, List<Tree<T>> _subtrees) {
        if (_subtrees == null) {
            _subtrees = new ArrayList<>();
        } else {
            _subtrees = new ArrayList<>(_subtrees);
        }
    }


    private boolean is_empty() {
        /*Return whether this tree is empty.

        >>> t1 = Tree(None, [])
        >>> t1.is_empty()
        True
        >>> t2 = Tree(3, [])
        >>> t2.is_empty()
        False
        */
        return _root == null;
//        return !_root.isPresent();
        }


    private int size() {
            /*Return the
        number of items contained in this tree.

        >>> t1 = Tree(None, [])
        >>> len(t1)
        0
        >>> t2 = Tree(3, [Tree(4, []), Tree(1, [])])
        >>> len(t2)
        3
        */
        if (is_empty()) {
            return 0;
        }
        else {
            int length = 1;
            // count the root
            for (Tree<T> x : _subtrees) {
                length += x.size();
//            #could also do len(subtree) here
            }
            return length;
        }
        }


    private double count(T item) {
        /*
        Return the number of occurrences of <item> in this tree.

        >>> t = Tree(3, [Tree(4, []), Tree(1, [])])
        >>> t.count(3)
        1
        >>> t.count(100)
        0
        */
        if (is_empty()) {
            return 0;
        }
        else {
            int num = 0;
            if (_root == item) {
                num += 1;
            }
            for (Tree<T> subtree : _subtrees ){
                num += (int) subtree.count(item);
            }
            return num;
        }
    }

    public String toString() {
            /* Return a
         string representation of this tree.

        For each node, its item is printed before any of its
        descendants' items. The output is nicely indented.

        You may find this method helpful for debugging.
        */
            return indentedString(0);
        }

    private String indentedString(int depth){
        /* Return an indented string representation of this tree.

        The indentation level is specified by the <depth> parameter.
        */
            if (is_empty()) {
                return " ";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("  ".repeat(depth)).append(_root).append("\n");
                for (Tree<T> x : _subtrees) {
//                Note that the 'depth' argument to the recursive call is
//                modified.
                    sb.append(x.indentedString(depth + 1));
                }
                return sb.toString();
            }
        }

    public double average() {
            /* Return the
         average of all the values in this tree.

        Return 0.0 if this tree is empty.

        Precondition: this is a tree of numbers.

        >>> Tree(None, []).average()
        0.0
        >>> t = Tree(13, [Tree(2, []), Tree(6, [])])
        >>> t.average()
        7.0
        >>> lt = Tree(2, [Tree(4, []), Tree(5, [])])
        >>> rt = Tree(3, [Tree(6, []), Tree(7, []), Tree(8, []), Tree(9, []),\
                          Tree(10, [])])
        >>> t = Tree(1, [lt, rt])
        >>> t.average()
        5.5
        */
            if (is_empty()) {
                return 0.0;
            } else {
                int[] result = average_helper();
                return (double) result[0] / result[1];
            }
        }

    private int[] average_helper() {
        /*Return a tuple (x,y) where:

        x is the total values in this tree, and
        y is the size of this tree.

        >>> lt = Tree(2, [Tree(4, []), Tree(5, [])])
        >>> rt = Tree(3, [Tree(6, []), Tree(7, []), Tree(8, []), Tree(9, []),\
                          Tree(10, [])])
        >>> t = Tree(1, [lt, rt])
        >>> t._average_helper()
        (55, 10)
        */
            if (is_empty()) {
                return new int[]{0,0};
            } else {
                int total = (Integer) _root;
                int size = 1;
                for (Tree<T> x : _subtrees) {
                    int[] subtreeResult = x.average_helper();
                    total += subtreeResult[0];
                    size += subtreeResult[1];
                }
                return new int[]{total, size};
            }
        }

    public boolean equals(Object other) {
                /* Return whether
         <self> and <other> are equal.
        */
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Tree<?> other_tree = (Tree<?>) other;
        if (is_empty() && other_tree.is_empty()) {
            return true;
        } else if (is_empty() || other_tree.is_empty()) {
            return false;
        } else if (!_root.equals(other_tree._root) || _subtrees.size() != other_tree._subtrees.size()) {
            return false;
        }
        for (int i = 0; i < _subtrees.size(); i++) {
            if (!_subtrees.get(i).equals(other_tree._subtrees.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(T item) {
                /* Return whether
         <item> is in this tree.

        >>> t = Tree(1, [Tree(2, []), Tree(5, [])])
        >>> 1 in t  # Same as t.__contains__(1)
        True
        >>> 5 in t
        True
        >>> 4 in t
        False
        */
        if (this.is_empty()) {
            return false;
        }
//        item may in root, or subtrees
        if (_root.equals(item)) {
            return true;
        } else {
            for (Tree<T> x : _subtrees) {
                if (x.contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<T> leaves() {
        if (is_empty()) {
            return new ArrayList<>();
        }
        List<T> leaf_list = new ArrayList<>();
        if (_subtrees.isEmpty()) {
            leaf_list.add(_root);
        } else {
            for (Tree<T> x : _subtrees) {
                leaf_list.addAll(x.leaves());
            }
        }
        return leaf_list;
    }


//    # -------------------------------------------------------------------------
//    # Mutating methods
//    # ------------------------------------------------------------------------
        public boolean delete_item(T item){
                /* Delete *one* occurrence of the given item from this tree.

        Return True if <item> was deleted, and False otherwise.
        Do not modify this tree if it does not contain <item>.

        >>> Tree(None, []).delete_item(99)
        False
        >>> lt = Tree(2, [Tree(4, []), Tree(5, [])])
        >>> rt = Tree(3, [Tree(6, []), \
                          Tree(7, []), \
                          Tree(8, []), \
                          Tree(9, []), \
                          Tree(10, [Tree(11, [Tree(13, []), Tree(14, [])]), \
                                    Tree(12, [])])])
        >>> t = Tree(1, [lt, rt])
        >>> t.delete_item(99)
        False
        >>> t.delete_item(3)
        True
        >>> 3 in t
        False
        */
            if (is_empty()){
                return false;
            } else if (_root.equals(item)){
                delete_root();
                return true;
            } else {
                for (int i = 0; i< _subtrees.size(); i++){
                    Tree <T> subtree = _subtrees.get(i);
                    if (subtree.delete_item(item)) {
                        _subtrees.remove(i);
                    }
                    return true;
                }
            }
            return false;
        }

    private void delete_root() {
                /* Remove the root item of this tree.

        Precondition: this tree has at least one subtree.
        */
        if (_subtrees.isEmpty()){
//            #This is a leaf.Deleting the root gives and empty tree
            _root = null;
        } else {
//            #Get the last subtree in this tree.
                    Tree<T> chosen_subtree = _subtrees.remove(_subtrees.size() - 1);
                    _root = chosen_subtree._root;
                    _subtrees.addAll(chosen_subtree._subtrees);

//            #Strategy 2:Replace with a leaf.
//            #1. Extract the leftmost leaf (using another helper).
//            #leaf = self._extract_leaf()
//            #
//            #2. Update self._root. (Note that self._subtrees remains the same.)
//            #self._root = leaf
                }
            }

    private T extract_leaf() {
        /*Remove and return the leftmost leaf in a tree.

        Precondition: this tree is non-empty.
        */
        if (is_empty()) {
            return null;
        }
        if (_subtrees.isEmpty()) {
            T leaf_value = _root;
            _root = null;
            return leaf_value;
        }
        T leaf_value = _subtrees.get(0).extract_leaf();
        if (_subtrees.get(0).is_empty()) {
            _subtrees.remove(0);
        }
        return leaf_value;
    }

    public void insert(T item){
        /* Insert <item> into this tree using the following algorithm.

            1. If the tree is empty, <item> is the new root of the tree.
            2. If the tree has a root but no subtrees, create a
               new tree containing the item, and make this new tree a subtree
               of the original tree.
            3. Otherwise, pick a random number between 1 and 3 inclusive.
                - If the random number is 3, create a new tree containing
                  the item, and make this new tree a subtree of the original.
                - If the random number is a 1 or 2, pick one of the existing
                  subtrees at random, and *recursively insert* the new item
                  into that subtree.

        >>> t = Tree(None, [])
        >>> t.insert(1)
        >>> 1 in t
        True
        >>> lt = Tree(2, [Tree(4, []), Tree(5, [])])
        >>> rt = Tree(3, [Tree(6, []), Tree(7, []), Tree(8, []), Tree(9, []),\
                          Tree(10, [])])
        >>> t = Tree(1, [lt, rt])
        >>> t.insert(100)
        >>> 100 in t
        True
        */
        if (_subtrees.isEmpty()){
            _root = null;
        } else {
            Tree<T> chosen_subtree = _subtrees.remove(_subtrees.size() - 1);
            _root = chosen_subtree._root;
            _subtrees.addAll(chosen_subtree._subtrees);
        }
     }

    public boolean insert_child(T item, T parent) {
                /* Insert <item> into this tree as a child of <parent>.

        If successful, return True. If <parent> is not in this tree,
        return False.

        If <parent> appears more than once in this tree, <item> should only
        be inserted

    once (you can pick where to insert it).
        */
        if (is_empty()) {
            return false;
        }
        if (_root.equals(parent)) {
            _subtrees.add(new Tree<>(item, new ArrayList<>()));
            return true;
        }
        for (Tree<T> x : _subtrees) {
            if (x.insert_child(item, parent)) {
                return true;
            }
        }
        return false;
    }

}