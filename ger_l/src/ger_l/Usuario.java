package ger_l;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private List<Integer> livrosAlugados; 

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.livrosAlugados = new ArrayList<>();  
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    
    public void alugarLivro(int livroId) {
        livrosAlugados.add(livroId);
    }

   
    public void devolverLivro(int livroId) {
        livrosAlugados.remove(Integer.valueOf(livroId)); 
    }

  
    public boolean possuiLivro(int livroId) {
        return livrosAlugados.contains(livroId);
    }

    public List<Integer> getLivrosAlugados() {
        return livrosAlugados;
    }
}
