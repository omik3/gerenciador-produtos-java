import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Produto> listaDeProdutos = new ArrayList<>();
        Scanner scann = new Scanner(System.in);

        int opcao = 1;

        while (opcao != 0) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto pelo nome");
            System.out.println("4 - Atualizar preço");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Mostrar produto mais caro");
            System.out.println("7 - Mostrar valor total do estoque");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scann.nextInt();
            scann.nextLine();

            // CADASTRAR PRODUTO
            if (opcao == 1) {

                System.out.print("Nome do produto: ");
                String nome = scann.nextLine();

                System.out.print("Preço do produto: ");
                double preco = scann.nextDouble();

                System.out.print("Quantidade do produto: ");
                int quantidade = scann.nextInt();
                scann.nextLine();

                Produto produto = new Produto(nome, preco, quantidade);

                listaDeProdutos.add(produto);

                System.out.println("Produto cadastrado com sucesso!");

            }

            // LISTAR PRODUTOS
            else if (opcao == 2) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    for (Produto produto : listaDeProdutos) {

                        System.out.println("----------------------");
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preço: R$ " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidade());

                    }

                }

            }

            // BUSCAR PRODUTO
            else if (opcao == 3) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    System.out.print("Digite o nome do produto: ");
                    String nome = scann.nextLine();

                    boolean encontrado = false;

                    for (Produto produto : listaDeProdutos) {

                        if (produto.getNome().equalsIgnoreCase(nome)) {

                            System.out.println("\nProduto encontrado:");
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: R$ " + produto.getPreco());
                            System.out.println("Quantidade: " + produto.getQuantidade());

                            encontrado = true;
                            break;

                        }

                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }

                }

            }

            // ATUALIZAR PREÇO
            else if (opcao == 4) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    System.out.print("Qual produto deseja atualizar? ");
                    String nome = scann.nextLine();

                    boolean encontrado = false;

                    for (Produto produto : listaDeProdutos) {

                        if (produto.getNome().equalsIgnoreCase(nome)) {

                            System.out.print("Digite o novo preço: ");
                            double preco = scann.nextDouble();
                            scann.nextLine();

                            produto.setPreco(preco);

                            System.out.println("Preço atualizado com sucesso!");

                            encontrado = true;
                            break;

                        }

                    }

                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }

                }

            }

            // REMOVER PRODUTO
            else if (opcao == 5) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    System.out.print("Qual produto deseja remover? ");
                    String nome = scann.nextLine();

                    boolean removido = false;

                    for (int i = 0; i < listaDeProdutos.size(); i++) {

                        Produto produto = listaDeProdutos.get(i);

                        if (produto.getNome().equalsIgnoreCase(nome)) {

                            listaDeProdutos.remove(i);

                            System.out.println("Produto removido com sucesso!");

                            removido = true;
                            break;

                        }

                    }

                    if (!removido) {
                        System.out.println("Produto não encontrado.");
                    }

                }

            }

            // PRODUTO MAIS CARO
            else if (opcao == 6) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    Produto maisCaro = listaDeProdutos.get(0);

                    for (Produto produto : listaDeProdutos) {

                        if (produto.getPreco() > maisCaro.getPreco()) {

                            maisCaro = produto;

                        }

                    }

                    System.out.println("\nProduto mais caro:");
                    System.out.println("Nome: " + maisCaro.getNome());
                    System.out.println("Preço: R$ " + maisCaro.getPreco());
                    System.out.println("Quantidade: " + maisCaro.getQuantidade());

                }

            }

            // VALOR TOTAL DO ESTOQUE
            else if (opcao == 7) {

                if (listaDeProdutos.size() == 0) {
                    System.out.println("Nenhum produto cadastrado.");
                }

                else {

                    double valorTotal = 0;

                    for (Produto produto : listaDeProdutos) {

                        valorTotal += produto.getPreco() * produto.getQuantidade();

                    }

                    System.out.println("Valor total do estoque: R$ " + valorTotal);

                }

            }

            // SAIR
            else if (opcao == 0) {

                System.out.println("Encerrando sistema...");

            }

            // OPÇÃO INVÁLIDA
            else {

                System.out.println("Opção inválida.");

            }

        }

    }

}