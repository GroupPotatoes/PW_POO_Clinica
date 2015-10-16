package Module;

/**
 * Enum que controla alguns valores existentes nas regras de negócio da nossa aplicação.
 * @author Maiara Rodrigues
 */
public enum Controle {
    
    NUM_CARACTERES_SENHA (6),
    NUM_CARACTERES_LOGIN (6);
    
    protected int valor;
    
    /**
     * Construtor do Enum.
     * @param valor valor a ser setado para cada item do Enum.
     */
    Controle(int valor){
        this.valor=valor;
    }
    
    /**
     * Getter do valor.
     * @return valor valor que existe pro item do Enum.
     */
    public int getValor(){
        return this.valor;
    }
}
