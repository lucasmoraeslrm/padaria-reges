
package com.mycompany.padariareges;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bruno Vieira 
 * @author Lucas Moraes
 * @author Wesley Junior
 */

public class PadariaReges {
    private static Prateleira prateleira;
    private static List<Cliente> clientes;
    private static Scanner sc;

    public static void main(String[] args) {
        prateleira = new Prateleira();
        clientes = new ArrayList<>();
        sc = new Scanner(System.in);

        prateleira.cadastrarItem(1, "Pão", 1.50);
        prateleira.cadastrarItem(2, "Bolo", 5.0);
        prateleira.cadastrarItem(3, "Salgado", 3.0);
        prateleira.cadastrarItem(4, "Coca-Cola", 7.0);
        prateleira.cadastrarItem(5, "Mussarela 100g", 3.5);

        exibirMenu();
    }

    public static void exibirMenu() {
        System.out.println("MENU");
        System.out.println("----");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Realizar Venda");
        System.out.println("3. Resgatar Pontos");
        System.out.println("4. Extrato de Compras");
        System.out.println("5. Sair");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                realizarVenda();
                break;
            case 3:
                resgatarPontos();
                break;
            case 4:
                extratoCompras();
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                exibirMenu();
                break;
        }
    }

    public static void cadastrarCliente() {
        System.out.println("Cadastro de Cliente");
        System.out.println("-------------------");

        System.out.println("Digite o nome completo do cliente:");
        String nomeCompleto = sc.nextLine();

        System.out.println("Digite o email do cliente:");
        String email = sc.nextLine();

        System.out.println("Digite o endereço do cliente:");
        String endereco = sc.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String telefone = sc.nextLine();

        System.out.println("Digite a data de nascimento do cliente (formato: dd/mm/aaaa):");
        String dataNascStr = sc.nextLine();
        Calendar dataNasc = obterData(dataNascStr);

        System.out.println("Digite o documento do cliente:");
        String documento = sc.nextLine();

        System.out.println("Digite o RG do cliente:");
        String rgIe = sc.nextLine();

        Cliente cliente = new Cliente(nomeCompleto, email, endereco, telefone, dataNasc, documento, rgIe);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

        exibirMenu();
    }

    public static void realizarVenda() {
        System.out.println("PDV - Ponto de Venda");
        System.out.println("--------------------");

        System.out.println("Selecione o cliente:");
        listarClientes();

        int escolhaCliente = sc.nextInt();
        Cliente cliente = clientes.get(escolhaCliente - 1);

        List<Item> itensSelecionados = new ArrayList<>();
        List<Integer> quantidades = new ArrayList<>();

        boolean adicionarMaisProdutos = true;

        while (adicionarMaisProdutos) {
            System.out.println("Selecione o item:");
            prateleira.listarItens();

            int escolhaItem = sc.nextInt();
            Item item = prateleira.getItem(escolhaItem);

            System.out.println("Digite a quantidade:");
            int quantidade = sc.nextInt();

            itensSelecionados.add(item);
            quantidades.add(quantidade);

            System.out.println("Deseja adicionar mais produtos? (S/N)");
            String resposta = sc.next();
            adicionarMaisProdutos = resposta.equalsIgnoreCase("S");
        }

        double subtotal = 0;
        double total = 0;
        int pontos = 0;

        for (int i = 0; i < itensSelecionados.size(); i++) {
            Item item = itensSelecionados.get(i);
            int quantidade = quantidades.get(i);

            double precoItem = item.getPreco();
            subtotal += precoItem * quantidade;
            pontos += (int) (precoItem * quantidade / 10);
            
            cliente.getItensComprados().add(item);
            cliente.getQuantidadesCompradas().add(quantidade);
        }

        total = subtotal;

        cliente.adicionarPontos(pontos);

        System.out.println("Subtotal: R$" + subtotal);
        System.out.println("Total: R$" + total);
        System.out.println("Pontos adicionados: " + pontos);

        exibirMenu();
    }

    public static void resgatarPontos() {
        System.out.println("Resgate de Pontos");
        System.out.println("-----------------");

        System.out.println("Selecione o cliente:");
        listarClientes();

        int escolhaCliente = sc.nextInt();
        Cliente cliente = clientes.get(escolhaCliente - 1);

        System.out.println("Pontos disponíveis: " + cliente.getPontos());
        System.out.println("Digite a quantidade de pontos a resgatar:");
        int pontosResgatar = sc.nextInt();

        if (pontosResgatar <= cliente.getPontos()) {
            cliente.adicionarPontos(-pontosResgatar); // Subtrai os pontos resgatados do total de pontos do cliente
            System.out.println("Pontos resgatados com sucesso!");
            System.out.println("Pontos restantes: " + cliente.getPontos());
        } else {
            System.out.println("Quantidade de pontos inválida. Operação cancelada.");
        }

        exibirMenu();
    }

    public static void listarClientes() {
        System.out.println("Clientes cadastrados:");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente.getNomeCompleto());
        }
    }
    
    public static void extratoCompras() {
        System.out.println("Extrato de Compras");
        System.out.println("------------------");

        System.out.println("Selecione o cliente:");
        listarClientes();

        int escolhaCliente = sc.nextInt();
        Cliente cliente = clientes.get(escolhaCliente - 1);

        List<Item> itensComprados = cliente.getItensComprados();
        List<Integer> quantidadesCompradas = cliente.getQuantidadesCompradas();

        System.out.println("Cliente: " + cliente.getNomeCompleto());
        System.out.println("Itens Comprados:");
        System.out.println("Código\tNome\t\tPreço\t\tQuantidade");

        for (int i = 0; i < itensComprados.size(); i++) {
            Item item = itensComprados.get(i);
            int quantidade = quantidadesCompradas.get(i);

            System.out.println(item.getCodigo() + "\t" + item.getNome() + "\t" + item.getPreco() + "\t\t" + quantidade);
        }

        exibirMenu();
    }

    public static Calendar obterData(String dataStr) {
        String[] partes = dataStr.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]) - 1;
        int ano = Integer.parseInt(partes[2]);

        Calendar data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, dia);
        data.set(Calendar.MONTH, mes);
        data.set(Calendar.YEAR, ano);

        return data;
    }
}

