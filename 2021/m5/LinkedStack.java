public class LinkedStack<E> implements Stack<E> {
  private Node<E> head;
  private Node<E> tail;
  private int numElements;

  public LinkedStack() {
    this.head = null;
    this.tail = null;
    this.numElements = 0;
  }

  public int numElements() {
    return numElements;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(E element) {
    Node<E> newNode = new Node<>(element);
    if (isEmpty())
      head = tail = newNode;
    else {
      newNode.setNext(head);
      head = newNode;
    }
    numElements++;
  }

  public void printList() {
    Node<E> currNode = head;

    while (currNode != null) {
      System.out.print(currNode.element + " ");
      currNode = currNode.next;
    }
  }
}
