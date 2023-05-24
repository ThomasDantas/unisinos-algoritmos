public class Metodo2<E> implements Stack<E> {
  protected int top;
  protected E[] elements;
  protected int contadorEsq = 0;
  protected int contadorDir = 0;

  public Metodo2(int maxSize) {
    elements = (E[]) new Object[maxSize];
    top = -1;
 }

  public void push(E element){
    elements[++top] = element;
  }

  public boolean checkBrackets(){
    for(int i = 0; i < elements.length; i++){
      E elemento =  elements[i];

      if(elemento.equals("(")){
        contadorEsq++;
      }else if(elemento.equals(")")){
        contadorDir++;
      }
    }
    if(contadorEsq == contadorDir) return true;
    else return false;
  }
}
