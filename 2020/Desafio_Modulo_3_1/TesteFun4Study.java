public class TesteFun4Study {
    public static void main(String args[]) {

        int op;
        int opEstudante = 1;
        String alteracao;

        do {
            op = Teclado.leInt("Informe a opção, 1 => criar cidade, 0 => encerrar: ");

            switch (op) {
                case 1:
                    System.out.println("\nCadastre a Cidade:\n");
                    Cidade c1 = new Cidade(Teclado.leInt("Informe o código: "),
                            Teclado.leString("Informe a descrição: "), Teclado.leString("Informe a UF: "));

                    while (opEstudante != 0) {
                        opEstudante = Teclado.leInt("Informe a opção, 1 => criar estudante, 0 => encerrar: ");

                        switch (opEstudante) {
                            case 1:
                                System.out.println("\nCadastre o Estudante:\n");
                                Estudante e1 = new Estudante(Teclado.leInt("Informe o código: "),
                                        Teclado.leString("Informe o nome: "),
                                        Teclado.leString("Informe a data de nascimento: "),
                                        Teclado.leString("Informe o email: "), Teclado.leString("Informe a senha: "),
                                        c1);

                                // Após apresentar os dados do estudante na tela, deve-se perguntar
                                // se o usuário deseja alterar algum dado do estudante criado. Em caso
                                // positivo, deve-se perguntar qual é o atributo que se deseja alterar e
                                // permitir a alteração. Após a alteração deve-se apresentar os dados do
                                // estudante atualizados;
                                alteracao = Teclado.leString("Deseja alterar algum dado do estudante? sim / nao =>");
                                if ((alteracao.equals("sim"))) {
                                    System.out.println("Opções");
                                    System.out.println("1 => Alterar nome");
                                    System.out.println("2 => Alterar codigo");
                                    System.out.println("3 => Alterar Data Nascimento");
                                    System.out.println("4 => Alterar email");
                                    System.out.println("5 => Alterar senha");
                                    System.out.println("6 => Alterar cidade");
                                    int opAlterar = Teclado.leInt("Informe a opção: ");

                                    switch (opAlterar) {
                                        case 1:
                                            String n = Teclado.leString("Nome: ");
                                            e1.setNome(n);
                                            e1.exibeDados();
                                            break;
                                        case 2:
                                            int codigo = Teclado.leInt("Codigo: ");
                                            e1.setCodigo(codigo);
                                            e1.exibeDados();
                                            break;
                                        case 3:
                                            String data = Teclado.leString("Data Nascimento: ");
                                            e1.setDataNascimento(data);
                                            e1.exibeDados();
                                            break;
                                        case 4:
                                            String e = Teclado.leString("Email: ");
                                            e1.setEmail(e);
                                            e1.exibeDados();
                                            break;
                                        case 5:
                                            /*
                                             * Para cada Estudante criado, atualize a senha. Utilize a classe: Teclado
                                             * para solicitar os dados do teclado.
                                             */
                                            System.out.println("\nAtualize os dados\n");
                                            System.out.println("Estudante:");
                                            // Atualização da senha
                                            String senhaAnterior;
                                            String novaSenha;
                                            String confirmaSenha;
                                            System.out.println("\n" + e1.getNome() + " , atualize sua senha! ");
                                            senhaAnterior = Teclado.leString("Digite a Senha Anterior: ");
                                            novaSenha = Teclado.leString("Digite a Nova Senha: ");
                                            confirmaSenha = Teclado.leString("Confirme a Nova Senha: ");

                                            if ((e1.getSenha().equals(senhaAnterior))
                                                    && (novaSenha.equals(confirmaSenha))) {
                                                e1.setSenha(confirmaSenha);
                                                System.out.println("\nSenha atualizada com sucesso!");
                                            } else {
                                                System.out.println("\nERRO: AS SENHAS NÃO CONFEREM!");
                                            }
                                            e1.exibeDados();
                                            break;
                                        case 6:
                                            Cidade c = new Cidade(Teclado.leInt("Informe o código: "),
                                                    Teclado.leString("Informe a descrição: "),
                                                    Teclado.leString("Informe a UF: "));
                                            e1.setCidade(c);
                                            e1.exibeDados();
                                            break;
                                        default:
                                            System.out.println("Encerrando alterações!");
                                    }
                                }
                                break;
                            default:
                                if (c1.getEstudantes() < 4) {
                                    System.out.println("devem ser criados no minimo 4 estudantes");
                                    opEstudante = 1;
                                } else {
                                    System.out.println("encerrando a criação de estudantes!");
                                }
                        }
                    }

                    System.out.println("Cidade:\n");
                    c1.exibeDados();
                    break;
                default:
                    System.out.println("encerrando a criação de cidades!");
            }
        } while (op != 0);
    }

}