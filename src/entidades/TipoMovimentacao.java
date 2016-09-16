package entidades;

public enum TipoMovimentacao {
    ENTRADA("Entrada"),
    SAIDA("Saida");
    
    private String descricao;

    private TipoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }   
    
}
