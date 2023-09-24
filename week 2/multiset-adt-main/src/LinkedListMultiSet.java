public class LinkedListMultiSet<T> {
    public Node<T> front;
    public int size;

    public LinkedListMultiSet() {
        front = null;
        size = 0;
    }

    public boolean add(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = front;
        this.front = newNode;
        size += 1;
        return true;
    }

    public void remove(T item) {
        Node<T> cur = front;
        Node<T> prev = null;
        while (cur != null) {
            if (cur.item == item) {
                size -= 1;
                if (prev) {
                    prev.next = cur.next;
                } else {
                    // first item
                    front = cur.next;
                }
                return;
            }
            Node<T> oldCur = cur;
            cur = cur.next;
            prev = oldCur;

        }
        // If here, item not found
        return;
    }

    public boolean contains(T item) {
        Node<T> cur = front;
        while (cur != null) {
            if (cur.item == item) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean is_empty() {
        return front == null;

    }

    public int count(T item) {
        int num_seen = 0;
        Node<T> cur = front;
        while (cur != null) {
            if (cur.item == item) {
                num_seen += 1;
            }
            cur = cur.next;
        }
        return num_seen;
    }

    public int size() {
        return size;
    }
}