package Br.Edu.Unisep.Biblioteca.Model;

public class LivroFisico extends Livro {
    private String condicao;

    public LivroFisico(String titulo, Autor autor, Genero genero, String condicao) {
        super(titulo, autor, genero);
        this.condicao = condicao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
}
