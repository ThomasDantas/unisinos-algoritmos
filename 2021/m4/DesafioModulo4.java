public class DesafioModulo4{
  
  public static void main(String args[]) {
    System.out.println("-------------------QUESTAO 1-----------------------------------");
    List<Integer> lista = new StaticList<Integer>(10);
    try {
      for(int i = 0; i < 10; i++) lista.insert(i*2, i);

      System.out.println("Lista -> " + lista.toString());
      System.out.println("Conta elemento -> " + lista.contaElementos(2));
  
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  
    System.out.println();
    System.out.println("-------------------QUESTAO 2-----------------------------------");
    String[] brackets = {"(", "(", "A", "+", "B", ")", ")"};
    Metodo2<String> pilha = new Metodo2<String>(brackets.length);
    for (String i : brackets) {
      pilha.push(i);
    }    
    System.out.println("Pilha -> " + pilha.checkBrackets());
  }
}