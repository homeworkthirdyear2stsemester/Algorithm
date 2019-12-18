public interface Sort<E extends Comparable<E>> {
    public static final boolean ASCENDING_ORDER = true;
    public static final boolean DESCENDING_ORDER = false;

    public void sort(E[] array);
}
