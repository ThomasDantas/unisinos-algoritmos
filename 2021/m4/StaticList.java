public class StaticList<E> implements List<E> {
  private E[] elements;
  private int numElements;
  private int contador = 0;

  
  public StaticList(int maxSize) {
    elements = (E[])new Object[maxSize];
    numElements = 0;
  }

  public int contaElementos(E element) throws IllegalArgumentException{
   return contaElementos(element, 0, contador);
  }

  private int contaElementos(E element, int pos, int contador) {
    if(pos > this.numElements-1) 
      return contador;
    
    if(element.equals(elements[pos]))
      contador++;
    
    pos += 1;
    return contaElementos(element, pos, contador);
	}

  public void insert(E element, int pos){
    for (int i = numElements-1; i >= pos; i--)
      elements[i+1] = elements[i];
    
    elements[pos] = element;
    numElements++;
  }

  public String toString(){
    String s = "";
    for (int i = 0; i < numElements; i++)
      s += elements[i] + " ";
    return s;
  }
}
