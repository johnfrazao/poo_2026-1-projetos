package br.ufpb.john;
/**
 * Exceção lançada quando um filme
 * não é encontrado no sistema.
 *
 * @author John
 */
public class FilmeInexistenteException extends Exception{
    /**
     * Cria a exceção com a mensagem informada.
     *
     * @param msg mensagem de erro.
     */
    public FilmeInexistenteException(String msg){
        super(msg);
    }
}
