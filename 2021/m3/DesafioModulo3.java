import java.io.*;
import java.util.Arrays;

public class DesafioModulo3 {
  
  public static void main(String args[]) throws IOException {
    System.out.println("-----------------------------------------------------------");
    int[] array1 = { 8, 2, 12, 6, 22, 18 };
		int valor = 22;
    System.out.println("Array -> " + Arrays.toString(array1));

    System.out.println("Binaria => "+ busca(array1, valor));

    int[] direta = insercao(array1);
    System.out.print("Insercao Direta -> ");
    printArray(direta, direta.length);
    
    int[] selecao = selecao(array1);
    System.out.print("Selecao Direta -> ");
    printArray(selecao, selecao.length);
  }


  private static int busca(int[] array, int valor) {
    Arrays.sort(array);
		return pesquisaBinaria(array, 0, array.length - 1, valor);
	}

	private static int pesquisaBinaria(int[] array, int menor, int maior, int valor) {
		int media = (maior + menor) / 2;
		int valorMeio = array[media];

		if (menor > maior)
			return -1;
		else if(valorMeio == valor) 
			return media;
		else if (valorMeio < valor)
			return pesquisaBinaria(array, media+1, maior, valor);
		else
			return pesquisaBinaria(array, menor, media-1, valor);
	}

  private static int[] selecao(int[] array) {
		return selecaoDireta(array, array.length);
	}

  private static int[] selecaoDireta(int[] array, int lengthArray){
    int iterator,indiceMaiorValue,tmp;
    if(lengthArray > 1){
      indiceMaiorValue = 0;
      for(iterator=1; iterator < lengthArray; iterator++)
        if(array[iterator] > array[indiceMaiorValue])
          indiceMaiorValue = iterator;
        if(indiceMaiorValue != lengthArray-1){
          tmp = array[lengthArray-1];
          array[lengthArray-1] = array[indiceMaiorValue];
          array[indiceMaiorValue] = tmp;
        }
      selecaoDireta(array, lengthArray-1);
    } 
    return array;
  }

  private static int[] insercao(int[] array) {
		return insercaoDireta(array, array.length);
	}

  private static int[] insercaoDireta(int[] array, int lengthArray){
    if (lengthArray > 1){
      insercaoDireta(array, lengthArray - 1 );
      int last = array[lengthArray-1];
      int j = lengthArray-2;
      while (j >= 0 && array[j] > last){
          array[j+1] = array[j];
          j--;
      }
      array[j+1] = last;
    }
    return array;
  }

  private static void printArray(int arr[], int n){
    for (int i=0; i < n; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
