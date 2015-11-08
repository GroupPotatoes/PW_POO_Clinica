package Module.Conexao;

/**
 * Enum que controla alguns valores existentes nas regras de negócio da nossa aplicação.
 * @author Maiara Rodrigues
 */
public enum Controle {
    
    /**
     * Valor inicial na tabela ASCII para caracteres alfabéticos maiúsculos símbolos.
     */
    ASCII_VALOR_MIN (64),
    
     /**
     * Valor final na tabela ASCII para caracteres alfabéticos maiúsculos e símbolos.
     */
    ASCII_VALOR_MAX (90),
    
     /**
     * Quantidade de caracteres para uma senha.
     */
    NUM_CARACTERES_SENHA (6),
    
     /**
     * Quantidade de caracteres para um login.
     */
    NUM_CARACTERES_LOGIN (6),
    
    
    ///TODO: alterei os valores porque estavam vindo id invalidos ou repetidos.
    /**
     * Valor do RoleId de um Funcionário do tipo Administrador de RH
     */
    ROLE_ID_ADMINISTRADOR (1),
    
    /**
     * Valor do RoleId de um Funcionário do tipo Recepcionista
     */
    ROLE_ID_RECEPCIONISTA (2),
    
    /**
     * Valor do RoleId de um Funcionário do tipo Secretária
     */
    ROLE_ID_SECRETARIA (3);    
    
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
