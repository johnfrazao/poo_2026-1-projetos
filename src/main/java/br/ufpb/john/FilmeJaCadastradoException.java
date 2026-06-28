package br.ufpb.john;
/**
 * Exceção lançada quando se tenta cadastrar
 * um filme que já existe no sistema.
 *
 * @author John
 */
public class FilmeJaCadastradoException extends Exception{
    /**
     * Cria a exceção com a mensagem informada.
     *
     * @param msg mensagem de erro.
     */
    public FilmeJaCadastradoException(String msg){
        super(msg);
    }
}
