public class ContaCorrente {

    private int numero;
    private double saldo;
    private Cliente titular;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero <= 0) { throw new RuntimeException("Numero de conta inválido. Por favor, insira um número maior e diferente de 0");
        }else {
            this.numero = numero;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0) { throw new RuntimeException("Saldo inválido");
        }else {
            this.saldo = saldo;
        }
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void deposito(double saldoAtual, double valorDeposito){
        if(valorDeposito <= 0){
            throw new RuntimeException("O valor depositado não pode ser igual ou menor que 0");
        }else{
            setSaldo(saldoAtual + valorDeposito);
        }
    }

    public void saque(double saldoAtual, double valorSacado){
        if(valorSacado > saldoAtual){
            throw new RuntimeException("Não é possível sacar, dinheiro insuficiente!");
        }else{
            setSaldo(saldoAtual - valorSacado);
        }
    }

    public void removerContaCorrenteArrayList(ContaCorrente contaCorrente){
        if(contaCorrente.getSaldo() > 0) {
            throw new RuntimeException("Impossível remover conta, saldo positivo");
        }else {
            BancoConta.contaCorrenteArrayList.remove(contaCorrente);
        }
    }


    @Override
    public String toString() {
        return "ContaCorrente{" +
                "titular=" + titular +
                '}';
    }
}
