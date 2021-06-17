import java.util.ArrayList;

public class BancoCliente {

    public static ArrayList<Cliente> clienteArrayList = new ArrayList<>();

    public ArrayList<Cliente> getClienteArrayList() {
        return BancoCliente.clienteArrayList;
    }

    public static void adiciona(Cliente cliente) {
        clienteArrayList.add(cliente);
    }
}
