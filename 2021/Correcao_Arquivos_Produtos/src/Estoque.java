import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Estoque {
	private Produto[] produtos;
	private BufferedReader br;

	public Estoque(String nomeArquivoEstoque){
		preencheEstoque(nomeArquivoEstoque);
	}
	
	public Produto[] getProdutos(){
		return produtos;
	}
	
	public void preencheEstoque(String nomeArquivo){
		try {
			FileReader fr = new FileReader(nomeArquivo);
			br = new BufferedReader(fr);

			//a seguir, duas formas de saber a quantidade de linhas do arquivo
			
			//FORMA 1: usando o método lines().count() do BufferedReader
			//CUIDAR que o arquivo é fechado, e deve ser aberto novamente
			//quando utilizarmos esta forma!
			System.out.println("COUNT: "+br.lines().count());
			
			//FORMA 2
			
			//aqui, estamos abrindo novamente em virtude 
			//do br.lines().count(), que fechou o fluxo
			fr = new FileReader(nomeArquivo);
			br = new BufferedReader(fr);
			
			int quantProdutos = 0;

			String line = br.readLine();
			while(line != null) {
				quantProdutos++;
				line = br.readLine();
			}
			
			System.out.println("QUANT PRODUTOS: "+quantProdutos);

			br.close();

			produtos = new Produto[quantProdutos-1];

			System.out.println("Quantidade de produtos no arquivo: "+produtos.length);

			//abrindo novamente para ler os produtos e prencher o estoque
			fr = new FileReader(nomeArquivo);
			br = new BufferedReader(fr);

			br.readLine(); 

			for(int i=0; i<produtos.length; i++) {
				line = br.readLine();
				String[] separada = line.split("\\s\\*\\s"); //divide por espaço * espaço
				String tipo = separada[0];
				String descricao = separada[1];
				double preco = Double.parseDouble(separada[2]);
				if(separada[3].equalsIgnoreCase("Alimento")) {
					String dataValidade = separada[4];
					produtos[i] = new Alimento(preco, descricao, tipo, dataValidade);
				}else if(separada[3].equalsIgnoreCase("Vestuario")) {
					int quantidadeEstoque = Integer.parseInt(separada[4]);
					produtos[i] = new Vestuario(preco, descricao, tipo, quantidadeEstoque);
				}else if(separada[3].equalsIgnoreCase("Eletrodomestico")) {
					double ipi = Double.parseDouble(separada[4]);
					produtos[i] = new Eletrodomestico(preco, descricao, tipo, ipi);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void imprimeEstoque() throws IllegalArgumentException{
		if(produtos == null)
			throw new IllegalArgumentException();
		for(Produto p: produtos)
			System.out.println(p);
	} 
}
