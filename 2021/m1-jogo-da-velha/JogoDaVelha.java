public class JogoDaVelha {
  public char tabuleiro[][];

  public JogoDaVelha (int d){
    this.tabuleiro = new char[d][d];
    // for (int i = 0; i < d; i++) {
		// 	for (int j = 0; j < d; j++) {
		// 		tabuleiro[i][j] = 0;
		// 	}
		// }
  }

  public char[][] getTabuleiro() {
    return tabuleiro;
  }


  public boolean realizaJogada(int linha, int coluna, char caracter){
    if ((linha < 0) || (linha > 2)) {
			return false;
		}
		if ((coluna < 0) || (coluna > 2)) {
			return false;
		}
		if (tabuleiro[linha][coluna] != 0) {
			return false;
		}
		tabuleiro[linha][coluna] = caracter;
		return true;
  }

  public int verificaGanhador(){
    for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
			if ((tabuleiro[coluna][0] == tabuleiro[coluna][1]) && (tabuleiro[coluna][0] == tabuleiro[coluna][2])) {
				if (tabuleiro[coluna][0] != 0) {
					return 1;
				}
			}
		}

		for (int linha = 0; linha < tabuleiro.length; linha++) {
			if ((tabuleiro[0][linha] == tabuleiro[1][linha]) && (tabuleiro[0][linha] == tabuleiro[2][linha]) && (tabuleiro[0][linha] != 0)) {
				return 1;
			}
		}

		if ((tabuleiro[0][0] == tabuleiro[1][1]) &&	(tabuleiro[0][0] == tabuleiro[2][2]) && (tabuleiro[0][0] != 0)) {
			return 1;
		}

		if ((tabuleiro[0][2] == tabuleiro[1][1]) &&	(tabuleiro[0][2] == tabuleiro[2][0]) &&	(tabuleiro[0][2] != 0)) {
			return 1;
    }

		for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
			for (int linha = 0; linha < tabuleiro.length; linha++) {
				if (tabuleiro[coluna][linha] == 0) {
					return 0;
				}
			}
		}
    return 2;
  }

  public String toString(){
      System.out.println();
      for(int linha=0 ; linha < tabuleiro.length ; linha++){
          for(int coluna=0 ; coluna < tabuleiro.length ; coluna++){
              if(tabuleiro[linha][coluna] == 'X'){
                  System.out.print(" X ");
              }
              if(tabuleiro[linha][coluna] == 'O'){
                  System.out.print(" O ");
              }
              if(tabuleiro[linha][coluna] == 0){
                  System.out.print("   ");
              }
              
              if(coluna==0 || coluna==1)
                  System.out.print("|");
          }
          System.out.println();
      }
      return null;
  }
}