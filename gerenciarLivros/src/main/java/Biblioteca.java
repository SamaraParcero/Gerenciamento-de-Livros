import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<Integer, Livros> livros = new HashMap<>();
    private Map<String, Usuario> usuarios = new HashMap<>();

    
    public void adicionarLivro(Livros livro) {
        livros.put(livro.getId(), livro);
    }

   
    public void adicionarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getEmail())) {
            System.out.println("Erro: Este e-mail já está cadastrado.");
        } else {
            usuarios.put(usuario.getEmail(), usuario);
            System.out.println("Usuário adicionado com sucesso!");
        }
    }

   
    public void alugarLivro(int livroId, String email) {
        try {
            Livros livro = livros.get(livroId);
            Usuario usuario = usuarios.get(email);

            if (livro == null) throw new Exception("Livro não encontrado.");
            if (usuario == null) throw new Exception("Usuário não encontrado.");

            if (livro.isDisponivel()) {
                livro.alugar();
                usuario.alugarLivro(livroId);  
                LocalDate dataDevolucao = livro.calcularDataDevolucao();
                System.out.println("Livro alugado com sucesso para o usuário: " + usuario.getNome());
                System.out.println("Data de devolução: " + dataDevolucao);
            } else {
                System.out.println("Livro sem estoque. Retornando ao catálogo...");
                Thread.sleep(2000); 
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

 
    public void devolverLivro(int livroId, String email) {
        try {
            Livros livro = livros.get(livroId);
            Usuario usuario = usuarios.get(email);

            if (livro == null) throw new Exception("Livro não encontrado.");
            if (usuario == null) throw new Exception("Usuário não encontrado.");

            if (usuario.possuiLivro(livroId)) {
                livro.devolver();
                usuario.devolverLivro(livroId); 
                System.out.println("Livro devolvido com sucesso pelo usuário: " + usuario.getNome());
            } else {
                System.out.println("Erro: Este usuário não alugou o livro.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public void listarUsuariosEDevolucoes() {
        System.out.println("Usuários que pegaram livros e suas datas de devolução:");
        for (Usuario usuario : usuarios.values()) {
            if (!usuario.getLivrosAlugados().isEmpty()) {
                System.out.println("Usuário: " + usuario.getNome());
                for (Integer livroId : usuario.getLivrosAlugados()) {
                    Livros livro = livros.get(livroId);
                    System.out.println(" - Livro: " + livro.getTitulo() + " | Data de devolução: " + livro.calcularDataDevolucao());
                }
            }
        }
    }

 
    public void mostrarCatalogo() {
        System.out.println("Catálogo de livros:");
        for (Livros livro : livros.values()) {
            String disponibilidade = livro.isDisponivel() ? "Disponível" : "Indisponível";
            System.out.println("ID: " + livro.getId() + " - " + livro.getTitulo() + " - Estoque: " + livro.getEstoque() + " - " + disponibilidade);
        }
    }

   
    public int contarUsuarios() {
        return usuarios.size();
    }
    
    public int contarLivros() {
        return livros.size();
    }
}


