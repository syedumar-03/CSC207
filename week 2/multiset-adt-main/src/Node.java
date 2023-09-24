public class Node<T> {
    /*
     * Internal node structure used by the LinkedListMultiSet above.
     */

    public T item;
    public Node<T> next;

    public Node(T _item) {
        item = _item;
        next = null;
    }
}