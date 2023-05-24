public interface Queue<E> {
  public void insert(E element, int pos) throws NullPointerException, IndexOutOfBoundsException;

  public void insertFirst(E element) throws NullPointerException;

  public void insertLast(E element) throws NullPointerException;

  public boolean isEmpty();

  public String printList();
}
