package br.ufpb.john;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SistemaFilmes sistemaFilmes = new SistemaFilmes();
        try {
            sistemaFilmes.recuperarDados();
        } catch ( IOException e) {
            System.out.println("Nenhum arquivo encontrado.");
        }
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        int opcao = -1;
        do {
            System.out.println("---------< Sistema de Filmes >---------");
            System.out.println("1 - Cadastrar Filme\n2 - Listar filmes\n3 - Pesquisar filmes por gênero \n4 - Remover Filme\n0 - Sair");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Por favor digite uma opção válida.");
                continue;
            }
            if (opcao == 1) {
                try {
                    System.out.println("Digite o nome do filme: ");
                    String nome = leitor.nextLine();
                    System.out.println("Digite o gênero do filme: ");
                    String genero = leitor.nextLine();
                    int ano = 0;
                    boolean anoValido = false;
                    while (!anoValido){
                        try {
                            System.out.println("Digite o ano do filme: ");
                            ano = Integer.parseInt(leitor.nextLine());
                            anoValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("ERRO! Por favor digite um ano válido.");
                        }
                    }
                    sistemaFilmes.cadastrarFilme(nome, genero, ano);
                    sistemaFilmes.salvarDados();
                } catch (FilmeJaCadastradoException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (opcao == 2) {
                sistemaFilmes.listarFilmes();
            } else if (opcao == 3) {
                System.out.println("Digite o gênero do filme: ");
                String genero = leitor.nextLine();
                Collection<Filme> filmesPorGenero = sistemaFilmes.pesquisarPorGenero(genero);
                for (Filme f : filmesPorGenero){
                    System.out.println(f);
                }
            } else if (opcao == 4){
                try {
                    System.out.println("Digite o nome do filme:");
                    String nome = leitor.nextLine();

                    sistemaFilmes.removerFilme(nome);

                    System.out.println("Filme removido com sucesso.");

                } catch (FilmeInexistenteException e) {
                    System.out.println(e.getMessage());
                }
            }else if (opcao == 0) {
                continuar = false;
            }else {
                System.out.println("Opção inválida.");
            }
        } while (continuar);
        System.out.println("Programa encerrado.");
        leitor.close();
    }
}
