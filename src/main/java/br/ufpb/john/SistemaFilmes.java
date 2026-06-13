package br.ufpb.john;

import java.io.IOException;
import java.util.*;

public class SistemaFilmes implements CatalogoFilmes {
    private Map<String, Filme> filmes;
    private GravadorDeDados gravador;

    public SistemaFilmes(Map<String, Filme> filmes){
        this.filmes = filmes;

    }
    public SistemaFilmes() {
        this.filmes = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastrarFilme(String nome, String genero, int ano) throws FilmeJaCadastradoException{
        if(filmes.containsKey(nome)){
            throw new FilmeJaCadastradoException("ERRO! Filme já cadastrado.");
        }
        filmes.put(nome, new Filme(nome, genero, ano));

        return true;
    }

    @Override
    public Collection<Filme> pesquisarPorGenero(String genero) {
        List<Filme> encontrados = new ArrayList<>();
        for(Filme f : filmes.values()){
            if(f.getGenero().equalsIgnoreCase(genero)){
                encontrados.add(f);
            }
        }
        return encontrados;
    }

    @Override
    public boolean removerFilme(String nome) throws FilmeInexistenteException {
        if (!filmes.containsKey(nome)){
            throw  new FilmeInexistenteException("ERRO! Filme não existe.");
        }
        filmes.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.gravarDados(filmes);
    }

    @Override
    public void recuperarDados() throws IOException {
        filmes = gravador.recuperarDados();
    }

    public void listarFilmes() {

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        for (Filme f : filmes.values()) {
            System.out.println(f);
        }
    }
}

