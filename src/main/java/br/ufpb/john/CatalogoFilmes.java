package br.ufpb.john;

import java.io.IOException;
import java.util.Collection;

/**
 * Interface para gerenciamento de filmes.
 */
public interface CatalogoFilmes {
    boolean cadastrarFilme(String nome, String genero, int ano) throws FilmeJaCadastradoException;
    Collection<Filme> pesquisarPorGenero(String genero);
    boolean removerFilme(String nome) throws FilmeInexistenteException;
    void salvarDados() throws IOException;
    void recuperarDados() throws IOException;
}