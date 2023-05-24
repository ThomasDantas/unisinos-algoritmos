public class Principal {
  
  public static void main(String args[]) {
    System.out.println("-----------------------------------------------------------");
    int op;
    String result = "continue";
    String vencedor;
    Jogador p1;
    Jogador p2;

    System.out.println("\nCadastro de jogadores:");
    p1 = new Jogador(Teclado.leString("Insira o nome do primeiro jogador: "), 'X');
    p2 = new Jogador(Teclado.leString("Insira o nome do segundo jogador: "), 'O');

    do {
      System.out.println("\n1 => Iniciar Jogo da Velha \n0 => Resultado ");
      op = Teclado.leInt("\nInforme a opção: ");
      
      switch (op) {
        case 1:
            System.out.println("\nDimensoes do tabuleiro");
            JogoDaVelha jogo = new JogoDaVelha(Teclado.leInt("Insira o tamanho do tabuleiro: "));

            System.out.println("\nHora de jogar:");
            jogo.toString();

            while (result.equals("continue")) {
              vencedor = executaJogada(p1, p1.getCaracter(), jogo);
              if(vencedor.equals("vitoria")){
                p1.setPontos();
                break;
              } else if (vencedor.equals("empate")){
                break;
              }
              
              vencedor = executaJogada(p2, p2.getCaracter(), jogo);
              if(vencedor.equals("vitoria")){
                p2.setPontos();
                break;
              } else if (vencedor.equals("empate")){
                break;
              }
            }
            break;
        default:
          if(p1.getPontos() > p2.getPontos()){
            System.out.println(p1.getNome() +" venceu" + " | " + "Pontos: " +p1.getPontos());
            System.out.println(p2.getNome() +" perdeu" + " | " + "Pontos: " +p2.getPontos());
          } else if(p2.getPontos() > p1.getPontos()){
            System.out.println(p2.getNome() +" venceu" + " | " + "Pontos: " +p2.getPontos());
            System.out.println(p1.getNome() +" perdeu" + " | " + "Pontos: " +p1.getPontos());
          } else{
            System.out.println("\nEmpate entre os jogadores");
            System.out.println(p1.getNome() + " | " + "- Pontos: " + p1.getPontos());
            System.out.println(p2.getNome() + " | " + "- Pontos: " + p2.getPontos());
          }
          System.out.println("\nEncerrando jogo");
      }
    } while (op != 0);
  }
  
  public static String executaJogada(Jogador player, char caracter, JogoDaVelha jogo){
    System.out.println("\nSua vez, " + player.getNome());
    int coluna = Teclado.leInt("Coluna: ");
    int linha = Teclado.leInt("Linha: ");
    boolean jogada = jogo.realizaJogada(linha, coluna, player.getCaracter());
    int ganhador = jogo.verificaGanhador();
    if(ganhador == 1){
      System.out.println("\n" + player.getNome() + " venceu!!");
      jogo.toString();
      return "vitoria";
    }
    if(ganhador == 2){
      System.out.println("\nEmpate...");
      jogo.toString();
      return "empate";
    }
    if (!jogada) {
      System.out.println("Jogada invalida, tente novamente...");
      executaJogada(player, caracter, jogo);
    }
    jogo.toString();
    return "continua";
  }
}
