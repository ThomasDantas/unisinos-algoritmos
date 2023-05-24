public class Principal {

  public static void main(String args[]) throws Exception {
    System.out.println("-----------------------------------------------------------");
    int op;
    BinaryTree bTree = new BinaryTree();

    System.out.println("\nARVORE AVL:");
    do {
      System.out.println("\n\n###########################################################");
      int num;
      System.out.println(
          "1 => Inserir\n2 => Buscar\n3 => Excluir\n0 => Sair ");
      op = Teclado.leInt("\nInforme a opção: ");
      switch (op) {
        case 1:
          num = Teclado.leInt("Numero: ");
          System.out.println();
          bTree.insert(num);
          System.out.println("\nroot: " + bTree.getRoot() + "\n");
          bTree.viewBinaryTree();
          break;
        case 2:
          num = Teclado.leInt("Numero: ");
          System.out.println();
          System.out.println(bTree.searchNumber(num) + "\n");
          bTree.viewBinaryTree();
          break;
        case 3:
          num = Teclado.leInt("Numero: ");
          System.out.println();
          bTree.deleteNum(num);
          System.out.println("root: " + bTree.getRoot() + "\n");
          bTree.viewBinaryTree();
          break;
        default:
          System.out.println("\nEncerrando...");
          break;
      }
    } while (op != 0);
  }
}
