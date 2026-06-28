package br.ufpb.john;

import java.io.Serializable;
import java.util.Objects;
/**
 * Representa um filme cadastrado no sistema.
 *
 * Cada filme possui nome, gênero e ano de lançamento.
 *
 * @author John
 */
public class Filme implements Serializable {
    private String nome;
    private String genero;
    private int ano;

    /**
     * Cria um filme com os dados informados.
     *
     * @param nome nome do filme.
     * @param genero gênero do filme.
     * @param ano ano de lançamento.
     */
    public Filme(String nome, String genero, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
    }

    /**
     * Cria um filme vazio.
     */
    public Filme() {
        this("", "", 0);
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setGenero(String novoGenero) {
        this.genero = novoGenero;
    }

    public void setAno(int novoAno) {
        this.ano = novoAno;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getAno() {
        return this.ano;
    }

    public String toString() {
        return "Filme: " + this.nome + "\n" +
                "Gênero: " + this.genero + "\n" +
                "Ano: " + this.ano;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Filme filme)) return false;
        return ano == filme.ano &&
                Objects.equals(nome.toUpperCase(), filme.nome.toUpperCase()) &&
                Objects.equals(genero.toUpperCase(), filme.genero.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, ano);
    }
}
