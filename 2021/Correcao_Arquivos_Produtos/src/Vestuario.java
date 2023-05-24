
public class Vestuario extends Produto {
	private int quantidadeEstoque;

	public Vestuario(double preco, String descricao, String tipo, int quantidadeEstoque) {
		super(preco, descricao, tipo);
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	} 

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {
		return "Vestuario [quantidadeEstoque=" + quantidadeEstoque + ", toString()=" + super.toString() + "]";
	}
}
