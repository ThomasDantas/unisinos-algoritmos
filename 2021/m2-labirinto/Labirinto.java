import java.io.*;

public class Labirinto {
  public char posicoes[][];

  public Labirinto (){
    this.posicoes = new char[0][0];
  }

  public char[][] carregaLabirinto(String fileName) {
    String filename = fileName;
    try {
      FileReader fr = new FileReader(filename);
      BufferedReader in = new BufferedReader(fr);
      long L = in.lines().count();

			fr = new FileReader(filename);
			in = new BufferedReader(fr);

      String line = in.readLine();
      int C = line.length();
      
      posicoes = new char[(int) (L)][C];

      int linha = 0;
      while (line != null) {
        for(int coluna = 0; coluna < line.length(); coluna++){	
          char caracter = line.charAt(coluna);
          posicoes[linha][coluna] = caracter;
        }
        linha++;
        line = in.readLine();
      }
      System.out.println(linha);
      System.out.println(C);
      for (int l = 0; l < posicoes.length; l++) {
       for (int c = 0; c < C; c++) {
          System.out.print(posicoes[l][c]);
        }
        System.out.println();
      }
      in.close();
      
      return posicoes;
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo \""+filename+"\" não existe.");
    } catch (IOException e) {
      System.out.println("Erro na leitura de " + filename+".");
    }
    return posicoes;
  }
}