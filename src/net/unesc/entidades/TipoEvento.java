package net.unesc.entidades;

public enum TipoEvento {
    GASOLINA("Gasolina"),
    ALMOCO("Almoço");
    
    private String descricao;

    private TipoEvento(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }   
    
}
