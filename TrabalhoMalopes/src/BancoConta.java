import java.util.ArrayList;

public class BancoConta {

    public static ArrayList<ContaCorrente> contaCorrenteArrayList = new ArrayList<>();

    public ArrayList<ContaCorrente> getContaCorrenteArrayList() {
        return BancoConta.contaCorrenteArrayList;
    }

    public static void adicionaContaCorrente(ContaCorrente contaCorrente) {
        BancoConta.contaCorrenteArrayList.add(contaCorrente);
    }
}
