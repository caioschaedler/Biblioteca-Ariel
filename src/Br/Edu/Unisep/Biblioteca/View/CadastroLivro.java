package Br.Edu.Unisep.Biblioteca.View;

import Br.Edu.Unisep.Biblioteca.Model.Autor;
import Br.Edu.Unisep.Biblioteca.Model.Genero;
import Br.Edu.Unisep.Biblioteca.Model.Livro;

import javax.swing.*;
import java.util.ArrayList;

public class CadastroLivro extends JFrame {

    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Autor> autores = new ArrayList<>();
    private static ArrayList<Genero> generos = new ArrayList<>();

    public CadastroLivro() {
        // Configuração da janela
        setTitle("Cadastro de Livro");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        // Label e campo de texto para o título do livro
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 100, 25);
        add(lblTitulo);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(20, 50, 200, 25);
        add(txtTitulo);

        // Label e ComboBox para o autor
        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(20, 80, 100, 25);
        add(lblAutor);

        JComboBox<Autor> comboAutor = new JComboBox<>(autores.toArray(new Autor[0]));
        comboAutor.setEditable(true); // Torna o campo editável
        comboAutor.setBounds(20, 110, 200, 25);
        add(comboAutor);

        // Label e ComboBox para o gênero
        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setBounds(20, 140, 100, 25);
        add(lblGenero);

        JComboBox<Genero> comboGenero = new JComboBox<>(generos.toArray(new Genero[0]));
        comboGenero.setEditable(true); // Torna o campo editável
        comboGenero.setBounds(20, 170, 200, 25);
        add(comboGenero);

        // Botão para salvar o livro
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20, 210, 100, 25);
        add(btnSalvar);

        // Ação do botão salvar
        btnSalvar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            String autorNome = comboAutor.getEditor().getItem().toString().trim();
            String generoNome = comboGenero.getEditor().getItem().toString().trim();

            if (!titulo.isEmpty() && !autorNome.isEmpty() && !generoNome.isEmpty()) {
                Autor autor = encontrarOuCriarAutor(autorNome);
                Genero genero = encontrarOuCriarGenero(generoNome);

                livros.add(new Livro(titulo, autor, genero));
                JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
                txtTitulo.setText("");
                comboAutor.setSelectedItem(null);
                comboGenero.setSelectedItem(null);
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            }
        });

        // Exibe a janela
        setVisible(true);
    }

    private Autor encontrarOuCriarAutor(String nome) {
        for (Autor autor : autores) {
            if (autor.getNome().equalsIgnoreCase(nome)) {
                return autor;
            }
        }
        Autor novoAutor = new Autor(nome);
        autores.add(novoAutor);
        return novoAutor;
    }

    private Genero encontrarOuCriarGenero(String nome) {
        for (Genero genero : generos) {
            if (genero.getNome().equalsIgnoreCase(nome)) {
                return genero;
            }
        }
        Genero novoGenero = new Genero(nome);
        generos.add(novoGenero);
        return novoGenero;
    }

    // Métodos estáticos para gerenciar os dados
    public static ArrayList<Livro> getLivros() {
        return livros;
    }

    public static void addAutor(Autor autor) {
        autores.add(autor);
    }

    public static void addGenero(Genero genero) {
        generos.add(genero);
    }
}
