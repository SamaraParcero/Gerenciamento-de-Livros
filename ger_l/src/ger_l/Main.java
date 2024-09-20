package ger_l;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        
        biblioteca.adicionarLivro(new Livros(1, "Dom Casmurro", 10));
        biblioteca.adicionarLivro(new Livros(2, "1984", 10));
        biblioteca.adicionarLivro(new Livros(3, "O Senhor dos Anéis", 10));
        biblioteca.adicionarLivro(new Livros(4, "Cem Anos de Solidão", 10));
        biblioteca.adicionarLivro(new Livros(5, "O Hobbit", 10));
        biblioteca.adicionarLivro(new Livros(6, "A Revolução dos Bichos", 10));
        biblioteca.adicionarLivro(new Livros(7, "Moby Dick", 10));
        biblioteca.adicionarLivro(new Livros(8, "O Processo", 10));
        biblioteca.adicionarLivro(new Livros(9, "A Metamorfose", 10));
        biblioteca.adicionarLivro(new Livros(10, "Crime e Castigo", 10));

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Alugar Livro");
            System.out.println("3. Devolver Livro");
            System.out.println("4. Listar Usuários e Datas de Devolução");
            System.out.println("5. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email = scanner.nextLine();
                    int id = biblioteca.contarUsuarios() + 1;
                    biblioteca.adicionarUsuario(new Usuario(id, nome, email));
                    System.out.println("Usuário adicionado com sucesso!");
                    break;
                case 2:
                  
                    System.out.println("Livros disponíveis para alugar:");
                    biblioteca.mostrarCatalogo();

                    System.out.print("Digite o ID do livro para alugar: ");
                    int livroId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String emailAluguel = scanner.nextLine();
                    biblioteca.alugarLivro(livroId, emailAluguel);
                    break;
                case 3:
                  
                    System.out.print("Digite o ID do livro para devolver: ");
                    int livroDevolucaoId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String emailDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(livroDevolucaoId, emailDevolucao);
                    break;
                case 4:
                 
                    biblioteca.listarUsuariosEDevolucoes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}


