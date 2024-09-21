import java.time.LocalDate;

public class Livros {
    private int id;
    private String titulo;
    private int estoque;

    public Livros(int id, String titulo, int estoque) {
        this.id = id;
        this.titulo = titulo;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return estoque > 0;  
    }

    public void alugar() {
        if (estoque > 0) {
            estoque--; 
        }
    }

    public void devolver() {
        estoque++; 
    }

    public int getEstoque() {
        return estoque;  
    }


    public LocalDate calcularDataDevolucao() {
        return LocalDate.now().plusDays(14);
    }
}
