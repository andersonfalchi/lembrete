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
    
    public static TipoEvento porDescricao(String valor) {
        if (valor == null)
            return null;
        for (int i = 0; i < 10; i++) {
            if (valor.toLowerCase().equals(values()[i].toString().toLowerCase()))
            {
                return values()[i];
            }
        }
        return null;
    }
    
    
    
}
