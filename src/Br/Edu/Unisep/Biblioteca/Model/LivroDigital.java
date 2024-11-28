package Br.Edu.Unisep.Biblioteca.Model;

public class LivroDigital extends Livro {
    private double tamanhoEmMb;

    public LivroDigital(String titulo, Autor autor, Genero genero, double tamanhoEmMb) {
        super(titulo, autor, genero);
        this.tamanhoEmMb = tamanhoEmMb;
    }

    public double getTamanhoEmMb() {
        return tamanhoEmMb;
    }

    public void setTamanhoEmMb(double tamanhoEmMb) {
        this.tamanhoEmMb = tamanhoEmMb;
    }
}
