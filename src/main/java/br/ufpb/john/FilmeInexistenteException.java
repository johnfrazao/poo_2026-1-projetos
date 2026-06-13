package br.ufpb.john;

public class FilmeInexistenteException extends Exception{
    public FilmeInexistenteException(String msg){
        super(msg);
    }
}
