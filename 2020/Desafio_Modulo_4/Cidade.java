public class Cidade {
    // atributos da classe
    private int codigo;
    private String descricao;
    private String UF;
    private int qtd_estudantes;

    // costrutor da classe
    public Cidade(int c, String d, String distrito) {
        codigo = c;
        descricao = d;
        UF = distrito;
    }

    // retornar código
    public int getCodigo() {
        return codigo;
    }

    // retornar descricao
    public String getDescricao() {
        return descricao;
    }

    // retornar UF
    public String getUF() {
        return UF;
    }

    // modifica/alterar/setar Descricao
    public void setDescricao(String d) {
        this.descricao = d;
    }

    // modifica/alterar/setar UF
    public void setUF(String distrito) {
        this.UF = distrito;
    }

    public void adicionaNovoEstudante() {
        qtd_estudantes++;
    }

    // retornar estudantes
    public int getEstudantes() {
        return qtd_estudantes;
    }

    public void exibeDados() {
        System.out.println("Codigo Cidade: " + codigo);
        System.out.println("Descricao: " + descricao);
        System.out.println("UF: " + UF);
        System.out.println("Quantidade estudantes: " + qtd_estudantes);
    }

}
