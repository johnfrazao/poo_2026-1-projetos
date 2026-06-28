package br.ufpb.john;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Responsável pela gravação e recuperação
 * dos dados do sistema em arquivo.
 *
 * Utiliza serialização de objetos.
 *
 * @author John
 */
public class GravadorDeDados {
    private static final String NOME_DO_ARQUIUVO ="filmes.dat";

    /**
     * Grava os filmes em arquivo.
     *
     * @param filmes mapa contendo os filmes cadastrados.
     * @throws IOException caso ocorra erro durante a gravação.
     */
    public void gravarDados(Map<String, Filme> filmes)
            throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOME_DO_ARQUIUVO));
        out.writeObject(filmes);
        out.close();
    }

    /**
     * Recupera os filmes gravados em arquivo.
     *
     * @return mapa contendo os filmes recuperados.
     * @throws IOException caso ocorra erro durante a leitura.
     */
    public Map<String, Filme> recuperarDados() throws IOException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOME_DO_ARQUIUVO));
            Map<String, Filme> filmes = (Map<String, Filme>) in.readObject();

            in.close();

            return filmes;

        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        }
    }
}


