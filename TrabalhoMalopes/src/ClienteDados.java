import java.util.Scanner;

public class ClienteDados {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("----------Seja bem vindo!----------\n" +
                "Selecione alguma opção\n" +
                "1 - Cadastrar novo cliente.\n" +
                "2 - Listar todos os clientes.\n" +
                "3 - Buscar cliente pelo CPF.\n" +
                "4 - Alterar dados do cliente através do CPF.\n" +
                "5 - Remover cliente pelo CPF.\n" +
                "6 - Cadastrar nova conta corrente.\n" +
                "7 - Listar contas correntes.\n" +
                "8 - Buscar conta corrente pelo número.\n" +
                "9 - Depositar valor em conta corrente.\n" +
                "10 - Sacar valor em conta.\n" +
                "11 - Remover conta corrente por número.\n" +
                "0 - Sair do sistema.\n");

        int opcao = scanner.nextInt();

        while (opcao != 0) {

            switch (opcao) {

                case 1: { //Cadastrar novo cliente.
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    String cpf = scanner.nextLine();
                    String endereco = scanner.nextLine();
                    cadastraCliente(nome, cpf, endereco);
                    break;
                }
                case 2: { //Listar todos os clientes.
                    listaClientes();
                    break;
                }

                case 3: { //Buscar cliente pelo CPF.
                    scanner.nextLine();
                    String cpfBuscado = scanner.nextLine();
                    buscaClientePorCpf(cpfBuscado);
                    break;
                }
                case 4: { //Alterar dados do cliente pelo CPF.
                    scanner.nextLine();
                    String cpfBuscado = scanner.nextLine();
                    alterarDadosCliente(cpfBuscado, scanner);
                    break;
                }
                case 5: { //Remover cliente pelo CPF.
                    scanner.nextLine();
                    String cpfBuscado = scanner.nextLine();
                    removeClientePorCpf(cpfBuscado);
                    break;
                }
                case 6: { //Cadastrando nova conta corrente.
                    scanner.nextLine();
                    boolean teste = false;
                    String cpfBuscado = scanner.nextLine();
                    int numero = scanner.nextInt();
                    double saldo = scanner.nextDouble();
                    cadastraContaCorrente(cpfBuscado, numero, saldo, teste);
                    break;
                }
                case 7: { //Listar contas correntes.
                    listaContasCorrente();
                    break;
                }
                case 8: { //Buscar conta corrente pelo número.
                    scanner.nextLine();
                    boolean teste = false;
                    int numeroProcurado = scanner.nextInt();
                    buscaContaCorrentePorNumero(numeroProcurado, teste);
                    break;
                }
                case 9: { //Depositar valor numa conta.
                    scanner.nextLine();
                    boolean teste = false;
                    int numeroProcurado = scanner.nextInt();
                    double valorDepositado = scanner.nextDouble();
                    depositaValorConta(numeroProcurado, valorDepositado, teste);
                    break;
                }
                case 10: { //Sacar valor de uma conta.
                    scanner.nextLine();
                    boolean teste = false;
                    int numeroProcurado = scanner.nextInt();
                    double valorSacado = scanner.nextDouble();
                    sacarValorConta(numeroProcurado, valorSacado, teste);
                    break;
                }
                case 11: { //Remover conta corrente.
                    scanner.nextLine();
                    boolean teste = false;
                    int numeroProcurado = scanner.nextInt();
                    removerContaCorrente(numeroProcurado, teste);
                    break;
                }
            }
            System.out.println("----------Selecione uma nova opção----------\n" +
                    "1 - Cadastrar novo cliente.\n" +
                    "2 - Listar todos os clientes.\n" +
                    "3 - Buscar cliente pelo CPF.\n" +
                    "4 - Alterar dados do cliente através do CPF.\n" +
                    "5 - Remover cliente pelo CPF.\n" +
                    "6 - Cadastrar nova conta corrente.\n" +
                    "7 - Listar contas correntes.\n" +
                    "8 - Buscar conta corrente pelo número.\n" +
                    "9 - Depositar valor em conta corrente.\n" +
                    "10 - Sacar valor em conta.\n" +
                    "11 - Remover conta corrente por número.\n" +
                    "0 - Sair do sistema.\n");

            opcao = scanner.nextInt();
        }
        System.out.println("Adeus!");
    }

    public static void cadastraCliente(String nome, String cpf, String endereco){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        BancoCliente.adicionaCliente(cliente);
    }

    public static void listaClientes(){
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
            System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
            System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
        }
    }

    public static void buscaClientePorCpf(String cpfBuscado){
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
            }else{
                throw new RuntimeException();
            }
        }
    }

    public static void alterarDadosCliente(String cpfBuscado, Scanner scanner){
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
                scanner.nextLine();
                System.out.println("Alterar nome");
                String novoNome = scanner.nextLine();
                BancoCliente.clienteArrayList.get(i).setNome(novoNome);
                System.out.println("Alterar CPF");
                String novoCPF = scanner.nextLine();
                BancoCliente.clienteArrayList.get(i).setCpf(novoCPF);
                System.out.println("Alterar endereço");
                String novoEndereco = scanner.nextLine();
                BancoCliente.clienteArrayList.get(i).setEndereco(novoEndereco);
            }
        }
    }

    public static void removeClientePorCpf(String cpfBuscado){
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                Cliente cliente = BancoCliente.clienteArrayList.get(i);
                BancoCliente.clienteArrayList.remove(cliente);
            }else{ throw new RuntimeException("Não foi possível encontrar o CPF informado.");

            }
        }
    }

    public static void cadastraContaCorrente(String cpfBuscado, int numero, double saldo, boolean teste){
        ContaCorrente contaCorrente = new ContaCorrente();
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                try {
                    contaCorrente.setNumero(numero);
                }catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
                try {
                    contaCorrente.setSaldo(saldo);
                }catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
                contaCorrente.setTitular(BancoCliente.clienteArrayList.get(i));
            }else{
                throw new RuntimeException("Impossível criar conta, titular não consta na base de dados.");
            }
        }
        if(teste && contaCorrente.getNumero() <= 0){
            throw new RuntimeException("Numero de conta inválido. Por favor, insira um número maior e diferente de 0");
        }else{
            BancoConta.adicionaContaCorrente(contaCorrente);
        }
    }

    public static void listaContasCorrente(){
        for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
            System.out.println(BancoConta.contaCorrenteArrayList.get(i).getNumero());
            System.out.println(BancoConta.contaCorrenteArrayList.get(i).getSaldo());
            System.out.println(BancoConta.contaCorrenteArrayList.get(i).toString());
        }
    }

    public static void buscaContaCorrentePorNumero(int numeroProcurado, boolean teste){
        for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
            if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                System.out.println(BancoConta.contaCorrenteArrayList.get(i).getNumero());
                System.out.println(BancoConta.contaCorrenteArrayList.get(i).getSaldo());
                System.out.println(BancoConta.contaCorrenteArrayList.get(i).toString());
            }else{
                throw new RuntimeException("Não foi possível encontrar essa conta");
            }
        }
    }

    public static void depositaValorConta(int numeroProcurado, double valorDepositado, boolean teste) {
        for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
            if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                double saldoAtual = BancoConta.contaCorrenteArrayList.get(i).getSaldo();
                try {
                    BancoConta.contaCorrenteArrayList.get(i).deposito(saldoAtual, valorDepositado);
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
                if (teste) {
                    try {
                        BancoConta.contaCorrenteArrayList.get(i).deposito(saldoAtual, valorDepositado);
                    } catch (RuntimeException ex) {
                        throw new RuntimeException("O valor depositado não pode ser igual ou menor que 0");
                    }
                }
            }
        }
    }

    public static void sacarValorConta(int numeroProcurado, double valorSacado, boolean teste){
        ContaCorrente contaCorrente = new ContaCorrente();
        for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
            if (BancoConta.contaCorrenteArrayList.get(i).getNumero() == numeroProcurado) {
                double saldoAtual = BancoConta.contaCorrenteArrayList.get(i).getSaldo();
                try{
                    BancoConta.contaCorrenteArrayList.get(i).saque(saldoAtual, valorSacado);
                }catch (RuntimeException ex){
                    System.out.println(ex.getMessage());
                }
                if(teste){
                    try{
                        BancoConta.contaCorrenteArrayList.get(i).saque(saldoAtual, valorSacado);
                    }catch (RuntimeException ex){
                        throw new RuntimeException("Não é possível sacar, dinheiro insuficiente!");
                    }
                }
            }
        }
    }

    public static void removerContaCorrente(int numeroProcurado, boolean teste){
        for (int i = 0; i < BancoConta.contaCorrenteArrayList.size(); i++) {
            BancoConta bancoConta = new BancoConta();
            if (((BancoConta.contaCorrenteArrayList.get(i).getNumero()) == numeroProcurado)) {
                ContaCorrente contaCorrente = BancoConta.contaCorrenteArrayList.get(i);
                if(!teste) {
                    try {
                        BancoConta.contaCorrenteArrayList.get(i).removerContaCorrenteArrayList(contaCorrente);
                    } catch (RuntimeException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                if(teste){
                    try{
                        BancoConta.contaCorrenteArrayList.get(i).removerContaCorrenteArrayList(contaCorrente);
                    }catch (RuntimeException ex){
                        throw new RuntimeException("Impossível remover conta, saldo positivo");
                    }
                }
            }
        }
    }
}