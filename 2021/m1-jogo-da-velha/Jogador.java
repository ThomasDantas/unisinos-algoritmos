public class Jogador {
  private String nome;
  private int pontos;
  private char caracter;


  public Jogador (String n, char c){
    this.nome = n;
    this.caracter = c;
    this.pontos = 0;
  }

  public String getNome(){
    return nome;
  }
 
  public int getPontos(){
    return pontos;
  }

  public char getCaracter(){
    return caracter;
  }

  public void setPontos(){
    this.pontos = this.pontos + 1;
  }
 
}
