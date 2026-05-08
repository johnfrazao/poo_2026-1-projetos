package br.ufpb.john;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FilmeJaCadastradoException {
        SistemaFilmes sistemaFilmes = new SistemaFilmes();
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        int opcao = -1;
        do {
            System.out.println("---------< Sistema de Filmes >---------");
            System.out.println("1 - Cadastrar Filme\n2 - Listar filmes\n0 - Sair");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Por favor digite uma opção válida.");
            }
            if (opcao == 1) {
                try {
                    System.out.println("Digite o nome do filme: ");
                    String nome = leitor.nextLine();
                    System.out.println("Digite o gênero do filme: ");
                    String genero = leitor.nextLine();
                    int ano = 0;
                    boolean anoValido = true;
                    while (anoValido!=false){
                        try {
                            System.out.println("Digite o ano do filme: ");
                            ano = Integer.parseInt(leitor.nextLine());
                            anoValido = false;
                        } catch (NumberFormatException e) {
                            System.out.println("ERRO! Por favor digite um ano válido.");
                            anoValido = true;
                        }
                    }
                    Filme filme = new Filme(nome, genero, ano);
                    sistemaFilmes.cadastrarFilmes(filme);
                } catch (FilmeJaCadastradoException e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                sistemaFilmes.listarFilmes();
            } else if (opcao == 0) {
                continuar = false;
            }
        } while (continuar);
        System.out.println("Programa encerrado.");
    }
}
