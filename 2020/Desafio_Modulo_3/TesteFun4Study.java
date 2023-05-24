public class TesteFun4Study {
    public static void main(String args[]) {
        Estudante e1, e2;
        Cidade c1, c2;

        System.out.println("=====================ESTUDANTE 1============================");
        // ESTUDANTE 1
        int cod = Teclado.leInt("Codigo Estudante: ");
        String n = Teclado.leString("Nome: ");
        String data = Teclado.leString("Data Nascimento: ");
        String e = Teclado.leString("Email: ");
        String s = Teclado.leString("Senha: ");

        // Cidade Estudante 1
        int c = Teclado.leInt("Codigo cidade: ");
        String d = Teclado.leString("descricao: ");
        String distrito = Teclado.leString("UF: ");

        c1 = new Cidade(c, d, distrito);
        e1 = new Estudante(cod, n, data, e, s, c1);

        System.out.println("ATUALIZAR SENHA DO ESTUDANTE: ");
        // Atualizar Senha
        String oldSenha = Teclado.leString("Digite a senha anteriormente criada: ");
        String senhaCriada = e1.getSenha();
        String newSenha = Teclado.leString("Digite a nova senha: ");
        String rptSenha = Teclado.leString("Digite novamente a senha: ");

        // equals comparar o valor, sendo senhaCriada retorno do objeto e1
        if (oldSenha.equals(senhaCriada)) {
            if (newSenha.equals(rptSenha)) {
                e1.setSenha(newSenha);
            } else {
                System.out.println("As senhas não batem, por favor digite as duas iguais");
            }
        } else {
            System.out.println("Senha está incorreta");
        }


        System.out.println("=====================ESTUDANTE2============================");
        // ESTUDANTE 2
        int cod2 = Teclado.leInt("Codigo Estudante 2: ");
        String n2 = Teclado.leString("Nome: ");
        String data2 = Teclado.leString("Data Nascimento: ");
        String em2 = Teclado.leString("Email: ");
        String s2 = Teclado.leString("Senha: ");

        // Cidade Estudante 2
        int codC2 = Teclado.leInt("Codigo cidade: ");
        String d2 = Teclado.leString("descricao: ");
        String distrito2 = Teclado.leString("UF: ");

        c2 = new Cidade(codC2, d2, distrito2);
        e2 = new Estudante(cod2, n2, data2, em2, s2, c2);
        
        System.out.println("ATUALIZAR SENHA DO ESTUDANTE: ");
        // Atualizar Senha
        String oldSenha2 = Teclado.leString("Digite a senha anteriormente criada: ");
        String senhaCriada2 = e2.getSenha();
        String newSenha2 = Teclado.leString("Digite a nova senha: ");
        String rptSenha2 = Teclado.leString("Digite novamente a senha: ");

        if (oldSenha2.equals(senhaCriada2)) {
            if (newSenha2.equals(rptSenha2)) {
                e2.setSenha(newSenha2);
            } else {
                System.out.println("As senhas não batem, por favor digite as duas iguais");
            }
        } else {
            System.out.println("Senha está incorreta");
        }

        
        System.out.println("---DADOS ESTUDANTE 1---- ");
        e1.exibeDados();

        System.out.println("---DADOS ESTUDANTE 2---- ");
        e2.exibeDados();
    }

}