package Br.Edu.Unisep.Biblioteca.View;

import Br.Edu.Unisep.Biblioteca.Model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema de Biblioteca");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JButton btnCadastroLivro = new JButton("Cadastrar Livro");
        btnCadastroLivro.setBounds(50, 30, 200, 30);
        add(btnCadastroLivro);

        JButton btnControleEmprestimos = new JButton("Controle de Empréstimos");
        btnControleEmprestimos.setBounds(50, 80, 200, 30);
        add(btnControleEmprestimos);

        JButton btnListarLivros = new JButton("Listar Livros");
        btnListarLivros.setBounds(50, 130, 200, 30);
        add(btnListarLivros);

        btnCadastroLivro.addActionListener(e -> new CadastroLivro());
        btnControleEmprestimos.addActionListener(e -> new ControleEmprestimo());
        btnListarLivros.addActionListener(e -> {
            List<Livro> livros = CadastroLivro.getLivros();
            ListaLivros listaLivrosView = new ListaLivros(livros);
            listaLivrosView.setVisible(true);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}