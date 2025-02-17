public class CadastroCliente {

    public static void main(String[] args) {
        Lista listaClientes = new Lista(); // cria a lista de clientes
        listaClientes.imprimeLista();
        Cliente novoCliente = new Cliente(221, "Produtos excelentes LTDA", "Rua sem fim", 5000.0);

        // inserindo elementos na Lista Ligada
        listaClientes.insereInicio(novoCliente); // usando uma variável cliente
        listaClientes.imprimeLista();

        listaClientes.insereInicio(
            new Cliente(
                185,
                "Negócios Importantes SA",
                "Avenida Principal",
                12000.0
            )
        );
        listaClientes.imprimeLista();

        listaClientes.insereInicio(
            new Cliente(
                443,
                "Parceiros Críticos LTDA",
                "Rua dos negócios, 2000",
                7000.0
            )
        );
        listaClientes.imprimeLista();

        // Busca do elemento na posição 2 da lista
        // Necessário type casting para a classe Cliente
        novoCliente = (Cliente) listaClientes.buscaElemento(2);
        if (novoCliente != null) {
            System.out.println("Elemento da posicao 2 da Lista Ligada");
            System.out.println(novoCliente);
        }

        // removendo um elemento da Lista Ligada
        // necessário type casting para a classe Cliente
        // Cliente clienteRemovido = (Cliente) listaClientes.removeInicio();
        // System.out.println("Elemento removido da Lista Ligada");
        // System.out.println(clienteRemovido);
        // listaClientes.imprimeLista();

        Cliente posicaoRemovida = (Cliente) listaClientes.removePosicao(2);
        System.out.println("Elemento removido da posição 2 da Lista Ligada");
        System.out.println(posicaoRemovida);
        listaClientes.imprimeLista();

        // liberando toda a lista
        System.out.println("Liberando toda a lista");
        listaClientes.liberaLista();
        listaClientes.imprimeLista();
    }
} 