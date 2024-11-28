package Br.Edu.Unisep.Biblioteca.View;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuPrincipal extends JFrame {

    public static void main(String[] args) {
        new MenuPrincipal();
    }

    public MenuPrincipal() {
        setTitle("Sistema de Biblioteca");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnCadastroLivro = new JButton("Cadastrar Livro");
        btnCadastroLivro.setBounds(50, 30, 200, 30);
        add(btnCadastroLivro);

        JButton btnControleEmprestimos = new JButton("Controle de Empréstimos");
        btnControleEmprestimos.setBounds(50, 80, 200, 30);
        add(btnControleEmprestimos);

        btnCadastroLivro.addActionListener(e -> new CadastroLivro());

        btnControleEmprestimos.addActionListener(e -> new ControleEmprestimo());

        setVisible(true);
    }
}
