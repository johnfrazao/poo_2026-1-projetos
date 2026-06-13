package br.ufpb.john;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    private static final String NOME_DO_ARQUIUVO ="filmes.txt";


    public void gravarDados(Map<String, Filme> filmes)
            throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOME_DO_ARQUIUVO));
        out.writeObject(filmes);
        out.close();
    }

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


