package br.ufpb.john;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;

public class TelaPrincipal extends JFrame {
    private SistemaFilmes sistema;

    public TelaPrincipal() {
        this.sistema = new SistemaFilmes();

        try {
            sistema.recuperarDados();
        } catch (Exception _) {
        }

        setTitle("Catálogo de Filmes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        criarMenu();

        setVisible(true);
    }

    private void criarMenu() {

        // Barra de menus
        JMenuBar barraMenu = new JMenuBar();

        // Menus
        JMenu menuFilmes = new JMenu("Filmes");
        JMenu menuArquivo = new JMenu("Arquivo");

        // Itens do menu Filmes
        JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
        itemCadastrar.addActionListener(e -> {

            try {

                String nome = JOptionPane.showInputDialog(
                        this,
                        "Digite o nome do filme:"
                );

                if (nome == null || nome.trim().isEmpty()) {
                    return;
                }

                String genero = JOptionPane.showInputDialog(
                        this,
                        "Digite o gênero:"
                );

                if (genero == null || genero.trim().isEmpty()) {
                    return;
                }

                String anoTexto = JOptionPane.showInputDialog(
                        this,
                        "Digite o ano:"
                );

                if (anoTexto == null) {
                    return;
                }

                int ano = Integer.parseInt(anoTexto);

                sistema.cadastrarFilme(nome, genero, ano);
                sistema.salvarDados();

                JOptionPane.showMessageDialog(
                        this,
                        "Filme cadastrado com sucesso!"
                );

            } catch (FilmeJaCadastradoException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ano inválido."
                );

            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Erro ao salvar os dados.");
            }

        });
        JMenuItem itemPesquisar = new JMenuItem("Pesquisar");
        itemPesquisar.addActionListener(e -> {

            String genero = JOptionPane.showInputDialog(
                    this,
                    "Digite o gênero do filme:"
            );

            if (genero == null || genero.trim().isEmpty()) {
                return;
            }

            Collection<Filme> filmes = sistema.pesquisarPorGenero(genero);

            if (filmes.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum filme encontrado para o gênero informado."
                );
                return;
            }

            StringBuilder resultado = new StringBuilder();

            for (Filme filme : filmes) {
                resultado.append(filme).append("\n\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    resultado.toString(),
                    "Filmes encontrados",
                    JOptionPane.INFORMATION_MESSAGE
            );

        });
        JMenuItem itemRemover = new JMenuItem("Remover");
        itemRemover.addActionListener(e -> {

            String nome = JOptionPane.showInputDialog(
                    this,
                    "Digite o nome do filme que deseja remover:"
            );

            if (nome == null || nome.trim().isEmpty()) {
                return;
            }

            try {

                sistema.removerFilme(nome);
                sistema.salvarDados();

                JOptionPane.showMessageDialog(
                        this,
                        "Filme removido com sucesso!"
                );

            } catch (FilmeInexistenteException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao salvar os dados.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });

        // Item do menu Arquivo
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        itemSalvar.addActionListener(e -> {

            try {

                sistema.salvarDados();

                JOptionPane.showMessageDialog(
                        this,
                        "Dados salvos com sucesso!"
                );

            } catch (IOException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao salvar os dados.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        });

        // Adiciona os itens aos menus
        menuFilmes.add(itemCadastrar);
        menuFilmes.add(itemPesquisar);
        menuFilmes.add(itemRemover);

        menuArquivo.add(itemSalvar);

        // Adiciona os menus à barra
        barraMenu.add(menuFilmes);
        barraMenu.add(menuArquivo);

        // Define a barra de menus da janela
        setJMenuBar(barraMenu);
    }
}
