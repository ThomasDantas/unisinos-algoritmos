public class DesafioModulo5 {

  public static void main(String args[]) {
    System.out.println("-------------------QUESTAO 1-----------------------------------");
    LinkedStack<String> pilha = new LinkedStack<String>();
    String[] brackets = { "(", "(", "A", "+", "B", ")", ")" };
    for (String i : brackets) {
      pilha.push(i);
    }
    System.out.print("Pilha -> ");
    pilha.printList();
    System.out.println();

    System.out.print("Num Elements -> " + pilha.numElements());
    System.out.println();

    System.out.println("-------------------QUESTAO 2-----------------------------------");
    LinkedQueue<String> queue = new LinkedQueue<String>();
    try {
      for (int i = 0; i < 10; i++)
        queue.insert("numeros" + i * 2, i);
      System.out.println("Queue -> " + queue.printList());
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }
}