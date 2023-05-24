public class Estudante {
   // atributos da classe
   private int codigo;
   private String nome;
   private String dataNascimento;
   private String email;
   private String senha;
   private Cidade cidade;

   // costrutor da classe
   public Estudante(int cod, String n, String data, String e, String s, Cidade c) {
      codigo = cod;
      nome = n;
      dataNascimento = data;
      email = e;
      senha = s;
      cidade = c;
      cidade.adicionaNovoEstudante();
   }

   // retornar código
   public int getCodigo() {
      return codigo;
   }

   // retornar nome
   public String getNome() {
      return nome;
   }

   // retornar dataNascimento
   public String getDataNascimento() {
      return dataNascimento;
   }

   // retornar email
   public String getEmail() {
      return email;
   }

   // retornar senha
   public String getSenha() {
      return senha;
   }

   // retornar cidade
   public Cidade getCidade() {
      return cidade;
   }

   // modifica/alterar/setar codigo
   public void setCodigo(int cod) {
      this.codigo = cod;
   }
   
   
   // modifica/alterar/setar nome
   public void setNome(String n) {
      this.nome = n;
   }

   // modifica/alterar/setar dataNascimento
   public void setDataNascimento(String d) {
      this.dataNascimento = d;
   }

   // modifica/alterar/setar email
   public void setEmail(String e) {
      this.email = e;
   }

   // modifica/alterar/setar senha
   public void setSenha(String s) {
      this.senha = s;
   }

   // modifica/alterar/setar cidade
   public void setCidade(Cidade c) {
      this.cidade = c;
   }


   public void exibeDados() {
      System.out.println("Codigo Estudante: " + codigo);
      System.out.println("Nome: " + nome);
      System.out.println("Data de Nascimento: " + dataNascimento);
      System.out.println("Email: " + email);
      System.out.println("Senha: " + senha);
      cidade.exibeDados();
   }

}
