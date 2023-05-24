public abstract class Produto {
	private double preco;
	private String descricao, nome;
	
	public Produto(double preco, String descricao, String nome) {
		this.preco = preco;
		this.descricao = descricao;
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
	@Override
	public String toString() {
		return "Produto [preco=" + preco + ", descricao=" + descricao + ", nome=" + nome + "]";
	}
}
