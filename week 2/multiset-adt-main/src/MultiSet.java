public abstract class MultiSet<T> {
    /*
    Abstract class representing MultiSet ADT, which supports the add, remove, is_empty,
    count, and contains operations.

    inherits Object class
     */
    public abstract boolean add(T item);
    public abstract void remove(T item);
    public abstract boolean contains(T item);
    public abstract boolean is_empty();
    public abstract int count(T item);
    public abstract int size();
}