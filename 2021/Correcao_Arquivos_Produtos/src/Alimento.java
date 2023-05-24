 
public class Alimento extends Produto {
	private String dataValidade;

	public Alimento(double preco, String descricao, String tipo, String dataValidade) {
		super(preco, descricao, tipo);
		this.dataValidade = dataValidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	@Override
	public String toString() {
		return "Alimento [dataValidade=" + dataValidade + ", toString()=" + super.toString() + "]";
	}
}
