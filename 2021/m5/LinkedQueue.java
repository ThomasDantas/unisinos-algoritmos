public class LinkedQueue<E> implements Queue<E> {
  private Node<E> head;
  private Node<E> tail;
  private int numElements;

  public LinkedQueue() {
    this.head = null;
    this.tail = null;
    this.numElements = 0;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertFirst(E element) throws NullPointerException {
    if (element == null)
      throw new NullPointerException();
    Node<E> newNode = new Node<>(element);
    if (isEmpty())
      head = tail = newNode;
    else {
      newNode.setNext(head);
      head = newNode;
    }
    numElements++;
  }

  public void insertLast(E element) throws NullPointerException {
    if (element == null)
      throw new NullPointerException();
    Node<E> newNode = new Node<>(element);
    if (isEmpty())
      head = tail = newNode;
    else {
      tail.setNext(newNode);
      tail = newNode;
    }
    numElements++;
  }

  public void insert(E element, int pos) throws NullPointerException, IndexOutOfBoundsException {
    if (element == null)
      throw new NullPointerException();
    if (pos < 0 || pos > numElements)
      throw new IndexOutOfBoundsException();
    if (pos == 0)
      insertFirst(element);
    else if (pos == numElements)
      insertLast(element);
    else {
      Node<E> current = head;
      for (int i = 0; i < pos - 1; i++)
        current = current.getNext();
      Node<E> newNode = new Node<>(element);
      newNode.setNext(current.getNext());
      current.setNext(newNode);
      numElements++;
    }
  }

  public String printList() {
    String s = "";
    Node<E> current = head;
    while (current != null) {
      s += current.getElement().toString() + " - ";
      current = current.getNext();
    }
    return s;
  }
}
