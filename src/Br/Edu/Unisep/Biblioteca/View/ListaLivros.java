package Br.Edu.Unisep.Biblioteca.View;

import Br.Edu.Unisep.Biblioteca.Model.Livro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaLivros extends JFrame {

    public ListaLivros(List<Livro> livros) {
        setTitle("Lista de Livros");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] colunas = {"Título", "Autor", "Gênero"};

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        for (Livro livro : livros) {
            String titulo = livro.getTitulo();
            String autor = livro.getAutor().getNome();
            String genero = livro.getGenero().getNome();
            Object[] dados = {titulo, autor, genero};
            modeloTabela.addRow(dados);
        }

        JTable tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);
    }
}
