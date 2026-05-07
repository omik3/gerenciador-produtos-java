    import java.util.ArrayList;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            ArrayList<Produto> listaDeProdutos = new ArrayList<>();
            Scanner scann = new Scanner(System.in);


            int opcao = 1;

            while (opcao != 0) {
                System.out.println("_Menu_");

                System.out.println("1 - Cadastrar produto\n" +
                        "2 - Listar produtos\n" +
                        "3 - Buscar produto pelo nome\n" +
                        "4 - Atualizar preço\n" +
                        "5 - Remover produto\n" +                  //MENU
                        "6 - Mostrar produto mais caro\n" +
                        "7 - Mostrar valor total do estoque\n" +
                        "8 - Sair");

                System.out.println("Escolha uma opção:");


                opcao = scann.nextInt();


                if (opcao == 1) {

                    scann.nextLine();


                    System.out.println("Nome do produto:");
                    String nome = scann.nextLine();
                    System.out.println("Preço do produto:");
                    double preco = scann.nextDouble();
                    System.out.println("Quantidade do produto:");
                    int quantidade = scann.nextInt();
                    Produto produto = new Produto(nome, preco, quantidade);
                    listaDeProdutos.add(produto);


                } else if (opcao == 2) {
                    for (Produto produto : listaDeProdutos) {
                        if (listaDeProdutos.size() == 0) {
                            System.out.println("Não há nenhum produto para listar");
                        } else {
                            System.out.println("Nome: " + produto.getNome() + "\nPreço: R$" + produto.getPreco() + "\nQuantidade: " + produto.getQuantidade());
                            System.out.println("------------------------------------------");

                        }
                    }


                } else if (opcao == 3) {
                    System.out.println("Digite o nome do produto:");
                    String nome;
                    nome = scann.nextLine();

                    for (Produto produto : listaDeProdutos) {
                        if (produto.getNome().equalsIgnoreCase(nome)) {
                            System.out.println("-------------------");
                            System.out.println("Produto encontrado");
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Preço: R$" + produto.getPreco());
                            System.out.println("Quantidade: " + produto.getQuantidade());
                            System.out.println("-------------------");
                        } else {
                            System.out.println("Produto não encontrado");
                        }


                    }

                } else if (opcao == 4) {
                    System.out.println("De qual produto voce deseja atualizar o preço: ");
                    String nome;
                    nome = scann.nextLine();
                    for (Produto produto : listaDeProdutos) {
                        if (produto.getNome().equalsIgnoreCase(nome)){
                            System.out.println("Digite o novo preço:");
                            double preco = scann.nextDouble();
                            produto.setPreco(preco);
                            System.out.println("Preço de " + produto.getNome() + "atualizado" +"\nNovo preço R$" + produto.getPreco());
                        }



                    }


                } else if (opcao == 5) {
                    System.out.println("Qual produto voce deseja remover?: ");
                    String nome;
                    nome = scann.nextLine();
                    for (Produto produto : listaDeProdutos){
                        if (produto.getNome().equalsIgnoreCase(nome)){
                            System.out.println("Removendo " + produto.getNome());
                            listaDeProdutos.remove(produto);
                            System.out.println("Produto removido com sucesso!");
                        }
                    }

                }


            }


        }
    }
