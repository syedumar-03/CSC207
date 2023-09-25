public interface MultiSet<T> {
    /*
     * interface representing MultiSet ADT, which supports the add, remove,
     * is_empty,
     * count, and contains operations.
     * 
     */
    public boolean add(T item);

    public void remove(T item);

    public boolean contains(T item);

    public boolean is_empty();

    public int count(T item);

    public int size();
}