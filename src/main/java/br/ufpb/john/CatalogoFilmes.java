package br.ufpb.john;

import java.io.IOException;
import java.util.Collection;

/**
 * Interface que define as operações de gerenciamento
 * de um catálogo de filmes.
 *
 * Permite cadastrar, pesquisar, remover filmes e realizar
 * a persistência dos dados em arquivo.
 *
 * @author John
 */
public interface CatalogoFilmes {
    /**
     * Cadastra um novo filme no catálogo.
     *
     * @param nome nome do filme.
     * @param genero gênero do filme.
     * @param ano ano de lançamento do filme.
     * @return true caso o filme seja cadastrado com sucesso.
     * @throws FilmeJaCadastradoException caso já exista um filme
     * com o mesmo nome cadastrado.
     */
    boolean cadastrarFilme(String nome, String genero, int ano) throws FilmeJaCadastradoException;

    /**
     * Pesquisa todos os filmes pertencentes a um determinado gênero.
     *
     * @param genero gênero a ser pesquisado.
     * @return uma coleção contendo os filmes encontrados.
     */
    Collection<Filme> pesquisarPorGenero(String genero);

    /**
     * Remove um filme do catálogo.
     *
     * @param nome nome do filme a ser removido.
     * @return true caso a remoção seja realizada com sucesso.
     * @throws FilmeInexistenteException caso o filme não exista.
     */
    boolean removerFilme(String nome) throws FilmeInexistenteException;

    /**
     * Salva os dados do catálogo em arquivo.
     *
     * @throws IOException caso ocorra erro durante a gravação.
     */
    void salvarDados() throws IOException;

    /**
     * Recupera os dados previamente gravados em arquivo.
     *
     * @throws IOException caso ocorra erro durante a leitura.
     */
    void recuperarDados() throws IOException;
}