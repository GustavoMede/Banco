import java.util.Scanner;

public class ClienteDados {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BancoCliente banco = new BancoCliente();

        int opcao = scanner.nextInt();

        System.out.println("Digite a opção que deseja, 1 para cadastro");

        while (opcao != 0) {

            switch (opcao) {

                case 1: { //Cadastrar novo cliente.
                    Cliente cliente = new Cliente();
                    cliente.setNome("Jose");
                    cliente.setCpf("111.222.333-44");
                    cliente.setEndereco("Rua 1 numero 0");
                    BancoCliente.adiciona(cliente);
                    break;
                }
                case 2: { //Listar todos os clientes.
                    for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
                        System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                        System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                        System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
                    }
                    break;
                }

                case 3: { //Buscar cliente pelo CPF.
                    String cpfBuscado = "111.222.333-44";
                    for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
                        if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                            System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                            System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                            System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
                        }
                    }
                    break;
                }
                case 4: { //Alterar dados do cliente pelo CPF.
                    String cpfBuscado = "111.222.333-44";
                    for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
                        if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                            System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                            System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                            System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
                            System.out.println("Alterar nome");
                            String novoNome = scanner.nextLine();
                            BancoCliente.clienteArrayList.get(i).setNome(novoNome);
                            System.out.println("Alterar CPF");
                            String novoCPF = scanner.nextLine();
                            BancoCliente.clienteArrayList.get(i).setNome(novoCPF);
                            System.out.println("Alterar endereço");
                            String novoEndereco = scanner.nextLine();
                            BancoCliente.clienteArrayList.get(i).setNome(novoEndereco);
                        }
                    }
                    break;
                }
                case 5: { //Remover cliente pelo CPF.
                    String cpfBuscado = "111.222.333-44";
                    for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
                        if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                            Cliente cliente = BancoCliente.clienteArrayList.get(i);
                            BancoCliente.clienteArrayList.remove(cliente);
                        }
                    }
                    break;
                }
                case 6: { //Cadastrando nova conta corrente.
                    String cpfBuscado = "111.222.333-44";
                    ContaCorrente contaCorrente = new ContaCorrente();
                    contaCorrente.setNumero(1);
                    contaCorrente.setSaldo(1000.1);
                    for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
                        if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                            contaCorrente.setTitular(BancoCliente.clienteArrayList.get(i));
                        }
                    }
                    BancoConta.contaCorrenteArrayList.add(contaCorrente);
                    break;
                }
                case 7: { //Listar contas correntes.
                    for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
                        System.out.println(BancoConta.contaCorrenteArrayList.get(i).getNumero());
                        System.out.println(BancoConta.contaCorrenteArrayList.get(i).getSaldo());
                        System.out.println(BancoConta.contaCorrenteArrayList.get(i).getTitular());
                    }
                    break;
                }
                case 8: { //Buscar conta corrente pelo número.
                    int numeroProcurado = 1;
                    for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
                        if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                            System.out.println(BancoConta.contaCorrenteArrayList.get(i).getNumero());
                            System.out.println(BancoConta.contaCorrenteArrayList.get(i).getSaldo());
                            System.out.println(BancoConta.contaCorrenteArrayList.get(i).getTitular());
                        }
                    }
                    break;
                }
                case 9: { //Depositar valor numa conta.
                    int numeroProcurado = 1;
                    for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
                        if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                            BancoConta.contaCorrenteArrayList.get(i).setSaldo(2000.0);
                        }
                    }
                    break;
                }
                case 10: { //Sacar valor de uma conta.
                    int numeroProcurado = 1;
                    double valorSacado = 2000.0;
                    for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
                        if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                            double saldoAtual = BancoConta.contaCorrenteArrayList.get(i).getSaldo();
                            if(saldoAtual <= valorSacado){
                                System.out.println("Não é possível sacar, dinheiro insuficiente!");
                            }else{
                                BancoConta.contaCorrenteArrayList.get(i).setSaldo(saldoAtual - valorSacado);
                            }
                        }
                    }
                    break;
                }
                case 11: { //Remover conta corrente.
                    int numeroProcurado = 1;
                    for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
                        if (((BancoConta.contaCorrenteArrayList.get(i).getNumero()) == numeroProcurado)) {
                            ContaCorrente contaCorrente = BancoConta.contaCorrenteArrayList.get(i);
                            BancoConta.contaCorrenteArrayList.remove(contaCorrente);
                        }
                    }
                }
            }
            opcao = scanner.nextInt();
        }
        System.out.println("Adeus!");
    }
}