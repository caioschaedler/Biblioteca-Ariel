package Br.Edu.Unisep.Biblioteca.View;

import Br.Edu.Unisep.Biblioteca.Model.Livro;
import Br.Edu.Unisep.Biblioteca.Model.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class ControleEmprestimo extends JFrame {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();

    public ControleEmprestimo() {
        setTitle("Controle de Empréstimos");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(20, 20, 100, 25);
        add(lblUsuario);

        JComboBox<Usuario> comboUsuario = new JComboBox<>(usuarios.toArray(new Usuario[0]));
        comboUsuario.setEditable(true); // Permite a edição para entrada de novos usuários
        comboUsuario.setBounds(20, 50, 200, 25);
        add(comboUsuario);

        JLabel lblLivro = new JLabel("Livro:");
        lblLivro.setBounds(20, 80, 100, 25);
        add(lblLivro);

        JComboBox<Livro> comboLivro = new JComboBox<>(CadastroLivro.getLivros().toArray(new Livro[0]));
        comboLivro.setBounds(20, 110, 200, 25);
        add(comboLivro);

        JButton btnEmprestar = new JButton("Emprestar");
        btnEmprestar.setBounds(20, 150, 100, 25);
        add(btnEmprestar);

        JButton btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(140, 150, 100, 25);
        add(btnDevolver);

        btnEmprestar.addActionListener(e -> {
            String nomeUsuario = comboUsuario.getEditor().getItem().toString().trim();
            Livro livro = (Livro) comboLivro.getSelectedItem();

            if (!nomeUsuario.isEmpty() && livro != null && livro.isDisponivel()) {
                Usuario usuario = encontrarOuCriarUsuario(nomeUsuario);
                usuario.emprestarLivro(livro);
                JOptionPane.showMessageDialog(this, "Livro emprestado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuário e um livro disponível.");
            }
        });

        btnDevolver.addActionListener(e -> {
            Usuario usuario = (Usuario) comboUsuario.getSelectedItem();
            Livro livro = (Livro) comboLivro.getSelectedItem();

            if (usuario != null && livro != null) {
                usuario.devolverLivro(livro);
                JOptionPane.showMessageDialog(this, "Livro devolvido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuário e um livro.");
            }
        });

        setVisible(true);
    }

    private Usuario encontrarOuCriarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        Usuario novoUsuario = new Usuario(nome);
        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    public static void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
