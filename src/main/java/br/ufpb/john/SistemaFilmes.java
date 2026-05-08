package br.ufpb.john;

import java.util.ArrayList;
import java.util.List;

public class SistemaFilmes {
    private List<Filme> filmes;

    public SistemaFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public SistemaFilmes() {
        this(new ArrayList<>());
    }

    public void cadastrarFilmes(Filme f) throws FilmeJaCadastradoException {
        if (filmes.contains(f)) {
            throw new FilmeJaCadastradoException("Filme já cadastrado");
        }
        filmes.add(f);
    }

    public void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        for (Filme f : filmes) {
            System.out.println(f);
        }
    }
}

