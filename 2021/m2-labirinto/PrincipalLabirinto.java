import java.io.*;

public class PrincipalLabirinto {
  
  public static void main(String args[]) throws IOException {
    System.out.println("-----------------------------------------------------------");
    Labirinto lab = new Labirinto();

    char[][] arrayLabirinto = lab.carregaLabirinto(Teclado.leString("Insira o nome do arquivo: "));

    boolean saida = labirinto(arrayLabirinto);
    String mensagem = saida == true 
      ? "Existe um caminho para o labirinto" 
      : "Não existe um caminho para o labirinto";

    writeMensagemRetorno(mensagem);
  }

  public static boolean labirinto(char[][] array) throws IllegalArgumentException{
    if(array == null) throw new IllegalArgumentException();
    return labirinto(array, array[0].length, 0);
  }  

  private static boolean labirinto(char[][] array, int colunas, int linha){
    if(linha >= array.length) return true;
    int bloqueado = 0;
    for (int caracter = 0; caracter < colunas; caracter++) {
      if(array[linha][caracter] == ' ') bloqueado++;
    }
    if(bloqueado == 0){
      return false;
    };
    linha++;
    return labirinto(array, colunas, linha);
  }


  public static void writeMensagemRetorno(String message) throws IOException{
    try {
      File f = new File ("saidaLabirinto.txt");
      FileWriter fr = new FileWriter (f);
      PrintWriter out = new PrintWriter (fr);
      out.println (message);
      out.close();
    } catch (IOException e) {
      System.out.println ("Erro ao escrever arquivo.");
    }
    
  }
}
