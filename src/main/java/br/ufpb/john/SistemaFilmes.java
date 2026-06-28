package br.ufpb.john;

import java.io.IOException;
import java.util.*;
/**
 * Implementação da interface CatalogoFilmes.
 *
 * Esta classe é responsável por gerenciar o cadastro,
 * pesquisa, remoção e persistência dos filmes do sistema.
 *
 * @author John
 */
public class SistemaFilmes implements CatalogoFilmes {
    private Map<String, Filme> filmes;
    private GravadorDeDados gravador;

    /**
     * Cria um sistema de filmes utilizando um mapa já existente.
     *
     * @param filmes mapa contendo os filmes cadastrados.
     */
    public SistemaFilmes(Map<String, Filme> filmes){
        this.filmes = filmes;

    }

    /**
     * Cria um sistema de filmes vazio,
     * e um gravador de dados.
     */
    public SistemaFilmes() {
        this.filmes = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cadastrarFilme(String nome, String genero, int ano) throws FilmeJaCadastradoException{
        if(filmes.containsKey(nome)){
            throw new FilmeJaCadastradoException("ERRO! Filme já cadastrado.");
        }
        filmes.put(nome, new Filme(nome, genero, ano));

        return true;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removerFilme(String nome) throws FilmeInexistenteException {
        if (!filmes.containsKey(nome)){
            throw  new FilmeInexistenteException("ERRO! Filme não existe.");
        }
        filmes.remove(nome);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void salvarDados() throws IOException {
        gravador.gravarDados(filmes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void recuperarDados() throws IOException {
        filmes = gravador.recuperarDados();
    }

    /**
     * Exibe todos os filmes cadastrados no sistema.
     * Caso não existam filmes cadastrados, informa ao usuário.
     */
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

