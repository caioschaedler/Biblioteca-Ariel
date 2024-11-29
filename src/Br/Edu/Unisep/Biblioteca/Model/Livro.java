package Br.Edu.Unisep.Biblioteca.Model;


import java.util.Objects;

public class Livro {
    private String titulo;
    private Autor autor;
    private Genero genero;
    private boolean disponivel = true;

    // Construtor
    public Livro(String titulo, Autor autor, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Método para emprestar o livro
    public void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException("O livro já está emprestado.");
        }
        this.disponivel = false;
    }

    // Método para devolver o livro
    public void devolver() {
        if (disponivel) {
            throw new IllegalStateException("O livro já está disponível.");
        }
        this.disponivel = true;
    }

    // Sobrescrita do método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) &&
                Objects.equals(autor, livro.autor) &&
                Objects.equals(genero, livro.genero);
    }

    // Sobrescrita do método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, genero);
    }

    // Sobrescrita do método toString
    @Override
    public String toString() {
        return titulo + " (" + autor.getNome() + ", " + genero.getNome() + ")";
    }
}
