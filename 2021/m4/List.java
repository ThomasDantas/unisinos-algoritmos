public interface List<E> {
  public int contaElementos(E element) throws IllegalArgumentException;

  public void insert(E element, int pos);

  public String toString();
}
