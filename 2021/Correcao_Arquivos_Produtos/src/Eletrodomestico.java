 
public class Eletrodomestico extends Produto {
	private double ipi;

	public Eletrodomestico(double preco, String descricao, String tipo, double ipi) {
		super(preco, descricao, tipo);
		this.ipi = ipi;
	}

	public double getIpi() {
		return ipi;
	}

	public void setIpi(double ipi) {
		this.ipi = ipi;
	}

	@Override
	public String toString() {
		return "Eletrodomestico [ipi=" + ipi + ", toString()=" + super.toString() + "]";
	}
}
