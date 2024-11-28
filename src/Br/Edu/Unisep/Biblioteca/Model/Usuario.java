package Br.Edu.Unisep.Biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Livro> emprestimos = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getEmprestimos() {
        return emprestimos;
    }

    public boolean emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.emprestar();
            emprestimos.add(livro);
            return true;
        }
        return false;
    }

    public void devolverLivro(Livro livro) {
        livro.devolver();
        emprestimos.remove(livro);
    }
}
