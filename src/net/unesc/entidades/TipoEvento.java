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
    
    public static String[] valores() {
        String[] names = new String[values().length];

        for (int i = 0; i < values().length; i++) {
            names[i] = values()[i].toString();
        }

        return names;
    }
    
    
    
}
