import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Principal {

	public static void main(String[] args) {
		Estoque e = new Estoque("arquivoProdutos.txt");

		String gravaArquivo = "";
		
		Produto[] produtos = e.getProdutos();
		
		//alimento mais caro
		gravaArquivo += "Informações do alimento mais caro:\n";
		int posicaoAlimentoMaisCaro = -1;

		//encontra a posicao do primeiro produto do tipo Alimento
		for(int i=0; i<produtos.length; i++)
			if(produtos[i] instanceof Alimento){
				posicaoAlimentoMaisCaro = i;
				break;
			}

		//procura o alimento mais caro
		if(posicaoAlimentoMaisCaro == -1)
			gravaArquivo += "[Não existem alimentos no estoque]\n";
		else{
			for(int i=posicaoAlimentoMaisCaro+1; i<produtos.length; i++)
				if(produtos[i] instanceof Alimento)
					if(produtos[i].getPreco() > produtos[posicaoAlimentoMaisCaro].getPreco())
						posicaoAlimentoMaisCaro = i;
			gravaArquivo += produtos[posicaoAlimentoMaisCaro]+"\n";
		}

		//eletrodomestico mais barato

		gravaArquivo += "\nInformações do eletrodoméstico mais barato:\n";
		int posicaoEletrodomesticoMaisBarato = -1;

		//encontra a posicao do primeiro produto do tipo Eletrodomestico
		for(int i=0; i<produtos.length; i++)
			if(produtos[i] instanceof Eletrodomestico){
				posicaoEletrodomesticoMaisBarato = i;
				break;
			}

		//procura o eletrodomestico mais barato
		if(posicaoEletrodomesticoMaisBarato == -1)
			gravaArquivo += "[Não existem eletrodomésticos no estoque]\n";
		else{
			for(int i=posicaoEletrodomesticoMaisBarato+1; i<produtos.length; i++)
				if(produtos[i] instanceof Eletrodomestico)
					if(produtos[i].getPreco() < produtos[posicaoEletrodomesticoMaisBarato].getPreco())
						posicaoEletrodomesticoMaisBarato = i;
			gravaArquivo += produtos[posicaoEletrodomesticoMaisBarato]+"\n";
		}
		
		//o nome e a quantidade em estoque de todos os produtos de vestuário
		gravaArquivo += "\nNome e quantidade em estoque de todos os produtos de vestuário:\n";
		for(int i=0; i<produtos.length; i++)
			if(produtos[i] instanceof Vestuario)
				gravaArquivo += produtos[i].getNome()+" | Quantidade em estoque: "+((Vestuario)produtos[i]).getQuantidadeEstoque()+"\n";
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			 fw = new FileWriter("info.txt");
			 pw = new PrintWriter(fw);
			 
			 pw.write(gravaArquivo);
			 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			pw.close();
		}
	}
}
