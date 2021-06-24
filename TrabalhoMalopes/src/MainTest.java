import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("----------testeCadastroCliente----------");
        testeCadastroCliente();
        System.out.println("\n----------testeListaClientes----------");
        testeListaClientes();
        System.out.println("\n----------testeBuscaClientePorCpfTemQueDarCerto----------");
        testeBuscaClientePorCpfTemQueDarCerto();
        System.out.println("\n----------testeBuscaClientePorCpfTemQueDarErrado----------");
        testeBuscaClientePorCpfTemQueDarErrado();
        System.out.println("\n----------testeAlterarDadosCliente----------");
        testeAlterarDadosCliente();
        System.out.println("\n----------testeRemoveClientePorCpfTemQueDarCerto----------");
        testeRemoveClientePorCpfTemQueDarCerto();
        criaClientes();
        System.out.println("\n----------testeRemoveClientePorCpfTemQueDarErrado----------");
        testeRemoveClientePorCpfTemQueDarErrado();
        System.out.println("\n----------testeCadastraContaCorrenteTemQueDarCerto----------");
        testeCadastraContaCorrenteTemQueDarCerto();
        System.out.println("\n----------testeCadastraContaCorrenteTemQueDarErrado----------");
        testeCadastraContaCorrenteTemQueDarErrado();
        System.out.println("\n----------testeListaContasCorrente----------");
        testeListaContasCorrente();
        System.out.println("\n----------testeBuscaContaCorrentePorNumeroTemQueDarCerto----------");
        testeBuscaContaCorrentePorNumeroTemQueDarCerto();
        System.out.println("\n----------testeBuscaContaCorrentePorNumeroTemQueDarErrado----------");
        testeBuscaContaCorrentePorNumeroTemQueDarErrado();
        System.out.println("\n----------testeDepositaValorContaTemQueDarCerto----------");
        testeDepositaValorContaTemQueDarCerto();
        System.out.println("\n----------testeDepositaValorContaTemQueDarErrado----------");
        testeDepositaValorContaTemQueDarErrado();
        System.out.println("\n----------testeSacarValorContaTemQueDarCerto----------");
        testeSacarValorContaTemQueDarCerto();
        System.out.println("\n----------testeSacarValorContaTemQueDarErrado----------");
        testeSacarValorContaTemQueDarErrado();
        System.out.println("\n----------removerContaCorrenteTemQueDarCerto----------");
        removerContaCorrenteTemQueDarCerto();
        criarContaCorrente();
        System.out.println("\n----------removerContaCorrenteTemQueDarErrado----------");
        removerContaCorrenteTemQueDarErrado();

    }

    public static void testeCadastroCliente(){
        Cliente cliente = new Cliente();
        String nome = "Jose";
        String cpf = "111.222.333-44";
        String endereco = "Rua 1 numero 0";
        ClienteDados.cadastraCliente(nome, cpf, endereco);
        System.out.println("Passou: True");
    }

    public static void testeListaClientes(){
        ClienteDados.listaClientes();
        System.out.println("Passou: True");
        }

    public static void testeBuscaClientePorCpfTemQueDarCerto(){
        Scanner scanner = new Scanner(System.in);
        String cpfBuscado = "111.222.333-44";
        ClienteDados.buscaClientePorCpf(cpfBuscado);
        System.out.println("Passou: True");
    }

    public static void testeBuscaClientePorCpfTemQueDarErrado() {
        Scanner scanner = new Scanner(System.in);
        String cpfBuscado = "222.333.444-55";
        try {
            ClienteDados.buscaClientePorCpf(cpfBuscado);
        } catch (RuntimeException ex) {
            System.out.println("Passou: True");
        }
    }

    public static void testeAlterarDadosCliente(){
        Scanner scanner = new Scanner(System.in);
        String cpfBuscado = "111.222.333-44";
        for (int i = 0; i < BancoCliente.clienteArrayList.size(); i++) {
            if (((BancoCliente.clienteArrayList.get(i).getCpf()).equals(cpfBuscado))) {
                System.out.println(BancoCliente.clienteArrayList.get(i).getNome());
                System.out.println(BancoCliente.clienteArrayList.get(i).getCpf());
                System.out.println(BancoCliente.clienteArrayList.get(i).getEndereco());
                System.out.println("Alterar nome");
                String novoNome = "Josue";
                BancoCliente.clienteArrayList.get(i).setNome(novoNome);
                System.out.println("Alterar CPF");
                String novoCPF = "222.333.444-55";
                BancoCliente.clienteArrayList.get(i).setCpf(novoCPF);
                System.out.println("Alterar endereço");
                String novoEndereco = "Rua 2 numero 1";
                BancoCliente.clienteArrayList.get(i).setEndereco(novoEndereco);
                System.out.println("Passou: True");
            }
        }
    }

    public static void testeRemoveClientePorCpfTemQueDarCerto(){
        String cpfBuscado = "222.333.444-55";
        ClienteDados.removeClientePorCpf(cpfBuscado);
        System.out.println("Passou: True");
    }

    public static void criaClientes(){
        Cliente cliente = new Cliente();
        String nome = "Jose";
        String cpf = "111.222.333-44";
        String endereco = "Rua 1 numero 0";
        ClienteDados.cadastraCliente(nome, cpf, endereco);
    }

    public static void testeRemoveClientePorCpfTemQueDarErrado(){
        String cpfBuscado = "516516511";
        try {
            ClienteDados.removeClientePorCpf(cpfBuscado);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }

    public static void testeCadastraContaCorrenteTemQueDarCerto(){
        Scanner scanner = new Scanner(System.in);
        String cpfBuscado = "111.222.333-44";
        boolean teste = true;
        int numero = 1;
        double saldo = 200.0;
        ClienteDados.cadastraContaCorrente(cpfBuscado, numero, saldo, teste);
        System.out.println("Passou: True");
    }

    public static void testeCadastraContaCorrenteTemQueDarErrado() {
        String cpfBuscado = "111.222.333-44";
        boolean teste = true;
        int numero = -1;
        double saldo = 200;
        try {
            ClienteDados.cadastraContaCorrente(cpfBuscado, numero, saldo, teste);
        }catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }

    public static void testeListaContasCorrente(){
        ClienteDados.listaContasCorrente();
        System.out.println("Passou: True");
    }

    public static void testeBuscaContaCorrentePorNumeroTemQueDarCerto(){
        boolean teste = true;
        int numeroProcurado = 1;
        ClienteDados.buscaContaCorrentePorNumero(numeroProcurado, teste);
        System.out.println("Passou: True");
    }

    public static void testeBuscaContaCorrentePorNumeroTemQueDarErrado(){
        boolean teste = true;
        int numeroProcurado = 0;
        try {
            ClienteDados.buscaContaCorrentePorNumero(numeroProcurado, teste);
        }catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }

    public static void testeDepositaValorContaTemQueDarCerto(){
        boolean teste = true;
        int numeroProcurado = 1;
        double valorDepositado = 200.0;
        ClienteDados.depositaValorConta(numeroProcurado,valorDepositado, teste);
        System.out.println("Passou: True");
    }

    public static void testeDepositaValorContaTemQueDarErrado(){
        int numeroProcurado = 1;
        double valorDepositado = -200.0;
        boolean teste = true;
        try {
            ClienteDados.depositaValorConta(numeroProcurado, valorDepositado, teste);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }

    public static void testeSacarValorContaTemQueDarCerto(){
        boolean teste = true;
        int numeroProcurado = 1;
        double valorSacado = 400;
        ClienteDados.sacarValorConta(numeroProcurado, valorSacado, teste);
        System.out.println("Passou: True");
    }

    public static void testeSacarValorContaTemQueDarErrado(){
        boolean teste = true;
        int numeroProcurado = 1;
        double valorSacado = 100000;
        try {
            ClienteDados.sacarValorConta(numeroProcurado, valorSacado, teste);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }

    public static void removerContaCorrenteTemQueDarCerto(){
        boolean teste = true;
        int numeroProcurado = 1;
        ClienteDados.removerContaCorrente(numeroProcurado, teste);
        System.out.println("Passou: True");
    }

    public static void criarContaCorrente(){
        String cpfBuscado = "111.222.333-44";
        boolean teste = true;
        int numero = 1;
        double saldo = 200;
        ClienteDados.cadastraContaCorrente(cpfBuscado, numero, saldo, teste);
    }

    public static void removerContaCorrenteTemQueDarErrado(){
        boolean teste = true;
        int numeroProcurado = 1;
        try {
            ClienteDados.removerContaCorrente(numeroProcurado, teste);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            System.out.println("Passou: True");
        }
    }
}
