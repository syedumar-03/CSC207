public class Node {
    /*
     * Internal node structure used by the LinkedListMultiSet above.
     */

    public T item;
    public Node next;

    public Node(T _item) {
        item = _item;
        next = null;
    }
}