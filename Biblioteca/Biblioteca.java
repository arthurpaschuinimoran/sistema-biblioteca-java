package Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import Biblioteca.classes.Livro;

//Tempo de programação total do sistema: 2h30 - 3h

public class Biblioteca {
    public static void main(String[] args) {
        String answer = null;
        Scanner value = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        // livros de exemplo
        livros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, true));
        livros.add(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, true));
        livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866, false));
        livros.add(new Livro("Confissões de Santo Agostinho", "Santo Agostinho", 398, true));


        while (true) { // esse é o loop principal, continua até o user sair.
                    System.out.println("Bem-vindo à Biblioteca!");
                    System.out.println("======== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA - V1 ========");
                    System.out.println("1 - Cadastrar novo livro.");
                    System.out.println("2 - Listar livros e operações.");
                    System.out.println("3 - Sair do sistema.");
                    System.out.println("Digite o número da opção desejada:");
                    int opcao = value.nextInt();
                    value.nextLine();

                    switch (opcao) {
                        case 1:
                            catalogarLivro(value, livros);
                            break;
                        case 2:
                            menuGerenciamento(value, livros, answer);
                            break;
                        case 3:
                            System.out.println("Saindo do sistema. Até logo!");
                            value.close();
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }
        }

        
    }

    private static void exibirLivro(Livro livro) {
        System.out.println("* Título: " + livro.getTitulo());
        System.out.println("* Autor: " + livro.getAutor());
        System.out.println("* Ano: " + livro.getAno());
        System.out.println("* Corredor Alocado: " + livro.CorredorAlocado());
        System.out.println("* Preço: R$" + livro.findPrice());

        if (livro.estaDisponivel()) {
            System.out.println("* O livro está disponível para empréstimo.");
        } else {
            System.out.println("* O livro não está disponível para empréstimo.");
        }
    }
    
    private static void catalogarLivro(Scanner value, ArrayList<Livro> livros) {
        System.out.println("Digite o título do livro:");
        String titulo = value.nextLine();
        System.out.println("Digite o autor do livro:");
        String autor = value.nextLine();
        System.out.println("Digite o ano de publicação do livro:");
        int ano = value.nextInt();
        value.nextLine();
        livros.add(new Livro(titulo, autor, ano, true));
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void menuGerenciamento(Scanner value, ArrayList<Livro> livros, String answer) {
        boolean returnMain = false;

        while(!returnMain) { // loop do menu de gerenciamento de livros.
            System.out.println("Escolha um livro:");
            System.out.println("** 0 - Voltar ao menu principal.");
                for (int i = 0; i < livros.size(); i++) {
                    System.out.println((i + 1) + " - " + livros.get(i).getTitulo() + " (" + livros.get(i).getAno() + ")");
                }
                                                    
                int escolha = value.nextInt();
                value.nextLine();

                if (escolha >= 1 && escolha <= livros.size()) {
                Livro livroSelecionado = livros.get(escolha - 1);
                    exibirLivro(livroSelecionado);
                } else if (escolha == 0) {
                    System.out.println("Voltando ao menu principal.");
                    returnMain = true;
                    continue;
                } 
                    else {
                    System.out.println("Escolha inválida.");
                    continue;
                }


                System.out.println("O que deseja fazer com o livro selecionado?");
                System.out.println("1 - Emprestar");
                System.out.println("2 - Devolver");
                System.out.println("3 - Voltar a seleção de livros");
                int acao = value.nextInt();
                value.nextLine();

                switch (acao) {
                    case 1:
                            livros.get(escolha - 1).emprestar();
                            break;
                        case 2:
                            livros.get(escolha - 1).devolver();
                            break;
                        case 3:
                            System.out.println("Voltando à seleção de livros.");
                            answer = "mi";
                            continue;
                        default:
                            System.out.println("Ação inválida.");
                            break;
                        }

                System.out.println("Deseja voltar ao menu de livros? (s/n)");
                answer = value.nextLine();

                if (answer.equalsIgnoreCase("n")) {
                    returnMain = true;
                    continue;
                }
        }
    }


}



