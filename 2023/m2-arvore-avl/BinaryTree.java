public class BinaryTree {
  Node node;

  public void insert(int number) throws Exception {
    node = recursiveInsert(node, number);
  }

  private Node recursiveInsert(Node node, int number) throws Exception {
    if (node == null) {
      return new Node(number);
    } else if (number < node.number) {
      System.out.println("Numero " + number + " foi inserido para Esquerda do " + node.number);
      node.left = recursiveInsert(node.left, number);
    } else if (number > node.number) {
      System.out.println("Numero " + number + " foi inserido para Direita do " + node.number);
      node.right = recursiveInsert(node.right, number);
    } else {
      throw new Exception("\nO Numero " + number + " ja existe na arvore!!!");
    }
    // checar balancemanto apos insercao
    return checkBalance(node);
  }

  private Node checkBalance(Node currentNode) {
    updateHeightNode(currentNode);
    int heigthLeft = heigth(currentNode.left);
    int heigthRigth = heigth(currentNode.right);
    int balancingFactor = heigthLeft - heigthRigth; // Fator de balanceamento
    System.out.println();
    System.out.println("Altura direita: " + heigthRigth);
    System.out.println("Altura esquerda: " + heigthLeft);
    System.out.println("Diferenca de altura: " + balancingFactor);
    // diferenca nao pode ser > 1 & < -1
    if (balancingFactor > 1) {
      if (heigth(currentNode.left.left) > heigth(currentNode.left.right)) {
        System.out.println("\nRotacao simples para direita");
        currentNode = simpleRotateRight(currentNode);
      } else {
        System.out.println("\nRotacao dupla para direita");
        currentNode = doubleRotateRight(currentNode);
      }
    } else if (balancingFactor < -1) {
      if (heigth(currentNode.right.right) > heigth(currentNode.right.left)) {
        System.out.println("\nRotacao simples para esquerda");
        currentNode = simpleRotateLeft(currentNode);
      } else {
        System.out.println("\nRotacao dupla para esquerda");
        currentNode = doubleRotateLeft(currentNode);
      }
    }
    return currentNode;
  }

  private int heigth(Node node) {
    return node == null ? -1 : node.height;
  }

  private int maxHeightBetween(int leftNodeHeight, int rightNodeHeight) {
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
  }

  private void updateHeightNode(Node node) {
    node.height = maxHeightBetween(heigth(node.left), heigth(node.right)) + 1;
  }

  private Node simpleRotateLeft(Node currentNode) {
    Node newNode = currentNode.right;
    Node AuxNode = newNode.left;
    newNode.left = currentNode;
    currentNode.right = AuxNode;
    updateHeightNode(currentNode);
    updateHeightNode(newNode);
    return newNode;
  }

  private Node simpleRotateRight(Node currentNode) {
    Node newNode = currentNode.left;
    Node AuxNode = newNode.right;
    newNode.right = currentNode;
    currentNode.left = AuxNode;
    updateHeightNode(currentNode);
    updateHeightNode(newNode);
    return newNode;
  }

  private Node doubleRotateLeft(Node currentNode) {
    currentNode.right = simpleRotateRight(currentNode.right);
    return simpleRotateLeft(currentNode);
  }

  private Node doubleRotateRight(Node currentNode) {
    currentNode.left = simpleRotateLeft(currentNode.left);
    return simpleRotateRight(currentNode);
  }

  public void deleteNum(int number) {
    node = deleteNode(node, number);
  }

  private Node deleteNode(Node node, int number) {
    if (node == null)
      return node;
    if (number < node.number) {
      node.left = deleteNode(node.left, number);
    } else if (number > node.number) {
      node.right = deleteNode(node.right, number);
    } else if (node.left == null && node.right == null) {
      node = null;
    } else if (node.left == null) {
      node = node.right;
    } else if (node.right == null) {
      node = node.left;
    } else {
      deleteNodeNumber(node);
    }
    if (node != null) {
      // checar balancemanto apos exclusao
      node = checkBalance(node);
    }
    return node;
  }

  private void deleteNodeNumber(Node node) {
    Node mostLeft = find(node.right);
    node.number = mostLeft.number;
    node.right = deleteNode(node.right, node.number);
  }

  private Node find(Node node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  public boolean searchNumber(int number) {
    boolean exists = false;
    Node auxNode = node;
    while (auxNode != null && !exists) {
      if (auxNode.number == number) {
        exists = true;
        break;
      }
      auxNode = auxNode.number < number ? auxNode.right : auxNode.left;
    }
    return exists;
  }

  public void viewBinaryTree() {
    printAllNumbers(node);
  }

  public static void printAllNumbers(Node node) {
    if (node != null) {
      printAllNumbers(node.left);
      System.out.print(node.number + " | ");
      printAllNumbers(node.right);
    }
  }

  public int getRoot() {
    return node.number;
  }
}
